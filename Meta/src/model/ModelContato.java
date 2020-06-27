package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.Contato;



public class ModelContato {
	public String msg = "";
	Connection conn;
//Conecta ao BD / CRIA TABELA CONTATO SE NÃO TIVER
	public ModelContato() {
	try {

		String driver = "com.mysql.jdbc.Driver";

		Class.forName(driver);

		String url = "jdbc:mysql://localhost:3306/";

		String user = "root";
		String password = "";

		conn = DriverManager.getConnection(url, user, password);
		
		//CRIA O DATABASE SE NAO TIVER
		String sql = "CREATE DATABASE IF NOT EXISTS meta_web_api;";
		PreparedStatement st = conn.prepareStatement(sql);
		st.execute();

		//SELECIONA O BD
		String use = "USE meta_web_api;";
		st = conn.prepareStatement(use);
		st.execute();

		// cria tabela CONTATO				
		//CPF 14 character caso use mascara xxx.xxx.xxx-xx
		//CELL 14 character caso use mascara (xx)xxxx-xxxxx
		//IDT 12 character caso use mascara (xx.xxx.xxx-x)
		String tabelaPaciente = "CREATE TABLE IF NOT EXISTS contato(id int PRIMARY KEY AUTO_INCREMENT,nome VARCHAR(100) NOT NULL,cpf VARCHAR(14)UNIQUE,idt VARCHAR(12) UNIQUE, valor_canal int UNIQUE,cell VARCHAR(14) NOT NULL,email VARCHAR(100) NOT NULL);";
		st = conn.prepareStatement(tabelaPaciente);
		st.execute();

	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}

	//FECHAR CONN
	private boolean fecharConn() {
		try {
			if (conn != null || conn.isClosed()) {
				conn.close();
				return true;
			} else {
				msg = "Conexão já está fechada.";
				return false;
			}

		} catch (SQLException e) {
			msg= "Erro fecharConn: "+e.toString();
			
			return false ;
		}
	}	
	//Cadastrar contato
	public boolean mCadastrar(Contato c) {
		try {
			String sql = "INSERT INTO contato (nome,cpf,idt,email,cell,valor_canal) VALUES (?,?,?,?,?,?);";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, c.getNome());
			st.setString(2, c.getCpf());
			st.setString(3, c.getIdt());
			st.setString(4, c.getEmail());
			st.setString(5, c.getCell());
			st.setInt(6, c.getValorCanal());
			
			int i = st.executeUpdate();
			
			fecharConn();
			if (i == 1) {
				msg = "Contato: " + c.getNome() + " Cadastrado com sucesso!";
				return true;
			} else {
				msg = "Foi cadastrado: " + i + " Contato(s).";
				return false;
			}
		}catch(SQLException e) {
			msg = "Erro mCadastrar: "+e.toString();
			return false;
		}
	}
	
