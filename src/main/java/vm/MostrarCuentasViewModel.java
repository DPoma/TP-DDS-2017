package vm;

import java.util.List;
import org.uqbar.commons.utils.Observable;
import model.Cuenta;

@Observable
public class MostrarCuentasViewModel {
	private String empresa;
	private List<Cuenta> cuentas;
	private List<String> nombres ;
	private List<Integer> anios ;
	private List<Double> montos ;
	private Cuenta cuentaSeleccionada;
	
	public MostrarCuentasViewModel(List<Cuenta> cuentas, String empresa) {
		this.cuentas = cuentas;
		this.empresa = empresa;
	}
	
	public String getEmpresa() {
		return empresa;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}
	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	public List<String> getNombre() {
		return nombres;
	}
	public void setNombre(List<String> nombre) {
		this.nombres = nombre;
	}
	public List<Integer> getAnio() {
		return anios;
	}
	public void setAnio(List<Integer> anio) {
		this.anios = anio;
	}
	public List<Double> getMonto() {
		return montos;
	}
	public void setMonto(List<Double> monto) {
		this.montos = monto;
	}
	public Cuenta getCuentaSeleccionada() {
		return cuentaSeleccionada;
	}
	public void setCuentaSeleccionada(Cuenta cuentaSeleccionada) {
		this.cuentaSeleccionada = cuentaSeleccionada;
	}
}
