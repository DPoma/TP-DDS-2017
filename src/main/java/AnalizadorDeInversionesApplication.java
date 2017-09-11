import java.io.IOException;

import javax.persistence.EntityManager;

import model.Empresa;
import model.IgualA;
import model.MayorA;
import model.Mediana;
import model.MenorA;
import model.Promedio;
import model.Sumatoria;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import repositories.Repositorios;
import windows.PrincipalWindow;

public class AnalizadorDeInversionesApplication extends Application{

		public static void main(String[] args) throws IOException {
			EntityManager entity = PerThreadEntityManagers.getEntityManager();
			entity.getTransaction().begin();
			entity.persist(new MayorA());
			entity.persist(new MenorA());
			entity.persist(new IgualA());
			entity.getTransaction().commit();
			entity.getTransaction().begin();
			entity.persist(new Promedio());
			entity.persist(new Sumatoria());
			entity.persist(new Mediana());
			entity.getTransaction().commit();
			new AnalizadorDeInversionesApplication().start();

		}
		
		@Override
		protected Window<?> createMainWindow() {
			return new PrincipalWindow(this);
		}
}
