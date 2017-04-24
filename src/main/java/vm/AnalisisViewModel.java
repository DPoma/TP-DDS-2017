package vm;

import repositories.Repositorios;
import model.Cuenta;
import model.Empresa;
import org.uqbar.commons.utils.Observable;

public class AnalisisViewModel {
	private String empresa = "";
	private String metodologia = "";

public String getEmpresa() {
	return empresa;
}

public void setEmpresa(String empresa) {
	this.empresa = empresa;
}

public String getMetodologia() {
	return metodologia;
}

public void setMetodologia(String metodologia) {
	this.metodologia = metodologia;
}
}
