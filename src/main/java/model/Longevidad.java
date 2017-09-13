package model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;

@Entity
public class Longevidad extends Condicion {


	//------------------------------------ CONSTRUCTORES --------------------------------
	
	public Longevidad() {
		
	}
	
	//------------------------------------ METODOS --------------------------------
	
	public BigDecimal calcularMonto(Empresa unaEmpresa, String anio)
	{
		return new BigDecimal(Calendar.getInstance().get(Calendar.YEAR) - unaEmpresa.getAnioFundacion());
	}

	@Override
	public void compararEmpresas(Empresa unaEmpresa, Empresa otraEmpresa) {
		
	}

}
