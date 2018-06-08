package br.com.SistemaGiada.util;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory(); //iniciar conexao

	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			//return new Configuration().configure().buildSessionFactory(new StandardServiceRegistryBuilder().build());
			//subst
			
			Configuration configuration = new Configuration();
			configuration.configure();
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			
			SessionFactory sessionFactory = new Configuration().buildSessionFactory(serviceRegistry);
			return sessionFactory;
			
		} catch (Throwable ex) {
			//Mensagem de erro ao conectar
			System.err.println("Erro na conxexão." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}