package model;

import java.math.BigDecimal;
import java.util.Calendar;

public class Longevidad extends Indicador {

	public Longevidad(String nombre, String formula) {
		super(nombre, formula);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public BigDecimal calcularMonto(Empresa unaEmpresa, String anio)
	{
		return new BigDecimal(Calendar.getInstance().get(Calendar.YEAR) - unaEmpresa.getAnioFundacion());
	}

}
