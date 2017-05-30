package model;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Empresa {

	private String nombre;
	private int longevidad;
	private List<Cuenta> cuentas;
	
	public Empresa(String empresa, Cuenta cuenta){
		this.nombre= empresa;
		agregarCuenta(cuenta);
	}
	
	public void agregarCuenta(Cuenta cuenta){
		cuentas.add(cuenta);
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public List<Cuenta> periodoEntre(int anio1, int anio2){
		return this.cuentas.stream().filter(x->x.periodoEntre(anio1, anio2)).collect(Collectors.toList());
	}
}
