package repositories;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.opencsv.CSVReader;

import model.Cuenta;

public class RepositorioCuentas {

	private List<Cuenta> cuentas;
	
	public RepositorioCuentas()
	{
		this.cuentas = new ArrayList<Cuenta>();
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}
	
	public void agregarCuenta(Cuenta unaCuenta)
	{
		this.cuentas.add(unaCuenta);
	}
	
	public void eliminarCuenta(Cuenta unaCuenta)
	{
		this.cuentas.remove(unaCuenta);
	}
	
	public void cargarCuentas(String path) throws IOException
	{
	    CSVReader reader = new CSVReader(new FileReader(path), ';');
	    String [] linea;
	    while ((linea = reader.readNext()) != null) {
	       int anio = Integer.parseInt(linea[2]);
	       Cuenta unaCuenta = new Cuenta(linea[0], linea[1], anio, linea[3]);
	       this.agregarCuenta(unaCuenta);
	       
	    }
	    reader.close();
	}
	
	public List<Cuenta> filtrarPorEmpresaPeriodo(String empresa,String anioMin, String anioMax)
	{
		int unAnio = Integer.parseInt(anioMin);
		int otroAnio = Integer.parseInt(anioMax);
		return cuentas.stream().filter(unaCuenta -> unaCuenta.perteneceA(empresa, unAnio, otroAnio)).collect(Collectors.toList());
	}
}
