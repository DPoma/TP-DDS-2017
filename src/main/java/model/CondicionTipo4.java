package model;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class CondicionTipo4 extends Condicion {

	@Transient
	private List<String> anios;
	private Integer cantidadAnios;
	
	public CondicionTipo4(Indicador indicador, OperacionIndicador operacion, Integer anios)
	{
		Integer anio = Calendar.getInstance().get(Calendar.YEAR);
		this.indicador = indicador;
		this.operacion = operacion;
		this.cantidadAnios = anios;
		this.anios  = IntStream.rangeClosed(anio-anios, anio)
			    .boxed()
			    .map(unAnio -> unAnio.toString())
			    .collect(Collectors.toList());
		
	}
	
	@Override
	public void compararEmpresas(Empresa unaEmpresa, Empresa otraEmpresa) {
		if(indicador.sigueTendencia(operacion, unaEmpresa, anios))
			unaEmpresa.aumentarPuntuacion();
		else
			otraEmpresa.aumentarPuntuacion();
		
	}
	
	public CondicionTipo4() {
		
	}


}
