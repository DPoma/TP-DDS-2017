package model;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import windows.AgregarCondicionTipo1o4Window;

public class CondicionTipo4 extends Condicion {

	private List<String> anios;
	
	public CondicionTipo4(Indicador indicador, OperacionIndicador operacion, Integer anios)
	{
		Integer anio = Calendar.getInstance().get(Calendar.YEAR);
		this.indicador = indicador;
		this.operacion = operacion;
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
	
	@Override
	public void abrirWindowAgregarCondicion() {
		AgregarCondicionTipo1o4Window dialog = new AgregarCondicionTipo1o4Window(this);
		dialog.open();
		
	}

}
