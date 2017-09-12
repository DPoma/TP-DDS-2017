package model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
public abstract class Operacion {

	//------------------------------------ ATRIBUTOS --------------------------------
	
	@Id @GeneratedValue()
	protected int idOperacion;
	
	protected String nombre;
	
	/*
	@OneToMany(mappedBy = "operacion", fetch = FetchType.LAZY)
	protected List<CondicionTipo3> condiciones;
	*/
	
	//----------------------------------- CONSTRUCTORES --------------------------------
	
	public Operacion(String unNombre) {
		nombre = unNombre;
	}
	
	public Operacion() {
		
	}
	
	//------------------------------- GETTERS Y SETTERS --------------------------------


	public String getNombre() {
		return nombre;
	}

	public int getIdOperacion() {
		return idOperacion;
	}

	public void setIdOperacion(int idOperacion) {
		this.idOperacion = idOperacion;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//--------------------------------------- METODOS ----------------------------------
	
	public BigDecimal calcular(Indicador indicador, Empresa empresa)
	{
		return new BigDecimal(0);
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
	
}
