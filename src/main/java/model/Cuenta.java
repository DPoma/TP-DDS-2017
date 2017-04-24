package model;

import org.uqbar.commons.utils.Observable;

@Observable
public class Cuenta {

	private String empresa;
	private String nombre;
	private int anio;
	private double monto;
	
	public Cuenta(String empresa, String nombre, int anio, double monto)
	{
		this.empresa = empresa;
		this.nombre = nombre;
		this.anio = anio;
		this.monto = monto;
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
	
	public double getMonto() {
		return monto;
	}
	
	
}
