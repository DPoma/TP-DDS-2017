package vm;

import java.io.IOException;

import org.uqbar.commons.utils.Observable;

import repositories.Repositorios;

@Observable
public class PathViewModel {
	private String path = "";
	
	public void cargarCuentas() throws IOException{
		Repositorios.repositorioCuentas.cargarCuentas(path);
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
