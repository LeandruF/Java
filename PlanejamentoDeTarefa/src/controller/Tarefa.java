package controller;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import model.ModelTarefa;

//@SuppressWarnings("serial") // suprimindo aviso de código sem serial, nativo do java
@Entity(name = "tarefas") // avisa ao hibernate para criar uma tabela chamada aluno no BD
@DynamicUpdate(value = true) // informada update dinamico. so exita o que foi alterado
@SelectBeforeUpdate(value = true) // verifica antes de atualizar,
@DynamicInsert(value = true)
public class Tarefa extends VeriProjetoTarefa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column( length = 60) // redefine  tamanho o varchar
	private String nome;
	@Column( length = 300) // redefine  tamanho o varchar
	private String descricao;
	@Column( length = 300,name="lista_Pessoas") // redefine  tamanho o varchar
	private String listaPessoas;
	@Column(name = "data_ini",length = 11)
	private String dataIni;
	@Column(name = "data_fim",length = 11)
	private String dataFim;
	@Column(name = "hora_ini",length = 5)
	private String horaIni;
	@Column(name = "hora_fim",length = 5)
	private String horaFim;
	@Column(name="status", length =12)// Concluido | Pendente | Trancado | Inicializado
	private String status;
	@Column(name="identificacao", length =30, unique=true)// Concluido | Pendente | Trancado | Inicializado
	private String identificacao;
	@OneToOne
	@JoinColumn(name = "id_responsavel_tarefa", nullable = true,foreignKey = @ForeignKey(name =
			"fk_tarefa_responsavel_tarefa"))
	private ResponsavelTarefa responsavelTarefa; 
	
	@ManyToOne
	@JoinColumn(name = "id_projeto", nullable = true)
	public Projeto projeto;
	
	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "id_equipe", nullable = true, foreignKey = @ForeignKey(name ="fk_tarefa_equipe"))
	private Equipe equipes;
	@Transient
	private String msg;
	
	
	//CADASTRAR
	public boolean cadastrarTarefa() { // REMOVER OS SYSTEM.OUT.PRINTLN
		// (nome,descricao,ini,fim,idEquipe,idPessoa)
	boolean valida = false;
	int cont = 0;
	valida = verificarNome(nome);
	if(valida) {
		System.out.println("Nome ok");
		cont++;
	}
	valida = verificarDescricao(descricao);
	if(valida) {
		System.out.println("Descricao ok");
		cont++;
	}
	valida = verificarDataIni(dataIni);
	if(valida) {
		System.out.println("Data Ini ok");
		cont++;
	}
	valida = verificarDataFim(dataFim);
	if(valida) {
		System.out.println("Data Fim ok");
		cont++;
	}
	valida = verificarHoraIni(horaIni);
	if(valida) {
		System.out.println("Hora Ini ok");
		cont++;
	}
	
	valida = verificarHoraFim(horaFim);
	if(valida) {
		System.out.println("Hora Fim ok");
		cont++;
	}
	if(cont == 6) {
	ModelTarefa mt = new ModelTarefa();
	mt.modelCadastrarTarefa(this);
	
	return valida;
	}else {
		msg = "ControlTarefa Err 110: Cadastro não efetuado";
		System.out.println(msg);
		return valida;
	}
}

	//DELETAR por nome + id ??
	public boolean deletarTarefa(String nome) {
		ModelTarefa mt = new ModelTarefa();
		boolean bool = mt.modelDeleteTarefa(this);
		
		return bool;
	}
	
	//LOCALIZAR	
	public void localizarTarefa() {
		ModelTarefa mt = new ModelTarefa();
		mt.modeLocalizarTarefa(nome);
	}
	
	
	//***********************************VERIFICAR TUDOOOOOOOOOOOO*-***********************
	String cpf=""; //APAGAR ISSO DEPOIS
	public void updateNome() {
		ModelTarefa mt = new ModelTarefa();
		mt.modelUpdateTarefaNome(nome,cpf);
	}
	public void updateDescricao() {
		ModelTarefa mt = new ModelTarefa();
		mt.modelUpdateTarefaDescricao(descricao,cpf);
	}
	public void updateListaPessoas() {
	ModelTarefa mt = new ModelTarefa();
	mt.modelUpdateTarefaListaPessoas(listaPessoas,cpf);
	}
	public void updateDataIni() {
		ModelTarefa mt = new ModelTarefa();
		mt.modelUpdateTarefaDataIni(dataIni,cpf);
	}
	public void updateDataFim() {
		ModelTarefa mt = new ModelTarefa();
		mt.modelUpdateTarefaDataFim(dataFim,cpf);
	}
	public void updateHoraIni() {
		ModelTarefa mt = new ModelTarefa();
		mt.modelUpdateTarefaHoraIni(horaIni,cpf);
	}
	public void updateHoraFim() {
		ModelTarefa mt = new ModelTarefa();
		mt.modelUpdateTarefaHoraFim(horaFim,cpf);
	}
