package vm;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import repositories.Repositorios;
import model.Empresa;
import model.Indicador;
import model.Metodologia;

@Observable
public class MetodologiaViewModel {
	
	private List<Metodologia> metodologias;
	private List<Metodologia> metodologiasPersonalizadas;
	private Metodologia metodologiaSeleccionada;
	private Indicador indicadorSeleccionado;
	private List<Indicador> indicadores;
	private List<Empresa> empresasOrdenadas;
	private String nombreNuevaMetodologia;
	
	public MetodologiaViewModel()
	{
		this.metodologiasPersonalizadas = Repositorios.repositorioMetodologiasPersonalizadas.getMetodologias();
		this.indicadores = Repositorios.repositorioIndicadores.getIndicadores();
	}
	

	public void setMetodologiaSeleccionada(Metodologia metodologiaSeleccionada) {
		this.metodologiaSeleccionada = metodologiaSeleccionada;
	}

	public Metodologia getMetodologiaSeleccionada() {
		return metodologiaSeleccionada;
	}
	
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

	
}


