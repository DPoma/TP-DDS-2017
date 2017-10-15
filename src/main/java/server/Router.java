package server;

import java.util.HashSet;
import java.util.Set;

import controllers.CondicionesController;
import controllers.EmpresasController;
import controllers.HomeController;
import controllers.IndicadoresController;
import controllers.MetodologiasController;
import spark.Filter;
import spark.Request;
import spark.Response;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.BooleanHelper;
import spark.utils.HandlebarsTemplateEngineBuilder;

public class Router {
	
	static Set<String> publicRoutes = new HashSet<String>();

	public static void configure() {
		HandlebarsTemplateEngine engine = HandlebarsTemplateEngineBuilder
				.create()
				.withDefaultHelpers()
				.withHelper("isTrue", BooleanHelper.isTrue)
				.build();

		Spark.staticFiles.location("/public");
		setPublicRoutes(publicRoutes);

		Spark.before(SessionHandler.allowed());
		
		HomeController homeController = new HomeController();
		IndicadoresController indicadoresController = new IndicadoresController();
		
		Spark.get("/", HomeController::home, engine);
		Spark.get("/login", HomeController::login, engine);
		Spark.get("/wrong-user-or-pass", HomeController::wrongLogin, engine);
		Spark.post("/wrong-user-or-pass", HomeController::wrongLogin, engine);
		Spark.post("/login", homeController::newSession);
		Spark.get("/empresas", EmpresasController::listar,engine);
		Spark.get("/metodologias", MetodologiasController::aplicar, engine);
		Spark.post("/metodologias/nueva", MetodologiasController::nueva, engine);
		Spark.get("/metodologias/:id", MetodologiasController::mostrar, engine);
		Spark.get("/indicadores", IndicadoresController::nuevo, engine);
		Spark.post("/indicadores", indicadoresController::crear, engine);
		Spark.get("/condiciones", CondicionesController::nueva, engine);
		Spark.post("/condiciones", CondicionesController::crear, engine);
		
		
		
	}
	
	public static Boolean isPublic(String route){
		return publicRoutes.contains(route);
	}
	
	private static void setPublicRoutes(Set<String> publicRoutes){
		publicRoutes.add("/login");
	}

}