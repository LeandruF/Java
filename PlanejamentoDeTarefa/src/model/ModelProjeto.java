package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import controller.Pessoa;
import controller.Projeto;
import controller.ResponsavelProjeto;

public class ModelProjeto  {
Session session;
String msg;

//COM HIBERNATE
//FALTA CADASTRAR IDRESPONSAVEL PROJETO
	public boolean modelCadastrarProjeto(Projeto p) {
		try {
		    session = HibernateUtil.abrirSession();
			session.beginTransaction();
			session.save(p);
			session.getTransaction().commit();

			session.close();
			// fecha a conexão
			System.out.println("Salvo");
			return true;
		} catch (HibernateException e) {
			msg = "ModCadtrarTarefa, Err 102: " + e.toString();
			System.out.println(msg);
			return false;
		}

	}
	//NÃO UTILIZADO AINDA
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
	//*********************************************TESTAR****************************
	public Projeto modelListarProjeto(int id_responsavel_projeto) {
		try {
			Session session = HibernateUtil.abrirSession();
			session.beginTransaction();

				Criteria cri = session.createCriteria(Projeto.class);
				cri.add(Restrictions.eq("id_responsavel_projeto",id_responsavel_projeto));
				
				//cri.setFirstResult(1).setMaxResults(1);

				Projeto p = (Projeto) cri.list().get(0);
					if(p == null) {
						session.close();
						return null;
					}else {
						session.close();
						return p;
					}
					
		}catch(HibernateException e) {
			session.close();
			return null;
		}
	}
	
