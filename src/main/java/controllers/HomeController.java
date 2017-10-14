package controllers;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import model.Usuario;
import repositories.RepositorioUsuarios;
import repositories.Repositorios;
import scala.Console;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Session;

public class HomeController implements WithGlobalEntityManager, TransactionalOps{
	
	public static ModelAndView home(Request req, Response res){
		
		return new ModelAndView(null, "home/home.hbs");
	}
	
	public static ModelAndView login (Request req, Response res){
	
		return new ModelAndView(null, "home/login.hbs");
	}
	
	public Void newSession(Request req, Response res){
		
		String username = req.queryParams("user");
		String pass = req.queryParams("password");
		Console.println(pass);
		Usuario user = Repositorios.repositorioUsuarios.buscarUsuario(username);
		if(user.loginCorrecto(pass))
		{
			Console.println("COREC");
			Session sesion = req.session(true);
			sesion.attribute("user", username);
		}
		res.redirect("/");	
		return null;
	}
}
