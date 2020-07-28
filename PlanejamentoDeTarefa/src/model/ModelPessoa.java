package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import controller.Equipe;
import controller.Pessoa;

public class ModelPessoa {
	String msg;
	// Connection conn;
	Session session;

	// USA O DATABASE PLANINGTASK

//ACHO Q PODE MORRER ESSE CONSTRUTOR
	public ModelPessoa() {
	}

	// CADASTRAR PESSOA COM HIBERNATE
	public boolean modelCadastrarPessoa(Pessoa p) {
		try {

			session = HibernateUtil.abrirSession();
			session.beginTransaction(); // mandafazer a persistencia dos dados

			session.save(p); // executa a ação de salvar

			session.getTransaction().commit(); // confirma a transação de salvar


			try {
				Equipe e = new Equipe();
				List <Pessoa>listaPessoas = new ArrayList<Pessoa>();
				listaPessoas.add(p);
				
				e.setNome(p.getNomeEquipe());
				e.setListaPessoasEquipe(listaPessoas);
				
				session.beginTransaction(); // mandafazer a persistencia dos dado
				session.save(e); // executa a ação de salvar
				session.getTransaction().commit(); // confirma a transação de salvar


				
			} catch (HibernateException e) {
				msg = "ModCadPessoa, Err 102: " + e.toString();
			}
			
			
			session.close(); // fecha a conexão
			return true;
		} catch (HibernateException e) {
			msg = "ModCadPessoa, Err 102: " + e.toString();
			return false;
		}

	}
	//LOCALIZAR
	public Pessoa localizarPessoa(String cpf) {
		try {
			Session session = HibernateUtil.abrirSession();
			session.beginTransaction();
			String sql = "SELECT id,nome,cpf,cell,email,password,nome_equipe FROM pessoas WHERE cpf = :cpf";

			Query query = session.createSQLQuery(sql);
			query.setParameter("cpf", cpf);
			List<Object[]> obj = query.getResultList();
			Pessoa p = new Pessoa();

			for (Object[] o : obj) {
				Object[] aux = o;
				
				// Objeto que sualistaModel recebe, vamos chamar de x
				p.setId((Integer) aux[0]);
				p.setNome((String) aux[1]);
				p.setCpf((String) aux[2]);
				p.setCell((String) aux[3]);
				p.setEmail((String) aux[4]);
				p.setPassword((String) aux[5]);
				p.setNomeEquipe((String) aux[6]);
				System.out.println("Olá " + p.getNome());
			}	
			return p;
		} catch (HibernateException e) {
			msg = "SQL Problem, Err 103: " + e.toString();
			System.out.println(msg);
			return null;
		}

	}
	public Pessoa localizarPessoaEmail(String email) {
		try {
			Session session = HibernateUtil.abrirSession();
			session.beginTransaction();
			String sql = "SELECT id,nome,cpf,cell,email,password,nome_equipe FROM pessoas WHERE email = :email";

			Query query = session.createSQLQuery(sql);
			query.setParameter("email", email);
			List<Object[]> obj = query.getResultList();
			Pessoa p = new Pessoa();

			for (Object[] o : obj) {
				Object[] aux = o;
				
				// Objeto que sualistaModel recebe, vamos chamar de x
				p.setId((Integer) aux[0]);
				p.setNome((String) aux[1]);
				p.setCpf((String) aux[2]);
				p.setCell((String) aux[3]);
				p.setEmail((String) aux[4]);
				p.setPassword((String) aux[5]);
				p.setNomeEquipe((String) aux[6]);
				
			}	
			return p;
		} catch (HibernateException e) {
			msg = "SQL Problem, Err 103: " + e.toString();
			System.out.println(msg);
			return null;
		}

	}	
	// UPDATE 	
	public boolean modelUpdatePessoaNome(String nome,String cpf) {
		try {
			session = HibernateUtil.abrirSession();
			session.beginTransaction();
			Pessoa p = new Pessoa();
			
		    p = localizarPessoa(cpf);
		    p = session.get(Pessoa.class,p.getId());
			p.setNome(nome);
			
			session.update(p);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			msg = "ModUpdate, Err 102: " + e.toString();
			return false;
		}
	}
	public boolean modelUpdatePessoaCell(String cell,String cpf) {
		try {
			session = HibernateUtil.abrirSession();
			session.beginTransaction();
			Pessoa p = new Pessoa();
			
		    p = localizarPessoa(cpf);
		    p = session.get(Pessoa.class,p.getId());
			p.setCell(cell);
			
			session.update(p);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			msg = "ModUpdate, Err 102: " + e.toString();
			return false;
		}
	}
	public boolean modelUpdatePessoaCpf(String cpf,String email) {
		try {
			session = HibernateUtil.abrirSession();
			session.beginTransaction();
			Pessoa p = new Pessoa();
			
		    p = localizarPessoaEmail(email);
		    p = session.get(Pessoa.class,p.getId());
			p.setCpf(cpf);
			
			session.update(p);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			msg = "ModUpdate, Err 102: " + e.toString();
			return false;
		}
	}
	public boolean modelUpdatePessoaEmail(String email,String cpf) {
		try {
			session = HibernateUtil.abrirSession();
			session.beginTransaction();
			Pessoa p = new Pessoa();
			
		    p = localizarPessoa(cpf);
		    p = session.get(Pessoa.class,p.getId());
			p.setEmail(email);
			
			session.update(p);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			msg = "ModUpdate, Err 102: " + e.toString();
			return false;
		}
	}
	public boolean modelUpdatePessoaPassword(String password,String cpf) {
		try {
			session = HibernateUtil.abrirSession();
			session.beginTransaction();
			Pessoa p = new Pessoa();
			
		    p = localizarPessoa(cpf);
		    p = session.get(Pessoa.class,p.getId());
			p.setPassword(password);
			
			session.update(p);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			msg = "ModUpdate, Err 102: " + e.toString();
			return false;
		}
	}
	public boolean modelUpdatePessoaNomeEquipe(String nomeEquipe,String cpf) {
		try {
			session = HibernateUtil.abrirSession();
			session.beginTransaction();
			Pessoa p = new Pessoa();
			
		    p = localizarPessoa(cpf);
		    p = session.get(Pessoa.class,p.getId());
			p.setNomeEquipe(nomeEquipe);
			
			session.update(p);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			msg = "ModUpdate, Err 102: " + e.toString();
			return false;
		}
	}
	
