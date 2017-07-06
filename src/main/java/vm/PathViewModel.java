package vm;

import java.io.IOException;
import model.FileHandler;

import org.uqbar.commons.utils.Observable;

@Observable
public class PathViewModel {
	private String path = "";
	
	public void cargarCuentas() throws IOException{
		FileHandler lector= new FileHandler();
		lector.leerArchivoCuentas(path);
		lector.leerArchivoIndicadores("indicadores.csv");
		lector.leerArchivoMetodologias("metodologias.csv");
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
