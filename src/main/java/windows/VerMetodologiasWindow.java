package windows;


import java.util.NoSuchElementException;

import vm.VerMetodologiasViewModel;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import model.Empresa;
import model.Metodologia;

@SuppressWarnings("serial")
public class VerMetodologiasWindow extends SimpleWindow<VerMetodologiasViewModel> {
	
	
	public VerMetodologiasWindow(WindowOwner parent) {
		super(parent, new VerMetodologiasViewModel());
	}
	
	public void createFormPanel(Panel panelActions) {
	new Panel(panelActions);
	}
	
	@Override
	public void createContents(Panel panelActions) {
		this.setTitle("Busqueda");
		panelActions.setLayout(new VerticalLayout());

		this.setTitle("Metodologias");
		new Label(panelActions).setText("                     Seleccionar metodologia                    ");
		Selector<Metodologia> selector = new Selector<Metodologia>(panelActions);
		selector.allowNull(false);
		selector.bindValueToProperty("metodologiaSeleccionada");
		selector.bindItemsToProperty("metodologias");
		new Button(panelActions)
		.setCaption("Aplicar Metodologia")
		.onClick(this::aplicarMetodologia);		
		
		new Label(panelActions).setText("");

		Table<Empresa> tableCuentas = new Table<Empresa>(panelActions, Empresa.class);
		tableCuentas.setNumberVisibleRows(5).bindItemsToProperty("empresasOrdenadas");
				
		Column<Empresa> columnaNombres = new Column<Empresa>(tableCuentas);
		columnaNombres.setTitle("Empresa").setFixedSize(100).bindContentsToProperty("nombre");
		
	}

	public void aplicarMetodologia()
	{
		try {
			this.getModelObject().aplicarMetodologia();
		}
		
		catch(NullPointerException | NumberFormatException | NoSuchElementException e) {
			Dialog <?> dialog = new ErrorWindow(this, "Datos incompletos o incorrectos");
			dialog.open();
		}
	}
	
	protected void addActions(Panel actionsPanel) {}

}
