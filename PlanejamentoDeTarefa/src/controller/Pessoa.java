package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import model.ModelPessoa;


//@SuppressWarnings("serial") // suprimindo aviso de código sem serial, nativo do java
 @Entity(name = "pessoas")
// avisa ao hibernate para criar uma tabela chamada pessoas no BD
@DynamicUpdate(value = true) // informada update dinamico. so exita o que foi alterado
@SelectBeforeUpdate(value = true) // verifica antes de atualizar,
@DynamicInsert(value = true)
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//Column =  Colunas com os atributos
	@Column( length = 14, unique =true) // redefine  tamanho o varchar
	private String cpf;
	@Column( length = 14)// redefine  tamanho o varchar
	private String cell;
	@Column(name = "nome_equipe", length = 30) // redefine o nome da coluna e o tamanho o varchar
	private String nomeEquipe;
	@Column
	private String nome, email, password;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "id_equipe", nullable = true)
	public Equipe equipes;
	
	
	//Não vai pra tabela
	@Transient
	private String msg;


	//VERIFICAÇÃO
	public boolean verificarNome(String nome) {
		nome.trim();
		if (nome.isEmpty() || nome.length() < 3) {
			msg = "Nome invalido.";
			return false;
		} else {
			return true;
		}
	}

	public boolean verificarCpf(String cpf) {
		cpf.trim();
		if (cpf.length() != 14) {
			msg = "Cpf invalido.";
			return false;

		} else {
			return true;
		}
	}
	public boolean existeCpf(String cpf) {
		ModelPessoa mp = new ModelPessoa();
		if(mp.modelExisteCpf(cpf)) {
			return true;			
		}else {
			return false;
		}
		
	}
	public boolean verificarCell(String cell) {
		cell.trim();
		if (cell.length() != 14) {
			msg = "Celular invalido.";
			return false;
		} else {
			return true;
		}
	}
	public boolean verificarEmail(String email) {
		int indiceEmail = email.indexOf('@'); // VERIFICA SE TEM @ | OBS:-1 = INVALIDO
		boolean validacao = false;
		if (!email.isEmpty()) {

			if (indiceEmail > 0) {
				if (indiceEmail > 0) {
					email = email.substring(0, indiceEmail);
					validacao = true;
				}
			} else {
				msg = "Email invalido.";
				
				validacao = false;
			}
		} else {
			msg = "Email em branco.";

			validacao = false;
		}
		return validacao;
	}
	public boolean verificarPassword(String password) {
		password.trim();
		boolean validacao = false;
		boolean up = false; // VAI SER TESTADO NA VERIFICAÇÃO DO CHARACTER MAIUSCULO
		boolean low = false;// VAI SER TESTADO NA VERIFICAÇÃO DO CHARACTER MINUSCULO

		if (!password.isEmpty()) {
			if (password.length() < 8) {
				msg = "Erro password precisa ter mais que 8 caracter.";

				validacao = false;
			} else {
				for (int i = 0; i < password.length(); i++) {
					if (Character.isUpperCase(password.charAt(i))) { // VERIFICA SE TEM 1 MAIUSCULO
						up = true;

					}
				}
		
				for (int j = 0; j < password.length(); j++) {
					if (Character.isLowerCase(password.charAt(j))) {// VERIFICA SE TEM 1 MINUSCULO
						low = true;
					}
				}
				
				
				if (up == true && low == true) { // SE MAIUSCULO E MINUSCULO == TRUE PARABENS
					validacao = true;
				} else {
					msg = "Senha precisa ter 1 Character Maiusculo e 1 Minusculo pelo menos.";
					validacao = false;
				}
			}
		} else {
			msg = "Senha em branco.";
			validacao = false;
		}
		return validacao;
	}

//CADASTRAR NOVA PESSOA
	public boolean cadastrarPessoa() {
		boolean valida = false;
		int cont = 0;
	
		valida = verificarNome(nome);
		if(valida) {
			cont++;
			System.out.println("Nome"+cont);
		}else {
			msg = "Nome em branco.";
		}
	
		valida = verificarCpf(cpf);
		if(valida) {
			
			cont++;
			System.out.println("cpf"+cont);
		}else {
			msg = msg+"\nCpf invalido.";
		}
		valida = existeCpf(cpf);
		if(valida) {
			cont++;
			System.out.println("CPF INEXISTENTE"+cont);
		}else {
			msg = msg+"\nCpf já existe.";
		}
	
		valida = verificarCell(cell);
		if(valida) {
		
			cont++;
			System.out.println("cell"+cont);
	
		}else {
			msg = msg+"\nCell invalido.";
		}
	
		email=email.toLowerCase();// FICA TUDO MINUSCULO
	
		valida = verificarEmail(email);
		if(valida) {
	
			cont++;
			System.out.println("email"+cont);
		}else {
			msg = msg+"\nEmail invalido.";
		}
	
		valida = verificarPassword(password);
		if(valida) {
			
			cont++;
			System.out.println("password"+cont);
		}else {
			msg = msg+"\nSenha precisa ter 1 pelo menos Maiusculo 1 Minusculo e 1 numero.";
		}
		
	if(nomeEquipe.isEmpty()) {
		nomeEquipe = "none";
		System.out.println("IMPRIMIU "+nomeEquipe);
	}
				
		if (cont== 6) {
			System.out.println("ENTRA ?");
			ModelPessoa mp = new ModelPessoa();
			mp.modelCadastrarPessoa(this);
			return true;

		} else {
	
			msg = "\nControlPess Err 110: Cadastro não efetuado" +msg;
			System.out.println(msg);
			return false;
			
		}
	}
