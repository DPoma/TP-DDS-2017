package controllers;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import repositories.Repositorios;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class HomeController implements WithGlobalEntityManager, TransactionalOps{
	
	public static ModelAndView home(Request req, Response res){
		
		return new ModelAndView(null, "home/home.hbs");
	}
	
	public static ModelAndView login (Request req, Response res){
		return new ModelAndView(null, "home/login.hbs");
	}
	
	public Void newSession(Request req, Response res){
		System.out.println("a");
		withTransaction(() ->{
			Repositorios.repositorioSesiones.nueva(req.session());
		});
		res.redirect("/");
		return null;
	}
}
