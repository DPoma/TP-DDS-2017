package repositories;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import model.Empresa;
import model.Metodologia;;

public class RepositorioMetodologias{

	private List<Metodologia> metodologias;
	
	public RepositorioMetodologias() {
		this.metodologias = new ArrayList<Metodologia>();
		
	}
	
	public List<Metodologia> getMetodologias() {
		return metodologias;
	}

	public void agregarMetodologia(Metodologia metodologia)
	{
		this.metodologias.add(metodologia);
	}
	
	public Metodologia find(Predicate<? super Metodologia> criterio)
	{
		return this.metodologias.stream().filter(criterio).findFirst().get();
	}
}
