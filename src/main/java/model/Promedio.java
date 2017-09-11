package model;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class Promedio extends Operacion {

	//------------------------------------ CONSTRUCTORES --------------------------------
	
	public Promedio() {
		
	}
	
	//------------------------------------ METODOS --------------------------------
	
	@Override
	public BigDecimal calcular(Indicador indicador, Empresa empresa) {
		return null;
	}

}
