package model;

import java.math.BigDecimal;
import java.util.List;

public class CondicionTipo1 extends Condicion {

	private BigDecimal valor;
	private List<String> anios;
	
	@Override
	public void compararEmpresas(Empresa unaEmpresa, Empresa otraEmpresa) {
		if(indicador.montoCumpleOperacionEnPeriodo(operacion, unaEmpresa, valor, anios))
			unaEmpresa.aumentarPuntuacion();
		
	}
	

}