	//Localiza todos os Contatos que tenham aquele %nome%.
	public List<Contato> mLocalizarNome(String nome) {
		try {
			if (conn != null || !conn.isClosed()) {
				
				String sql = "SELECT id,nome,cpf,idt,cell,email,valor_canal FROM contato WHERE nome LIKE ?;";
				
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1, "%%" + nome + "%%");
				ResultSet rs = st.executeQuery();
				List<Contato> listaNomes = new ArrayList<Contato>();

				while (rs.next()) {
					Contato c = new Contato();
					c.setId(rs.getInt("id"));
					c.setNome(rs.getString("nome"));
					c.setCpf(rs.getString("cpf"));
					c.setIdt(rs.getString("idt"));
					c.setCell(rs.getString("cell"));
					c.setEmail(rs.getString("email"));
					c.setValorCanal(rs.getInt("valor_canal"));
					
					listaNomes.add(c);
				}
				return listaNomes;

			} else {
				msg = "Conexão is closed.";
				return null;
			}
		} catch (SQLException e) {
			msg = "Erro mLocalizarMPacienteNome: " + e.toString();
			return null;
		}
	}

	//Localizar atraves do Cpf
	//Localiza todos os Contatos que tenham aquele %nome%.
	public Contato mLocalizarCpf(String cpf) {
		try {
				String sql = "SELECT id,nome,cpf,idt,cell,email,valor_canal FROM contato WHERE cpf = ?;";
				
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1, cpf);
				ResultSet rs = st.executeQuery();
				
				if (rs.next()) {
					Contato c = new Contato();
					c.setId(rs.getInt("id"));
					c.setNome(rs.getString("nome"));
					c.setCpf(rs.getString("cpf"));
					c.setIdt(rs.getString("idt"));
					c.setCell(rs.getString("cell"));
					c.setEmail(rs.getString("email"));
					c.setValorCanal(rs.getInt("valor_canal"));	
					return c;
				}else {
					msg = "Não localizei esse contato.";
				
					return null;
				}

		} catch (SQLException e) {
			msg = "Erro mLocalizarCpf: " + e.toString();
			return null;
		}
	}
	
	//Verifica o id daquele cpf 
	// -1 resp negativa
	public int mVerificarCpf(String cpf) {
		try {
			String sql = "SELECT id FROM contato WHERE cpf = ?;";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,  cpf );
			ResultSet rs = st.executeQuery();
			int id;
			if(rs.next()) {
				id = rs.getInt("id");
				return id;
			}else {
				msg = "Não achei ninguem com esse cpf.";
				return -1;
			}
		}catch(SQLException e) {	
			msg = "Erro mVerificarCpf: "+toString();
			return -2;
		}
	}
	
	//Verifica o id daquela idt 
	// -1 resp negativa
	public int mVerificarIdt(String idt) {
		try {
			String sql = "SELECT id FROM contato WHERE idt = ?;";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,  idt );
			ResultSet rs = st.executeQuery();
			int id;
			if(rs.next()) {
				id = rs.getInt("id");
				return id;
			}else {
				msg = "Não achei ninguem com essa Idt.";
				return -1;
			}
		}catch(SQLException e) {	
			msg = "Erro mVerificarIdt: "+toString();
			return -1;
		}
	}
	
	//Deletar um contato colocando o cpf
	public boolean mDeletarContato(String cpf) {
		try {
	int id = mVerificarCpf(cpf);
		String sql = "DELETE FROM contato WHERE id = ?;";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, id);
		int i = st.executeUpdate();
		if(i == 1) {
			msg = "Contato deletado com sucesso!";
			fecharConn();
			return true;
		}else {
			msg = "Foram deletados "+i+" Contato(s).";
			fecharConn();
			return false;
		}
		
		}catch(SQLException e) {
			msg = "Erro mDeletarContato: "+e.toString();
			fecharConn();
			return false;
		}
	}
	
	//Update NOME
	public boolean mUpdateNome(String nome,String cpf) {
		try {
			int id = mVerificarCpf(cpf);
			String sql = "UPDATE contato SET nome = ? WHERE id =?;";
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, nome);
			st.setInt(2, id);

			int i = st.executeUpdate();
			if (i == 1) {
				msg = "Nome: " + nome + " Atualizado com sucesso.";
				fecharConn();
				return true;
			} else {
				msg = "Não foi atualizado o nome do contato.";
				fecharConn();
				return false;
			}
			
		}catch(SQLException e) {
			msg = "Erro mUpdateNome: "+ e.toString();
			fecharConn();
			return false;
		}
	}
	//Update CPF
	public boolean mUpdateCpf(String cpf,String idt) {
		try {
			//int id = mVerificarCpf(cpf); //VERIFICAR IDT
			String sql = "UPDATE contato SET cpf = ? WHERE idt =?;";
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, cpf);
			st.setString(2, idt);

			int i = st.executeUpdate();				
			if (i == 1) {
				msg = "Cpf: " + cpf + " Atualizado com sucesso.";
				fecharConn();
				return true;
			} else {
				msg = "Não foi atualizado o cpf do contato.";
				fecharConn();
				return false;
			}
			
			
		}catch(SQLException e) {
			msg = "Erro mUpdateCpf: "+ e.toString();
			fecharConn();
			return false;
		}
	}
	//Upadte IDT
	public boolean mUpdateIdt(String idt,String cpf) {
		try {
			int id = mVerificarCpf(cpf);
			String sql = "UPDATE contato SET idt = ? WHERE id =?;";
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, idt);
			st.setInt(2, id);

			int i = st.executeUpdate();
			if (i == 1) {
				msg = "Identidade: " + idt + " Atualizado com sucesso.";
				fecharConn();
				return true;
			} else {
				msg = "Não foi atualizado o identidade do contato.";
				fecharConn();
				return false;
			}
			
		}catch(SQLException e) {
			msg = "Erro mUpdateIdt: "+ e.toString();
			fecharConn();
			return false;
		}
	}
	//Update EMAIL
	public boolean mUpdateEmail(String email,String cpf) {
		try {
			int id = mVerificarCpf(cpf);
			String sql = "UPDATE contato SET email = ? WHERE id =?;";
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, email);
			st.setInt(2, id);

			int i = st.executeUpdate();
			if (i == 1) {
				msg = "Email: " + email + " Atualizado com sucesso.";
				fecharConn();
				return true;
			} else {
				msg = "Não foi atualizado o email do contato.";
				fecharConn();
				return false;
			}
			
		}catch(SQLException e) {
			msg = "Erro mUpdateEmail: "+ e.toString();
			fecharConn();
			return false;
		}
	}
	//Update CELL
	public boolean mUpdateCell(String cell,String cpf) {
		try {
			int id = mVerificarCpf(cpf);
			String sql = "UPDATE contato SET cell = ? WHERE id =?;";
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, cell);
			st.setInt(2, id);

			int i = st.executeUpdate();
			if (i == 1) {
				msg = "Cell: " + cell + " Atualizado com sucesso.";
				fecharConn();
				return true;
			} else {
				msg = "Não foi atualizado o cell do contato.";
				fecharConn();
				return false;
			}
			
		}catch(SQLException e) {
			msg = "Erro mUpdateCell: "+ e.toString();
			fecharConn();
			return false;
		}
	}
	//Update VALOR_CANAL
	public boolean mUpdateValorCanal(int valorCanal,String cpf) {
		try {
			int id = mVerificarCpf(cpf);
			String sql = "UPDATE contato SET valor_canal = ? WHERE id =?;";
			PreparedStatement st = conn.prepareStatement(sql);

			st.setInt(1, valorCanal);
			st.setInt(2, id);

			int i = st.executeUpdate();
			if (i == 1) {
				msg = "Valor Canal: " + valorCanal + " Atualizado com sucesso.";
				fecharConn();
				return true;
			} else {
				msg = "Não foi atualizado o valor canal do contato.";
				fecharConn();
				return false;
			}
			
		}catch(SQLException e) {
			msg = "Erro mUpdateValorCanal: "+ e.toString();
			fecharConn();
			return false;
		}
	}
	//Listar Registros 
	public List<Contato> mListarRegistro(){
		try {
			
		String sql = "SELECT id,nome,cpf,idt,email,cell,valor_canal FROM contato ORDER BY id";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		ArrayList<Contato> lista = new ArrayList<Contato>();
	
		while(rs.next()) {
			Contato c = new Contato();
			c.setId(rs.getInt("id"));
			c.setNome(rs.getString("nome"));
			c.setCpf(rs.getString("cpf"));
			c.setIdt(rs.getString("idt"));
			c.setEmail(rs.getString("email"));
			c.setCell(rs.getString("cell"));
			c.setValorCanal(rs.getInt("valor_canal"));
			lista.add(c);
			
		}
		fecharConn();
		return lista;
		}catch(SQLException e) {
			msg = "Erro mListaRegistro: "+e.toString();
			System.out.println(msg);
			return null;
		}
	}
	//Listar Registros Qtd
	public List<Contato> mListarRegistro( int qtd){
		try {		
			String sql = "SELECT id,nome,cpf,idt,email,cell,valor_canal FROM contato ORDER BY id";
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			ArrayList<Contato> lista = new ArrayList<Contato>();
		int cont = 0;
			while(rs.next()) {
				while(cont!=qtd) { // esta com um bug q se tiver menos registro ele repete o ultimo ate dar a quantidade desejada.
				Contato c = new Contato();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setCpf(rs.getString("cpf"));
				c.setIdt(rs.getString("idt"));
				c.setEmail(rs.getString("email"));
				c.setCell(rs.getString("cell"));
				c.setValorCanal(rs.getInt("valor_canal"));
				lista.add(c);
				cont++;
				}
			}
			return lista;
			}catch(SQLException e) {
				msg = "Erro mListaRegistro(num): "+e.toString();
				return null;
			}
		}
}
