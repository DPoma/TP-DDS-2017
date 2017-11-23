package tareaprogramada;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.TimerTask;

import model.FileHandler;
import repositories.Repositorios;

public class TareaProgramada extends TimerTask {

	private String path;
	private Date ultimaEjecucion;

	public TareaProgramada(String path) 
	{
		super();
		this.path = path;
	}

	@Override
	public void run()
	{
		System.out.println("SE INVOCO LA TAREA");
		if(this.fueModificadoDesdeLaUltimaLectura())
		{
			FileHandler archivo = new FileHandler();
			try {
				archivo.importarArchivoCuentas(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Se proceso");
			Repositorios.repositorioIndicadores.eliminarPrecalculados();
		}
		else
			System.out.println("No se proceso");
		ultimaEjecucion = new Date();
		

	}

	public boolean fueModificadoDesdeLaUltimaLectura() {
		if(ultimaEjecucion == null) {
			return true;
		}
		File file = new File(path);
		Date lastModified = new Date(file.lastModified()); 
		return lastModified.after(ultimaEjecucion);
	}
	
}
