package vm;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import repositories.Repositorios;
import model.Condicion;
import model.CondicionTipo2;
import model.Empresa;
import model.Indicador;
import model.MayorA;
import model.MenorA;
import model.Metodologia;
import model.OperacionIndicador;

@Observable
public class AgregarCondicionViewModel {
	
	//------------------------------------- ATRIBUTOS ----------------------------------
	
	private List<Metodologia> metodologias;
	private List<Metodologia> metodologiasPersonalizadas;
	private Metodologia metodologiaSeleccionada;
	private Indicador indicadorSeleccionado;
	private List<Indicador> indicadores;
	private List<Empresa> empresasOrdenadas;
	private String nombreNuevaMetodologia;
	private List<OperacionIndicador> operaciones = new ArrayList<OperacionIndicador>();
	private OperacionIndicador operacionSeleccionada;
	private String anio;
	private Integer anios;

	//----------------------------------- CONSTRUCTORES --------------------------------
	
	public AgregarCondicionViewModel()
	{
		OperacionIndicador mayorA = new MayorA();
		OperacionIndicador menorA = new MenorA();
		this.operaciones.add(mayorA);
		this.operaciones.add(menorA);
		this.indicadores = Repositorios.repositorioIndicadores.getIndicadores();
		
	}

	//------------------------------- GETTERS Y SETTERS --------------------------------
	
	public void setIndicadores(List<Indicador> indicadores){
		this.indicadores = indicadores;
	}
	
	public List<Indicador> getIndicadores(){
		return this.indicadores;
	} 
	
	public Integer getAnios() {
		return anios;
	}

	public void setAnios(Integer anios) {
		this.anios = anios;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public OperacionIndicador getOperacionSeleccionada() {
		return operacionSeleccionada;
	}

	public void setOperacionSeleccionada(OperacionIndicador operacionSeleccionada) {
		this.operacionSeleccionada = operacionSeleccionada;
	}

	public List<OperacionIndicador> getOperaciones() {
		return operaciones;
	}

	public void setOperaciones(List<OperacionIndicador> operaciones) {
		this.operaciones = operaciones;
	}

	public Indicador getIndicadorSeleccionado() {
		return indicadorSeleccionado;
	}

	public void setIndicadorSeleccionado(Indicador indicadorSeleccionado) {
		this.indicadorSeleccionado = indicadorSeleccionado;
	}
	
	//--------------------------------------- METODOS ----------------------------------

	public void agregarCondicion() {
		ElegirTipoCondicionViewModel.crearCondicion(anio,anios,indicadorSeleccionado,operacionSeleccionada);
	}
	
}