	//DELETE
	public boolean modelDeletePessoa(String cpf	) {
		try {
			session = HibernateUtil.abrirSession();
			session.beginTransaction();
			Pessoa p = new Pessoa();
			 p = localizarPessoa(cpf);
			 p = session.get(Pessoa.class,p.getId());
			session.delete(p);
			session.getTransaction().commit();
			session.close();

			return true;
		} catch (HibernateException e) {
			msg = "ModDelete, Err 102: " + e.toString();
			return false;
		}
	}
	
	// HIBERNATE LOGIN**************ERRO****************************************

	public List<Pessoa> modelLoginPessoa(String email, String password) {
		try {
			Session session = HibernateUtil.abrirSession();
			session.beginTransaction();
			String sql = "SELECT id,nome,cpf,cell FROM pessoas WHERE email = :email AND password = :password";

			Query query = session.createSQLQuery(sql);
			query.setParameter("email", email);
			query.setParameter("password", password);

			// List<Pessoa> lista = (List<Pessoa>)query.list();
			// System.out.println(lista.size());

			List<Object[]> obj = query.getResultList();
			// Pessoa p = (Pessoa) query.getResultList();
			// List<Pessoa> lista = query.list();

			// Aqui vai ser manipulado o objs.
			// Cria suaLiistaModel
			List<Pessoa> lista = new ArrayList<Pessoa>();

			for (Object[] o : obj) {
				Object[] aux = o;
				Pessoa p = new Pessoa();
				// Objeto que sualistaModel recebe, vamos chamar de x
				p.setId((Integer) aux[0]);
				p.setNome((String) aux[1]);
				p.setCpf((String) aux[2]);
				p.setCell((String) aux[3]);
				p.setEmail(email);
				p.setPassword(password);
				System.out.println("Olá " + p.getNome());
				lista.add(p);
			}
			/*
			 * for (Object[] o : objs) {
			 * 
			 * Object[] aux = o; RelatorioStausTarefaProjetoModel r = new
			 * RelatorioStausTarefaProjetoModel(); //Objeto que sualistaModel recebe, vamos
			 * chamar de x
			 * 
			 * r.setIdprojeto((Integer)aux[0]); // id r.setStatus((StatusTarefa)aux[1]);
			 * r.setCont((Long)aux[2]); relList.add(r); }
			 * 
			 */

			if (lista.isEmpty()) {
				return null;
			} else {

				return lista;
			}
		} catch (HibernateException e) {
			msg = "SQL Problem, Err 103: " + e.toString();
			System.out.println(msg);
			return null;
		}

	}
	public Pessoa modelLoginPessoa2(Pessoa p) {
		try {
			Session session = HibernateUtil.abrirSession();
			session.beginTransaction();
			String sql = "SELECT id FROM pessoas WHERE email = :email AND password = :password";

			Query query = session.createSQLQuery(sql);
			query.setParameter("email", p.getEmail());
			query.setParameter("password", p.getPassword());

			
					//List<Pessoa> pessoa = query.getResultList();
					// p = (Pessoa) query.getResultList().get(0);
					 int id = (int) query.getResultList().get(0);
					// p.setId(id);
					p = session.find(Pessoa.class,id);
						
					return p ; 
		}catch(HibernateException e) {
			return null;
		}
	}
	public Pessoa modelLoginPessoa3(Pessoa p) {
		try {
			Session session = HibernateUtil.abrirSession();
			session.beginTransaction();

				Criteria cri = session.createCriteria(Pessoa.class);
				cri.add(Restrictions.eq("email",p.getEmail()));
				cri.add(Restrictions.eq("password",p.getPassword()));
				//cri.setFirstResult(1).setMaxResults(1);

				p = (Pessoa) cri.list().get(0);
					if(p == null) {
						return null;
					}else {
						return p;
					}
					
		}catch(HibernateException e) {
			return null;
		}
	}
	public boolean modelExisteCpf(String cpf) {
		try {
			Session session = HibernateUtil.abrirSession();
			session.beginTransaction();

				Criteria cri = session.createCriteria(Pessoa.class);
				cri.add(Restrictions.eq("cpf",cpf));
				List lista = cri.list();
					if(lista.isEmpty()) {
						return true;
					}else {
						return false;
					}
					
		}catch(HibernateException e) {
			return false;
		}
	}
	public int pegarIdPessoa(String cpf) {
		try {
			Session session = HibernateUtil.abrirSession();
			session.beginTransaction();
			String sql = "SELECT id FROM pessoas WHERE cpf = :cpf";

			Query query = session.createSQLQuery(sql);
			query.setParameter("cpf", cpf);
			try {	
			int id = (int) query.getSingleResult();
			return id;
			}catch(NoResultException e) { //SE NAO ACHAR NINGUEM CAI NESSE  EXCEPTION
				msg = "Não achei ninguem no sistema com esse cpf.";
				return -1;
			}	
		} catch (HibernateException e) {
			msg = "SQL Problem, Err 103: " + e.toString();
			System.out.println(msg);
			return -1;
		}

	}
	
}