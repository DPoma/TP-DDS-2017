package model;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

import parserIndicador.ParsearIndicador;
import repositories.Repositorios;

public class Indicador implements OperandoDeIndicador {
	private String nombre;
	private String formula;
	
	public Indicador(String nombre, String formula)
	{
		this.nombre = nombre;
		this.formula = formula;
	}
	
	public BigDecimal calcularMonto(Empresa unaEmpresa, String anio)
	{
		ParsearIndicador parser = new ParsearIndicador();
		return parser.reducirIndicador(this.formula, unaEmpresa, anio);
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getFormula() {
		return formula;
	}
	public void agregarARepositorio()
	{
		Repositorios.repositorioIndicadores.agregarIndicador(this);
	}
	
	public void guardar()
	{
		this.agregarARepositorio();
		FileHandler csv = new FileHandler();
		csv.guardarIndicador("indicadores.csv", this);
	}

	@Override
	public String toString()
	{
		return this.nombre;
	}
}
