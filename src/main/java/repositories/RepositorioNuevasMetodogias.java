package repositories;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import model.Empresa;
import model.NuevaMetodologia;

public class RepositorioNuevasMetodogias {

	private List<NuevaMetodologia> metodologias;
	
	public RepositorioNuevasMetodogias() {
		this.metodologias = new ArrayList<NuevaMetodologia>();
		
	}
	
	public List<NuevaMetodologia> getMetodologias() {
		return metodologias;
	}

	public void agregarMetodologia(NuevaMetodologia metodologia)
	{
		this.metodologias.add(metodologia);
	}
	
	public NuevaMetodologia find(Predicate<? super NuevaMetodologia> criterio)
	{
		return this.metodologias.stream().filter(criterio).findFirst().get();
	}
}

