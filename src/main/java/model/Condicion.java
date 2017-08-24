package model;

import java.util.Comparator;
import java.util.List;


public abstract class Condicion {
	
	protected Indicador indicador;
	protected OperacionIndicador operacion;
	
	public void evaluarEmpresas(List<Empresa> empresas)
	{
		// TO DO
	}
	
	public abstract void compararEmpresas(Empresa unaEmpresa, Empresa otraEmpresa);
	
	public Indicador getIndicador()
	{
		return indicador;
	}
}
