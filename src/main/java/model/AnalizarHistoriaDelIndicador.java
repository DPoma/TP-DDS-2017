package model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class AnalizarHistoriaDelIndicador extends Condicion {

	//------------------------------------- ATRIBUTOS ----------------------------------
	
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name = "idOperacion")
	private Operacion operacion;
	
	//----------------------------------- CONSTRUCTORES --------------------------------
	
	public AnalizarHistoriaDelIndicador(Indicador unIndicador, Operacion unaOperacion) {
		operacion = unaOperacion;
		indicador = unIndicador;
	}
	
	public AnalizarHistoriaDelIndicador() {
		
	}
	
	//------------------------------- GETTERS Y SETTERS --------------------------------
	
	//--------------------------------------- METODOS ----------------------------------
	
	@Override
	public void compararEmpresas(Empresa unaEmpresa, Empresa otraEmpresa) {
		BigDecimal total = operacion.calcular(indicador, unaEmpresa);
		if(operacionIndicador.operar(total, valor))
			unaEmpresa.aumentarPuntuacion();
		else
			otraEmpresa.aumentarPuntuacion();	
	}
}
