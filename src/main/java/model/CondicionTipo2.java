package model;

import java.math.BigDecimal;

<<<<<<< HEAD
import javax.persistence.Entity;

@Entity
=======
import windows.AgregarCondicionTipo1o4Window;
import windows.AgregarCondicionTipo2Window;

>>>>>>> 21b09211646e9f0acfd3b3b816e354454f8ba6de
public class CondicionTipo2 extends Condicion {
	private String anio;

	public CondicionTipo2(String anio, OperacionIndicador operacion, Indicador indicador)
	{
		this.anio = anio;
		this.operacion = operacion;
		this.indicador = indicador;
	}
	
	@Override
	public void compararEmpresas(Empresa unaEmpresa, Empresa otraEmpresa) {
		BigDecimal unMonto = indicador.calcularMonto(unaEmpresa, anio);
		BigDecimal otroMonto = indicador.calcularMonto(otraEmpresa, anio);
		if(operacion.operar(unMonto, otroMonto))
			unaEmpresa.aumentarPuntuacion();
		else
			otraEmpresa.aumentarPuntuacion();
	}
	
	@Override
	public void abrirWindowAgregarCondicion() {
		AgregarCondicionTipo2Window dialog = new AgregarCondicionTipo2Window(this);
		dialog.open();
		
	}

}
