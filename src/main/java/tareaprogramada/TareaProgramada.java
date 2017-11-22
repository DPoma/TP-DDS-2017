package tareaprogramada;
import java.util.TimerTask;

public class TareaProgramada extends TimerTask {

	private String path;

	public TareaProgramada(String path) 
	{
		super();
		this.path = path;
	}

	@Override
	public void run() {
		try {
		//codigo aqui
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
