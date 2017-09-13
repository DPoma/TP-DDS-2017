package repositories;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.persistence.EntityManager;

import org.hibernate.HibernateException;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import model.Indicador;
import model.MayorA;
import model.MenorA;
import model.Operacion;
import model.OperacionIndicador;
import model.Promedio;
import model.Sumatoria;

public class RepositorioIndicadores {

	//------------------------------------ ATRIBUTOS --------------------------------
	
	private List<Indicador> indicadores;
	private List<Operacion> operaciones;
	private List<OperacionIndicador> operacionesIndicador;

	//------------------------------------ CONSTRUCTORES --------------------------------
	
	public RepositorioIndicadores() {
		this.indicadores = new ArrayList<Indicador>();
		this.operaciones = new ArrayList<Operacion>();
		this.operacionesIndicador = new ArrayList<OperacionIndicador>();
	}

	//------------------------------------ GETTERS Y SETTERS --------------------------------
	
	public List<Indicador> getIndicadores() {
		return indicadores;
	}
	
	
	public List<Operacion> getOperaciones() {
		return operaciones;
	}

	public List<OperacionIndicador> getOperacionesIndicador() {
		return operacionesIndicador;
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
	public void obtenerIndicadores() {
		EntityManager entity = PerThreadEntityManagers.getEntityManager();
		indicadores = (List<Indicador>)entity.createQuery("FROM Indicador").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public void obtenerOperaciones() {
		EntityManager entity = PerThreadEntityManagers.getEntityManager();
		operaciones = (List<Operacion>)entity.createQuery("FROM Operacion").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public void obtenerOperacionesIndicador() {
		EntityManager entity = PerThreadEntityManagers.getEntityManager();
		operacionesIndicador = (List<OperacionIndicador>)entity.createQuery("FROM OperacionIndicador").getResultList();
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
		this.obtenerOperaciones();
		this.obtenerOperacionesIndicador();
		return operaciones.isEmpty() || operacionesIndicador.isEmpty();
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
		entity.getTransaction().commit();
		// Para que el contador se reinicie
		entity.getTransaction().begin();
		entity.persist(new Sumatoria("Sumatoria"));
		entity.persist(new Promedio("Promedio"));
		entity.getTransaction().commit();
		//
		entity.getTransaction().begin();
		Indicador roe = new Indicador("ROE", "(IngresoNeto-dividendos)/capitalTotal");
		Indicador proporcionDeuda = new Indicador("ProporcionDeuda", "FDS/IngresoNeto");
		Indicador margen = new Indicador("Margen", "IngresoNeto/EBITDA");
		entity.persist(roe);
		entity.persist(proporcionDeuda);
		entity.persist(margen);
		entity.getTransaction().commit();	
	}
}
