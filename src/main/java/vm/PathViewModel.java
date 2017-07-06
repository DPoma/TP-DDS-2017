package vm;

import java.io.IOException;

import model.FileHandler;
import model.Metodologia;

import org.uqbar.commons.utils.Observable;

import repositories.Repositorios;

@Observable
public class PathViewModel {
	private String path = "";
	
	public void cargarCuentas() throws IOException{
		FileHandler lector= new FileHandler();
		lector.leerArchivoCuentas(path);
		lector.leerArchivoIndicadores("indicadores.csv");
		lector.leerArchivoMetodologias("metodologias.csv");
		agregarMetodologiasPersonalizadas();
	}
	

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public void agregarMetodologiasPersonalizadas() {
		Repositorios.repositorioMetodologiasPersonalizadas.agregarMetodologia((new Metodologia("mayorValor", "5")));
		Repositorios.repositorioMetodologiasPersonalizadas.agregarMetodologia((new Metodologia("mayorPromedio", "6")));
	}
}
