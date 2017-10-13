package server;

import spark.Filter;
import spark.Request;
import spark.Response;
import repositories.Repositorios;
import server.Router;

public class SessionHandler {
	
	public static Filter allowed(){

		    return new Filter() {
		    	@Override
		    	public void handle(Request req, Response res){
		    	boolean authenticated = logged(
		    		req.session()
		    		.id(),
		    		req.session()
		    		.attribute("user"));
		    
			    if (!authenticated && !Router.isPublic(req.pathInfo())) {
			    	res.redirect("/login");
			    }
	    	}
	    };
	}

	private static Boolean logged(String id,String user){
		
		return Repositorios.repositorioSesiones.isLogged(id, user);
		 //return true;
	}

}
