package windows;


import vm.CargaViewModel;

import java.awt.FileDialog;
import java.awt.Frame;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import repositories.Repositorios;

@SuppressWarnings("serial")
public class CargaWindow extends SimpleWindow<CargaViewModel> {
	
	
	public CargaWindow(WindowOwner parent) {
		super(parent, new CargaViewModel());
	}
	
	//@Override
	public void createFormPanel(Panel panelActions) {
	new Panel(panelActions);
	}
	
	@Override
	public void createContents(Panel panelActions) {
		this.setTitle("Analizador de Inversiones");
		panelActions.setLayout(new VerticalLayout());

		new Button(panelActions)
			.setCaption("Cargar Cuentas")
			.onClick(this::cargarCuentas);
		
		
		new Label(panelActions).setText("");
		
		new Button(panelActions)
			.setCaption("Cargar Indicadores")
			.onClick(this::cargarIndicadores);
		
		new Label(panelActions).setText("");
		
		new Button(panelActions)
			.setCaption("Cargar Metodologias")
			.onClick(this::cargarMetodologias);
		
		new Label(panelActions).setText("");
		
		new Button(panelActions)
			.setCaption("Ventana Busqueda")
			.onClick(this::ventanaBusqueda);
		
		new Button(panelActions)
			.setCaption("Ventana Analisis")
			.onClick(this::ventanaAnalisis);
		
		new Button(panelActions)
			.setCaption("Ventana Crear")
			.onClick(this::ventanaCrear);
	}
	
	protected void addActions(Panel actionsPanel) {}
	
	public void cargarCuentas() {
		PathWindow dialog = new PathWindow(this);
		dialog.open();
		//System.out.println(Repositorios.repositorioCuentas.filtrarPorEmpresa("Facebook"));
		/*FileDialog dialogoArchivo;
		dialogoArchivo = new FileDialog(frame,"Lista de s desde Frame", FileDialog.LOAD); 
		dialogoArchivo.setDirectory("C:\\");
		dialogoArchivo.setFile("*.csv");*/
	}
	
	public void cargarIndicadores() {
		  
	}
	
	public void cargarMetodologias() {
		  
	}
	
	public void ventanaBusqueda() {
		BusquedaWindow dialog = new BusquedaWindow(this);
		this.close();
		dialog.open();
	}
	
	public void ventanaAnalisis() {
		AnalisisWindow dialog = new AnalisisWindow(this);
		this.close();
		dialog.open();
	}
	
	public void ventanaCrear() {
		CrearWindow dialog = new CrearWindow(this);
		this.close();
		dialog.open();
}
	
}