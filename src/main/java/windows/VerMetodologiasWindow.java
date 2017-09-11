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
		
		new Label(panelActions).setText("                  Seleccionar empresas a comparar                  ");
		Selector<Empresa> selector2 = new Selector<Empresa>(panelActions);
		selector2.allowNull(false);
		selector2.bindValueToProperty("empresaSeleccionada");
		selector2.bindItemsToProperty("empresas");
		
		new Button(panelActions)
		.setCaption("Agregar empresa a comparar")
		.onClick(this:: agregarEmpresaAComparar);
		
		/*Table<Empresa> tableAComparar = new Table<Empresa>(panelActions, Empresa.class);
		tableAComparar.setNumberVisibleRows(5).bindItemsToProperty("empresasAComparar");
				
		Column<Empresa> columnaNombres1 = new Column<Empresa>(tableAComparar);
		columnaNombres1.setTitle("Empresa").setFixedSize(100).bindContentsToProperty("nombre");*/
		
		//new Label(panelActions).setText("Elegir un anio");
		//new TextBox(panelActions).bindValueToProperty("anioElegido");
		
		new Label(panelActions).setText("");
		
		new Button(panelActions)
		.setCaption("Aplicar Metodologia")
		.onClick(this::aplicarMetodologia);		
		

		Table<Empresa> tableCuentas = new Table<Empresa>(panelActions, Empresa.class);
		tableCuentas.setNumberVisibleRows(5).bindItemsToProperty("empresasOrdenadas");
				
		Column<Empresa> columnaNombres = new Column<Empresa>(tableCuentas);
		columnaNombres.setTitle("Empresa").setFixedSize(100).bindContentsToProperty("nombre");
		Column<Empresa> columnaCuentas = new Column<Empresa>(tableCuentas);
		columnaCuentas.setTitle("Cuentas").setFixedSize(100).bindContentsToProperty("cuentas");
		
	}
	
	
	public void agregarEmpresaAComparar()
	{
		try {
			this.getModelObject().agregarEmpresaAComparar();
		}
		
		catch(NullPointerException | NumberFormatException | NoSuchElementException e) {
			Dialog <?> dialog = new ErrorWindow(this, "Datos incompletos o incorrectos");
			dialog.open();
		}
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
