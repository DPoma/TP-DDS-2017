import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import model.Cuenta;
import repositories.Repositorios;


public class CargaTest{
	
	private List<Cuenta> lista = new ArrayList<Cuenta>();
	
	
	@Before
	public void init() {
		lista.add(new Cuenta("Facebook","EBITDA",2016,"14870000000"));
		lista.add(new Cuenta("Facebook","EBITDA",2015,"8162000000"));
		lista.add(new Cuenta("Twitter","FDS",2014,"1111000000"));
	}
	
	@Test
	public void cargarArchivo() throws IOException
	{
		Repositorios.repositorioCuentas.cargarCuentas("src/main/java/cuentas.csv");
		Assert.assertEquals(lista.size(), Repositorios.repositorioCuentas.getCuentas().size());
		
	}
	
}