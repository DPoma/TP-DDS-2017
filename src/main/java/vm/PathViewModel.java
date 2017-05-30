package vm;

import java.io.IOException;
import model.LectorCSV;

import org.uqbar.commons.utils.Observable;

@Observable
public class PathViewModel {
	private String path = "";
	
	public void cargarCuentas() throws IOException{
		LectorCSV lector= new LectorCSV();
		lector.leerArchivoCuentas(path);
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
