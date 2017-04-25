package windows;


import vm.CrearViewModel;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

@SuppressWarnings("serial")
public class CrearWindow extends SimpleWindow<CrearViewModel> {
	
	
	public CrearWindow(WindowOwner parent) {
		super(parent, new CrearViewModel());
	}
	
	public void createFormPanel(Panel panelActions) {
	new Panel(panelActions);
	}
	
	@Override
	public void createContents(Panel panelActions) {
		this.setTitle("Analizador de Inversiones");
		panelActions.setLayout(new VerticalLayout());

		new Button(panelActions)
			.setCaption("Crear Nueva Metodologia")
			.onClick(this::crearNuevaMetodologia);
		
		new Label(panelActions).setText("");
		
		new Button(panelActions)
			.setCaption("Ventana Busqueda")
			.onClick(this::ventanaBusqueda);
		
		new Button(panelActions)
			.setCaption("Ventana Analisis")
			.onClick(this::ventanaAnalisis);
		
		new Button(panelActions)
			.setCaption("Ventana Carga")
			.onClick(this::ventanaCarga);
	}
	
	protected void addActions(Panel actionsPanel) {}
	
	public void crearNuevaMetodologia() {
		  
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
	
	public void ventanaCarga() {
		CargaWindow dialog = new CargaWindow(this);
		this.close();
		dialog.open();
	}
}
