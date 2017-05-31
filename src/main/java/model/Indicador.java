package model;

public class Indicador {
	private String nombre;
	private String texto;
	
	public Indicador(String nombre, String texto)
	{
		this.nombre = nombre;
		this.texto = texto;
	}
	
	public double monto(String unaEmpresa, int anio)
	{
		return 0.0;
	}
	
	@Override
	public String toString()
	{
		return this.nombre;
	}
}
