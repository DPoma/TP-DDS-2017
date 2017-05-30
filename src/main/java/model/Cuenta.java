package model;

import java.math.BigDecimal;

import org.uqbar.commons.utils.Observable;


@Observable
public class Cuenta {

	private String nombre;
	private int anio;
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
	
	public boolean periodoEntre(int anioMin, int anioMax)
	{
		return anio >= anioMin && anio <=anioMax;
	}
	
	
	
}
