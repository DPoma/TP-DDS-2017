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
public abstract class OperacionIndicador {
	
	//------------------------------------ ATRIBUTOS --------------------------------
	
	@Id @GeneratedValue
	protected int idOperacionIndicador;

	protected String nombre;
	
	/*
	@OneToMany(mappedBy = "operacionIndicador", fetch = FetchType.LAZY)
	protected List<Condicion> condiciones;
	*/
	
	//----------------------------------- CONSTRUCTORES --------------------------------
	
	public OperacionIndicador() {
		
	}

	//------------------------------- GETTERS Y SETTERS --------------------------------
	
	public int getIdOperacionIndicador() {
		return idOperacionIndicador;
	}

	public void setIdOperacionIndicador(int idOperacionIndicador) {
		this.idOperacionIndicador = idOperacionIndicador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	//--------------------------------------- METODOS ----------------------------------
	
	public boolean operar(BigDecimal unMonto, BigDecimal otroMonto) {
		return true;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}

}
