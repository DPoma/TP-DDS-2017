package windows;

import java.util.List;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import model.Cuenta;
import vm.CrearViewModel;
import vm.MostrarCuentasViewModel;

@SuppressWarnings("serial")
public class MostrarCuentasWindow extends Dialog<MostrarCuentasViewModel> {
	
	public MostrarCuentasWindow(WindowOwner parent, List<Cuenta> cuenta) {
		super(parent, new MostrarCuentasViewModel(cuenta));
	}

	public void createContents(Panel panelActions) {
		this.setTitle("Resultados de Cuentas");
		
		Table<Cuenta> tableCuentas = new Table<Cuenta>(panelActions, Cuenta.class);
		tableCuentas.setNumberVisibleRows(5).bindItemsToProperty("cuentas");
		
		Column<Cuenta> columnaEmpresa = new Column<Cuenta>(tableCuentas);
		columnaEmpresa.setTitle("Empresa").setFixedSize(150).bindContentsToProperty("empresa");
		
		Column<Cuenta> columnaNombres = new Column<Cuenta>(tableCuentas);
		columnaNombres.setTitle("Nombre").setFixedSize(100).bindContentsToProperty("nombre");
		
		Column<Cuenta> columnaAprobados = new Column<Cuenta>(tableCuentas);
		columnaAprobados.setTitle("Año").setFixedSize(75).bindContentsToProperty("anio");
		
		Column<Cuenta> columnaMonto = new Column<Cuenta>(tableCuentas);
		columnaMonto.setTitle("Monto").setFixedSize(150).bindContentsToProperty("monto");

	}
	protected void createFormPanel(Panel mainPanel) {}

}