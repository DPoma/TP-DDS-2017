package model;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import repositories.Repositorios;

public class NuevaMetodologia {

private String nombre;
private String operacion;
private Indicador indicador;
private List<Condicion> condiciones;

public NuevaMetodologia(String nombre, String operacion)
{
	this.nombre = nombre;
	this.operacion = operacion;
}


public String getNombre() {
	return nombre;
}

public void agregarARepositorio()
{
	Repositorios.repositorioNuevasMetodologias.agregarMetodologia(this);
}

public void guardar()
{
	this.agregarARepositorio();
	FileHandler csv = new FileHandler();
	csv.guardarNuevasMetodologia("metodologias.csv", this);
}

@Override
public String toString()
{
	return this.nombre;
}


public String getOperacion() {
	return operacion;
}


public void setOperacion(String operacion) {
	this.operacion = operacion;
}


public Indicador getIndicador() {
	return indicador;
}

public void setIndicador(Indicador indicador) {
	this.indicador = indicador;
}

public List<Condicion> getCondicion(){
	return this.condiciones;
}

public void addCondicion(Condicion condicion){
	this.condiciones.add(condicion);
}

public List<Empresa> aplicarMetodologia( List<Empresa> e){
	this.condiciones.forEach(x ->e.sort(x.esMejor(e.get(0), e.get(1))));
	return e;
}

}
