package windows;



import java.util.NoSuchElementException;

import vm.MetodologiaViewModel;
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
public class MetodologiaWindow extends SimpleWindow<MetodologiaViewModel> {
	
	
	public MetodologiaWindow(WindowOwner parent) {
		super(parent, new MetodologiaViewModel());
	}
	
	public void createFormPanel(Panel panelActions) {
	new Panel(panelActions);
	}
	
	@Override
	public void createContents(Panel panelActions) {
		this.setTitle("Nueva Metodologia");
		panelActions.setLayout(new VerticalLayout());
		
		new Label(panelActions).setText("Nombre");
		new TextBox(panelActions).bindValueToProperty("nombreNuevaMetodologia");
		/*
		new Label(panelActions).setText("            Seleccione una operacion             ");
		Selector<Metodologia> selector1 = new Selector<Metodologia>(panelActions);
		selector1.allowNull(false);
		selector1.bindValueToProperty("metodologiaSeleccionada");
		selector1.bindItemsToProperty("metodologiasPersonalizadas");
		
		new Label(panelActions).setText("Seleccione un indicador");
		Selector<Indicador> selector2 = new Selector<Indicador>(panelActions);
		selector2.allowNull(false);
		selector2.bindValueToProperty("indicadorSeleccionado");
		selector2.bindItemsToProperty("indicadores");*/
		
		new Button(panelActions)
		.setCaption("Agregar Condicion")
		.onClick(this:: agregarCondicion);
		
		new Label(panelActions).setText("");
		

		new Button(panelActions)
			.setCaption("Crear metodologia")
			.onClick(this::crearNuevaMetodologia);
		
		new Label(panelActions).setText("");
		
	}
	
	protected void addActions(Panel actionsPanel) {}
	
	public void crearNuevaMetodologia() {
		try {
			this.getModelObject().crearMetodologia();
			this.close();
		}
		catch(NullPointerException | NumberFormatException | NoSuchElementException e) {
			Dialog <?> dialog = new ErrorWindow(this, "Datos incompletos o incorrectos");
			dialog.open();
		}
		}
	
	
	public void agregarCondicion() {
		ElegirTipoCondicionWindow dialog = new ElegirTipoCondicionWindow(this);
		dialog.open();
	
	}
	
}
