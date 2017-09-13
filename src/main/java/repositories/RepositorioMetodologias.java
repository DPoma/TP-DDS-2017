package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.persistence.EntityManager;

import org.hibernate.HibernateException;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import model.AnalizarHistoriaDelIndicador;
import model.AnalizarIndicadorEnUltimosAnios;
import model.AnalizarIndicadoresEntreEmpresas;
import model.Condicion;
import model.Indicador;
import model.Longevidad;
import model.MayorA;
import model.MenorA;
import model.Metodologia;
import model.Operacion;
import model.OperacionIndicador;
import model.Promedio;
import model.Sumatoria;


@SuppressWarnings("unused")
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
	
	public boolean hayOperacionesSinCargar() {
		Repositorios.repositorioIndicadores.obtenerOperaciones();
		Repositorios.repositorioIndicadores.obtenerOperacionesIndicador();
		this.obtenerMetodologias();
		return Repositorios.repositorioIndicadores.getOperaciones().isEmpty() || Repositorios.repositorioIndicadores.getOperacionesIndicador().isEmpty()  || this.getMetodologias().isEmpty(); 
	}
	
	
	public void cargarOperaciones() {
		if(hayOperacionesSinCargar())
			this.cargarTodo();
	}
	
	public void cargarTodo() {
		
		//EntityManager entity = PerThreadEntityManagers.getEntityManager();
		
		//OperacionIndicador mayorA = new MayorA("MayorA");
		//OperacionIndicador menorA = new MenorA("MenorA");
		

		
		//Operacion sumatoria = new Sumatoria("Sumatoria");
		//Operacion promedio = new Promedio("Promedio");
		
		//Condicion condicion1 = new AnalizarIndicadorEnUltimosAnios(roe, entity.find(OperacionIndicador.class, 1) , 10); 
		//Condicion condicion2 = new AnalizarIndicadoresEntreEmpresas("2013",entity.find(OperacionIndicador.class, 1), proporcionDeuda); 
		//Condicion condicion3 = new AnalizarHistoriaDelIndicador(margen, entity.find(Operacion.class, 1), entity.find(OperacionIndicador.class, 1),"10000000"); 
		//Condicion condicion4 = new Longevidad();
		
		/*
		List<Condicion> condiciones = new ArrayList<Condicion>();
		condiciones.add(condicion1);
		condiciones.add(condicion2);
		condiciones.add(condicion3);
		condiciones.add(condicion4);
		
		try {
			
	
			
			
		} catch(HibernateException e) {
			entity.getTransaction().rollback();
		} finally {
			entity.close();
		}
		]*/
		
//		Metodologia warrenBuffet = new Metodologia("WarrenBuffet", condiciones);
//		warrenBuffet.guardar();
	}
}
