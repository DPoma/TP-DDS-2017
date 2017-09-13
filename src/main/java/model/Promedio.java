package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.persistence.Entity;

@Entity
public class Promedio extends Operacion {

	//------------------------------------ CONSTRUCTORES --------------------------------
	
	public Promedio(String unNombre) {
		nombre = unNombre;
	}
	
	
	public Promedio() {
		
	}
	
	//------------------------------------ METODOS --------------------------------
	
	public List<String> obtenerUltimosAnios(int cantidadAnios) {
		Integer anio = Calendar.getInstance().get(Calendar.YEAR);
		return IntStream.rangeClosed(anio - cantidadAnios, anio).boxed().map(unAnio -> unAnio.toString()).collect(Collectors.toList());
	}
	
	public int obtenerAniosDeCuentas(Empresa empresa) {
		int maximo = Collections.max(empresa.getCuentas().stream().map(e -> e.getAnio()).collect(Collectors.toList()));
		int minimo = Collections.min(empresa.getCuentas().stream().map(e -> e.getAnio()).collect(Collectors.toList()));
		return maximo - minimo;
	}
	
	public List<BigDecimal> obtenerListaDeMontos(List<String> anios, Indicador indicador, Empresa empresa) {
		return anios.stream().map(a -> indicador.calcularMonto(empresa, a)).collect(Collectors.toList());
	}

	public BigDecimal obtenerMontoTotal(List<BigDecimal> montos, int cantidadAnios) {
		return montos.stream().reduce(BigDecimal.ZERO, BigDecimal::add).divide(new BigDecimal(String.valueOf(cantidadAnios)), 2, RoundingMode.HALF_EVEN);
	}
	
	@Override
	public BigDecimal calcular(Indicador indicador, Empresa empresa) {
		int cantidadAnios = this.obtenerAniosDeCuentas(empresa);
		List<String> anios = this.obtenerUltimosAnios(cantidadAnios); 
		List<BigDecimal> montos = this.obtenerListaDeMontos(anios, indicador, empresa); 
		return this.obtenerMontoTotal(montos, cantidadAnios); 
	}

}
