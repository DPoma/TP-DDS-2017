package vm;

import org.uqbar.commons.utils.Observable;

@Observable
public class ErrorViewModel {
	private String texto;

	public ErrorViewModel(String texto)
	{
		this.texto= texto;
	}
	public String getTexto() {
		return texto;
	}
}
