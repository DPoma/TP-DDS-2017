package model;

import java.math.BigDecimal;
import java.util.Calendar;

public class Longevidad extends Indicador {

	//------------------------------------ CONSTRUCTORES --------------------------------
	
	public Longevidad(String nombre, String formula) {
		super(nombre, formula);
	}
	
	//------------------------------------ METODOS --------------------------------
	
	@Override
	public BigDecimal calcularMonto(Empresa unaEmpresa, String anio)
	{
		return new BigDecimal(Calendar.getInstance().get(Calendar.YEAR) - unaEmpresa.getAnioFundacion());
	}

}
