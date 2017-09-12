package model;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.persistence.*;

import parserIndicador.ParsearIndicador;
import repositories.Repositorios;

@Entity
public class Indicador implements OperandoDeIndicador {
	
	//------------------------------------ ATRIBUTOS --------------------------------
	
	@Id
	private String nombre;
	
	private String formula;
	
	@OneToMany(mappedBy = "indicador", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<Condicion> condiciones;
	
	//------------------------------------ CONSTRUCTORES --------------------------------

	public Indicador(String nombre, String formula)
	{
		this.nombre = nombre;
		this.formula = formula;
	}
	
	public Indicador() {
		
	}
		
	//------------------------------------ GETTERS Y SETTERS --------------------------------
	
	public String getNombre() {
		return nombre;
	}

	public String getFormula() {
		return formula;
	}
	
	public List<Condicion> getCondiciones() {
		return condiciones;
	}

	public void setCondiciones(List<Condicion> condiciones) {
		this.condiciones = condiciones;
	}
	//------------------------------------ METODOS --------------------------------
	
	public void agregarARepositorio()
	{
		Repositorios.repositorioIndicadores.agregarIndicador(this);
	}
	
	public void guardar()
	{
		Repositorios.repositorioIndicadores.persistirIndicador(this);
		//this.agregarARepositorio();
		//FileHandler csv = new FileHandler();
		//csv.guardarIndicador("indicadores.csv", this);
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
	
	public boolean montoCumpleOperacionEnPeriodo(OperacionIndicador operacion, Empresa unaEmpresa, Empresa otraEmpresa, List<String> anios)
	{
		Stream<Boolean> resultados = anios.stream().map(unAnio -> operacion.operar(this.calcularMonto(unaEmpresa, unAnio), this.calcularMonto(otraEmpresa, unAnio)));
		resultados.allMatch(unBool -> unBool.booleanValue() == true);
		return true;
	}
	
	public boolean sigueTendencia(OperacionIndicador operacion, Empresa unaEmpresa, List<String> anios)
	{
		IntStream.range(0, anios.size() - 1)
		.filter(i -> i % 2 == 0)
		.allMatch(i -> operacion.operar(this.calcularMonto(unaEmpresa, anios.get(i)), this.calcularMonto(unaEmpresa, anios.get(i+1))));
		return true;
	}

	@Override
	public String toString()
	{
		return this.nombre;
	}
	
}
