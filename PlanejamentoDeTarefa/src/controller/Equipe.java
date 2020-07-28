package controller;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

//@SuppressWarnings("serial") // suprimindo aviso de código sem serial, nativo do java
@Entity(name = "equipes") // avisa ao hibernate para criar uma tabela chamada aluno no BD
@DynamicUpdate(value = true) // informada update dinamico. so exita o que foi alterado
@SelectBeforeUpdate(value = true) // verifica antes de atualizar,
@DynamicInsert(value = true)
public class Equipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column (unique = true)
	private String nome;

	@OneToMany
	@JoinColumn(name = "id_equipe", nullable = true,foreignKey = @ForeignKey(name =
			"fk_equipe_pessoa"))
	private List<Pessoa> listaPessoasEquipe; 

	
	
	public Equipe() {
	}

	public Equipe(String nome, List<Pessoa> listaPessoasEquipe) {
		super();
		this.nome = nome;
		this.listaPessoasEquipe = listaPessoasEquipe;
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

	public List<Pessoa> getListaPessoasEquipe() {
		return listaPessoasEquipe;
	}

	public void setListaPessoasEquipe(List<Pessoa> listaPessoasEquipe) {
		this.listaPessoasEquipe = listaPessoasEquipe;
	}



}
