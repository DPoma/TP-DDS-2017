package vm;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import model.Empresa;
import model.Indicador;
import repositories.Repositorios;

@Observable
public class VerIndicadoresViewModel {
	
	private List<Indicador> indicadores;
	private Indicador indicadorSeleccionado;
	public int getAnio() {
		return anio;
	}

	public void setIndicadorSeleccionado(Indicador indicadorSeleccionado) {
		this.indicadorSeleccionado = indicadorSeleccionado;
	}

	public List<Indicador> getIndicadores() {
		return indicadores;
	}

	public Indicador getIndicadorSeleccionado() {
		return indicadorSeleccionado;
	}

	public double getResultado() {
		return resultado;
	}

	private double resultado;
	private String empresa;
	private int anio;
	
	public VerIndicadoresViewModel(String unaEmpresa)
	{
		this.indicadores = Repositorios.repositorioIndicadores.getIndicadores();
		this.empresa = unaEmpresa;
	}
	
	public void aplicarIndicador()
	{
		this.resultado = this.indicadorSeleccionado.monto(empresa, anio);
	}

}