public Tarefa() {
	
}


// CONSTRUTOR ***SEM*** ID, id_responsavel E id_projeto
public Tarefa(String nome, String listaPessoas, String descricao,String dataIni, String dataFim,String horaIni, String horaFim,String status,String identificacao) {
	super();
	this.nome = nome;
	this.descricao = descricao;
	this.listaPessoas = listaPessoas;
	this.dataIni = dataIni;
	this.dataFim = dataFim;
	this.horaIni = horaIni;
	this.horaFim = horaFim;
	this.status = status;
	this.identificacao = identificacao;
}
// CONSTRUTOR ***COM*** ID, id_responsavel E id_projeto
public Tarefa(int id, String nome, String descricao, String listaPessoas, String dataIni, String dataFim,
		String horaIni, String horaFim, ResponsavelTarefa responsavelTarefa, Projeto projeto, Equipe equipes,String status,String identificacao) {
	super();
	this.id = id;
	this.nome = nome;
	this.descricao = descricao;
	this.listaPessoas = listaPessoas;
	this.dataIni = dataIni;
	this.dataFim = dataFim;
	this.horaIni = horaIni;
	this.horaFim = horaFim;
	this.responsavelTarefa = responsavelTarefa;
	this.projeto = projeto;
	this.equipes = equipes;
	this.status = status;
	this.identificacao = identificacao;
}


public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
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


public String getDescricao() {
	return descricao;
}


public void setDescricao(String descricao) {
	this.descricao = descricao;
}


public String getIni() {
	return dataIni;
}


public void setIni(String ini) {
	this.dataIni = ini;
}


public String getFim() {
	return dataFim;
}


public void setFim(String fim) {
	this.dataFim = fim;
}

public String getListaPessoas() {
	return listaPessoas;
}
public void setListaPessoas(String listaPessoas) {
	this.listaPessoas = listaPessoas;
}
public String getDataIni() {
	return dataIni;
}
public void setDataIni(String dataIni) {
	this.dataIni = dataIni;
}
public String getDataFim() {
	return dataFim;
}
public void setDataFim(String dataFim) {
	this.dataFim = dataFim;
}
public ResponsavelTarefa getResponsavelTarefa() {
	return responsavelTarefa;
}
public void setResponsavelTarefa(ResponsavelTarefa responsavelTarefa) {
	this.responsavelTarefa = responsavelTarefa;
}
public Projeto getProjeto() {
	return projeto;
}
public void setProjeto(Projeto projeto) {
	this.projeto = projeto;
}
public Equipe getEquipes() {
	return equipes;
}
public void setEquipes(Equipe equipes) {
	this.equipes = equipes;
}
public String getHoraIni() {
	return horaIni;
}
public void setHoraIni(String horaIni) {
	this.horaIni = horaIni;
}
public String getHoraFim() {
	return horaFim;
}
public void setHoraFim(String horaFim) {
	this.horaFim = horaFim;
}

public String getIdentificacao() {
	return identificacao;
}

public void setIdentificacao(String identificacao) {
	this.identificacao = identificacao;
}



}
