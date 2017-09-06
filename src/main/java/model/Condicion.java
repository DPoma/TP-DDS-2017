package model;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import windows.AgregarCondicionTipo3Window;



public abstract class Condicion {
	
	protected Indicador indicador;
	protected OperacionIndicador operacion;
	
	public void evaluarEmpresas(List<Empresa> empresas)
	{
		IntStream.range(0, empresas.size() - 1)
		.filter(i -> i % 2 == 0)
		.forEach(i -> this.compararEmpresas(empresas.get(i), empresas.get(i+1)));
		
	}
	
	public abstract void compararEmpresas(Empresa unaEmpresa, Empresa otraEmpresa);
	
	public Indicador getIndicador()
	{
		return indicador;
	}

	public void abrirWindowAgregarCondicion() {
		AgregarCondicionTipo3Window dialog = new AgregarCondicionTipo3Window(this);
		dialog.open();
		
	}
}
