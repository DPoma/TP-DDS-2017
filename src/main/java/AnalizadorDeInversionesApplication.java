import java.io.IOException;

import javax.persistence.EntityManager;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import windows.AnalisisEmpresaWindow;
import windows.PrincipalWindow;
import windows.PathWindow;
import repositories.Repositorios;

public class AnalizadorDeInversionesApplication extends Application{

		public static void main(String[] args) throws IOException {
			EntityManager entity = PerThreadEntityManagers.
					getEntityManager();
			new AnalizadorDeInversionesApplication().start();
		}
		
		@Override
		protected Window<?> createMainWindow() {
			return new PathWindow(this);
		}
}
