package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.transform.ToListResultTransformer;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import model.AnalizarCrecimientoEnPeriodo;
import model.AnalizarHistoriaDelIndicador;
import model.AnalizarIndicadorEnUltimosAnios;
import model.AnalizarIndicadoresEntreEmpresas;
import model.Condicion;
import model.Empresa;
import model.Indicador;
import model.Metodologia;
import model.Operacion;
import model.OperacionIndicador;
import model.Usuario;
import repositories.Repositorios;
import scala.Console;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class MetodologiasController implements WithGlobalEntityManager, TransactionalOps{
	
	
	static final String TIPO1 = "Analizar indicador en los ultimos anios";
	static final String TIPO2 = "Analizar indicadores entre empresas";
	static final String TIPO3 = "Analizar historia del indicador";
	static final String TIPO4 = "Analizar crecimiento del indicador";
	static final String TIPO5 = "Analizar por antiguedad";
	
	List<Condicion> condiciones = new ArrayList<Condicion>();
	Map<String, Object> model=new HashMap<>();
	
	public ModelAndView nueva(Request req, Response res){
		Map<String, Object> model=new HashMap<>();
		String usuario = req.params("usuario");
		Repositorios.repositorioIndicadores.obtenerIndicadores();
		Repositorios.repositorioIndicadores.obtenerOperaciones();
		Repositorios.repositorioIndicadores.obtenerOperacionesIndicador();
		Console.println(condiciones);
		model.put("usuario", usuario);
		return new ModelAndView(model, "metodologias/new.hbs");
	}
	
	public ModelAndView mostrar(Request req, Response res){
		
		Map<String, Object> model = new HashMap<>();
		String id = req.params("id");
		String usuario = req.params("usuario");
		Metodologia metodologia = Repositorios
								.repositorioMetodologias
								.find(x->x.getIdMetodologia()==Integer.parseInt(id));
		
		model.put("proyecto", metodologia);
		model.put("usuario", usuario);
		return new ModelAndView(model, "metodologias/show.hbs");
	}
	
	public ModelAndView home(Request req, Response res){
		Map<String, Object> model=new HashMap<>();
		String usuario = req.params("usuario");
		Usuario usr = Repositorios.repositorioUsuarios.buscarUsuario(usuario);
		Repositorios.repositorioEmpresas.obtenerEmpresas();
		Repositorios.repositorioMetodologias.obtenerMetodologias();
		model.put("empresas", Repositorios.repositorioEmpresas.getEmpresas());
		model.put("metodologias", usr.getMetodologias());
		model.put("usuario", usuario);
		condiciones.clear();
		return new ModelAndView(model, "metodologias/home.hbs");
	}
	
	public ModelAndView aplicar(Request req, Response res){
		Map<String, Object> model=new HashMap<>();
		String usuario = req.params("usuario");
		String[] qempresas = req.queryParamsValues("empresas");
		List<String> empresas = Arrays.asList(qempresas);
		List<Empresa> empresasMapeadas = Repositorios.repositorioEmpresas.buscarEmpresasPorNombre(empresas);
		String nombreMetodologia = req.queryParams("nombreMetodologia");
		Metodologia metodologia = Repositorios.repositorioMetodologias.find(m->m.getNombre().equals(nombreMetodologia));
		List<Empresa> empresasOrdenadas = metodologia.aplicarMetodologia(empresasMapeadas);
		model.put("empresas", Repositorios.repositorioEmpresas.getEmpresas());
		model.put("metodologias", Repositorios.repositorioMetodologias.getMetodologias());
		model.put("empresasOrdenadas", empresasOrdenadas);
		model.put("usuario", usuario);
		return new ModelAndView(model, "metodologias/home.hbs");
	}
	
	public ModelAndView crear(Request req, Response res) {
		Metodologia metodologia = new Metodologia(req.queryParams("nombre"), condiciones);
		String usuario = req.params("usuario");
		Usuario user = Repositorios.repositorioUsuarios.buscarUsuario(usuario);
		user.agregarMetodologia(metodologia);
		withTransaction(() ->{
			Repositorios.repositorioMetodologias.persistirMetodologia(metodologia);
		});
		Console.println(metodologia);
		condiciones.clear();
		res.redirect("/metodologias/" + usuario);
		
		return null;
	}
	
	public ModelAndView verCondicionTipo1(Request req, Response res) {
		String usuario = req.params("usuario");
		model.put("usuario", usuario);
		return new ModelAndView(model, "/condiciones/condicion1.hbs");
	}
	
	public ModelAndView verCondicionTipo2(Request req, Response res) {
		String usuario = req.params("usuario");
		model.put("usuario", usuario);
		return new ModelAndView(model, "/condiciones/condicion2.hbs");
	}
	
	public ModelAndView verCondicionTipo3(Request req, Response res) {
		String usuario = req.params("usuario");
		model.put("usuario", usuario);
		return new ModelAndView(model, "/condiciones/condicion3.hbs");
	}
	
	public ModelAndView verCondicionTipo4(Request req, Response res) {
		String usuario = req.params("usuario");
		model.put("usuario", usuario);
		return new ModelAndView(model, "/condiciones/condicion4.hbs");
	}
	
	public ModelAndView crearCondicionTipo1(Request req, Response res) {
		String usuario = req.params("usuario");
		OperacionIndicador operacion = Repositorios.repositorioIndicadores.getOperacionesIndicador().stream().filter(o->o.getNombre().equals(req.queryParams("operacionIndicador"))).findFirst().get();
		Indicador indicador = Repositorios.repositorioIndicadores.find(i->i.getNombreIndicador().equals(req.queryParams("indicador")));
		String anios = req.queryParams("anios");
		Condicion condicion = new AnalizarIndicadorEnUltimosAnios(indicador, operacion, Integer.parseInt(anios));
		condiciones.add(condicion);
		Console.println(condicion);
		Console.println(condiciones);
		res.redirect("/condiciones/"+usuario+"/nueva");
		return null;
	}
	
	public ModelAndView crearCondicionTipo2(Request req, Response res) {
		String usuario = req.params("usuario");
		OperacionIndicador operacion = Repositorios.repositorioIndicadores.getOperacionesIndicador().stream().filter(o->o.getNombre().equals(req.queryParams("operacionIndicador"))).findFirst().get();
		Indicador indicador = Repositorios.repositorioIndicadores.find(i->i.getNombreIndicador().equals(req.queryParams("indicador")));
		String anio = req.queryParams("anio");
		Condicion condicion = new AnalizarIndicadoresEntreEmpresas(anio, operacion, indicador);
		condiciones.add(condicion);
		Console.println(condicion);
		Console.println(condiciones);
		res.redirect("/condiciones/"+usuario+"/nueva");
		return null;
	}
	
	public ModelAndView crearCondicionTipo3(Request req, Response res) {
		String usuario = req.params("usuario");
		OperacionIndicador operacionInd = Repositorios.repositorioIndicadores.getOperacionesIndicador().stream().filter(o->o.getNombre().equals(req.queryParams("operacionIndicador"))).findFirst().get();
		Operacion operacion = Repositorios.repositorioIndicadores.getOperaciones().stream().filter(o->o.getNombre().equals(req.queryParams("operacion"))).findFirst().get();
		Indicador indicador = Repositorios.repositorioIndicadores.find(i->i.getNombreIndicador().equals(req.queryParams("indicador")));
		String valor = req.queryParams("valor");
		Condicion condicion = new AnalizarHistoriaDelIndicador(indicador,operacion, operacionInd, valor);
		condiciones.add(condicion);
		Console.println(condicion);
		Console.println(condiciones);
		res.redirect("/condiciones/"+usuario+"/nueva");
		return null;
	}
	
	public ModelAndView crearCondicionTipo4(Request req, Response res) {
		String usuario = req.params("usuario");
		OperacionIndicador operacion = Repositorios.repositorioIndicadores.getOperacionesIndicador().stream().filter(o->o.getNombre().equals(req.queryParams("operacionIndicador"))).findFirst().get();
		Indicador indicador = Repositorios.repositorioIndicadores.find(i->i.getNombreIndicador().equals(req.queryParams("indicador")));
		String anios = req.queryParams("anios");
		Condicion condicion = new AnalizarCrecimientoEnPeriodo(indicador, operacion, Integer.parseInt(anios));
		condiciones.add(condicion);
		Console.println(condicion);
		Console.println(condiciones);
		res.redirect("/condiciones/"+usuario+"/nueva");
		return null;
	}
	
	public ModelAndView verCondicion(Request req, Response res) {
		String usuario = req.params("usuario");
		Map<String, Object> model=new HashMap<>();
		model.put("usuario", usuario);
		return new ModelAndView(model, "/condiciones/new.hbs");
	}
	
	public ModelAndView crearCondicion(Request req, Response res) {
		String usuario = req.params("usuario");
		Usuario usr = Repositorios.repositorioUsuarios.buscarUsuario(usuario);
		Repositorios.repositorioIndicadores.obtenerIndicadores();
		Repositorios.repositorioIndicadores.obtenerOperaciones();
		Repositorios.repositorioIndicadores.obtenerOperacionesIndicador();
		model.put("operacionesIndicador", Repositorios.repositorioIndicadores.getOperacionesIndicador());
		model.put("operaciones", Repositorios.repositorioIndicadores.getOperaciones());
		model.put("indicadores", usr.getIndicadores());
		switch(req.queryParams("nombreCondicion")){
			case TIPO1: res.redirect("condicionTipo1");
			case TIPO2: res.redirect("condicionTipo2");
			case TIPO3: res.redirect("condicionTipo3");
			case TIPO4: res.redirect("condicionTipo4");
			default: return null;
		}
	}

}
