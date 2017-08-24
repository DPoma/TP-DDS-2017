package model;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

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
		try {
			ParsearIndicador parser = new ParsearIndicador();
			return parser.reducirIndicador(this.formula, unaEmpresa, anio);
		}
		catch(NullPointerException | NumberFormatException | NoSuchElementException e) {
			return new BigDecimal(0);
		}
		catch(ArithmeticException ae) {
			return new BigDecimal(0);
		}

	}
	
	public boolean montoCumpleOperacionEnPeriodo(OperacionIndicador operacion, Empresa unaEmpresa, BigDecimal valor, List<String> anios)
	{
		// TODO
		return true;
	}
	
	public boolean sigueTendencia(OperacionIndicador operacion, List<String> anios)
	{
		// TODO
		return true;
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
