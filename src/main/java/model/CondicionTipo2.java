package model;

import java.math.BigDecimal;

public class CondicionTipo2 extends Condicion {
	private String anio;

	public CondicionTipo2(String anio, OperacionIndicador operacion, Indicador indicador)
	{
		this.anio = anio;
		this.operacion = operacion;
		this.indicador = indicador;
	}
	
	@Override
	public void compararEmpresas(Empresa unaEmpresa, Empresa otraEmpresa) {
		BigDecimal unMonto = indicador.calcularMonto(unaEmpresa, anio);
		BigDecimal otroMonto = indicador.calcularMonto(otraEmpresa, anio);
		if(operacion.operar(unMonto, otroMonto))
			unaEmpresa.aumentarPuntuacion();
		else
			otraEmpresa.aumentarPuntuacion();
	}
	
	

}
