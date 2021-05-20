package co.prueba.model.persistence.baseDeDatos;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Clase encargada de Inicializar una SessionFactory por medio del patrón de diseño Singleton
 * @author Diego Torres
 *
 */
public class SesionHibernate {
	
	private static final SessionFactory sf;

	
	static {
		sf = new Configuration().configure().buildSessionFactory();
	}


	public static SessionFactory getSf() {
		
		return sf;
	}

	
}
