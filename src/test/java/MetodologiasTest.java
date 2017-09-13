import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import repositories.Repositorios;
import model.Condicion;
import model.AnalizarIndicadorEnUltimosAnios;
import model.AnalizarIndicadoresEntreEmpresas;
import model.AnalizarCrecimientoEnPeriodo;
import model.Cuenta;
import model.Empresa;
import model.FileHandler;
import model.IgualA;
import model.Indicador;
import model.Longevidad;
import model.MayorA;
import model.MenorA;
import model.Metodologia;

@SuppressWarnings("unused")
public class MetodologiasTest {
	
		private AnalizarIndicadoresEntreEmpresas unaCondicion;
		private Empresa unaEmpresa;
		private Empresa otraEmpresa;
		private Indicador indicador;
		
		@Before
		public void init() {
			Empresa facebook = new Empresa("Facebook", 2004);
			Empresa twitter = new Empresa("Twitter", 2006);
			Repositorios.repositorioEmpresas.agregarEmpresa(facebook);
			Repositorios.repositorioEmpresas.agregarEmpresa(twitter);
			Cuenta unaCuenta = new Cuenta("EBITDA",2015,"200000", facebook);
			Cuenta otraCuenta = new Cuenta("EBITDA",2015,"100000", twitter);
			indicador = new Indicador("humo", "2*(EBITDA+2000)");
			unaCondicion = new AnalizarIndicadoresEntreEmpresas("1000", new IgualA(), indicador);
			unaEmpresa = Repositorios.repositorioEmpresas.find(empresa -> empresa.getNombre().equals("Facebook"));
			otraEmpresa = Repositorios.repositorioEmpresas.find(empresa -> empresa.getNombre().equals("Twitter"));			
		}
		
		@Test
		public void condictionTipo3Compara() {
			
			unaCondicion.compararEmpresas(unaEmpresa, otraEmpresa);
			Assert.assertEquals(1, unaEmpresa.getPuntacion());
			
		}
		
		@Test
		public void metodologiaWarrenBuffet()
		{
			Indicador ROE = Repositorios.repositorioIndicadores.find(indicador -> indicador.getNombreIndicador().equals("ROE"));
			Indicador proporcionDeDeuda = Repositorios.repositorioIndicadores.find(indicador -> indicador.getNombreIndicador().equals("ProporcionDeuda"));
			Indicador margen = Repositorios.repositorioIndicadores.find(indicador -> indicador.getNombreIndicador().equals("Margen"));
			//Longevidad longevidad = new Longevidad("Longevidad", "");
			Condicion condicionROE = new AnalizarIndicadorEnUltimosAnios(ROE,  new MayorA(), 10);
			Condicion condicionDeuda = new AnalizarIndicadoresEntreEmpresas("2017", new MenorA(),proporcionDeDeuda);
			Condicion condicionMargen = new AnalizarCrecimientoEnPeriodo(margen, new MayorA(),10);
			//Condicion condicionLongevidad = new AnalizarIndicadoresEntreEmpresas("2000", new MayorA(),longevidad);
			List<Condicion> condiciones = new ArrayList<Condicion>();
			condiciones.add(condicionROE);
			condiciones.add(condicionDeuda);
			condiciones.add(condicionMargen);
			//condiciones.add(condicionLongevidad);
			unaEmpresa.setAnioFundacion(2000);
			otraEmpresa.setAnioFundacion(2002);
			Metodologia warrenBuffet = new Metodologia("Warren Buffet", condiciones);
			List<Empresa> empresas = new ArrayList<Empresa>();
			empresas.add(unaEmpresa);
			empresas.add(otraEmpresa);
			List<Empresa> empresasOrdenadas = warrenBuffet.aplicarMetodologia(empresas);
			Empresa primera = empresasOrdenadas.get(0);
			Empresa segunda = empresasOrdenadas.get(1);
			Assert.assertEquals(3, primera.getPuntacion());
			Assert.assertEquals(1, segunda.getPuntacion());
			Assert.assertEquals(primera.getNombre(), "Facebook");
		}
		
		@After
		public void end()
		{
			Repositorios.repositorioEmpresas.limpiar();
			
		}

}
