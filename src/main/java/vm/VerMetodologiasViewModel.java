package vm;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

import com.google.common.collect.Lists;

import repositories.Repositorios;
import model.Empresa;
import model.Indicador;
import model.Metodologia;

@Observable
public class VerMetodologiasViewModel {
	
	private List<Metodologia> metodologias;
	private Metodologia metodologiaSeleccionada;
	private List<Indicador> indicadores;
	private List<Empresa> empresas;
	private List<Empresa> empresasOrdenadas;
	private String anioElegido;
	
	public VerMetodologiasViewModel()
	{
		this.metodologias = Repositorios.repositorioMetodologias.getMetodologias();
		this.indicadores = Repositorios.repositorioIndicadores.getIndicadores();
		this.empresas = Repositorios.repositorioEmpresas.getEmpresas();
	}
	

	public void setMetodologiaSeleccionada(Metodologia metodologiaSeleccionada) {
		this.metodologiaSeleccionada = metodologiaSeleccionada;
	}

	public List<Metodologia> getMetodologias() {
		return metodologias;
	}

	public Metodologia getMetodologiaSeleccionada() {
		return metodologiaSeleccionada;
	}
	
	public List<Empresa> getEmpresasOrdenadas() {
		return empresasOrdenadas;
	}

	public void setEmpresasOrdenadas(List<Empresa> empresasOrdenadas) {
		this.empresasOrdenadas = empresasOrdenadas;
	}


	
	//------------------------COMPARACIONES--------------------------------
	
	public int compararValoresROIC(Empresa unaEmpresa, Empresa otraEmpresa) {
		return this.ROICUltimosAnios(unaEmpresa).compareTo(this.ROICUltimosAnios(otraEmpresa));
	}
	
	public int compararValoresDeuda(Empresa unaEmpresa, Empresa otraEmpresa) {
		return this.proporcionDeudaUltimosAnios(unaEmpresa).compareTo(this.proporcionDeudaUltimosAnios(otraEmpresa));
	}
	
	public int compararValoresMargen(Empresa unaEmpresa, Empresa otraEmpresa) {
		return this.margenUltimosAnios(unaEmpresa).compareTo(this.margenUltimosAnios(otraEmpresa));
	}
	
/*	public int compararValoresIndicador(Empresa unaEmpresa, Empresa otraEmpresa, String anio) {
		return this.valorDeUnIndicador(unaEmpresa, anio).compareTo(this.valorDeUnIndicador(otraEmpresa, anio));
	}
	*/
	
	//------------------------ORDENAR LISTAS--------------------------------
	
	public void ordenarEmpresasPorROIC() {
		empresasOrdenadas = Lists.reverse(empresas.stream().sorted((e1,e2)-> this.compararValoresROIC(e1, e2)).collect(Collectors.toList()));
		System.out.print(empresasOrdenadas + " = ");
		System.out.println(this.mapearPorROIC());
	}
	
	public void ordenarEmpresasPorMargen() {
		empresasOrdenadas = Lists.reverse(empresas.stream().sorted((e1,e2)-> this.compararValoresMargen(e1, e2)).collect(Collectors.toList()));
		System.out.print(empresasOrdenadas + " = ");
		System.out.println(this.mapearPorMargen());
	}
	
	public void ordenarEmpresasPorProporcionDeuda() {
		empresasOrdenadas = empresas.stream().sorted((e1,e2)-> this.compararValoresDeuda(e1, e2)).collect(Collectors.toList());
		System.out.print(empresasOrdenadas + " = ");
		System.out.println(this.mapearPorDeuda());
	}

	public void ordenarEmpresasPorAntiguedad() {
		empresasOrdenadas = empresas.stream().filter(e-> this.esAntigua(e)).collect(Collectors.toList());
	}
	
/*	public void ordenarPorValor(String anio) {
		empresasOrdenadas = Lists.reverse(empresas.stream().sorted((e1,e2)-> this.compararValoresIndicador(e1, e2, anio)).collect(Collectors.toList()));
	}
	
	public void ordenarPorValorMenor(String anio) {
		empresasOrdenadas = empresas.stream().sorted((e1,e2)-> this.compararValoresIndicador(e1, e2, anio)).collect(Collectors.toList());
	}*/
	
	
	
