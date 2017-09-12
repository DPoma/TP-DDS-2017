import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.Cuenta;
import model.Empresa;
import model.FileHandler;
import repositories.Repositorios;
import vm.PathViewModel;

@SuppressWarnings("unused")
public class CargaTest{
	
	private List<Empresa> lista = new ArrayList<Empresa>();
	
	
	@Before
	public void init() {
	}
	
	@Test
	public void tiraExcepcionSiNoEncuentraArchivoCuentas()
	{
		PathViewModel vm = new PathViewModel();
		vm.setPath("humo");
		try
		{
			vm.cargarCuentas();
			Assert.fail();
		}
		catch(FileNotFoundException e)
		{}
		catch(IOException e)
		{}
	}
	
	@Test
	public void cargarArchivo() throws IOException
	{
		FileHandler lector = new FileHandler();
		lector.leerArchivoCuentas("src/main/java/cuentas.csv");
		Assert.assertEquals(3, Repositorios.repositorioEmpresas.getEmpresas().size());
		Assert.assertEquals(7,Repositorios.repositorioEmpresas.getEmpresas().stream().mapToInt(x->x.getCuentas().size()).sum());
	}
	
}