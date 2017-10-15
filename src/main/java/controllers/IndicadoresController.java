package controllers;


import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import model.Indicador;
import repositories.Repositorios;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class IndicadoresController implements WithGlobalEntityManager, TransactionalOps{
	
	public ModelAndView mostrar(Request req, Response res){
		
		return new ModelAndView(null, "indicadores/show.hbs");
	}
	
	public ModelAndView home(Request req, Response res){
		
		return new ModelAndView(null, "indicadores/home.hbs");
	}
	
	public ModelAndView nuevo(Request req, Response res){
		
		return new ModelAndView(null, "indicadores/new.hbs");
	}
	
	public ModelAndView crear(Request req, Response res){
		Indicador indicador = new Indicador(req.queryParams("nombre"), req.queryParams("formula"));
		withTransaction(() ->{
			Repositorios.repositorioIndicadores.agregarIndicador(indicador);
		});
		res.redirect("/indicadores");
		return null;
	}
	
}
