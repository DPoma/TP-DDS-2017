package model;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class IgualA extends OperacionIndicador {
	
	//------------------------------------ CONSTRUCTORES --------------------------------
	
	public IgualA() {
		
	}
	
	//------------------------------------ METODOS --------------------------------
	@Override
	public boolean operar(BigDecimal unMonto, BigDecimal otroMonto) {
		return unMonto.compareTo(otroMonto) == 1;
	}
	

}
