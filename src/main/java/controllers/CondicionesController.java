package controllers;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class CondicionesController implements WithGlobalEntityManager, TransactionalOps{
	
	public static ModelAndView nueva(Request req, Response res){
		return new ModelAndView(null, "condiciones/home.hbs");
	}
	
	public static ModelAndView crear(Request req, Response res){
		return new ModelAndView(null, "home/home.hbs");
	}
	
}
