package controllers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ProyectosController implements WithGlobalEntityManager, TransactionalOps{
	
	public ModelAndView nuevo(Request req, Response res){
		return new ModelAndView(null, "proyectos/new.hbs");
	}

}
