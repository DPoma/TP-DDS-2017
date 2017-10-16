package controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import model.Empresa;
import model.FileHandler;
import repositories.Repositorios;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class EmpresasController implements WithGlobalEntityManager, TransactionalOps{
	
	public ModelAndView home(Request req, Response res){
		Map<String, List<Empresa>> model = new HashMap<>();
		Repositorios.repositorioEmpresas.obtenerEmpresas();
		model.put("empresas",  Repositorios.repositorioEmpresas.getEmpresas());
		return new ModelAndView(model, "empresas/home.hbs");
	}
	
	public ModelAndView aplicar(Request req, Response res){
		Map<String, Object> model = new HashMap<>();
		String nombreEmpresa = req.queryParams("nombreEmpresa");
		Empresa empresa = Repositorios.repositorioEmpresas.buscarEmpresa(nombreEmpresa);
		String anioMin = req.queryParams("anioMin");
		String anioMax = req.queryParams("anioMax");
		model.put("cuentas", Repositorios.repositorioEmpresas.obtenerCuentasDeUnPeriodo(empresa.getIdEmpresa(), anioMin, anioMax));
		model.put("empresas",  Repositorios.repositorioEmpresas.getEmpresas());
		return new ModelAndView(model, "empresas/home.hbs");
	}
	
	public ModelAndView verArchivos(Request req, Response res){
		return new ModelAndView(null, "empresas/carga.hbs");
	}
	
	public ModelAndView cargarArchivos(Request req, Response res) throws IOException{
		String ruta = req.queryParams("ruta");
		FileHandler lector= new FileHandler();
		lector.importarArchivoCuentas(ruta);
		res.redirect("/");
		return null;
	}
}
