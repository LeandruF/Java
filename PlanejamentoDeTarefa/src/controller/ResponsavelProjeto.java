package controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name = "responsavel_projeto") // avisa ao hibernate para criar uma tabela chamada aluno no BD
@DynamicUpdate(value = true) // informada update dinamico. so exita o que foi alterado
@SelectBeforeUpdate(value = true) // verifica antes de atualizar,
@DynamicInsert(value = true)
public class ResponsavelProjeto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "cpf_responsavel")
	private String cpfResponsavel;
	@Column(name = "ident_projeto")
	private String identProjeto;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getCpfResponsavel() {
		return cpfResponsavel;
	}

	public void setCpfResponsavel(String cpfResponsavel) {
		this.cpfResponsavel = cpfResponsavel;
	}

	public String getIdentProjeto() {
		return identProjeto;
	}

	public void setIdentProjeto(String identProjeto) {
		this.identProjeto = identProjeto;
	}
	public ResponsavelProjeto() {}
	public ResponsavelProjeto(String cpfResponsavel, String identProjeto) {
		super();
		this.cpfResponsavel = cpfResponsavel;
		this.identProjeto = identProjeto;
	}

	


	
	

	
	


	

	
}
