package model;

import java.math.BigDecimal;

import javax.persistence.*;

import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.uqbar.commons.utils.Observable;
import org.uqbarproject.jpa.java8.extras.convert.LocalDateTimeConverter;


@Observable
@Entity
public class Cuenta implements OperandoDeIndicador{
	@Id @GeneratedValue
	private int id;
	private String nombre;
	private int anio;
	@Convert(converter = BigDecimalConverter.class)
	private BigDecimal monto;
	
	public Cuenta(String nombre, int anio, String monto)
	{
		this.nombre = nombre;
		this.anio = anio;
		this.monto = new BigDecimal(monto);
	}

	@Override
	public String toString() {
		return "Cuenta [nombre=" + nombre + ", anio=" + anio + ", monto=" + monto + "]";
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getAnio() {
		return anio;
	}
	
	public BigDecimal getMonto() {
		return monto;
	}
	
	public BigDecimal calcularMonto(Empresa empresa, String anio)
	{
		return monto;
	}
	
	public boolean periodoEntre(int anioMin, int anioMax)
	{
		return anio >= anioMin && anio <=anioMax;
	}
	
	
	
}