//DELETAR PESSOA
	public boolean deletarPessoa(String cpf) {
		ModelPessoa mp = new ModelPessoa();
		boolean bool = mp.modelDeletePessoa(cpf);
		return bool;
		
	}
	//LISTAR PESSOAS
	public List<Pessoa>listarPessoa(){
		List<Pessoa> lista = new ArrayList<Pessoa>();
		ModelPessoa mp = new ModelPessoa();
		lista = mp.modelListarPessoas();
		return lista;
	}
	//LOCALIZAR
	public Pessoa localizarPessoa(String cpf) {
		
		ModelPessoa mp = new ModelPessoa();
		Pessoa p = mp.localizarPessoa(cpf);
		if(p!=null) {
			return p;
			
		}else {
			msg = "Não achei a pessoa do cpf: "+cpf;
				return null;
		}
	}
	public Pessoa localizarPessoa(int id) {
		ModelPessoa mp = new ModelPessoa();
		Pessoa p = mp.pegarPessoa(id);
		if(p!=null) {
			return p;
			
		}else {
			msg = "Não achei a pessoa do cpf: "+cpf;
				return null;
		}
	}
	//UPDATE (VERIFICAÇÃO COM SENHA?? TALVEZ)
	public void updateNome(String nome,String cpf) {
		ModelPessoa mp = new ModelPessoa();
	
		mp.modelUpdatePessoaNome(nome,cpf);
	}
	public void updateCpf(String cpf,String email) {
		ModelPessoa mp = new ModelPessoa();
		mp.modelUpdatePessoaCpf(cpf,email);
	}
	public void updateCell(String cell,String cpf) {
		ModelPessoa mp = new ModelPessoa();
		mp.modelUpdatePessoaCell(cell,cpf);
	}
	public void updateNomeEquipe(String nomeEquipe,String cpf) {
		ModelPessoa mp = new ModelPessoa();
		mp.modelUpdatePessoaNomeEquipe( nomeEquipe, cpf);
	}
	public void updateEmail(String email,String cpf) {
		ModelPessoa mp = new ModelPessoa();
		mp.modelUpdatePessoaEmail(email,cpf);
	}
	//PEDIR PARA CONFIRMAR SENHA 
	public void updatePassword(String password,String cpf) {
		ModelPessoa mp = new ModelPessoa();
		mp.modelUpdatePessoaPassword(password,cpf);
	}
	
	//LOGIN
	public boolean efetuarLogin(String email, String password) {
		this.email = email;
		this.password =password;
		ModelPessoa mp = new ModelPessoa();

	//	List <Pessoa> p  = mp.modelLoginPessoa(email, password);
		/*if (p!= null) {
			
			return true;
		} else {
			
			return false;
		}*/
		
		
		Pessoa p = mp.modelLoginPessoa2(this);
	
	if(p!=null) {
		this.id = p.getId();
		this.nome = p.getNome();
		this.cpf = p.getCpf();
		this.cell = p.getCell();
		this.email = p.getEmail();
		this.password = p.getPassword();
		this.nomeEquipe = p.getNomeEquipe();
		this.equipes = p.getEquipes();
		
		
		return true;
		}else {
			return false;
		}

	}
	
	public boolean fecharConn() {
		ModelPessoa mp = new ModelPessoa();
		mp.fecharConn();
		return true;
	}
	
	public Pessoa() {}

	public Pessoa(  String nome,String cpf, String cell, String nomeEquipe, String email, String password) {
		this.nome = nome;
		this.cpf = cpf;
		this.cell = cell;
		this.nomeEquipe = nomeEquipe;
		this.email = email;
		this.password = password;
	}

	

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	public String getNomeEquipe() {
		return nomeEquipe;
	}

	public void setNomeEquipe(String nomeEquipe) {
		this.nomeEquipe = nomeEquipe;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	public Equipe getEquipes() {
		return equipes;
	}

	
	public void setEquipes(Equipe equipes) {
		this.equipes = equipes;
	}


	
}
