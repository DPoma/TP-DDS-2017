package windows;


import vm.CargaViewModel;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

@SuppressWarnings("serial")
public class PrincipalWindow extends SimpleWindow<CargaViewModel> {
	
	
	public PrincipalWindow(WindowOwner parent) {
		super(parent, new CargaViewModel());
	}
	
	public void createFormPanel(Panel panelActions) {
	new Panel(panelActions);
	}
	
	@Override
	public void createContents(Panel panelActions) {
		this.setTitle("Analizador de Inversiones");
		panelActions.setLayout(new VerticalLayout());
		new Label(panelActions).setText("Menu Principal");
			
		new Button(panelActions)
			.setCaption("Cargar Indicadores")
			.onClick(this::cargarIndicadores);
		
		new Button(panelActions)
			.setCaption("Cargar Metodologias")
			.onClick(this::ventanaCrear);
		
		new Button(panelActions)
		.setCaption("Analizar por periodo")
		.onClick(this::ventanaBusqueda);
		
		new Button(panelActions)
		.setCaption("Analizar por metodologia")
		.onClick(this::ventanaAnalisis);
		
		new Label(panelActions).setText("");
	}
	
	protected void addActions(Panel actionsPanel) {}
	
	public void cargarIndicadores() {
		IndicadorWindow dialog = new IndicadorWindow(this);
		dialog.open();
	}
	
	public void cargarMetodologias() {
		  
	}
	
	public void ventanaBusqueda() {
		BusquedaWindow dialog = new BusquedaWindow(this);
		dialog.open();
	}
	
	public void ventanaAnalisis() {
		AnalisisWindow dialog = new AnalisisWindow(this);
		dialog.open();
	}
	
	public void ventanaCrear() {
		MetodologiaWindow dialog = new MetodologiaWindow(this);
		dialog.open();
}
	
}