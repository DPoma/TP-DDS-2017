package vm;

import repositories.Repositorios;
import model.Cuenta;
import model.Empresa;

import java.math.BigDecimal;
import java.util.List;

import org.uqbar.commons.utils.Observable;

@Observable
public class AnalisisEmpresaViewModel {
	private Empresa empresaSeleccionada;
	private String anioMin = "";
	private String anioMax = "";
	private List<Empresa> empresas;
	private List<Cuenta> cuentas;
	private List<String> nombres ;
	private List<Integer> anios ;
	private List<BigDecimal> montos ;
	
	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public List<String> getNombres() {
		return nombres;
	}

	public List<Integer> getAnios() {
		return anios;
	}

	public List<BigDecimal> getMontos() {
		return montos;
	}

	public AnalisisEmpresaViewModel()
	{
		this.empresas = Repositorios.repositorioEmpresas.getEmpresas();
	}

	public Empresa getEmpresaSeleccionada() {
		return empresaSeleccionada;
	}

	public void setEmpresaSeleccionada(Empresa empresaSeleccionada) {
		this.empresaSeleccionada = empresaSeleccionada;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public List<Cuenta> consultaCuentas() throws NullPointerException {
		
		return empresaSeleccionada.periodoEntre(anioMin, anioMax);
	}	


	public String getAnioMin() {
		return anioMin;
	}
	
	public void setAnioMin(String anio1) {
		this.anioMin = anio1;
	}
	public String getAnioMax() {
		return anioMax;
	}

	public void setAnioMax(String anio2) {
		this.anioMax = anio2;
	}
	
	public void mostrarCuentas()
	{
		cuentas = this.consultaCuentas();
	}
}