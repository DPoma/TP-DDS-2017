package vm;

import repositories.RepositorioEmpresas;
import repositories.Repositorios;
import model.Cuenta;
import model.Empresa;

import java.util.List;

import org.uqbar.commons.utils.Observable;

@Observable
public class BusquedaViewModel {
	private String empresa = "";
	private String anio1 = "";
	private String anio2 = "";

	public List<Cuenta> consultaCuentas(){
		return Repositorios.repositorioEmpresas.filtrarPorEmpresaPeriodo(empresa, anio1, anio2);
	}	
	
	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getAnio1() {
		return anio1;
	}
	
	public void setAnio1(String anio1) {
		this.anio1 = anio1;
	}
	public String getAnio2() {
		return anio2;
	}

	public void setAnio2(String anio2) {
		this.anio2 = anio2;
	}
}