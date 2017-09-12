package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.persistence.EntityManager;

import org.hibernate.HibernateException;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import model.Condicion;
import model.Metodologia;


public class RepositorioMetodologias{
	
	//------------------------------------- ATRIBUTOS ----------------------------------
	
	private List<Metodologia> metodologias;
	
	//----------------------------------- CONSTRUCTORES --------------------------------
	
	public RepositorioMetodologias() {
		this.metodologias = new ArrayList<Metodologia>();
		
	}

	//------------------------------- GETTERS Y SETTERS --------------------------------
	
	public List<Metodologia> getMetodologias() {
		return metodologias;
	}

	//--------------------------------------- METODOS ----------------------------------

	public void agregarMetodologia(Metodologia metodologia) {
		this.metodologias.add(metodologia);
	}
	
	
	public void crearMetodologia(String nombre, List<Condicion> condiciones) {
		Metodologia metodologia = new Metodologia(nombre, condiciones);
		metodologia.asignarseEnSusCondiciones();
		this.persistirMetodologia(metodologia);
	}
	
	@SuppressWarnings("unchecked")
	public void obtenerMetodologias() {
		EntityManager entity = PerThreadEntityManagers.getEntityManager();
		metodologias = (List<Metodologia>)entity.createQuery("FROM Metodologia").getResultList();
	}
	
	public Metodologia find(Predicate<? super Metodologia> criterio)
	{
		return this.metodologias.stream().filter(criterio).findFirst().get();
	}
	
	public void persistirMetodologia(Metodologia metodologia) {
		EntityManager entity = PerThreadEntityManagers.getEntityManager();
	    try {
	    entity.getTransaction().begin();
	    entity.persist(metodologia);
	    entity.getTransaction().commit();
	    } catch(HibernateException e) {
	    	entity.getTransaction().rollback();
	    } finally {
	    	entity.close();
	    }
	}
}
