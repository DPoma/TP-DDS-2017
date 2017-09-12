package model;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class AnalizarIndicadoresEntreEmpresas extends Condicion {
	
	//------------------------------------- ATRIBUTOS ----------------------------------
	
	private String anio;

	//----------------------------------- CONSTRUCTORES --------------------------------
	
	public AnalizarIndicadoresEntreEmpresas(String anio, OperacionIndicador operacion, Indicador indicador)
	{
		this.anio = anio;
		this.operacionIndicador = operacion;
		this.indicador = indicador;
	}
	
	public AnalizarIndicadoresEntreEmpresas() {
		
	}
	
	//--------------------------------------- METODOS ----------------------------------

	@Override
	public void compararEmpresas(Empresa unaEmpresa, Empresa otraEmpresa) {
		BigDecimal unMonto = indicador.calcularMonto(unaEmpresa, anio);
		BigDecimal otroMonto = indicador.calcularMonto(otraEmpresa, anio);
		if(operacionIndicador.operar(unMonto, otroMonto))
			unaEmpresa.aumentarPuntuacion();
		else
			otraEmpresa.aumentarPuntuacion();
	}
}
