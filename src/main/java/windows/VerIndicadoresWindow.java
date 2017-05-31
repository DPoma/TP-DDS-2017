package windows;

import java.util.List;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import model.Empresa;
import model.Indicador;
import vm.VerIndicadoresViewModel;

@SuppressWarnings("serial")
public class VerIndicadoresWindow extends Dialog<VerIndicadoresViewModel> {
	public VerIndicadoresWindow(WindowOwner parent, String unaEmpresa)
	{
		super(parent, new VerIndicadoresViewModel(unaEmpresa));
	}
	public void createFormPanel(Panel panelActions) {
		new Panel(panelActions);
	}
	@Override
	public void createContents(Panel panelActions) {
		Selector<Indicador> selector = new Selector<Indicador>(panelActions);
		selector.bindValueToProperty("indicadorSeleccionado");
		selector.bindItemsToProperty("indicadores");
		
		new Button(panelActions)
		.setCaption("Aplicar Indicador")
		.onClick(this::aplicarIndicador);
		
		new Label(panelActions).bindValueToProperty("resultado");
	}
	
	public void aplicarIndicador()
	{
		this.getModelObject().aplicarIndicador();
	}
}