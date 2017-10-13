package repositories;

import java.util.ArrayList;
import java.util.List;

import spark.Session;

public class RepositorioSesiones {
	
	List<Session> sessions = new ArrayList<Session>();

	public void nueva(Session session){
		sessions.add(session);
		System.out.println("guarde esto "+session);
	}
	
	public Boolean isLogged(String id, String user){
		return sessions.stream().anyMatch(x->x.id().equals(id) || x.attribute("user").equals(user));
	}
	
	public void delete (String id, String user){
		sessions.removeIf(x->x.id().equals(id) && x.attribute("user").equals(user));
	}
	
}
