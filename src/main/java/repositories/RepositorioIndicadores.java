package repositories;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.persistence.EntityManager;

import org.hibernate.HibernateException;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import model.Empresa;
import model.Indicador;

public class RepositorioIndicadores {

	//------------------------------------ ATRIBUTOS --------------------------------
	
	private List<Indicador> indicadores;

	//------------------------------------ CONSTRUCTORES --------------------------------
	
	public RepositorioIndicadores() {
		this.indicadores = new ArrayList<Indicador>();
	}

	//------------------------------------ GETTERS Y SETTERS --------------------------------
	
	public List<Indicador> getIndicadores() {
		return indicadores;
	}
	//------------------------------------ METODOS --------------------------------
	
	public void agregarIndicador(Indicador indicador)
	{
		this.indicadores.add(indicador);
	}
	
	public Indicador find(Predicate<? super Indicador> criterio)
	{
		return this.indicadores.stream().filter(criterio).findFirst().get();
	}
	
	@SuppressWarnings("unchecked")
	public List<Indicador> obtenerIndicadores() {
		EntityManager entity = PerThreadEntityManagers.getEntityManager();
		indicadores = (List<Indicador>)entity.createQuery("FROM Indicador").getResultList();
		return indicadores; 
	}
	
	public void persistirIndicador(Indicador indicador) {
		EntityManager entity = PerThreadEntityManagers.getEntityManager();
	    try {
	    entity.getTransaction().begin();
	    entity.persist(indicador);
	    entity.getTransaction().commit();
	    } catch(HibernateException e) {
	    	entity.getTransaction().rollback();
	    } finally {
	    	entity.close();
	    }
	}
}
