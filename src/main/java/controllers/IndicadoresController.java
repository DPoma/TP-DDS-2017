package controllers;

import java.math.BigDecimal;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import model.Indicador;
import repositories.Repositorios;
import server.SessionHandler;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class IndicadoresController implements WithGlobalEntityManager, TransactionalOps{
	
	public ModelAndView nuevo(Request req, Response res){
		
		SessionHandler session = new SessionHandler();
		session.loginAttempt(req, res);
		
		return new ModelAndView(null, "home/home.hbs");
	}
	
	public ModelAndView crear(Request req, Response res){
		
		SessionHandler session = new SessionHandler();
		session.loginAttempt(req, res);
		
		Indicador indicador = new Indicador(req.queryParams("nombre"), req.queryParams("formula"));
		withTransaction(() ->{
			Repositorios.repositorioIndicadores.agregarIndicador(indicador);
		});
		res.redirect("/proyectos");
		return null;
	}
	
}
