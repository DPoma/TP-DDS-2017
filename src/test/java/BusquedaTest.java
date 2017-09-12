import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import repositories.Repositorios;
import model.Cuenta;
import model.Empresa;

@SuppressWarnings("unused")
public class BusquedaTest{
	
	
	private Cuenta unaCuenta;
	private Cuenta otraCuenta;
	
	@Before
	public void init() {
		Empresa facebook = new Empresa("Facebook", 2004);
		unaCuenta = new Cuenta("PDS",2015,"200000", facebook);
		otraCuenta = new Cuenta("PDS",2015,"200000", facebook);
	}
	
	@Test
	public void repositorioCuentasFiltraLasEmpresas() {
		//Assert.assertEquals(unaCuenta,Repositorios.repositorioEmpresas.filtrarPorEmpresaPeriodo("facebook","2013","2016").get(0));
	}
	
	@After
	public void end() {
		
		Repositorios.repositorioEmpresas.limpiar();
		
	}
	

	
}