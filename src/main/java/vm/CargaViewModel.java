package vm;

import repositories.Repositorios;

public class CargaViewModel {
	
	public void cargarOperaciones() {
		Repositorios.repositorioIndicadores.cargarOperaciones();
	}
	
}
