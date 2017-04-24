package vm;

import java.io.IOException;

import repositories.Repositorios;

public class PathViewModel {
	private String path = "";
	
	public void cargarCuentas(){
		try {
			Repositorios.repositorioCuentas.cargarCuentas(path);
		} catch (IOException e) {
			System.out.println("Error al cargar el archivo");
			e.printStackTrace();
		}	
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
