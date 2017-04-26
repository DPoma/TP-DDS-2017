package windows;


import vm.CargaViewModel;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

@SuppressWarnings("serial")
public class CargaWindow extends SimpleWindow<CargaViewModel> {
	
	
	public CargaWindow(WindowOwner parent) {
		super(parent, new CargaViewModel());
	}
	
	public void createFormPanel(Panel panelActions) {
	new Panel(panelActions);
	}
	
	@Override
	public void createContents(Panel panelActions) {
		this.setTitle("Analizador de Inversiones");
		panelActions.setLayout(new VerticalLayout());
		
		new Label(panelActions).setText("															");
		
		new Button(panelActions)
			.setCaption("Cargar Cuentas")
			.onClick(this::cargarCuentas);
		
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
	
	public void cargarCuentas() {
		PathWindow dialog = new PathWindow(this);
		dialog.open();
	}
	
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
		CrearWindow dialog = new CrearWindow(this);
		dialog.open();
}
	
}