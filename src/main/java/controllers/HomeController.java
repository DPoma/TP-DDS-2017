package controllers;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class HomeController implements WithGlobalEntityManager, TransactionalOps{
	
	public static ModelAndView home(Request req, Response res){
		return new ModelAndView(null, "home/home.hbs");
	}
	
	public ModelAndView login (Request req, Response res){
		return new ModelAndView(null, "home/home.hbs");
	}
	
}
