package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

@Observable
public class Empresa {

	private String nombre;
	private List<Cuenta> cuentas;
	private int puntuacion;
	private int anioFundacion;
	


	public void setAnioFundacion(int anioFundacion) {
		this.anioFundacion = anioFundacion;
	}

	public Empresa(String empresa, Cuenta cuenta){
		this.nombre= empresa;
		this.cuentas= new ArrayList<Cuenta>();
		agregarCuenta(cuenta);
	}
	
	public int getAnioFundacion() {
		return anioFundacion;
	}
	
	public void agregarCuenta(Cuenta cuenta){
		cuentas.add(cuenta);
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public boolean equals(String compare){
		return this.getNombre().toLowerCase().equals(compare.toLowerCase());
	}
	
	public List<Cuenta> getCuentas(){
		return this.cuentas;
	}
	
	public void setCuentas(List<Cuenta> unasCuentas) {
		this.cuentas = unasCuentas;
	}
	
	public List<Cuenta> periodoEntre(String anio1, String anio2) throws NumberFormatException {
		int unAnio = Integer.parseInt(anio1);
		int otroAnio = Integer.parseInt(anio2);
		return this.cuentas.stream().filter(x->x.periodoEntre(unAnio, otroAnio)).collect(Collectors.toList());
	}
	
	private Cuenta find(Predicate<? super Cuenta> criterio)
	{
		return this.cuentas.stream().filter(criterio).findFirst().get();
	}
	
	public Cuenta encontrarCuenta(String nombre, String anio)
	{
		int anioNumerico = Integer.parseInt(anio);
		return this.find(unaCuenta -> unaCuenta.getNombre().equals(nombre) && unaCuenta.getAnio() == anioNumerico);
	}
	
	public void aumentarPuntuacion()
	{
		puntuacion++;
	}
	
	public int getPuntacion()
	{
		return this.puntuacion;
	}
	
	public void setPuntacion(int  puntuacion) {
		this. puntuacion =  puntuacion;
	}
	
	
	@Override
	public String toString()
	{
		return this.nombre;
	}
}

