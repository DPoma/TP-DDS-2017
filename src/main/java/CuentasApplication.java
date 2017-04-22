import java.io.IOException;

import repositories.Repositorios;

public class CuentasApplication {

	public static void main(String[] args) throws IOException {
		
		Repositorios.repositorioCuentas.cargarCuentas("C:\\Users\\Diego\\Documents\\Git\\dds-tpa-clandestino\\src\\main\\java\\cuentas.csv");
		System.out.println(Repositorios.repositorioCuentas.filtrarPorEmpresa("Facebook"));
		
	}
	

}
