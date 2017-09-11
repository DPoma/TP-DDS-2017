package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import model.Cuenta;
import model.Empresa;

public class RepositorioEmpresas {

	//------------------------------------ ATRIBUTOS --------------------------------
	
	private List<Empresa> empresas;
	
	//------------------------------------ CONSTRUCTORES --------------------------------
	
	public RepositorioEmpresas(){
		this.empresas = new ArrayList<Empresa>();
	}
	
	//------------------------------------ GETTERS Y SETTERS --------------------------------
	
	public List<Empresa> getEmpresas(){
		return this.empresas;
	}
	
	//------------------------------------ METODOS--------------------------------
	
	public boolean existeEmpresa(String empresa){
		return empresas.stream().anyMatch(x->x.getNombre().equals(empresa));
	}
	
	public Empresa find(Predicate<? super Empresa> criterio) {
		return this.empresas.stream().filter(criterio).findFirst().get();
	}
	
	
	public void guardarCuenta(String[] linea) {
		//0 = NombreEmpresa | 1 = AnioFundacion  | 2 = NombreCuenta | 3 = anioCuenta | 4 = MontoCuenta
		String nombreEmpresa = linea[0];
		int anioFundacion = Integer.parseInt(linea[1]);
		String nombreCuenta = linea[2];
		int anioCuenta = Integer.parseInt(linea[3]);
		String montoCuenta = linea[4];
		Empresa empresa = this.obtenerEmpresa(nombreEmpresa, anioFundacion);
		Cuenta cuenta = new Cuenta(nombreCuenta, anioCuenta, montoCuenta, empresa);
		empresa.agregarCuenta(cuenta);
	}
	
	public Empresa generarEmpresa(String nombreEmpresa, int anioFundacion) {
		Empresa empresa = new Empresa(nombreEmpresa, anioFundacion);
		empresas.add(empresa);
		return empresa;
	}
	
	
	public Empresa obtenerEmpresa(String nombreEmpresa, int anioFundacion) {
		if(this.existeEmpresa(nombreEmpresa))
			return this.buscarEmpresa(nombreEmpresa);
		else
			return this.generarEmpresa(nombreEmpresa, anioFundacion);
	}
	
	public Empresa buscarEmpresa(String nombre) {
		return this.find(e -> e.getNombre().equals(nombre));
	}
	
	public void limpiar() {
		empresas.clear();
	}
	
	public void eliminarEmpresa(String empresa) {
		this.empresas.removeIf(x->x.getNombre().equals(empresa));
	}
	
	//MAGIA NEGRA
	
	@SuppressWarnings("unchecked")
	public void obtenerEmpresas() {
		EntityManager entity = PerThreadEntityManagers.getEntityManager();
		empresas = (List<Empresa>)entity.createQuery("FROM Empresa").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cuenta> obtenerCuentasDeUnPeriodo(int id, String anio1, String anio2) {
		int anioMinimo = Integer.parseInt(anio1);
		int anioMaximo = Integer.parseInt(anio2);
		EntityManager entity = PerThreadEntityManagers.getEntityManager();
		Query query = entity.createQuery("FROM Cuenta WHERE anio >= :anioMinimo AND anio <= :anioMaximo AND idEmpresa = :id");
		query.setParameter("id", id);
		query.setParameter("anioMinimo", anioMinimo);
		query.setParameter("anioMaximo", anioMaximo);
		List<Cuenta> cuentas = query.getResultList();
		return cuentas; 
	}
	
	public void persistirEmpresas() {
		EntityManager entity = PerThreadEntityManagers.getEntityManager();
	    try {
	    entity.getTransaction().begin();
	    for(Empresa empresa : empresas)
	    	entity.persist(empresa);
	    entity.getTransaction().commit();
	    } catch(HibernateException e) {
	    	entity.getTransaction().rollback();
	    } finally {
	    	entity.close();
	    }
	}

}
