package model;

import java.math.BigDecimal;

import javax.persistence.Entity;

import repositories.Repositorios;
@Entity
public class Sumatoria extends Operacion {

	@Override
	public BigDecimal calcular(Indicador indicador, Empresa empresa) {
		
		return null;
	}

}
