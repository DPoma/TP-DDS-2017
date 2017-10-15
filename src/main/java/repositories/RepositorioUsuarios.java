package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import model.Empresa;
import model.Usuario;
import model.UsuarioIncorrecto;

public class RepositorioUsuarios {

	//------------------------------------ ATRIBUTOS --------------------------------
	
	private EntityManager entity;
	
	//------------------------------------ CONSTRUCTORES --------------------------------
	
	public RepositorioUsuarios(){
		this.entity = PerThreadEntityManagers.getEntityManager();
		
	}
	
	
	public Usuario buscarUsuario(String user) {
		Query query = entity.createQuery("FROM Usuario WHERE username = :user");
		query.setParameter("user", user);
		try{
		Usuario result = (Usuario)query.getSingleResult();
		return result;
		}catch(Exception e){return new UsuarioIncorrecto();}
	}
	

	
}
