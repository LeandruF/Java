package model;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import controller.Equipe;


public class ModelEquipe {
	Session session;
	String msg;
	public boolean modelCadastrarEquipe(Equipe eq) {
		try {

		    session = HibernateUtil.abrirSession();
			session.beginTransaction();
			// manda fazer a persistencia dos dados

			session.save(eq);
			// executa a a��o de salvar

			session.getTransaction().commit();
			// confirma a transa��o de salvar

			session.close();
			// fecha a conex�o

			return true;
		} catch (HibernateException e) {
			msg = "Fatal Error, Err 102: " + e.toString();
			return false;
		}

	}
}
