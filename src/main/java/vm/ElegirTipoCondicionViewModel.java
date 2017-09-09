package vm;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.Observable;

import repositories.Repositorios;
import windows.AgregarCondicionTipo1o4Window;
import windows.AgregarCondicionTipo2Window;
import windows.AgregarCondicionTipo3Window;
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
	
	@Observable
	public static String condicionSeleccionada;
	
	public List<String> condiciones = new ArrayList<String>();
	
	public ElegirTipoCondicionViewModel(){
		condiciones.add("Condicion tipo 1");
		condiciones.add("Condicion tipo 2");
		condiciones.add("Condicion tipo 3");
		condiciones.add("Condicion tipo 4");
	}
	
	public void setCondiciones(List<String> condiciones){
		this.condiciones =condiciones;
	}
	
	public List<String> getCondiciones(){
		return condiciones;
	}
	
	public void setcondicionSeleccionada(String condicionSeleccionada){
		this.condicionSeleccionada =condicionSeleccionada;
	}
	
	public String getcondicionSeleccionada(){
		return condicionSeleccionada;
	}
	
	/*public void agregarCondicion() {
		switch(condicionSeleccionada){
		case "Condicion tipo 2":
			Dialog <?> dialog = new AgregarCondicionTipo2Window(this);
			dialog.open();
			break;
		
		case "Condicion tipo 3":
			Dialog <?> dialog1 = new AgregarCondicionTipo3Window(this);
			dialog1.open();
			break;
			
		default: 
			Dialog <?> dialog2 = new AgregarCondicionTipo1o4Window(this);
			dialog2.open();
			break;
			
			}
		
	}*/
	
}