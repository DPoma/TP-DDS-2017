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

		new Button(panelActions)
			.setCaption("Cargar Cuentas")
			.onClick(this::cargarCuentas);
		
		
		new Label(panelActions).setText("");
		
		new Button(panelActions)
			.setCaption("Cargar Indicadores")
			.onClick(this::cargarIndicadores);
		
		new Label(panelActions).setText("");
		
		new Button(panelActions)
			.setCaption("Cargar Metodologias")
			.onClick(this::cargarMetodologias);
		
		new Label(panelActions).setText("");
		
		new Button(panelActions)
			.setCaption("Ventana Busqueda")
			.onClick(this::ventanaBusqueda);
		
		new Button(panelActions)
			.setCaption("Ventana Analisis")
			.onClick(this::ventanaAnalisis);
		
		new Button(panelActions)
			.setCaption("Ventana Crear")
			.onClick(this::ventanaCrear);
	}
	
	protected void addActions(Panel actionsPanel) {}
	
	public void cargarCuentas() {
		PathWindow dialog = new PathWindow(this);
		dialog.open();
	}
	
	public void cargarIndicadores() {
		  
	}
	
	public void cargarMetodologias() {
		  
	}
	
	public void ventanaBusqueda() {
		BusquedaWindow dialog = new BusquedaWindow(this);
		this.close();
		dialog.open();
	}
	
	public void ventanaAnalisis() {
		AnalisisWindow dialog = new AnalisisWindow(this);
		this.close();
		dialog.open();
	}
	
	public void ventanaCrear() {
		CrearWindow dialog = new CrearWindow(this);
		this.close();
		dialog.open();
}
	
}