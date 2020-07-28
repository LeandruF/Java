package model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HibernateUtil {
	private static Session session;
	public static String erro = null;

	public static Session abrirSession() {
		try {
		SessionFactory sessionFactory;
	    sessionFactory = new Configuration().configure().buildSessionFactory();
		// pegando as configuraçõe de um hibernate específico, conforme passado como argumento
		session = sessionFactory.openSession();
		return session;
		} catch (Throwable e) {
		erro = e.toString();
		System.out.println("ERRO NO HIBERNATE: "+erro);
		return null;
		}
		}

	public static void fecharSession() {
		if (session != null) {
			try {
				session.close();
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}