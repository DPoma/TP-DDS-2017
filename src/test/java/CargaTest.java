

import java.io.IOException;

import org.junit.Test;
import org.mockito.Mockito;

import windows.PathWindow;
import vm.PathViewModel;
import repositories.RepositorioCuentas;


public class CargaTest{
	
	
	@Test
	public void pathWindowMandaAVM(){
		
		PathWindow unaPathWindow = Mockito.mock(PathWindow.class);
		unaPathWindow.aceptar();
		
		Mockito.verify(unaPathWindow).aceptar();
		
	}
	
	@Test
	public void pathViewModelMandaARepositorios(){
		
		PathViewModel unaPathViewModel = Mockito.mock(PathViewModel.class);
		unaPathViewModel.cargarCuentas();
		
		Mockito.verify(unaPathViewModel).cargarCuentas();
		
	}
	
	@Test
	public void repositorioCuentasCargaLasCuentas() throws IOException{
		
		RepositorioCuentas unRepositorioCuentas = Mockito.mock(RepositorioCuentas.class);
		unRepositorioCuentas.cargarCuentas("unPath");
		
		Mockito.verify(unRepositorioCuentas).cargarCuentas(Mockito.any());
		
	}
	
}