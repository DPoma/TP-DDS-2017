import java.io.IOException;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import windows.AnalisisEmpresaWindow;
import windows.PrincipalWindow;
import windows.PathWindow;
import repositories.Repositorios;

public class AnalizadorDeInversionesApplication extends Application{

		public static void main(String[] args) throws IOException {
			new AnalizadorDeInversionesApplication().start();
		}
		
		@Override
		protected Window<?> createMainWindow() {
			return new PathWindow(this);
		}
}
