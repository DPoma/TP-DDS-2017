package windows;

import java.util.NoSuchElementException;

import vm.ConfigurarCondicionViewModel;
import model.Indicador;
import model.OperacionIndicador;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

public class AgregarCondicionTipo3Window extends SimpleWindow<ConfigurarCondicionViewModel> {
	
	private ElegirCondicionWindow ventanaElegir;
	
	public AgregarCondicionTipo3Window(WindowOwner parent, String condicion) {
		super( parent, new ConfigurarCondicionViewModel(condicion));
		ventanaElegir = (ElegirCondicionWindow) parent;
	}

	@Override
	public void createContents(Panel panelActions)  {
		this.setTitle("Configurar condicion");
		panelActions.setLayout(new VerticalLayout());
		
		new Label(panelActions).setText("         Seleccione un indicador         ");
		Selector<Indicador> selector2 = new Selector<Indicador>(panelActions);
		selector2.allowNull(false);
		selector2.bindValueToProperty("indicadorSeleccionado");
		selector2.bindItemsToProperty("indicadores");
		
		new Label(panelActions).setText("Seleccione una operacion");
		Selector<OperacionIndicador> selector = new Selector<OperacionIndicador>(panelActions);
		selector.allowNull(false);
		selector.bindValueToProperty("operacionSeleccionada");
		selector.bindItemsToProperty("operaciones");
		
		new Label(panelActions).setText("");
		
		new Button(panelActions)
		.setCaption("Aceptar")
		.onClick(this:: agregarCondicion);
		
		new Label(panelActions).setText("");
	}

	
	public void agregarCondicion() {
		try {
			ventanaElegir.getModelObject().setCondicion(this.getModelObject().crearCondicion());
			this.close();
		}
		catch(NullPointerException | NumberFormatException | NoSuchElementException e) {
			Dialog <?> dialog = new ErrorWindow(this, "Datos incompletos o incorrectos");
			dialog.open();
		}
		}
	@Override
	protected void createFormPanel(Panel arg0) {
		
	}

	@Override
	protected void addActions(Panel arg0) {
		
	}
}