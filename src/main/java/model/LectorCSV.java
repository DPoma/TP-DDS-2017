package model;

import java.io.FileReader;
import java.io.IOException;

import com.ibm.icu.math.BigDecimal;
import com.opencsv.CSVReader;

import repositories.Repositorios;

public class LectorCSV {
	
	public LectorCSV(){
		
	}
	
	public CSVReader leer(String path) throws IOException {
		return new CSVReader(new FileReader(path), ';');
	}
	
	public void leerArchivoCuentas(String path) throws IOException{
		CSVReader reader= this.leer(path);
	    String [] linea;
	    while ((linea = reader.readNext()) != null) {
	        int anio = Integer.parseInt(linea[2]);
	        Cuenta unaCuenta = new Cuenta(linea[1], anio, linea[3]);
	    	Repositorios.repositorioEmpresas.trabajarEmpresa(linea[0], unaCuenta);
	    }
		
	}
}