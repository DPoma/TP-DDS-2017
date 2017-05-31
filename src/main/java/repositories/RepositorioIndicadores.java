package repositories;
import java.util.ArrayList;
import java.util.List;

import model.Indicador;

public class RepositorioIndicadores {

	private List<Indicador> indicadores;
	
	public RepositorioIndicadores() {
		this.indicadores = new ArrayList<Indicador>();
		
	}
	
	public List<Indicador> getIndicadores() {
		return indicadores;
	}

	public void agregarIndicador(Indicador indicador)
	{
		this.indicadores.add(indicador);
	}
}