	public Projeto modelLocalizarProjeto(int idProjeto) {
		try {
			session = HibernateUtil.abrirSession();
			session.beginTransaction();
				Projeto p = new Projeto();
				p = session.find(Projeto.class, idProjeto);
				session.getTransaction().commit();
				session.close();
					
				return p; //ALTERAR
			
		}catch(HibernateException e) {
			System.out.println("ERRO modelLocalizarProjeto:"+e.toString());
			return null;
		}
		catch(Exception e1) {
			System.out.println("ERRO GERAL: "+e1.toString());
			return null;
		}
		
	}
	public List<Projeto> modelListarProjetos() {
		try {
			Session session = HibernateUtil.abrirSession();
			session.beginTransaction();

			Criteria cri = session.createCriteria(Projeto.class);
			List<Projeto> lista = new ArrayList<Projeto>();
			lista = (List<Projeto>) cri.list();
	
			session.close();
			return lista;
		}catch(HibernateException e) {
			System.out.println("ERRO modelListarProjeto:"+e.toString());
			return null;
		}
		catch(Exception e1) {
			System.out.println("ERRO GERAL: "+e1.toString());
			return null;
		}
	}
	public List<Projeto> modelListarProjetos(String cpf_responsavel) {
		try {
			Session session = HibernateUtil.abrirSession();
			session.beginTransaction();
			String sql = "SELECT id, identificacao, nome,descricao, data_ini,data_fim,hora_ini,hora_fim,status,cpf_responsavel,id_responsavel_projeto FROM projetos WHERE cpf_responsavel = :cpf_responsavel";

			Query query = session.createSQLQuery(sql);
			query.setParameter("cpf_responsavel", cpf_responsavel);
			//query.setParameter(1, cpf);

			List<Object[]> obj = query.getResultList();
			List<Projeto> lista = new ArrayList<Projeto>();

		
			for (Object[] o : obj) {
				Object[] aux = o;
				
				Projeto p = new Projeto();
				Pessoa pe = new Pessoa();
				ResponsavelProjeto rp = new ResponsavelProjeto();
				// Objeto que sualistaModel recebe, vamos chamar de x
				p.setId((Integer) aux[0]);
				p.setIdentificacao((String) aux[1]);
				p.setNome((String) aux[2]);
				p.setDescricao((String) aux[3]);
				p.setDataIni((String) aux[4]);
				p.setDataFim((String) aux[5]);
				p.setHoraIni((String) aux[6]);
				p.setHoraFim((String) aux[7]);
				p.setStatus((String) aux[8]);
				p.setCpfResponsavel((String)aux[9]);
				int idResponsavel = (Integer) aux[10];
			
			
				rp.setCpfResponsavel(cpf_responsavel);
				rp.setIdentProjeto(p.getIdentificacao());
				
				p.setResponsavelProjeto(rp);
				
			/*
				  System.out.println("---------------------------------------------------------------");
				  System.out.println("ID: "+p.getId());
				  System.out.println("IDENTIFICACAÇÃO: "+p.getIdentificacao());
				  System.out.println("NOMEE: "+p.getNome());
				  System.out.println("DESCRICAO:  "+p.getDescricao());
				 */
				
				lista.add(p);

			
		}
			session.close();
			return lista;
		}catch(HibernateException e) {
			System.out.println("ERRO modelPegarTarefas:"+e.toString());
			return null;
		}
		catch(Exception e1) {
			System.out.println("ERRO GERAL: "+e1.toString());
			return null;
		}




	}
	//*********************************************TESTAR****************************
	public List<Projeto> modelLocalizarProjeto(String nome, int idResponsavel) {
		try {
			session = HibernateUtil.abrirSession();
			session.beginTransaction();
			// VAI DAR ERRO NO IDRESPONSAVEL AQUI
			String sql = "SELECT id, nome, descricao, data_ini, data_fim, hora_ini, hora_fim, responsavel,identificacao,id_responsavel_projeto status FROM projetos WHERE nome= :nome AND id_responsavel_projeto = :idResponsavel";
			//SELECT id, nome, descricao, data_ini, data_fim, hora_ini, hora_fim, responsavel, status FROM projetos WHERE nome= "Cotidiano" AND responsavel = "Leandro"
			//id,nome,descricao,responsavel,data_ini,data_fim,hora_ini,hora_fim,status
			Query query = session.createQuery(sql);
			
			query.setParameter("nome",nome);
			query.setParameter("id_responsavel_projeto", idResponsavel);
			//query.setParameter("responsavel",nomeResp);
			
			List<Object[]> obj = query.getResultList();
			
			List<Projeto> lista =  new ArrayList<Projeto>();
			Projeto p = new Projeto();
			for (Object[] o : obj) {
				Object[] aux = o;
				System.out.println("ENTROU");
				p.setId((Integer) aux[0]);
				p.setNome((String) aux[1]);
				p.setDescricao((String) aux[2]);
				p.setCpfResponsavel((String) aux[3]);
				p.setDataIni((String) aux[4]);
				p.setDataFim((String) aux[5]);
				p.setHoraIni((String) aux[6]);
				p.setHoraFim((String) aux[7]);	
				p.setStatus((String)aux[8]);
				p.setIdentificacao((String)aux[9]);
				
				int idResp=	(int) aux[10];
				Pessoa pe = new Pessoa();
				pe = pe.localizarPessoa(idResp);// PEGA O CPF DO RESPOSAVEL
			
				ResponsavelProjeto rp = new ResponsavelProjeto();
				rp.setCpfResponsavel(pe.getCpf());
				rp.setIdentProjeto(p.getIdentificacao());
				
				p.setResponsavelProjeto(rp);
			
				System.out.println("ID: "+p.getId()+"| PROJETO: " + p.getNome()+"DESCRICAO: "+p.getDescricao()+"| RESPONSAVEL: "+p.getCpfResponsavel());
				lista.add(p);
			}
			if(lista.isEmpty() || lista==null) {
				msg = "Não achei o projeto.";
				p.setMsg(msg);
				lista.add(p);
				return lista;
			}else {
				return lista;
				
			}
		
		}catch(HibernateException e) {
			msg="ModUpdate, Err 102: "+e.toString();
			System.out.println(msg);
			return null;
		}
	}
	
	//UPDATE E DELETE PRECISA PEGAR ID
	//PARTE DA PREMISSA QUE O OBJETO JA TEM O ID DENTRO DELE
	//***********************************************ALTERAR TUDO DEPOIS DE FAZER UMA IDENTIFICAÇÃO DO PROJETO***************************************************************************************
	public boolean modelUpdateProjeto(Projeto p) {
		try {
			
			session = HibernateUtil.abrirSession();
			session.beginTransaction(); // mandafazer a persistencia dos dados
			session.saveOrUpdate(p); // executa a ação de salvar
			session.getTransaction().commit(); // confirma a transação de salvar
			session.close(); // fecha a conexão

			return true;
		} catch (HibernateException e) {
			msg = "ModUpdate, Err 102: " + e.toString();
			return false;
		}
	}

