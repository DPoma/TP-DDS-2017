import java.math.BigDecimal;

import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.Cuenta;
import model.Empresa;
import model.Indicador;
import parserIndicador.ParsearIndicador;
import repositories.Repositorios;
import vm.AgregarIndicadorViewModel;

@SuppressWarnings("unused")
public class IndicadoresTest {
	private ParsearIndicador parser = new ParsearIndicador();
	
	
	@Before
	public void init() {

	}
	
	@Test(expected=ParseCancellationException.class)
	public void parserDetectaErrores()
	{
		parser.generarArbol("2*3-");
	}
	
	@Test
	public void parserReduceCorrectamente()
	{
		BigDecimal resultado = parser.reducirIndicador("(4/8*(9+3))*3", null, "");
		BigDecimal expected = new BigDecimal("18");
		Assert.assertTrue(resultado.compareTo(expected) == 0);
	}
	
	@Test(expected=ParseCancellationException.class)
	public void indicadorNoPuedeCaerEnRecusrividadInfinita()
	{
		AgregarIndicadorViewModel vm = new AgregarIndicadorViewModel();
		vm.setNombreIndicador("test");
		vm.setFormulaIndicador("test+2");
		vm.guardarIndicador();
		
	}
	
	@Test
	public void indicadorFuncionaConCuentas()
	{
		//Cuenta cuenta = new Cuenta("test", 2013, "2000000");
		//Empresa empresa = new Empresa("Empresa", cuenta);
		Indicador indicador = new Indicador("Indicador", "test*2");
		//BigDecimal resultado = indicador.calcularMonto(empresa, "2013");
		BigDecimal expected = new BigDecimal("4000000");
		//Assert.assertTrue(resultado.compareTo(expected) == 0);
	}
	
	@Test 
	public void indicadorSeGuardaEnRepo()
	{
		Indicador indicador = new Indicador("testing", "2*3");
		indicador.agregarARepositorio();
		Assert.assertEquals(1, Repositorios.repositorioIndicadores.getIndicadores().size());
	}
	
	@After
	public void end()
	{
		Repositorios.repositorioIndicadores.getIndicadores().removeIf(unIndicador -> unIndicador.getNombreIndicador().equals("testing"));
	}
}
