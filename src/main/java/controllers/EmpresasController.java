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
		Map<String, Object> model = new HashMap<>();
		String usuario = req.params("usuario");
		Repositorios.repositorioEmpresas.obtenerEmpresas();
		model.put("empresas",  Repositorios.repositorioEmpresas.getEmpresas());
		model.put("usuario", usuario);
		return new ModelAndView(model, "empresas/home.hbs");
	}
	
	public ModelAndView aplicar(Request req, Response res){
		Map<String, Object> model = new HashMap<>();
		String nombreEmpresa = req.queryParams("nombreEmpresa");
		String usuario = req.params("usuario");
		Empresa empresa = Repositorios.repositorioEmpresas.buscarEmpresa(nombreEmpresa);
		String anioMin = req.queryParams("anioMin");
		String anioMax = req.queryParams("anioMax");
		model.put("cuentas", Repositorios.repositorioEmpresas.obtenerCuentasDeUnPeriodo(empresa.getIdEmpresa(), anioMin, anioMax));
		model.put("empresas",  Repositorios.repositorioEmpresas.getEmpresas());
		model.put("usuario", usuario);
		return new ModelAndView(model, "empresas/home.hbs");
	}
	
	public ModelAndView verArchivos(Request req, Response res){
		String usuario = req.params("usuario");
		Map<String, Object> model = new HashMap<>();
		model.put("usuario", usuario);
		return new ModelAndView(model, "empresas/carga.hbs");
	}
	
	public ModelAndView cargarArchivos(Request req, Response res) throws IOException{
		String ruta = req.queryParams("ruta");
		String usuario = req.params("usuario");
		FileHandler lector= new FileHandler();
		lector.importarArchivoCuentas(ruta);
		res.redirect("/principal/"+ usuario);
		return null;
	}
}
