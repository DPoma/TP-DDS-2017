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
	
	//NO MIRAR
	
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
	
	public boolean hayOperacionesSinCargar() {
		List<Operacion> operaciones = this.obtenerOperaciones();
		List<OperacionIndicador> operacionesIndicador = this.obtenerOperacionesIndicador();
		return operaciones.isEmpty() && operacionesIndicador.isEmpty();
	}
	
	@SuppressWarnings("unchecked")
	public List<Operacion> obtenerOperaciones() {
		EntityManager entity = PerThreadEntityManagers.getEntityManager();
		List<Operacion> operaciones = (List<Operacion>)entity.createQuery("FROM Operacion").getResultList();
		return operaciones;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<OperacionIndicador> obtenerOperacionesIndicador() {
		EntityManager entity = PerThreadEntityManagers.getEntityManager();
		List<OperacionIndicador> operacionesIndicador = (List<OperacionIndicador>)entity.createQuery("FROM OperacionIndicador").getResultList();
		return operacionesIndicador;
	}
	
	public void cargarOperaciones() {
		if(hayOperacionesSinCargar())
			this.persistirOperaciones();
	}
	
	public void persistirOperaciones() {
		EntityManager entity = PerThreadEntityManagers.getEntityManager();
		entity.getTransaction().begin();
		entity.persist(new MayorA("MayorA"));
		entity.persist(new MenorA("MenorA"));
		entity.persist(new IgualA("IgualA"));
		entity.getTransaction().commit();
		// Para que el contador se reinicie
		entity.getTransaction().begin();
		entity.persist(new Promedio("Promedio"));
		entity.persist(new Sumatoria("Sumatoria"));
		entity.persist(new Mediana("Mediana"));
		entity.getTransaction().commit();
	}
}
