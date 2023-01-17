package jpa.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * 
 * This class sets up the Hibernate connection from this Maven project to the database
 *
 */
public class HibernateUtil {

	public static Session getConnection() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		return session;
	}

}