	//------------------------REALIZAR CALCULO--------------------------------
	
	
	public BigDecimal realizarCalculo(Empresa unaEmpresa, String anio, int indicador) {
			return this.indicadores.get(indicador).calcularMonto(unaEmpresa, anio);
		}

	
	public BigDecimal obtenerROIC(Empresa unaEmpresa, String anio) {
		return this.realizarCalculo(unaEmpresa, anio, 1);
	}
	
	public BigDecimal proporcionDeDeuda(Empresa unaEmpresa, String anio) {
		return this.realizarCalculo(unaEmpresa, anio, 2);
	}
	
	public BigDecimal margenDeUtilidad(Empresa unaEmpresa, String anio) {
		return this.realizarCalculo(unaEmpresa, anio, 3);
	}
	
/*	public BigDecimal valorDeUnIndicador(Empresa unaEmpresa, String anio) {
	//	BigDecimal bd = this.metodologiaSeleccionada.getIndicador().calcularMonto(unaEmpresa, anio);
		System.out.println(unaEmpresa.getNombre() + ": " + bd);
	//	return bd ;
	}*/
	
	public boolean esAntigua(Empresa unaEmpresa) {
		return unaEmpresa.getCuentas().stream().anyMatch(c-> c.getAnio() <= 2007);
	}
	
	
	
	//------------------------SUMAR ULTIMOS ANIOS--------------------------------
	
	public BigDecimal obtener(Empresa unaEmpresa, String anio, int operacion) {
		
		BigDecimal a = new BigDecimal(0);
		
		switch(operacion) {
		case 0: a = this.obtenerROIC(unaEmpresa, anio); break;
		case 1: a = this.proporcionDeDeuda(unaEmpresa, anio); break;
		case 2: a = this.margenDeUtilidad(unaEmpresa, anio); break;
		}
		
		return a;
		
	}
	
	public BigDecimal ROICUltimosAnios(Empresa unaEmpresa) {
		return this.acumulador(unaEmpresa, 0);
	}
	
	public BigDecimal margenUltimosAnios(Empresa unaEmpresa) {
		return this.acumulador(unaEmpresa, 1);
	}
	
	public BigDecimal proporcionDeudaUltimosAnios(Empresa unaEmpresa) {
		return this.acumulador(unaEmpresa, 2);
	}
	
	public BigDecimal acumulador(Empresa unaEmpresa, int operacion) {
		BigDecimal total = new BigDecimal(0);
		int i;
		for(i=2017; i>2007; i--)
			total = total.add(this.obtener(unaEmpresa, String.valueOf(i), operacion));
		return total;
	}
	
	//------------------------PARA CONTROLAR--------------------------------
	
	public List<BigDecimal> ordenarLista(List<BigDecimal> unaLista) {
		return unaLista.stream().sorted((a1,a2)-> a1.compareTo(a2)).collect(Collectors.toList());
	}
	
	public List<BigDecimal> mapearPorMargen() {
		return empresasOrdenadas.stream().map(e-> this.margenUltimosAnios(e)).collect(Collectors.toList());
	}

	public List<BigDecimal> mapearPorROIC() {
		return empresasOrdenadas.stream().map(e-> this.ROICUltimosAnios(e)).collect(Collectors.toList());
	}
	
	public List<BigDecimal> mapearPorDeuda() {
		return empresasOrdenadas.stream().map(e-> this.proporcionDeudaUltimosAnios(e)).collect(Collectors.toList());
	}


	//------------------------APLICACION METODOLOGIA--------------------------------

	public void aplicar() {


	}
	
	public void aplicarMetodologia() throws NullPointerException
	{
		this.aplicar();
	}


	public String getAnioElegido() {
		return anioElegido;
	}


	public void setAnioElegido(String anioElegido) {
		this.anioElegido = anioElegido;
	}
	
}

