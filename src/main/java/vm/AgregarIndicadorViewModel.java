package vm;

import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.uqbar.commons.utils.Observable;

import model.Indicador;
import parserIndicador.ParsearIndicador;

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

	public void guardarIndicador() throws ParseCancellationException
	{
		ParsearIndicador parser = new ParsearIndicador();
		if(formulaIndicador.contains(nombreIndicador))
			throw new ParseCancellationException("Se llama a si mismo");
		parser.generarArbol(formulaIndicador);
		Indicador indicador = new Indicador(nombreIndicador, formulaIndicador);
		indicador.guardar();
	}
}
