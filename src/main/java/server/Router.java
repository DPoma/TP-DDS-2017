package server;

import java.util.HashSet;
import java.util.Set;

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

		Spark.before(SessionHandler.allowed());
		
		HomeController homeController = new HomeController();
		EmpresasController empresasController = new EmpresasController();
		IndicadoresController indicadoresController = new IndicadoresController();
		MetodologiasController metodologiasController = new MetodologiasController();
		
		Spark.get("/", homeController::home, engine);
		Spark.get("/login", homeController::login, engine);
		Spark.post("/login", homeController::newSession);
		
		Spark.get("/empresas", empresasController::home,engine);
		
		Spark.get("/metodologias", metodologiasController::home, engine);
		Spark.get("/metodologias/nueva", metodologiasController::nueva, engine);
		Spark.post("/metodologias/nueva", metodologiasController::crear, engine);
		Spark.get("/metodologias/:id", metodologiasController::mostrar, engine);
		
		Spark.get("/indicadores", indicadoresController::home, engine);
		Spark.get("/indicadores/nuevo", indicadoresController::nuevo, engine);
		Spark.post("/indicadores/nuevo", indicadoresController::crear, engine);
	}
	
	public static Boolean isPublic(String route){
		return publicRoutes.contains(route);
	}
	
	private static void setPublicRoutes(Set<String> publicRoutes){
		publicRoutes.add("/login");
	}

}