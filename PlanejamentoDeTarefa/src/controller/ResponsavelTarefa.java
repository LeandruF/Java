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
@Table(name = "responsavel_tarefa") // avisa ao hibernate para criar uma tabela chamada aluno no BD
@DynamicUpdate(value = true) // informada update dinamico. so exita o que foi alterado
@SelectBeforeUpdate(value = true) // verifica antes de atualizar,
@DynamicInsert(value = true)
public class ResponsavelTarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "cpf_responsavel")
	private String cpfResponsavel;
	@Column(name = "ident_Tarefa")
	private String identTarefa;
	
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

	public String getIdentTarefa() {
		return identTarefa;
	}

	public void setIdentTarefa(String identTarefa) {
		this.identTarefa = identTarefa;
	}
	public ResponsavelTarefa() {}
	public ResponsavelTarefa(String cpfResponsavel, String identTarefa) {
		super();
		this.cpfResponsavel = cpfResponsavel;
		this.identTarefa = identTarefa;
	}

	

}
