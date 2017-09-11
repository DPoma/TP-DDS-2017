package model;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class MayorA extends OperacionIndicador {

	//------------------------------------ CONSTRUCTORES --------------------------------
	
	public MayorA() {
		
	}
	
	//------------------------------------ METODOS --------------------------------
	
	@Override
	public boolean operar(BigDecimal unMonto, BigDecimal otroMonto) {
		return unMonto.compareTo(otroMonto) > 0;
	}
}
