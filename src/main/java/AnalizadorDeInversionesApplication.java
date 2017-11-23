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
		
		}
		
		
		@Override
		protected Window<?> createMainWindow() {
			return new PrincipalWindow(this);
		}
}
