package model;

import java.math.BigDecimal;

import org.uqbar.commons.utils.Observable;


@Observable
public class Cuenta {

	private String empresa;
	private String nombre;
	private int anio;
	private BigDecimal monto;
	
	public Cuenta(String empresa, String nombre, int anio, String monto)
	{
		this.empresa = empresa;
		this.nombre = nombre;
		this.anio = anio;
		this.monto = new BigDecimal(monto);
	}

	@Override
	public String toString() {
		return "Cuenta [empresa=" + empresa + ", nombre=" + nombre + ", anio=" + anio + ", monto=" + monto + "]";
	}

	public String getEmpresa() {
		return empresa;
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
	
	private boolean periodoEntre(int anioMin, int anioMax)
	{
		return anio >= anioMin && anio <=anioMax;
	}

	public boolean perteneceA(String empresa, int anioMin, int anioMax)
	{
		return this.empresa.equals(empresa) && this.periodoEntre(anioMin, anioMax);
	}
	
	
	
}
