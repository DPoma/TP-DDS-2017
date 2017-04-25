package windows;

import vm.PathViewModel;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

@SuppressWarnings("serial")
public class PathWindow extends SimpleWindow<PathViewModel> {
	
	
	public PathWindow(WindowOwner parent) {
		super(parent, new PathViewModel());
	}
	
	public void createFormPanel(Panel panelActions) {
	new Panel(panelActions);
	}
	
	@Override
	public void createContents(Panel panelActions) {
		panelActions.setLayout(new VerticalLayout());

		new Label(panelActions).setText("RutaDeArchivo:                                                                          ");
		new TextBox(panelActions).bindValueToProperty("path");
		
		new Label(panelActions).setText("");
		
		new Button(panelActions)
			.setCaption("Aceptar")
			.onClick(this::aceptar);
	}
	
	protected void addActions(Panel actionsPanel) {}
	
	public void aceptar() {
		this.getModelObject().cargarCuentas();
		this.close();
	}
}
