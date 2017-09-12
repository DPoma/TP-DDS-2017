package model;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class Sumatoria extends Operacion {
	
	//------------------------------------ CONSTRUCTORES --------------------------------
	
	public Sumatoria(String unNombre) {
		nombre = unNombre;
	}
	
	
	public Sumatoria() {
		
	}
	
	//------------------------------------ METODOS --------------------------------
	
	@Override
	public BigDecimal calcular(Indicador indicador, Empresa empresa) {
		return null;
	}

}
