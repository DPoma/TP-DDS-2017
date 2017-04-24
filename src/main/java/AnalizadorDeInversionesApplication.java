import java.io.IOException;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import windows.BusquedaWindow;
import repositories.Repositorios;

public class AnalizadorDeInversionesApplication extends Application{

		public static void main(String[] args) throws IOException {
			new AnalizadorDeInversionesApplication().start();
		}
		
		@Override
		protected Window<?> createMainWindow() {
			return new BusquedaWindow(this);
		}
			//Repositorios.repositorioCuentas.cargarCuentas("C:\\Users\\Diego\\Documents\\Git\\dds-tpa-clandestino\\src\\main\\java\\cuentas.csv");
			//System.out.println(Repositorios.repositorioCuentas.filtrarPorEmpresa("Facebook"));
}
