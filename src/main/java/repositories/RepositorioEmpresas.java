package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import model.Cuenta;
import model.Empresa;

public class RepositorioEmpresas {

	private List<Empresa> empresas;
	
	public RepositorioEmpresas(){
		
		this.empresas = new ArrayList<Empresa>();
	}
	
	public List<Empresa> getEmpresas(){
		
		return this.empresas;
	}
	
	private void agregarEmpresa(String empresa, Cuenta cuenta){
		this.empresas.add(new Empresa(empresa,cuenta));
	}
	
	private void modificarEmpresa(String empresa, Cuenta cuenta){
		this.empresas.stream().forEach(x->{
			if(x.equals(empresa)) x.agregarCuenta(cuenta);
		});
	}
	
	public void trabajarEmpresa(String empresa, Cuenta cuenta){
		if(!existeEmpresa(empresa))
			this.agregarEmpresa(empresa, cuenta);
		else
			this.modificarEmpresa(empresa,cuenta);
	}
	
	public boolean existeEmpresa(String empresa){
		return empresas.stream().anyMatch(x->x.getNombre().equals(empresa));
	}
	
	public void borrarTodo()
	{
		empresas.clear();
	}
	
/*	public List<Cuenta> filtrarPorEmpresaPeriodo(String empresa, String anioMin, String anioMax){
		Empresa e= this.empresas.stream().filter(x->x.nameEqualsCI(empresa)).findFirst().get();
		return e.periodoEntre(anioMin, anioMax);
	}*/
	
	public void eliminarEmpresa(String empresa){
		this.empresas.removeIf(x->x.getNombre().equals(empresa));
	}
	
	public Empresa find(Predicate<? super Empresa> criterio)
	{
		return this.empresas.stream().filter(criterio).findFirst().get();
	}

	
	
}
