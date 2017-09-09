package vm;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import repositories.Repositorios;
import model.Empresa;
import model.Indicador;
import model.Metodologia;

@Observable
public class AgregarCondicionViewModel {
	
	private List<Metodologia> metodologias;
	private List<Metodologia> metodologiasPersonalizadas;
	private Metodologia metodologiaSeleccionada;
	private Indicador indicadorSeleccionado;
	private List<Indicador> indicadores;
	private List<Empresa> empresasOrdenadas;
	private String nombreNuevaMetodologia;
	private String operador;
	
	public AgregarCondicionViewModel()
	{
		this.indicadores = Repositorios.repositorioIndicadores.getIndicadores();
		
	}
	
	public void agregarCondicion() {
		// TODO Auto-generated method stub
		
	}
	
}