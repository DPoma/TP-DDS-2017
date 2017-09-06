package model;

import java.math.BigDecimal;

<<<<<<< HEAD
import javax.persistence.Entity;

@Entity
=======
import windows.AgregarCondicionTipo3Window;

>>>>>>> 21b09211646e9f0acfd3b3b816e354454f8ba6de
public class CondicionTipo3 extends Condicion {

	private BigDecimal valor;
	private Operacion operacion;
	private OperacionIndicador operacionIndicador;
	
	@Override
	public void compararEmpresas(Empresa unaEmpresa, Empresa otraEmpresa) {
		BigDecimal total = operacion.calcular(indicador, unaEmpresa);
		if(operacionIndicador.operar(total, valor))
			unaEmpresa.aumentarPuntuacion();
		else
			otraEmpresa.aumentarPuntuacion();
			
		
	}
	
	public void abrirWindowAgregarCondicion() {
		
	}

}
