package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.opencsv.CSVReader;

import repositories.Repositorios;

public class FileHandler {
	
	public FileHandler(){
		
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
	
	public void leerArchivoIndicadores(String path)
	{
		CSVReader reader;
		try {
			reader = this.leer(path);
			String [] linea;
			while ((linea = reader.readNext()) != null) {
	        
	        Indicador unIndicador = new Indicador(linea[0], linea[1]);
	    	Repositorios.repositorioIndicadores.agregarIndicador(unIndicador);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void guardarIndicador(String path, Indicador indicador)
	{
		File archivo = new File(path);
		PrintWriter escritor;
		try {
			escritor = new PrintWriter(new FileOutputStream(archivo, true));
			escritor.append(indicador.getNombre() + ";" + indicador.getFormula() + "\n");
			escritor.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public void leerArchivoMetodologias(String path)
	{
		CSVReader reader;
		try {
			reader = this.leer(path);
			String [] linea;
			while ((linea = reader.readNext()) != null) {
	        
	        Metodologia unaMetodologia = new Metodologia(linea[0], linea[1]);
	    	Repositorios.repositorioMetodologias.agregarMetodologia(unaMetodologia);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void guardarMetodologia(String path, Metodologia metodologia)
	{
		File archivo = new File(path);
		PrintWriter escritor;
		try {
			escritor = new PrintWriter(new FileOutputStream(archivo, true));
			escritor.append(metodologia.getNombre() + ";" + metodologia.getOperacion()  + "\n");
			escritor.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}	
	
	
	public void guardarNuevasMetodologia(String path, Metodologia nuevaMetodologia)
	{
		File archivo = new File(path);
		PrintWriter escritor;
		try {
			escritor = new PrintWriter(new FileOutputStream(archivo, true));
			escritor.append(nuevaMetodologia.getNombre() + ";" + nuevaMetodologia.getOperacion()  + "\n");
			escritor.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	

}