package repositories;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

import com.opencsv.CSVReader;

import model.Cuenta;
@Observable
public class RepositorioCuentas {

	private List<Cuenta> cuentas = new ArrayList<>();

	public List<Cuenta> getCuentas() {
		return cuentas;
	}
	
	public void agregarCuenta(Cuenta unaCuenta)
	{
		this.cuentas.add(unaCuenta);
	}
	
	public void cargarCuentas(String path) throws IOException
	{
	     CSVReader reader = new CSVReader(new FileReader(path), ';');
	     String [] linea;
	     while ((linea = reader.readNext()) != null) {
	    	int anio = Integer.parseInt(linea[2]);
	    	double monto = Double.parseDouble(linea[3]);
	        Cuenta unaCuenta = new Cuenta(linea[0], linea[1], anio, monto);
	        this.agregarCuenta(unaCuenta);
	     }
	     reader.close();
	}
	
	public List<Cuenta> filtrarPorEmpresaPeriodo(String empresa,String anio1, String anio2)
	{
		int iAnio1 = Integer.parseInt(anio1);
		int iAnio2 = Integer.parseInt(anio2);
		return cuentas.stream().filter(unaCuenta -> unaCuenta.getEmpresa().equals(empresa)).filter(unaCuenta -> unaCuenta.getAnio()>=iAnio1 && unaCuenta.getAnio()<=iAnio2 ).collect(Collectors.toList());
	}
}
