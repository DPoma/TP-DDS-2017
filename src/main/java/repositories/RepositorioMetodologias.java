package repositories;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import model.Metodologia;


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

	public void agregarMetodologia(Metodologia metodologia)
	{
		this.metodologias.add(metodologia);
	}
	
	public Metodologia find(Predicate<? super Metodologia> criterio)
	{
		return this.metodologias.stream().filter(criterio).findFirst().get();
	}
}
