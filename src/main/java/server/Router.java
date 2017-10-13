package server;

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

	public static void configure() {
		HandlebarsTemplateEngine engine = HandlebarsTemplateEngineBuilder
				.create()
				.withDefaultHelpers()
				.withHelper("isTrue", BooleanHelper.isTrue)
				.build();

		Spark.staticFiles.location("/public");

		HomeController homeController = new HomeController();
		EmpresasController empresasController = new EmpresasController();
		IndicadoresController indicadoresController = new IndicadoresController();
		CondicionesController condicionesController = new CondicionesController();
		MetodologiasController metodologiasController = new MetodologiasController();
		
		Spark.get("/", homeController::login, engine);
		Spark.get("/home", HomeController::home, engine);
		Spark.get("/empresas", empresasController::listar,engine);
		Spark.get("/metodologias", metodologiasController::aplicar, engine);
		Spark.post("/metodologias/nueva", metodologiasController::nueva, engine);
		Spark.get("/metodologias/:id", metodologiasController::mostrar, engine);
		Spark.get("/indicadores", indicadoresController::nuevo, engine);
		Spark.post("/indicadores", indicadoresController::crear, engine);
		Spark.get("/condiciones", condicionesController::nueva, engine);
		Spark.post("/condiciones", condicionesController::crear, engine);
		
		
	}

}