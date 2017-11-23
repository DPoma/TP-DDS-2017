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

 		Spark.get("/principal/:usuario", homeController::home, engine);
 		Spark.get("/login", homeController::login, engine);
  		Spark.post("/login", homeController::newSession);
		Spark.get("/wrong-user-or-pass", homeController::wrongLogin, engine);
		Spark.post("/wrong-user-or-pass", homeController::wrongLogin, engine);
  		

		Spark.get("/cuentas/:usuario", empresasController::verArchivos,engine);
		Spark.post("/cuentas/:usuario", empresasController::cargarArchivos,engine);
		Spark.get("/cuentas/:usuario/archivo-invalido.hbs", empresasController::archivoInvalido,engine);
 		Spark.get("/empresas/:usuario", empresasController::home,engine);
 		Spark.post("/empresas/:usuario", empresasController::aplicar,engine);

  		
 		Spark.get("/metodologias/:usuario", metodologiasController::home, engine);
 		Spark.post("/metodologias/:usuario", metodologiasController::aplicar, engine);
 		Spark.get("/metodologias/:usuario/nueva", metodologiasController::nueva, engine);
 		Spark.post("/metodologias/:usuario/nueva", metodologiasController::crear, engine);
 		Spark.get("/metodologias/:id", metodologiasController::mostrar, engine);
  		
 		Spark.get("/indicadores/:usuario", indicadoresController::home, engine);
 		Spark.post("/indicadores/:usuario", indicadoresController::aplicar, engine);
 		Spark.get("/indicadores/:usuario/nuevo", indicadoresController::nuevo, engine);
 		Spark.get("/indicadores/:usuario/error", indicadoresController::error, engine);
 		Spark.post("/indicadores/:usuario/nuevo", indicadoresController::crear, engine);
 		
 		
 		Spark.get("/condiciones/:usuario/nueva", metodologiasController::verCondicion, engine);
 		Spark.post("/condiciones/:usuario/nueva", metodologiasController::crearCondicion, engine);
		Spark.get("/condiciones/:usuario/condicionTipo1", metodologiasController::verCondicionTipo1, engine);
		Spark.post("/condiciones/:usuario/condicionTipo1", metodologiasController::crearCondicionTipo1, engine);
		Spark.get("/condiciones/:usuario/condicionTipo2", metodologiasController::verCondicionTipo2, engine);
		Spark.post("/condiciones/:usuario/condicionTipo2", metodologiasController::crearCondicionTipo2, engine);
		Spark.get("/condiciones/:usuario/condicionTipo3", metodologiasController::verCondicionTipo3, engine);
		Spark.post("/condiciones/:usuario/condicionTipo3", metodologiasController::crearCondicionTipo3, engine);
		Spark.get("/condiciones/:usuario/condicionTipo4", metodologiasController::verCondicionTipo4, engine);
		Spark.post("/condiciones/:usuario/condicionTipo4", metodologiasController::crearCondicionTipo4, engine);

	}
	
	public static Boolean isPublic(String route){
		return publicRoutes.contains(route);
	}
	
	private static void setPublicRoutes(Set<String> publicRoutes){
		publicRoutes.add("/login");
		publicRoutes.add("/wrong-user-or-pass");
	}

}