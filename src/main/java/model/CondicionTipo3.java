package model;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class CondicionTipo3 extends Condicion {

	private BigDecimal valor;
	private Operacion operacion;
	private OperacionIndicador operacionIndicador;
	
	@Override
	public void compararEmpresas(Empresa unaEmpresa, Empresa otraEmpresa) {
		BigDecimal total = operacion.calcular(indicador, unaEmpresa);
		if(operacionIndicador.operar(total, valor))
			unaEmpresa.aumentarPuntuacion();
		else
			otraEmpresa.aumentarPuntuacion();
			
		
	}

}
