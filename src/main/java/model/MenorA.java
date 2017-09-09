package model;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class MenorA extends OperacionIndicador {

	@Override
	public boolean operar(BigDecimal unMonto, BigDecimal otroMonto) {
		return unMonto.compareTo(otroMonto) < 0;
	}
	

}
