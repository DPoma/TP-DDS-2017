package windows;



import java.util.NoSuchElementException;

import vm.AgregarCondicionViewModel;
import vm.ElegirTipoCondicionViewModel;
import model.Condicion;
import model.Indicador;
import model.Metodologia;
import model.OperacionIndicador;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

@SuppressWarnings("serial")
public class AgregarCondicionTipo1o4Window extends SimpleWindow<AgregarCondicionViewModel> {
	
	
	public AgregarCondicionTipo1o4Window(WindowOwner parent) {
		super( parent, new AgregarCondicionViewModel());
	}

	@Override
	public void createContents(Panel panelActions)  {
		this.setTitle("Agregar Condicion");
		panelActions.setLayout(new VerticalLayout());
		
		new Label(panelActions).setText("Seleccione un indicador");
		Selector<Indicador> selector2 = new Selector<Indicador>(panelActions);
		selector2.allowNull(false);
		selector2.bindValueToProperty("indicadorSeleccionado");
		selector2.bindItemsToProperty("indicadores");
		
		new Label(panelActions).setText("Seleccione una operacion");
		Selector<OperacionIndicador> selector = new Selector<OperacionIndicador>(panelActions);
		selector.allowNull(false);
		selector.bindValueToProperty("operacionSeleccionada");
		selector.bindItemsToProperty("operaciones");
		
		new Label(panelActions).setText("Cantidad de anios");
		new TextBox(panelActions).bindValueToProperty("anios");
		
		new Label(panelActions).setText("");
		
		new Button(panelActions)
		.setCaption("Agregar Condicion")
		.onClick(this:: agregarCondicion);
		
		
		
	}

	
	public void agregarCondicion() {
		try {
			this.getModelObject().agregarCondicion();
			this.close();
		}
		catch(NullPointerException | NumberFormatException | NoSuchElementException e) {
			Dialog <?> dialog = new ErrorWindow(this, "Datos incompletos o incorrectos");
			dialog.open();
		}
		}
	@Override
	protected void createFormPanel(Panel arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addActions(Panel arg0) {
		// TODO Auto-generated method stub
		
	}
}