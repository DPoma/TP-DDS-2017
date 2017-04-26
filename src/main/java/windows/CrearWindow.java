package windows;


import vm.CrearViewModel;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
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
		this.setTitle("Nueva Metodologia");
		panelActions.setLayout(new VerticalLayout());
		new Label(panelActions).setText("		Ingrese una metodologia		");
		new TextBox(panelActions);
		new Button(panelActions)
			.setCaption("Aceptar")
			
			.onClick(this::crearNuevaMetodologia);
		
		new Label(panelActions).setText("");
		
	}
	
	protected void addActions(Panel actionsPanel) {}
	
	public void crearNuevaMetodologia() {
		  this.close();
	}
	
}
