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
import model.Operacion;
import model.OperacionIndicador;

@SuppressWarnings("unused")
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
	private List<OperacionIndicador> operacionesIndicador = new ArrayList<OperacionIndicador>();
	private List <Operacion> operaciones = new ArrayList<Operacion>();
	private Operacion operacionSeleccionada;
	private OperacionIndicador operacionIndicadorSeleccionada;
	private String anio;
	private Integer anios;

	//----------------------------------- CONSTRUCTORES --------------------------------
	
	public AgregarCondicionViewModel() {
		indicadores = Repositorios.repositorioIndicadores.obtenerIndicadores();
		operaciones = Repositorios.repositorioIndicadores.obtenerOperaciones();
		operacionesIndicador = Repositorios.repositorioIndicadores.obtenerOperacionesIndicador();
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

	public Operacion getOperacionSeleccionada() {
		return operacionSeleccionada;
	}

	public void setOperacionSeleccionada(Operacion operacionSeleccionada) {
		this.operacionSeleccionada = operacionSeleccionada;
	}

	public OperacionIndicador getOperacionIndicadorSeleccionada() {
		return operacionIndicadorSeleccionada;
	}

	public void setOperacionIndicadorSeleccionada(
			OperacionIndicador operacionIndicadorSeleccionada) {
		this.operacionIndicadorSeleccionada = operacionIndicadorSeleccionada;
	}

	public List<OperacionIndicador> getOperacionesIndicador() {
		return operacionesIndicador;
	}

	public void setOperacionesIndicador(
			List<OperacionIndicador> operacionesIndicador) {
		this.operacionesIndicador = operacionesIndicador;
	}

	public List<Operacion> getOperaciones() {
		return operaciones;
	}

	public void setOperaciones(List<Operacion> operaciones) {
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
		ElegirTipoCondicionViewModel.crearCondicion(anio,anios,indicadorSeleccionado,operacionIndicadorSeleccionada, operacionSeleccionada);
	}
	
}