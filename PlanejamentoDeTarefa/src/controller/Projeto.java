package controller;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import model.ModelProjeto;

//@SuppressWarnings("serial") // suprimindo aviso de código sem serial, nativo do java
@Entity(name = "projetos") // avisa ao hibernate para criar uma tabela chamada aluno no BD
@DynamicUpdate(value = true) // informada update dinamico. so exita o que foi alterado
@SelectBeforeUpdate(value = true) // verifica antes de atualizar,
@DynamicInsert(value = true)
public class Projeto extends VeriProjetoTarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column( length = 60) // redefine  tamanho o varchar
	private String nome;
	@Column( length = 60) // redefine  tamanho o varchar
	private String responsavel;
	@Column( length = 500) // redefine  tamanho o varchar
	private String descricao;
	@Column(name = "data_ini",length = 11)
	private String dataIni;
	@Column(name = "data_fim",length = 11)
	private String dataFim;
	@Column(name = "hora_ini",length = 5)
	private String horaIni;
	@Column(name = "hora_fim",length = 5)
	private String horaFim;
	@Column(name="identificacao", length =30, unique=true)// Concluido | Pendente | Trancado | Inicializado
	private String identificacao;
	@Column(name="status", length =12)// Concluido | Pendente | Trancado | Inicializado
	private String status;
	//ATIVO  | INATIVO | PAUSADO | CONCLUIDO | CANCELADO
	
	@OneToOne
	@JoinColumn(name = "id_responsavel_projeto", nullable = true,foreignKey = @ForeignKey(name ="fk_projeto_reponsavel_tarefa"))
	private ResponsavelProjeto responsavelProjeto; 
	
	@OneToMany (cascade = CascadeType.ALL)
	@JoinColumn(name = "id_projeto", nullable = true, foreignKey = @ForeignKey(name =
	"fk_projeto_tarefa"))
	private List<Tarefa> listaTarefas; 
	
	@Transient
	private String msg;
	//CADASTRAR PROJETO
	public boolean cadastrarProjeto() { 
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
	ModelProjeto mp = new ModelProjeto();
	mp.modelCadastrarProjeto(this);
	
	return valida;
	}else {
		msg = "ControlProjeto Err 110: Cadastro não efetuado";
		System.out.println(msg);
		return valida;
	}
}
	
	
	//DELETAR
	public boolean deletarProjeto(String nome,int id) {
		ModelProjeto mp = new ModelProjeto();
		boolean bool = mp.modelDeleteProjeto(this);
		
		return bool;
	}
	
	
	//LOCALIZAR PROJETO
	public void localizarProjeto(String nome, int idResponsavel) {
		ModelProjeto mp = new ModelProjeto();
		//int idPessoa= mp.pegarIdPessoa(responsavel);
		mp.modelLocalizarProjeto(nome,idResponsavel);
	}
	//LISTAR TODOS PROJETOS DA PESSOA RESPONSAVEL
	public void listarProjeto(String responsavel) {
		ModelProjeto mp = new ModelProjeto();
		mp.modelListarProjeto(responsavel);
	}
	
	//UPDATE
	public void updateNome(String nome,String cpf) {
		ModelProjeto mp = new ModelProjeto();
		mp.modelUpdateProjetoNome(nome,cpf);
	}
	public void updateResponsavel(String responsavel,String cpf) {
		ModelProjeto mp = new ModelProjeto();
		mp.modelUpdateProjetoResponsavel(responsavel,cpf);
	}
	public void updateDescricao(String descricao,String cpf) {
		ModelProjeto mp = new ModelProjeto();
		mp.modelUpdateProjetoDescricao(descricao,cpf);
	}
	public void updateDataIni(String dataIni,String cpf) {
		ModelProjeto mp = new ModelProjeto();
		mp.modelUpdateProjetoDataIni(dataIni,cpf);
	}
	public void updateDataFim(String dataFim,String cpf) {
		ModelProjeto mp = new ModelProjeto();
		mp.modelUpdateProjetoDataFim(dataFim,cpf);
	}
	public void updateHoraIni(String horaIni,String cpf) {
		ModelProjeto mp = new ModelProjeto();
		mp.modelUpdateProjetoHoraIni(horaIni,cpf);
	}
	public void updateHoraFim(String horaFim,String cpf) {
		ModelProjeto mp = new ModelProjeto();
		mp.modelUpdateProjetoHoraFim(horaFim,cpf);
	}
	public void updateStatus(String status,String cpf) {
		ModelProjeto mp = new ModelProjeto();
		mp.modelUpdateProjetoStatus(status,cpf);
	}
	
	
	public Projeto() {}
	//CONSTRUTOR ***SEM*** ID, id_responsavel, id_tarefa.
	public Projeto(String nome, String responsavel, String descricao, String dataIni, String dataFim,String horaIni, String horaFim,String status, String identificacao) {
		super();
		this.nome = nome;
		this.responsavel = responsavel;
		this.descricao = descricao;
		this.dataIni = dataIni;
		this.dataFim = dataFim;
		this.horaIni = horaIni;
		this.horaFim = horaFim;
		this.status = status;
		this.identificacao = identificacao;
	}
	public Projeto(String nome, String responsavel, String descricao, String dataIni, String dataFim,String horaIni, String horaFim,String status, String identificacao,ResponsavelProjeto responsavelProjeto) {
		super();
		this.nome = nome;
		this.responsavel = responsavel;
		this.descricao = descricao;
		this.dataIni = dataIni;
		this.dataFim = dataFim;
		this.horaIni = horaIni;
		this.horaFim = horaFim;
		this.status = status;
		this.identificacao = identificacao;
		this.responsavelProjeto = responsavelProjeto;
	}

	public Projeto(String nome, String responsavel, String descricao, String dataIni, String dataFim, String horaIni,
			String horaFim, String status, ResponsavelProjeto responsavelProjeto, List<Tarefa> listaTarefas, String identificacao) {
		super();
		this.nome = nome;
		this.responsavel = responsavel;
		this.descricao = descricao;
		this.dataIni = dataIni;
		this.dataFim = dataFim;
		this.horaIni = horaIni;
		this.horaFim = horaFim;
		this.status = status;
		this.responsavelProjeto = responsavelProjeto;
		this.listaTarefas = listaTarefas;
		this.identificacao = identificacao;
	}
	//CONSTRUTOR CHEIO
	public Projeto(int id, String nome, String responsavel, String descricao, String dataIni, String dataFim,String horaIni, String horaFim,
			ResponsavelProjeto responsavelProjeto, List<Tarefa> listaTarefas,String status, String identificacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.responsavel = responsavel;
		this.descricao = descricao;
		this.dataIni = dataIni;
		this.dataFim = dataFim;
		this.horaIni = horaIni;
		this.horaFim = horaFim;
		this.status = status;
		this.responsavelProjeto = responsavelProjeto;
		this.listaTarefas = listaTarefas;
		this.identificacao = identificacao;
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
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public List<Tarefa> getListaTarefas() {
		return listaTarefas;
	}
	public void setListaTarefas(List<Tarefa> listaTarefas) {
		this.listaTarefas = listaTarefas;
	}
	public ResponsavelProjeto getResponsavelProjeto() {
		return responsavelProjeto;
	}
	public void setResponsavelProjeto(ResponsavelProjeto responsavelProjeto) {
		this.responsavelProjeto = responsavelProjeto;
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
	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}
	
}
