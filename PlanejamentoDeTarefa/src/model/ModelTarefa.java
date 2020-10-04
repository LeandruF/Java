package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import controller.Equipe;
import controller.ResponsavelProjeto;
import controller.ResponsavelTarefa;
import controller.Tarefa;

public class ModelTarefa {
	Session session;
	Connection conn;
	String msg;

	public ModelTarefa() {}
	
	//*********************************************TESTAR****************************
	public List<Tarefa> modelLocalizarTarefa(String nome,int idResp) {
		try {
			session = HibernateUtil.abrirSession();
			session.beginTransaction();
			String sql = "SELECT id, nome, descricao, data_ini, data_fim, hora_ini, hora_fim, status FROM tarefas WHERE nome= :nome AND responsavel = :id_responsavel_tarefa";
			//SELECT id, nome, descricao, data_ini, data_fim, hora_ini, hora_fim, responsavel, status FROM projetos WHERE nome= "Cotidiano" AND responsavel = "Leandro"
			//id,nome,descricao,responsavel,data_ini,data_fim,hora_ini,hora_fim,status
			Query query = session.createQuery(sql);
			
			query.setParameter("nome",nome);
			query.setParameter("id_responsavel_tarefa", idResp);
			//query.setParameter("responsavel",nomeResp);
			
			List<Object[]> obj = query.getResultList();
			

			List<Tarefa> lista =  new ArrayList<Tarefa>();
			Tarefa t = new Tarefa();
			for (Object[] o : obj) {
				Object[] aux = o;
				System.out.println("ENTROU");
				t.setId((Integer) aux[0]);
				t.setNome((String) aux[1]);
				t.setDescricao((String) aux[2]);
				
				t.setDataIni((String) aux[3]);
				t.setDataFim((String) aux[4]);
				t.setHoraIni((String) aux[5]);
				t.setHoraFim((String) aux[6]);
			
				t.setStatus((String)aux[7]);
			
				System.out.println("ID: "+t.getId()+"| TAREFA: " + t.getNome()+"DESCRICAO: "+t.getDescricao());
				lista.add(t);
			}
			if(lista.isEmpty() || lista==null) {
				msg = "Não achei a Tarefa.";
				t.setMsg(msg);
				lista.add(t);
				session.close();
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
	//*********************************************TESTAR****************************
	public List<Tarefa> modelListarTarefa(String nome) {
			try {
				session = HibernateUtil.abrirSession();
				session.beginTransaction();
				String sql = "SELECT id, nome, descricao, data_ini, data_fim, hora_ini, hora_fim, status FROM tarefas WHERE nome= :nome";
				//SELECT id, nome, descricao, data_ini, data_fim, hora_ini, hora_fim, responsavel, status FROM projetos WHERE nome= "Cotidiano" AND responsavel = "Leandro"
				//id,nome,descricao,responsavel,data_ini,data_fim,hora_ini,hora_fim,status
				Query query = session.createQuery(sql);
				
				query.setParameter("nome",nome);
				//query.setParameter("responsavel",nomeResp);
				
				List<Object[]> obj = query.getResultList();
				

				List<Tarefa> lista =  new ArrayList<Tarefa>();
				Tarefa t = new Tarefa();
				for (Object[] o : obj) {
					Object[] aux = o;
					System.out.println("ENTROU");
					t.setId((Integer) aux[0]);
					t.setNome((String) aux[1]);
					t.setDescricao((String) aux[2]);
					
					t.setDataIni((String) aux[3]);
					t.setDataFim((String) aux[4]);
					t.setHoraIni((String) aux[5]);
					t.setHoraFim((String) aux[6]);
				
					t.setStatus((String)aux[7]);
				
					System.out.println("ID: "+t.getId()+"| TAREFA: " + t.getNome()+"DESCRICAO: "+t.getDescricao());
					lista.add(t);
					session.close();
				}
				if(lista.isEmpty() || lista==null) {
					msg = "Não achei a Tarefa.";
					t.setMsg(msg);
					lista.add(t);
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
	
	public ArrayList<Equipe> listarEquipes(String nome) { // EXIBE AS OPÇÕES DE EQUIPE PRA PEGAR O ID DELA NA VIEW E
															// DEPOIS CADASTRAR
		ArrayList<Equipe> lista = new ArrayList<Equipe>();
		try {
			if (conn != null || conn.isClosed()) {
				String sql = "SELECT id,nome FROM tarefa WHERE nome =?;";
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1, nome);
				ResultSet rs = st.executeQuery();

				while (rs.next()) {

					Equipe e = new Equipe();

					e.setId(rs.getInt("id"));
					e.setNome(rs.getString("nome"));

					lista.add(e);

				}
				session.close();
				return lista;
			} else {
				msg = "DEU RUIM!";
				return null;
			}
		} catch (SQLException e) {
			msg = "Erro: " + e.toString();
			return null;
		}
	}

	// Cadastrar
	public boolean modelCadastrarTarefa(Tarefa t) {
		try {
			session = HibernateUtil.abrirSession();
			session.beginTransaction();
			session.save(t);
			session.getTransaction().commit();

			
			//session.beginTransaction();
			return true;
		
		} catch (HibernateException e) {
			msg = "ModelCadastrarTarefa Error: " + e.toString();
			System.out.println(msg);
			return false;
		}

	}
	//LOCALIZAR
	//*****************************VERIFICAR************************
	public Tarefa modeLocalizarTarefa( int idTarefa){		
			try {
			session = HibernateUtil.abrirSession();
			session.beginTransaction();
				Tarefa t = new Tarefa();
				t = session.find(Tarefa.class, idTarefa);
				session.getTransaction().commit();
				session.close();
					
				return t; //ALTERAR
			
		}catch(HibernateException e) {
			System.out.println("ERRO modelPegarTarefas:"+e.toString());
			return null;
		}
		catch(Exception e1) {
			System.out.println("ERRO GERAL: "+e1.toString());
			return null;
		}
		
	}
	
	public List<Tarefa> modeLocalizarTarefa(String nome) {
		try {
		System.out.println("passa aqui ?");
			session = HibernateUtil.abrirSession();
			session.beginTransaction();
			String sql = "SELECT id FROM tarefa WHERE = :%nome%";
			Query query = session.createQuery(sql);
			
			query.setParameter("nome",nome);
			
			List<Tarefa> lista =  query.getResultList();
			session.getTransaction().commit();
			session.close();
			for(Tarefa t:lista) {
				System.out.println(t.getId());
				System.out.println(t.getNome());
				System.out.println(t.getDescricao());
			}
			return lista;
			/*
			if(lista==null || lista.isEmpty()) {
				System.out.println("NAO PEGOU NADA");
				return null;
			}else {
				lista.get(0).getCpf();
				lista.get(0).getId();
				System.out.println(" CPF: "+lista.get(0).getCpf()+" | Recebeu o ID:"+lista.get(0).getId()+" ");
				return lista;
				
			}*/
		}catch(HibernateException e) {
			msg="ModUpdate, Err 102: "+e.toString();
			System.out.println(msg);
			return null;
		}
	}
	//UPDATE E DELETE PRECISA PEGAR ID
	//PARTE DA PREMISSA QUE O OBJETO JA TEM O ID DENTRO DELE
	//*********************************************VERIFICAR TUDOOOOOOOOOOOOOOOOO**************************************************************
	public boolean modelUpdateTarefa(Tarefa t) {
			try {		
				session = HibernateUtil.abrirSession();
				session.beginTransaction(); // mandafazer a persistencia dos dados
				session.saveOrUpdate(t); // executa a ação de salvar
				session.getTransaction().commit(); // confirma a transação de salvar
				session.close(); // fecha a conexão

				return true;
			} catch (HibernateException e) {
				msg = "ModUpdate, Err 102: " + e.toString();
				return false;
			}
		}
	
	public boolean modelUpdateTarefaNome(String nome,String cpf) {
		try {
			
			session = HibernateUtil.abrirSession();
			session.beginTransaction(); // mandafazer a persistencia dos dados
			Tarefa t = new Tarefa();
			//int idPessoa = pegarIdPessoa(cpf);
			//t.localizarProjeto(nome, idPessoa);
			t = session.get(Tarefa.class,t.getId());
			t.setNome(nome);
			session.update(t); // executa a ação de salvar

			session.getTransaction().commit(); // confirma a transação de salvar

			session.close(); // fecha a conexão

			return true;
		} catch (HibernateException e) {
			msg = "ModUpdate, Err 102: " + e.toString();
			return false;
		}
	}
	public boolean modelUpdateTarefaDescricao(String descricao,String cpf) {
		try {
			
			session = HibernateUtil.abrirSession();
			session.beginTransaction(); // mandafazer a persistencia dos dados
			
			Tarefa t = new Tarefa();
		//	int idPessoa = pegarIdPessoa(cpf);
			//t.localizarProjeto(nome, idPessoa);
			t = session.get(Tarefa.class,t.getId());
			t.setDescricao(descricao);
			
			session.update(t); // executa a ação de salvar

			session.getTransaction().commit(); // confirma a transação de salvar

			session.close(); // fecha a conexão

			return true;
		} catch (HibernateException e) {
			msg = "ModUpdate, Err 102: " + e.toString();
			return false;
		}
	}
	public boolean modelUpdateTarefaResponsavel(String nomeResponsavel,String cpf) {
		try {
			
			session = HibernateUtil.abrirSession();
			session.beginTransaction(); // mandafazer a persistencia dos dados
			Tarefa t = new Tarefa();
			//int idPessoa = pegarIdPessoa(cpf);
			
			//t.localizarProjeto(nomeResponsavel, idPessoa);
			t = session.get(Tarefa.class,t.getId());
			//t.setResponsavel(nomeResponsavel);
			
			session.update(t); // executa a ação de salvar

			session.getTransaction().commit(); // confirma a transação de salvar

			session.close(); // fecha a conexão

			return true;
		} catch (HibernateException e) {
			msg = "ModUpdate, Err 102: " + e.toString();
			return false;
		}
	}	
	public boolean modelUpdateTarefaHoraIni(String horaIni,String cpf) {
		try {
			
			session = HibernateUtil.abrirSession();
			session.beginTransaction(); // mandafazer a persistencia dos dados
			Tarefa t = new Tarefa();
		//	int idPessoa = pegarIdPessoa(cpf);
			
			//t.localizarProjeto(horaIni, idPessoa);
			t = session.get(Tarefa.class,t.getId());
			t.setHoraIni(horaIni);
			
			session.update(t); // executa a ação de salvar

			session.getTransaction().commit(); // confirma a transação de salvar

			session.close(); // fecha a conexão

			return true;
		} catch (HibernateException e) {
			msg = "ModUpdate, Err 102: " + e.toString();
			return false;
		}
	}	
	public boolean modelUpdateTarefaHoraFim(String horaFim,String cpf) {
		try {
			
			session = HibernateUtil.abrirSession();
			session.beginTransaction(); // mandafazer a persistencia dos dados
			Tarefa t = new Tarefa();
		//	int idPessoa = pegarIdPessoa(cpf);
			
		///	t.localizarProjeto(horaFim, idPessoa);
			t = session.get(Tarefa.class,t.getId());
			t.setHoraFim(horaFim);
			
			session.update(t); // executa a ação de salvar

			session.getTransaction().commit(); // confirma a transação de salvar

			session.close(); // fecha a conexão

			return true;
		} catch (HibernateException e) {
			msg = "ModUpdate, Err 102: " + e.toString();
			return false;
		}
	}	
	public boolean modelUpdateTarefaDataIni(String dataIni,String cpf) {
		try {
			
			session = HibernateUtil.abrirSession();
			session.beginTransaction(); // mandafazer a persistencia dos dados
			Tarefa t = new Tarefa();
			//int idPessoa = pegarIdPessoa(cpf);
			
			//t.localizarProjeto(dataIni, idPessoa);
			t = session.get(Tarefa.class,t.getId());
			t.setDataIni(dataIni);
			
			session.update(t); // executa a ação de salvar

			session.getTransaction().commit(); // confirma a transação de salvar

			session.close(); // fecha a conexão

			return true;
		} catch (HibernateException e) {
			msg = "ModUpdate, Err 102: " + e.toString();
			return false;
		}
	}	
	public boolean modelUpdateTarefaDataFim(String dataFim,String cpf) {
		try {
			
			session = HibernateUtil.abrirSession();
			session.beginTransaction(); // mandafazer a persistencia dos dados
			Tarefa t = new Tarefa();
		//	int idPessoa = pegarIdPessoa(cpf);
			
			//t.localizarProjeto(dataFim, idPessoa);
			t = session.get(Tarefa.class,t.getId());
			t.setDataFim(dataFim);
			
			session.update(t); // executa a ação de salvar

			session.getTransaction().commit(); // confirma a transação de salvar

			session.close(); // fecha a conexão

			return true;
		} catch (HibernateException e) {
			msg = "ModUpdate, Err 102: " + e.toString();
			return false;
		}
	}	
	public boolean modelUpdateTarefaStatus(String status,String cpf) {
		try {
			
			session = HibernateUtil.abrirSession();
			session.beginTransaction(); // mandafazer a persistencia dos dados
			Tarefa t = new Tarefa();
			//int idPessoa = pegarIdPessoa(cpf);
			
			//t.localizarProjeto(status, idPessoa);
			t = session.get(Tarefa.class,t.getId());
			t.setStatus(status);
			
			session.update(t); // executa a ação de salvar

			session.getTransaction().commit(); // confirma a transação de salvar

			session.close(); // fecha a conexão

			return true;
		} catch (HibernateException e) {
			msg = "ModUpdate, Err 102: " + e.toString();
			return false;
		}
	}	
	public boolean modelUpdateTarefaIdResponsavel(ResponsavelProjeto responsavelProjeto,String cpf) {
		try {
			
			session = HibernateUtil.abrirSession();
			session.beginTransaction(); // mandafazer a persistencia dos dados
			Tarefa t = new Tarefa();
			//int idPessoa = pegarIdPessoa(cpf);
			
		//	p.localizarProjeto(responsavelProjeto, idPessoa);
			t = session.get(Tarefa.class,t.getId());
	//		t.setResponsavelProjeto(responsavelProjeto);
			
			session.update(t); // executa a ação de salvar

			session.getTransaction().commit(); // confirma a transação de salvar

			session.close(); // fecha a conexão

			return true;
		} catch (HibernateException e) {
			msg = "ModUpdate, Err 102: " + e.toString();
			return false;
		}
	}	
	public boolean modelUpdateTarefaListaPessoas(String listaPessoas,String cpf) {
		try {
			
			session = HibernateUtil.abrirSession();
			session.beginTransaction(); // mandafazer a persistencia dos dados
			Tarefa t = new Tarefa();
			//int idPessoa = pegarIdPessoa(cpf);
			
				//	p.localizarProjeto(responsavelProjeto, idPessoa);
			t = session.get(Tarefa.class,t.getId());
			//		t.setResponsavelProjeto(responsavelProjeto);
			
			session.update(t); // executa a ação de salvar

			session.getTransaction().commit(); // confirma a transação de salvar

			session.close(); // fecha a conexão

			return true;
		} catch (HibernateException e) {
			msg = "ModUpdate, Err 102: " + e.toString();
			return false;
		}
	}	
	
	//DELETAR
	public boolean modelDeleteTarefa(int id) {
		try {

			session = HibernateUtil.abrirSession();
			session.beginTransaction(); // mandafazer a persistencia dos dados
			Tarefa t = new Tarefa();
			t.setId(id);
			session.delete(t); // executa a ação de salvar

			session.getTransaction().commit(); // confirma a transação de salvar

			session.close(); // fecha a conexão

			return true;
		} catch (HibernateException e) {
			msg = "ModDelete, Err 102: " + e.toString();
			return false;
		}
	}
	public Equipe pegarIdEquipe(String nome) {
		try {
			Session session = HibernateUtil.abrirSession();
			session.beginTransaction();
			String sql = "SELECT id FROM equipes WHERE nome = :nome";

			Query query = session.createSQLQuery(sql);
			query.setParameter("nome", nome);
			try {
				int id = (int) query.getSingleResult();
								
				Equipe e = new Equipe();
				e = session.find(Equipe.class, id);
				session.getTransaction().commit();
				session.close();
				return e;
			} catch (NoResultException e) { // SE NAO ACHAR NINGUEM CAI NESSE EXCEPTION
				msg = "Não achei essa equipe.";
				System.out.println(msg);
				return null;
			}
			
		} catch (HibernateException e) {
			msg = "SQL Problem, Err 103: " + e.toString();
			System.out.println(msg);
			return null;
		}

	}

	//PEGAR NA TABELA RESPONSAVEL_TAREFA : ID | ID_RESPONSAVEL | ID_TAREFA
	public List<ResponsavelTarefa> modelPegarResponsavelTarefa(int idResponsavel) {
		try {
			Session session = HibernateUtil.abrirSession();
			session.beginTransaction();

				Criteria cri = session.createCriteria(ResponsavelTarefa.class);
				cri.add(Restrictions.eq("id_responsavel", idResponsavel));
				List<ResponsavelTarefa> lista = cri.list();
				if(lista!=null) {
					for(ResponsavelTarefa rt : lista) {
						rt.getId();
						rt.getCpfResponsavel();
						rt.getIdentTarefa();
						System.out.println(rt.getId());
						System.out.println(rt.getCpfResponsavel());
						System.out.println(rt.getIdentTarefa());
						lista.add(rt);
					}
					session.close();
					return lista;
				}else {
					System.out.println("erro");
					return null;
				}

		}catch(HibernateException e) {
			System.out.println("EXCEPTION: "+e.toString());
			return null;
		}
	}
	
	public List<Tarefa> modelPegarTarefas(int idPessoa,int idEquipe){
		try {
			Session session = HibernateUtil.abrirSession();
			session.beginTransaction();
			String sql = "SELECT id,identificacao,nome,descricao,data_ini,data_fim,hora_ini,hora_fim,status,id_projeto,id_responsavel_tarefa FROM tarefas WHERE id_equipe = :idEquipe ";

			Query query = session.createSQLQuery(sql);
			  query.setParameter("idEquipe", idEquipe);
			//query.setParameter("password", password);

			// List<Pessoa> lista = (List<Pessoa>)query.list();
			// System.out.println(lista.size());

			List<Object[]> obj = query.getResultList();
			// Pessoa p = (Pessoa) query.getResultList();
			// List<Pessoa> lista = query.list();

			// Aqui vai ser manipulado o objs.
			// Cria suaLiistaModel
			List<Tarefa> lista = new ArrayList<Tarefa>();

			for (Object[] o : obj) {
				Object[] aux = o;
				Tarefa t = new Tarefa();
				// Objeto que sualistaModel recebe, vamos chamar de x
				t.setId((Integer) aux[0]);
				t.setIdentificacao((String) aux[1]);
				t.setNome((String) aux[2]);
				t.setDescricao((String) aux[3]);
				t.setDataIni((String) aux[4]);
				t.setDataFim((String) aux[5]);
				t.setHoraIni((String) aux[6]);
				t.setHoraFim((String) aux[7]);
				t.setStatus((String) aux[8]);
				System.out.println(t.getIdentificacao()+" | "+ t.getNome()+" | "+ t.getDescricao());
				
				
				lista.add(t);
			
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

}
