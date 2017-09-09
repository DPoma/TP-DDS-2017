package model;

import java.math.BigDecimal;

public class IgualA extends OperacionIndicador {
	
	@Override
	public boolean operar(BigDecimal unMonto, BigDecimal otroMonto) {
		return unMonto.compareTo(otroMonto) == 1;
	}
	

}
