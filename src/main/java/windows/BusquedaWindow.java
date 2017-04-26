package windows;


import vm.BusquedaViewModel;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import java.util.List;
import model.Cuenta;

@SuppressWarnings("serial")
public class BusquedaWindow extends SimpleWindow<BusquedaViewModel> {
	
	
	public BusquedaWindow(WindowOwner parent) {
		super(parent, new BusquedaViewModel());
	}
	
	public void createFormPanel(Panel panelActions) {
	new Panel(panelActions);
	}
	
	@Override
	public void createContents(Panel panelActions) {
		this.setTitle("Busqueda");
		panelActions.setLayout(new VerticalLayout());

		new Label(panelActions).setText("		Nombre de empresa		");
		new TextBox(panelActions).bindValueToProperty("empresa");
		
		
		new Label(panelActions).setText("		Año inicial		 ");
		new TextBox(panelActions).bindValueToProperty("anio1");
		new Label(panelActions).setText("		Año final		 ");
		new TextBox(panelActions).bindValueToProperty("anio2");
		
		new Label(panelActions).setText("");
		
		new Button(panelActions)
		.setCaption("Buscar")
		.onClick(this::mostrarResultados);
		
		new Button(panelActions)
		.setCaption("Ver indicadores")
		.onClick(this::VerIndicadores);
	
		new Button(panelActions)
		.setCaption("Ver grafico")
		.onClick(this::VerIndicadores);
		
		new Label(panelActions).setText("");
		
	}
	
	protected void addActions(Panel actionsPanel) {}
	
	public void VerIndicadores() {
	 
	}
	public void mostrarResultados() {
		List<Cuenta> ListaCuentas = this.getModelObject().consultaCuentas();
		Dialog<?> dialog = new MostrarCuentasWindow(this, ListaCuentas);
		dialog.open();
		dialog.onAccept(() -> {});
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
	
	public void ventanaCrear() {
			CrearWindow dialog = new CrearWindow(this);
			this.close();
			dialog.open();
	}
}
