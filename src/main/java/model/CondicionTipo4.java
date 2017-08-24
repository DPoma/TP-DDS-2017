package model;

import java.util.List;

public class CondicionTipo4 extends Condicion {

	private List<String> anios;
	@Override
	public void compararEmpresas(Empresa unaEmpresa, Empresa otraEmpresa) {
		if(indicador.sigueTendencia(operacion, anios))
			unaEmpresa.aumentarPuntuacion();
		
	}
	
	

}
