import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repositories.Repositorios;
import model.Cuenta;
import model.Empresa;


public class BusquedaTest{
	
	private Cuenta unaCuenta;
	private Cuenta otraCuenta;
	
	@Before
	public void init() {
		//unaCuenta = new Cuenta("PDS",2015,"200000");
		//otraCuenta = new Cuenta("PDS",2015,"200000");
		//Repositorios.repositorioEmpresas.trabajarEmpresa("Facebook", unaCuenta);
		//Repositorios.repositorioEmpresas.trabajarEmpresa("Facebook",otraCuenta);
	}
	
	/*@Test
	public void repositorioCuentasFiltraLasEmpresas() {
		
		Assert.assertEquals(unaCuenta,Repositorios.repositorioEmpresas.filtrarPorEmpresaPeriodo("facebook","2013","2016").get(0));
		
	}*/
	
	@After
	public void end()
	{
		Repositorios.repositorioEmpresas.eliminarEmpresa("Facebook");
		Repositorios.repositorioEmpresas.eliminarEmpresa("Facebook");
		
	}
	

	
}