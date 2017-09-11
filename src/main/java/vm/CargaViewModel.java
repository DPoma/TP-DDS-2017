package vm;

import repositories.Repositorios;

public class CargaViewModel {
	
	public boolean hayEmpresasCargadas() {
		return !Repositorios.repositorioEmpresas.getEmpresas().isEmpty();
		
	}
}
