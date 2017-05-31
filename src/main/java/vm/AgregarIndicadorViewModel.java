package vm;

import org.uqbar.commons.utils.Observable;

import model.Indicador;
import repositories.Repositorios;

@Observable
public class AgregarIndicadorViewModel {
	private String nombreIndicador;
	private String formulaIndicador;

	public String getFormulaIndicador() {
		return formulaIndicador;
	}
	
	public String getNombreIndicador() {
		return nombreIndicador;
	}

	public void setNombreIndicador(String nombreIndicador) {
		this.nombreIndicador = nombreIndicador;
	}

	public void setFormulaIndicador(String formulaIndicador) {
		this.formulaIndicador = formulaIndicador;
	}

	public void guardarIndicador()
	{
		Indicador indicador = new Indicador(nombreIndicador, formulaIndicador);
		Repositorios.repositorioIndicadores.agregarIndicador(indicador);
	}
}
