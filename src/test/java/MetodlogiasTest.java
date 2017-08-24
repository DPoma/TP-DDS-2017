import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import repositories.Repositorios;
import model.CondicionTipo2;
import model.Cuenta;
import model.Empresa;
import model.Indicador;

public class MetodlogiasTest {
	
		private CondicionTipo2 unaCondicion;
		private Empresa unaEmpresa;
		private Empresa otraEmpresa;
		private Indicador indicador;
		
		@Before
		public void init() {
			Cuenta unaCuenta = new Cuenta("EBITDA",2015,"200000");
			Cuenta otraCuenta = new Cuenta("EBITDA",2015,"100000");
			Repositorios.repositorioEmpresas.trabajarEmpresa("Facebook", unaCuenta);
			Repositorios.repositorioEmpresas.trabajarEmpresa("Twitter",otraCuenta);
			indicador = new Indicador("humo", "2*(EBITDA+2000)");
			unaCondicion = new CondicionTipo2("2015", (a ,b) -> a.compareTo(b) == 1, indicador);
			unaEmpresa = Repositorios.repositorioEmpresas.find(empresa -> empresa.getNombre().equals("Facebook"));
			otraEmpresa = Repositorios.repositorioEmpresas.find(empresa -> empresa.getNombre().equals("Twitter"));
			
		}
		
		@Test
		public void condictionTipo3Compara() {
			
			unaCondicion.compararEmpresas(unaEmpresa, otraEmpresa);
			Assert.assertEquals(1, unaEmpresa.getPuntacion());
			
		}
		
		@After
		public void end()
		{
			Repositorios.repositorioEmpresas.eliminarEmpresa("Facebook");
			Repositorios.repositorioEmpresas.eliminarEmpresa("Facebook");
			
		}

}

