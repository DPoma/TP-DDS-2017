package controllers;

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
		return new ModelAndView(null, "metodologias/new.hbs");
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
		//ver como pasar lista de empresas por parametro
		return new ModelAndView(null, "metodologias/home.hbs");
	}
	
	public ModelAndView crear(Request req, Response res) {
		return null;
	}
	
}
