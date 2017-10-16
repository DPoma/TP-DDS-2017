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

		Spark.before(SessionHandler.allowed());
		
 		HomeController homeController = new HomeController();
 		EmpresasController empresasController = new EmpresasController();
  		IndicadoresController indicadoresController = new IndicadoresController();
 		MetodologiasController metodologiasController = new MetodologiasController();
 		CondicionesController condicionesController = new CondicionesController();

 		Spark.get("/", homeController::home, engine);
 		Spark.get("/login", homeController::login, engine);
  		Spark.post("/login", homeController::newSession);
		Spark.get("/wrong-user-or-pass", homeController::wrongLogin, engine);
		Spark.post("/wrong-user-or-pass", homeController::wrongLogin, engine);
  		
		Spark.get("/cargar", empresasController::verArchivos,engine);
		Spark.post("/cargar", empresasController::cargarArchivos,engine);
		
 		Spark.get("/empresas", empresasController::home,engine);
 		Spark.post("/empresas", empresasController::aplicar,engine);
  		
 		Spark.get("/metodologias", metodologiasController::home, engine);
 		Spark.post("/metodologias", metodologiasController::aplicar, engine);
 		Spark.get("/metodologias/nueva", metodologiasController::nueva, engine);
 		Spark.post("/metodologias/nueva", metodologiasController::condicionCrearTipo, engine);
 		Spark.get("/metodologias/:id", metodologiasController::mostrar, engine);
  		
 		Spark.get("/indicadores", indicadoresController::home, engine);
 		Spark.post("/indicadores", indicadoresController::aplicar, engine);
 		Spark.get("/indicadores/nuevo", indicadoresController::nuevo, engine);
 		Spark.post("/indicadores/nuevo", indicadoresController::crear, engine);
 		
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