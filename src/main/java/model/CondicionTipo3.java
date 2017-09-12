package model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("unused")
@Entity
public class CondicionTipo3 extends Condicion {

	//------------------------------------- ATRIBUTOS ----------------------------------
	
	private BigDecimal valor;
	
	@ManyToOne
	//@JoinColumn(name = "id")
	private Operacion operacionSobreIndicador;
	
	//----------------------------------- CONSTRUCTORES --------------------------------
	
	public CondicionTipo3(Indicador unIndicador, Operacion operacion) {
		operacionSobreIndicador = operacion;
		indicador = unIndicador;
	}
	
	public CondicionTipo3() {
		
	}
	
	//------------------------------- GETTERS Y SETTERS --------------------------------
	
	//--------------------------------------- METODOS ----------------------------------
	
	@Override
	public void compararEmpresas(Empresa unaEmpresa, Empresa otraEmpresa) {
		BigDecimal total = operacionSobreIndicador.calcular(indicador, unaEmpresa);
		if(operacion.operar(total, valor))
			unaEmpresa.aumentarPuntuacion();
		else
			otraEmpresa.aumentarPuntuacion();	
	}
}
