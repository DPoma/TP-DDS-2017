package model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

<<<<<<< HEAD
import javax.persistence.Entity;

@Entity
=======
import windows.AgregarCondicionTipo1o4Window;
import windows.AgregarCondicionTipo3Window;

>>>>>>> 21b09211646e9f0acfd3b3b816e354454f8ba6de
public class CondicionTipo1 extends Condicion {

	private List<String> anios;
	
	public CondicionTipo1(Indicador indicador, OperacionIndicador operacion, Integer anios)
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
		if(indicador.montoCumpleOperacionEnPeriodo(operacion, unaEmpresa, otraEmpresa, anios))
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
