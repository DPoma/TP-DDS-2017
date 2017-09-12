package model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
@SuppressWarnings("unused")
@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
public abstract class Operacion {

	//------------------------------------ ATRIBUTOS --------------------------------
	
	@Id @GeneratedValue()
	protected int id;
	
	//@OneToMany(mappedBy = "operacionSobreIndicador", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	//protected List<CondicionTipo3> condiciones;
	
	//------------------------------------ METODOS --------------------------------
	
	public BigDecimal calcular(Indicador indicador, Empresa empresa)
	{
		return new BigDecimal(0);
	}
	
}
