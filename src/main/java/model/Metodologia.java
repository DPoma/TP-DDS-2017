package model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import repositories.Repositorios;


public class Metodologia {

	private String nombre;
	private List<Condicion> condiciones;

	public Metodologia(String nombre, List<Condicion> condiciones)
	{
		this.nombre = nombre;
		this.condiciones = condiciones;
	}


	public String getNombre() {
		return nombre;
	}

	public void agregarARepositorio()
	{
		Repositorios.repositorioMetodologias.agregarMetodologia(this);
	}



	@Override
	public String toString()
	{
		return this.nombre;
	}


	public List<Condicion> getCondicion(){
		return this.condiciones;
	}

	public void addCondicion(Condicion condicion){
		this.condiciones.add(condicion);
	}

	public List<Empresa> aplicarMetodologia( List<Empresa> empresas){
		this.condiciones.forEach(unaCondicion -> unaCondicion.evaluarEmpresas(empresas));
		empresas.sort(Comparator.comparingInt(Empresa::getPuntacion));
		Collections.reverse(empresas);
		return empresas;
	}

}
