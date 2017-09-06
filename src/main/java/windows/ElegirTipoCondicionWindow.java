package windows;



import java.util.NoSuchElementException;

import vm.ElegirTipoCondicionViewModel;
import model.Indicador;
import model.Metodologia;

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
public class ElegirTipoCondicionWindow extends SimpleWindow<ElegirTipoCondicionViewModel> {
	
	
	public ElegirTipoCondicionWindow(WindowOwner parent) {
		super(parent, new ElegirTipoCondicionViewModel());
	}

	@Override
	public void createContents(Panel panelActions)  {
		this.setTitle("Elegir un Tipo de Condicion");
		panelActions.setLayout(new VerticalLayout());
		
		new Label(panelActions).setText("            Elija un Tipo            ");
		Selector<Metodologia> selector1 = new Selector<Metodologia>(panelActions);
		selector1.allowNull(false);
		selector1.bindValueToProperty("condicionSeleccionada");
		selector1.bindItemsToProperty("condiciones");
		
		
		new Label(panelActions).setText("");
		
		new Button(panelActions)
		.setCaption("Agregar Condicion")
		.onClick(this:: agregarCondicion);
		
		new Button(panelActions)
		.setCaption("OK")
		.onClick(this:: cerrar);
		
		
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
	
	public void cerrar(){
		this.close();
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