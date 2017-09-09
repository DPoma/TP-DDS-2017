package model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
public abstract class OperacionIndicador {
	@Id @GeneratedValue
	protected int id;

	
	public boolean operar(BigDecimal unMonto, BigDecimal otroMonto) {
		return true;
	}

}
