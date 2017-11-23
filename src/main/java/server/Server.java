package server;

import java.util.Timer;
import java.util.TimerTask;

import repositories.Repositorios;
import spark.Spark;
import spark.debug.DebugScreen;
import tareaprogramada.TareaProgramada;

public class Server {
	public static void main(String[] args) {
		Spark.port(9000);
		DebugScreen.enableDebugScreen();
		Router.configure();
		TimerTask cargarEmpresasBatch = new TareaProgramada("src/main/resources/static/cuentas.csv");
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(cargarEmpresasBatch, 0, 1*60*1000);	//esta en milisegundos, o sea 1 minutos
        
	}

}
