package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import model.Empresa;
import repositories.Repositorios;
import server.SessionHandler;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Spark;

public class EmpresasController implements WithGlobalEntityManager, TransactionalOps{
	
	public static ModelAndView listar(Request req, Response res){
		
		Map<String, List<Empresa>> model = new HashMap<>();
		List<Empresa> empresas = Repositorios.repositorioEmpresas.getEmpresas();
		model.put("proyectos", empresas);
		return new ModelAndView(model, "empresas/index.hbs");
		
	}
	
}
