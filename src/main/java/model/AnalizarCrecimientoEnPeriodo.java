package model;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class AnalizarCrecimientoEnPeriodo extends Condicion {

	//------------------------------------- ATRIBUTOS ----------------------------------
	
	@Transient
	private List<String> anios;
	
	private Integer cantidadAnios;
	
	//------------------------------- GETTERS Y SETTERS --------------------------------
	
	public List<String> getAnios() {
		return anios;
	}

	public void setAnios(List<String> anios) {
		this.anios = anios;
	}

	public Integer getCantidadAnios() {
		return cantidadAnios;
	}

	public void setCantidadAnios(Integer cantidadAnios) {
		this.cantidadAnios = cantidadAnios;
	}
	
	//----------------------------------- CONSTRUCTORES --------------------------------
	
	public AnalizarCrecimientoEnPeriodo(Indicador indicador, OperacionIndicador operacion, Integer anios)
	{
		Integer anio = Calendar.getInstance().get(Calendar.YEAR);
		this.indicador = indicador;
		this.operacionIndicador = operacion;
		this.cantidadAnios = anios;
		this.anios  = IntStream.rangeClosed(anio-anios, anio)
			    .boxed()
			    .map(unAnio -> unAnio.toString())
			    .collect(Collectors.toList());
		
	}
	


	public AnalizarCrecimientoEnPeriodo() {
		
	}
	
	//--------------------------------------- METODOS ----------------------------------
	
	@Override
	public void compararEmpresas(Empresa unaEmpresa, Empresa otraEmpresa) {
		if(indicador.sigueTendencia(operacionIndicador, unaEmpresa, anios))
			unaEmpresa.aumentarPuntuacion();
		else
			otraEmpresa.aumentarPuntuacion();
		
	}
	
}
