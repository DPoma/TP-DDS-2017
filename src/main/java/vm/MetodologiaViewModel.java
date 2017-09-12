package vm;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.Observable;
import org.uqbar.lacar.ui.model.WindowFactory;

import repositories.Repositorios;
import windows.ErrorWindow;
import model.Condicion;
import model.Empresa;
import model.Indicador;
import model.Metodologia;

@SuppressWarnings("unused")
@Observable
public class MetodologiaViewModel implements WindowOwner {
	
	//------------------------------------- ATRIBUTOS ----------------------------------
	
	private List<Metodologia> metodologias;
	private List<Metodologia> metodologiasPersonalizadas;
	
	private Metodologia metodologia;
	private Indicador indicadorSeleccionado;
	private List<Indicador> indicadores;
	private List<Empresa> empresasOrdenadas;
	private String nombreNuevaMetodologia;
	private static List<Condicion> condicionesDeLaMetodologia = new ArrayList<Condicion>();

	//----------------------------------- CONSTRUCTORES --------------------------------
	
	public MetodologiaViewModel()
	{
		this.metodologiasPersonalizadas = Repositorios.repositorioMetodologiasPersonalizadas.getMetodologias();
		this.indicadores = Repositorios.repositorioIndicadores.getIndicadores();
	}

	//------------------------------- GETTERS Y SETTERS --------------------------------

	public List<Empresa> getEmpresasOrdenadas() {
		return empresasOrdenadas;
	}

	public void setEmpresasOrdenadas(List<Empresa> empresasOrdenadas) {
		this.empresasOrdenadas = empresasOrdenadas;
	}


	public List<Indicador> getIndicadores() {
		return indicadores;
	}


	public void setIndicadores(List<Indicador> indicadores) {
		this.indicadores = indicadores;
	}
	
	
	public void crearMetodologia() {
		if(condicionesDeLaMetodologia.size()<2){ErrorWindow dialog = new ErrorWindow(this, "Ruta incorrecta");
		dialog.open();}
		else{
		metodologia = new Metodologia(nombreNuevaMetodologia,condicionesDeLaMetodologia);
		}
	}
	
	public static void agregarAListaCondiciones(Condicion condicion){
		condicionesDeLaMetodologia.add(condicion);
	}


	public Indicador getIndicadorSeleccionado() {
		return indicadorSeleccionado;
	}


	public void setIndicadorSeleccionado(Indicador indicadorSeleccionado) {
		this.indicadorSeleccionado = indicadorSeleccionado;
	}


	public List<Metodologia> getMetodologiasPersonalizadas() {
		return metodologiasPersonalizadas;
	}


	public void setMetodologiasPersonalizadas(
			List<Metodologia> metodologiasPersonalizadas) {
		this.metodologiasPersonalizadas = metodologiasPersonalizadas;
	}


	public List<Metodologia> getMetodologias() {
		return metodologias;
	}


	public void setMetodologias(List<Metodologia> metodologias) {
		this.metodologias = metodologias;
	}


	public String getNombreNuevaMetodologia() {
		return nombreNuevaMetodologia;
	}


	public void setNombreNuevaMetodologia(String nombreNuevaMetodologia) {
		this.nombreNuevaMetodologia = nombreNuevaMetodologia;
	}

	//--------------------------------------- METODOS ----------------------------------
	
	@Override
	public WindowFactory getDelegate() {
		return null;
	}
	
	/*public void setMetodologiaSeleccionada(Metodologia metodologiaSeleccionada) {
		this.metodologiaSeleccionada = metodologiaSeleccionada;
	}

	public Metodologia getMetodologiaSeleccionada() {
		return metodologiaSeleccionada;
	}*/

}


