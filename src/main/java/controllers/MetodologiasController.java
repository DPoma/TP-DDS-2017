package controllers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import model.Metodologia;
import repositories.Repositorios;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class MetodologiasController implements WithGlobalEntityManager, TransactionalOps{
	
	public ModelAndView nueva(Request req, Response res){
		//ver la lista
		Metodologia proyectoNuevo = new Metodologia(req.queryParams("nombre"), new List(req.queryParams("costoEstimado")));
		withTransaction(() ->{
			RepositorioProyectos.instancia.agregar(proyectoNuevo);
		});
		res.redirect("/proyectos");
		return null;
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
	
	public ModelAndView aplicar(Request req, Response res){
		//ver como pasar lista de empresas por parametro
		return new ModelAndView(null, "metodologias/home.hbs");
	}
	
}
