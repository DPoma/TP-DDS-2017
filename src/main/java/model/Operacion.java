package model;

import java.math.BigDecimal;

public interface Operacion {

	public BigDecimal calcular(Indicador indicador, Empresa empresa);
	
}
