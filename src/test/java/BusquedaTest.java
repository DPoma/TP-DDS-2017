import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repositories.Repositorios;
import model.Cuenta;


public class BusquedaTest{
	
	private Cuenta unaCuenta;
	private Cuenta otraCuenta;
	
	@Before
	public void init() {
		unaCuenta = new Cuenta("Facebook","PDS",2015,"200000");
		otraCuenta = new Cuenta("Facebook","PDS",2015,"200000");
		Repositorios.repositorioCuentas.agregarCuenta(unaCuenta);
		Repositorios.repositorioCuentas.agregarCuenta(otraCuenta);
	}
	
	@Test
	public void repositorioCuentasFiltraLasCuentas() {
		
		Assert.assertEquals(unaCuenta,Repositorios.repositorioCuentas.filtrarPorEmpresaPeriodo("Facebook","2013","2016").get(0));
		
	}
	
	@After
	public void end()
	{
		Repositorios.repositorioCuentas.eliminarCuenta(unaCuenta);
		Repositorios.repositorioCuentas.eliminarCuenta(otraCuenta);
		
	}
	

	
}