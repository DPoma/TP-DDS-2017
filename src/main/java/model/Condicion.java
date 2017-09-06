package model;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import javax.persistence.*;

@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
public abstract class Condicion {
	@Id @GeneratedValue
	protected int id;
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
}
