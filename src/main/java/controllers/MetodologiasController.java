package controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import model.Empresa;
import model.Metodologia;
import repositories.Repositorios;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class MetodologiasController implements WithGlobalEntityManager, TransactionalOps{
	
	public ModelAndView nueva(Request req, Response res){
		Map<String, Object> model=new HashMap<>();
		Repositorios.repositorioIndicadores.obtenerOperaciones();
		Repositorios.repositorioIndicadores.obtenerOperacionesIndicador();
		return new ModelAndView(model, "metodologias/new.hbs");
	}
	
	public ModelAndView mostrar(Request req, Response res){
		
		Map<String, Metodologia> model = new HashMap<>();
		String id = req.params("id");
		
		Metodologia metodologia = Repositorios
								.repositorioMetodologias
								.find(x->x.getIdMetodologia()==Integer.parseInt(id));
		
		model.put("proyecto", metodologia);
		return new ModelAndView(model, "metodologias/show.hbs");
	}
	
	public ModelAndView home(Request req, Response res){
		Map<String, Object> model=new HashMap<>();
		Repositorios.repositorioEmpresas.obtenerEmpresas();
		Repositorios.repositorioMetodologias.obtenerMetodologias();
		model.put("empresas", Repositorios.repositorioEmpresas.getEmpresas());
		model.put("metodologias", Repositorios.repositorioMetodologias.getMetodologias());
		return new ModelAndView(model, "metodologias/home.hbs");
	}
	
	public ModelAndView aplicar(Request req, Response res){
		Map<String, Object> model=new HashMap<>();
		String[] qempresas = req.queryParamsValues("empresas");
		List<String> empresas = Arrays.asList(qempresas);
		List<Empresa> empresasMapeadas = Repositorios.repositorioEmpresas.buscarEmpresasPorNombre(empresas);
		String nombreMetodologia = req.queryParams("nombreMetodologia");
		Metodologia metodologia = Repositorios.repositorioMetodologias.find(m->m.getNombre().equals(nombreMetodologia));
		List<Empresa> empresasOrdenadas = metodologia.aplicarMetodologia(empresasMapeadas);
		model.put("empresas", Repositorios.repositorioEmpresas.getEmpresas());
		model.put("metodologias", Repositorios.repositorioMetodologias.getMetodologias());
		model.put("empresasOrdenadas", empresasOrdenadas);
		return new ModelAndView(model, "metodologias/home.hbs");
	}
	
	public ModelAndView crear(Request req, Response res) {
		/*
		List<Condicion> condiciones = new ArrayList<Condicion>();  
		condiciones = req.queryParams("condiciones")
		Metodologia metodologia = new Metodologia(req.queryParams("nombre"), condiciones);
		withTransaction(() ->{
			Repositorios.repositorioMetodologias.persistirMetodologia(metodologia);
		});
		res.redirect("/metodologias");
		*/
		return null;
	}
	
}
