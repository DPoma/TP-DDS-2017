package server;

import spark.Filter;
import spark.Request;
import spark.Response;
import spark.Spark;
import server.Router;

public class SessionHandler {
	
	public void loginAttempt (Request req, Response res){
		Spark.before(req.pathInfo(), allowed(req,res));
	}
	
	private Filter allowed(Request req, Response res){
		    return new Filter() {
		    	@Override
		    	public void handle(Request req, Response res){
		    	boolean authenticated = logged(
		    		req.session()
		    		.attribute("user"),
		    		req.session()
		    		.attribute("password"));
		    
			    if (!authenticated || !Router.isPublic(req.pathInfo())) {
			    	res.redirect("/login");
			    }
	    	}
	    };
	}

	private static Boolean logged(String user,String password){
		 return true;
	}

}
