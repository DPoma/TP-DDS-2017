import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.persistence.EntityManager;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import repositories.Repositorios;
import tareaprogramada.TareaProgramada;
import windows.PrincipalWindow;

public class AnalizadorDeInversionesApplication extends Application{

		@SuppressWarnings("unused")
		public static void main(String[] args) throws IOException {
			EntityManager entity = PerThreadEntityManagers.getEntityManager();
			new AnalizadorDeInversionesApplication().start();
			TimerTask cargarEmpresasBatch = new TareaProgramada("");
	        Timer timer = new Timer(true);
	        timer.scheduleAtFixedRate(cargarEmpresasBatch, 0, 10*60*1000);	//esta en milisegundos, o sea 10 minutos
		}
		
		
		@Override
		protected Window<?> createMainWindow() {
			return new PrincipalWindow(this);
		}
}
