import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import model.Cuenta;
import model.Empresa;
import model.LectorCSV;
import repositories.Repositorios;


public class CargaTest{
	
	private List<Empresa> lista = new ArrayList<Empresa>();
	
	
	@Before
	public void init() {
		lista.add(new Empresa("Facebook",new Cuenta("EBITDA",2016,"14870000000")));
		lista.add(new Empresa("Facebook",new Cuenta("EBITDA",2015,"8162000000")));
		lista.add(new Empresa("Twitter",new Cuenta("FDS",2014,"1111000000")));
	}
	
	@Test
	public void cargarArchivo() throws IOException
	{
		LectorCSV lector = new LectorCSV();
		lector.leerArchivoCuentas("src/main/java/cuentas.csv");
		Assert.assertEquals(2, Repositorios.repositorioEmpresas.getEmpresas().size());
		Assert.assertEquals(lista.size(),Repositorios.repositorioEmpresas.getEmpresas().stream().mapToInt(x->x.getCuentas().size()).sum());
	}
	
}