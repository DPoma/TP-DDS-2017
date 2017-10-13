package server;

import java.util.HashSet;
import java.util.Set;

import controllers.CondicionesController;
import controllers.EmpresasController;
import controllers.HomeController;
import controllers.IndicadoresController;
import controllers.MetodologiasController;
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
		
		//HomeController homeController = new HomeController();
		EmpresasController empresasController = new EmpresasController();
		IndicadoresController indicadoresController = new IndicadoresController();
		CondicionesController condicionesController = new CondicionesController();
		MetodologiasController metodologiasController = new MetodologiasController();
		
		Spark.get("/", HomeController::home, engine);
		//Spark.get("/home", HomeController::home, engine);
		Spark.get("/empresas", empresasController::listar,engine);
		Spark.get("/metodologias", metodologiasController::aplicar, engine);
		Spark.post("/metodologias/nueva", metodologiasController::nueva, engine);
		Spark.get("/metodologias/:id", metodologiasController::mostrar, engine);
		Spark.get("/indicadores", indicadoresController::nuevo, engine);
		Spark.post("/indicadores", indicadoresController::crear, engine);
		Spark.get("/condiciones", condicionesController::nueva, engine);
		Spark.post("/condiciones", condicionesController::crear, engine);
		
		
	}
	
	public static Boolean isPublic(String route){
		return publicRoutes.contains(route);
	}
	
	private static void setPublicRoutes(Set<String> publicRoutes){
		publicRoutes.add("/login");
	}

}