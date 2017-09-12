package repositories;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.persistence.EntityManager;

import org.hibernate.HibernateException;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import model.IgualA;
import model.Indicador;
import model.MayorA;
import model.Mediana;
import model.MenorA;
import model.Operacion;
import model.OperacionIndicador;
import model.Promedio;
import model.Sumatoria;

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
	
	@SuppressWarnings("unchecked")
	public boolean hayOperacionesSinCargar() {
		EntityManager entity = PerThreadEntityManagers.getEntityManager();
		List<Operacion> operaciones = (List<Operacion>)entity.createQuery("FROM Operacion").getResultList();
		List<OperacionIndicador> operacionesInd = (List<OperacionIndicador>)entity.createQuery("FROM OperacionIndicador").getResultList();
		return operaciones.isEmpty() && operacionesInd.isEmpty();
	}
	
	public void cargarOperaciones() {
		if(hayOperacionesSinCargar())
			this.persistirOperaciones();
	}
	
	public void persistirOperaciones() {
		EntityManager entity = PerThreadEntityManagers.getEntityManager();
		entity.getTransaction().begin();
		entity.persist(new MayorA());
		entity.persist(new MenorA());
		entity.persist(new IgualA());
		entity.getTransaction().commit();
		// Para que el contador se reinicie
		entity.getTransaction().begin();
		entity.persist(new Promedio());
		entity.persist(new Sumatoria());
		entity.persist(new Mediana());
		entity.getTransaction().commit();
	}
}
