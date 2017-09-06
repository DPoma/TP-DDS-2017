package vm;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import repositories.Repositorios;
import model.Condicion;
import model.CondicionTipo1;
import model.CondicionTipo2;
import model.CondicionTipo3;
import model.CondicionTipo4;
import model.Empresa;
import model.Indicador;
import model.Metodologia;

@Observable
public class ElegirTipoCondicionViewModel {
	
	private List<Metodologia> metodologias;
	private List<Metodologia> metodologiasPersonalizadas;
	private Metodologia metodologiaSeleccionada;
	private Indicador indicadorSeleccionado;
	private List<Indicador> indicadores;
	private List<Empresa> empresasOrdenadas;
	private String nombreNuevaMetodologia;
	
	public Condicion condicionSeleccionada;
	public List<Condicion> condiciones = new ArrayList<Condicion>();
	public Condicion condicionTipo1 = new CondicionTipo1(null,null,1);
	public Condicion condicionTipo2 = new CondicionTipo2("1",null,null);
	public Condicion condicionTipo3 = new CondicionTipo3();
	public Condicion condicionTipo4 = new CondicionTipo4(null,null,1);
	
	public ElegirTipoCondicionViewModel(){
		condiciones.add(condicionTipo1);
		condiciones.add(condicionTipo2);
		condiciones.add(condicionTipo3);
		condiciones.add(condicionTipo4);
	}
	
	public void setCondiciones(List<Condicion> condiciones){
		this.condiciones =condiciones;
	}
	
	public List<Condicion> getCondiciones(){
		return condiciones;
	}
	
	public void setcondicionSeleccionada(Condicion condicionSeleccionada){
		this.condicionSeleccionada =condicionSeleccionada;
	}
	
	public Condicion getcondicionSeleccionada(){
		return condicionSeleccionada;
	}
	
	public void agregarCondicion() {
		//Estoy mandando al objeto abrir una ventana, no se si esta bien, asi se me hacia q tenia mas polimorfismo
		condicionSeleccionada.abrirWindowAgregarCondicion();
		
	}
	
}