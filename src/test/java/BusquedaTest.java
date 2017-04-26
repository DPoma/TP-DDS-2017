

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import windows.BusquedaWindow;
import vm.BusquedaViewModel;
import repositories.RepositorioCuentas;
import model.Cuenta;

public class BusquedaTest{
	
	
	@Test
	public void busquedaWindowMuestraResultados(){
		
		BusquedaWindow unaBusquedaWindow = Mockito.mock(BusquedaWindow.class);
		unaBusquedaWindow.mostrarResultados();
		
		Mockito.verify(unaBusquedaWindow).mostrarResultados();
		
	}
	
	@Test
	public void busquedaVMDevuelveListaDeCuentasFiltradas(){
		
		BusquedaViewModel unaBusquedaViewModel = Mockito.mock(BusquedaViewModel.class);
		unaBusquedaViewModel.consultaCuentas();
		
		Mockito.verify(unaBusquedaViewModel).consultaCuentas();
		
	}
	
	@Test
	public void repositorioCuentasFiltraLasCuentas() {
		
		RepositorioCuentas unRepositorioCuentas = new RepositorioCuentas();
		Cuenta cuenta1 =new Cuenta("Facebook","PDS",2015,200000);
		Cuenta cuenta2 =new Cuenta("Facebook","PDS",2010,200000);
		
		unRepositorioCuentas.agregarCuenta(cuenta1);
		unRepositorioCuentas.agregarCuenta(cuenta2);
		
		Assert.assertEquals(cuenta1,unRepositorioCuentas.filtrarPorEmpresaPeriodo("Facebook","2013","2016").get(0) );
		
	}
	
}