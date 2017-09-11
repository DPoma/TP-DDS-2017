package model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
public abstract class Operacion {

	//------------------------------------ ATRIBUTOS --------------------------------
	
	@Id @GeneratedValue()
	protected int id;
	
	//------------------------------------ METODOS --------------------------------
	
	public BigDecimal calcular(Indicador indicador, Empresa empresa)
	{
		return new BigDecimal(0);
	}
	
}
