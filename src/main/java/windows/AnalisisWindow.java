package windows;


import vm.AnalisisViewModel;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

@SuppressWarnings("serial")
public class AnalisisWindow extends SimpleWindow<AnalisisViewModel> {
	
	
	public AnalisisWindow(WindowOwner parent) {
		super(parent, new AnalisisViewModel());
	}
	
	public void createFormPanel(Panel panelActions) {
	new Panel(panelActions);
	}
	
	@Override
	public void createContents(Panel panelActions) {
		this.setTitle("Analizador de Inversiones");
		panelActions.setLayout(new VerticalLayout());

		new Label(panelActions).setText("Nombre de empresa:                                                                          ");
		new TextBox(panelActions).bindValueToProperty("empresa");
		
		new Label(panelActions).setText("Metodologia:                                                                                            ");
		new TextBox(panelActions).bindValueToProperty("metodologia");
		
		new Button(panelActions)
			.setCaption("Analizar")
			.onClick(this::mostrarResultados);
		
	}
	
	protected void addActions(Panel actionsPanel) {}
	
	public void mostrarResultados() {
	  this.close();
	}
	
}