	public boolean modelUpdateProjetoNome(String nome,String cpf) {
		try {
			
			session = HibernateUtil.abrirSession();
			session.beginTransaction(); // mandafazer a persistencia dos dados
			Projeto p = new Projeto();
			int idPessoa = pegarIdPessoa(cpf);
			p.localizarProjeto(nome, idPessoa);
			p = session.get(Projeto.class,p.getId());
			p.setNome(nome);
			session.update(p); // executa a ação de salvar

			session.getTransaction().commit(); // confirma a transação de salvar

			session.close(); // fecha a conexão

			return true;
		} catch (HibernateException e) {
			msg = "ModUpdate, Err 102: " + e.toString();
			return false;
		}
	}
	public boolean modelUpdateProjetoDescricao(String descricao,String cpf) {
		try {
			
			session = HibernateUtil.abrirSession();
			session.beginTransaction(); // mandafazer a persistencia dos dados
			
			Projeto p = new Projeto();
			int idPessoa = pegarIdPessoa(cpf);
			//p.localizarProjeto(nome, idPessoa);
			p = session.get(Projeto.class,p.getId());
			p.setDescricao(descricao);
			
			session.update(p); // executa a ação de salvar

			session.getTransaction().commit(); // confirma a transação de salvar

			session.close(); // fecha a conexão

			return true;
		} catch (HibernateException e) {
			msg = "ModUpdate, Err 102: " + e.toString();
			return false;
		}
	}
	public boolean modelUpdateProjetoResponsavel(String nomeResponsavel,String cpf) {
		try {
			
			session = HibernateUtil.abrirSession();
			session.beginTransaction(); // mandafazer a persistencia dos dados
			Projeto p = new Projeto();
			int idPessoa = pegarIdPessoa(cpf);
			
			p.localizarProjeto(nomeResponsavel, idPessoa);
			p = session.get(Projeto.class,p.getId());
			p.setCpfResponsavel(nomeResponsavel);
			
			session.update(p); // executa a ação de salvar

			session.getTransaction().commit(); // confirma a transação de salvar

			session.close(); // fecha a conexão

			return true;
		} catch (HibernateException e) {
			msg = "ModUpdate, Err 102: " + e.toString();
			return false;
		}
	}	
	public boolean modelUpdateProjetoHoraIni(String horaIni,String cpf) {
		try {
			
			session = HibernateUtil.abrirSession();
			session.beginTransaction(); // mandafazer a persistencia dos dados
			Projeto p = new Projeto();
			int idPessoa = pegarIdPessoa(cpf);
			
			p.localizarProjeto(horaIni, idPessoa);
			p = session.get(Projeto.class,p.getId());
			p.setHoraIni(horaIni);
			
			session.update(p); // executa a ação de salvar

			session.getTransaction().commit(); // confirma a transação de salvar

			session.close(); // fecha a conexão

			return true;
		} catch (HibernateException e) {
			msg = "ModUpdate, Err 102: " + e.toString();
			return false;
		}
	}	
	public boolean modelUpdateProjetoHoraFim(String horaFim,String cpf) {
		try {
			
			session = HibernateUtil.abrirSession();
			session.beginTransaction(); // mandafazer a persistencia dos dados
			Projeto p = new Projeto();
			int idPessoa = pegarIdPessoa(cpf);
			
			p.localizarProjeto(horaFim, idPessoa);
			p = session.get(Projeto.class,p.getId());
			p.setHoraFim(horaFim);
			
			session.update(p); // executa a ação de salvar

			session.getTransaction().commit(); // confirma a transação de salvar

			session.close(); // fecha a conexão

			return true;
		} catch (HibernateException e) {
			msg = "ModUpdate, Err 102: " + e.toString();
			return false;
		}
	}	
	public boolean modelUpdateProjetoDataIni(String dataIni,String cpf) {
		try {
			
			session = HibernateUtil.abrirSession();
			session.beginTransaction(); // mandafazer a persistencia dos dados
			Projeto p = new Projeto();
			int idPessoa = pegarIdPessoa(cpf);
			
			p.localizarProjeto(dataIni, idPessoa);
			p = session.get(Projeto.class,p.getId());
			p.setDataIni(dataIni);
			
			session.update(p); // executa a ação de salvar

			session.getTransaction().commit(); // confirma a transação de salvar

			session.close(); // fecha a conexão

			return true;
		} catch (HibernateException e) {
			msg = "ModUpdate, Err 102: " + e.toString();
			return false;
		}
	}	
	public boolean modelUpdateProjetoDataFim(String dataFim,String cpf) {
		try {
			
			session = HibernateUtil.abrirSession();
			session.beginTransaction(); // mandafazer a persistencia dos dados
			Projeto p = new Projeto();
			int idPessoa = pegarIdPessoa(cpf);
			
			p.localizarProjeto(dataFim, idPessoa);
			p = session.get(Projeto.class,p.getId());
			p.setDataFim(dataFim);
			
			session.update(p); // executa a ação de salvar

			session.getTransaction().commit(); // confirma a transação de salvar

			session.close(); // fecha a conexão

			return true;
		} catch (HibernateException e) {
			msg = "ModUpdate, Err 102: " + e.toString();
			return false;
		}
	}	
	public boolean modelUpdateProjetoStatus(String status,String cpf) {
		try {
			
			session = HibernateUtil.abrirSession();
			session.beginTransaction(); // mandafazer a persistencia dos dados
			Projeto p = new Projeto();
			int idPessoa = pegarIdPessoa(cpf);
			
			p.localizarProjeto(status, idPessoa);
			p = session.get(Projeto.class,p.getId());
			p.setStatus(status);
			
			session.update(p); // executa a ação de salvar

			session.getTransaction().commit(); // confirma a transação de salvar

			session.close(); // fecha a conexão

			return true;
		} catch (HibernateException e) {
			msg = "ModUpdate, Err 102: " + e.toString();
			return false;
		}
	}	
	public boolean modelUpdateProjetoIdResponsavel(ResponsavelProjeto responsavelProjeto,String cpf) {
		try {
			
			session = HibernateUtil.abrirSession();
			session.beginTransaction(); // mandafazer a persistencia dos dados
			Projeto p = new Projeto();
			int idPessoa = pegarIdPessoa(cpf);
			
		//	p.localizarProjeto(responsavelProjeto, idPessoa);
			p = session.get(Projeto.class,p.getId());
			p.setResponsavelProjeto(responsavelProjeto);
			
			session.update(p); // executa a ação de salvar

			session.getTransaction().commit(); // confirma a transação de salvar

			session.close(); // fecha a conexão

			return true;
		} catch (HibernateException e) {
			msg = "ModUpdate, Err 102: " + e.toString();
			return false;
		}
	}	
	
	
	//DELETAR	
	public boolean modelDeleteProjeto(int id) {
		try {

			session = HibernateUtil.abrirSession();
			session.beginTransaction(); // mandafazer a persistencia dos dados
			Projeto p = new Projeto();
			p.setId(id);
			session.delete(p); // executa a ação de salvar

			session.getTransaction().commit(); // confirma a transação de salvar

			session.close(); // fecha a conexão

			return true;
		} catch (HibernateException e) {
			msg = "ModDelete, Err 102: " + e.toString();
			return false;
		}
	}
	
	//PEGAR TODOS PROJETOS DO ID
	public List<Projeto> modelPegarProjetos(int idResponsavel ) {
		try {
			Session session = HibernateUtil.abrirSession();
			session.beginTransaction();

				Criteria cri = session.createCriteria(Projeto.class);
				cri.add(Restrictions.eq("id_responsavel_projeto",idResponsavel));
			
				//cri.setFirstResult(1).setMaxResults(1);

				List<Projeto> lista = cri.list();
					if(lista.isEmpty()) {
						return null;
					}else {
						return lista;
					}
					
		}catch(HibernateException e) {
			return null;
		}
	}
		
}
