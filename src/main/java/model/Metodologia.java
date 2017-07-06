package model;

import org.uqbar.commons.utils.Observable;

import repositories.Repositorios;

@Observable
public class Metodologia {
	
	private String nombre;
	private String operacion;
	
	public Metodologia(String nombre, String operacion)
	{
		this.nombre = nombre;
		this.operacion = operacion;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public void agregarARepositorio()
	{
		Repositorios.repositorioMetodologias.agregarMetodologia(this);
	}
	
	public void guardar()
	{
		this.agregarARepositorio();
		FileHandler csv = new FileHandler();
		csv.guardarMetodologia("metodologias.csv", this);
	}

	@Override
	public String toString()
	{
		return this.nombre;
	}


	public String getOperacion() {
		return operacion;
	}


	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	


}
