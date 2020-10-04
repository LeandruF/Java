package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
public class Tarefa{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column( length = 60) // redefine  tamanho o varchar
	private String nome;
	@Column( length = 300) // redefine  tamanho o varchar
	private String descricao;
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
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_responsavel_tarefa", nullable = true,foreignKey = @ForeignKey(name =
			"fk_tarefa_responsavel_tarefa"))
	private ResponsavelTarefa responsavelTarefa; 
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_projeto", nullable = true)
	public Projeto projeto;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "id_equipe", nullable = true)
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
	}else {
	//	System.out.println("erro nome");
	}
	valida = verificarDescricao(descricao);
	if(valida) {
		System.out.println("Descricao ok");
		cont++;
	}else {
		//System.out.println("erro descricao");
	}
	valida = verificarDataIni(dataIni);
	if(valida) {
		System.out.println("Data Ini ok");
		cont++;
	}else {
		//System.out.println("erro dataini");
	}
	valida = verificarDataFim(dataFim);
	if(valida) {
		System.out.println("Data Fim ok");
		cont++;
	}else {
		//System.out.println("erro datafim");
	}
	valida = verificarHoraIni(horaIni);
	if(valida) {
		System.out.println("Hora Ini ok");
		cont++;
	}else {
		//System.out.println("erro horaini");
	}
	
	valida = verificarHoraFim(horaFim);
	
	if(valida) {
	System.out.println("Hora Fim ok");
		cont++;
	}else {
		//System.out.println("erro horafim");
	}
	if(status.isEmpty()) {
		//System.out.println("PREENCHER STATUS");
	}else {
		System.out.println("contou status");
		cont++;
	}
	if(identificacao.isEmpty()) {
		//System.out.println("PREENCHER IDENTIFICACAO");
	}else {
		System.out.println("identificacao contada");
		cont++;
	}
	System.out.println("CONTADOR"+ cont);
	//System.out.println("CONTADOR FINAL"+cont);
	if(cont == 8) {
		
	ModelTarefa mt = new ModelTarefa();
	mt.modelCadastrarTarefa(this);
	
	return true;
	}else {
		msg = "ControlTarefa Err 110: Cadastro não efetuado";
		System.out.println(msg);
		return valida;
	}
}

	//DELETAR por nome + id ??
	public boolean deletarTarefa(int id) {
		ModelTarefa mt = new ModelTarefa();
		boolean bool = mt.modelDeleteTarefa(id);
		
		return bool;
	}
	
	//LOCALIZAR	
	/*public void localizarTarefa() {
		ModelTarefa mt = new ModelTarefa();
		 mt.modeLocalizarTarefa(nome);
		
	}*/
	public Tarefa localizarTarefa(int id) {
		ModelTarefa mt = new ModelTarefa();
		Tarefa t = mt.modeLocalizarTarefa(id);
		if(t!=null) {
			System.out.println("---------------");
		System.out.println("CONTROLER");
		System.out.println("ID CONTROLER:"+t.getId());
		System.out.println("NOME CONTROLER:"+t.getNome());
		System.out.println("---------------");
		return t;
		}else {
			msg = "Err Control localizarTarefa";
			System.out.println(msg);
			return null;
		}
	}
	
	//***********************************VERIFICAR TUDOOOOOOOOOOOO*-***********************
	@Transient
	public boolean updateTarefa(Tarefa t) {
		ModelTarefa mt = new ModelTarefa();
		boolean bool = mt.modelUpdateTarefa(t);
		return bool;
	}
	String cpf=""; //APAGAR ISSO DEPOIS
	public void updateNome() {
		ModelTarefa mt = new ModelTarefa();
		mt.modelUpdateTarefaNome(nome,cpf);
	}
	public void updateDescricao() {
		ModelTarefa mt = new ModelTarefa();
		mt.modelUpdateTarefaDescricao(descricao,cpf);
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
	
	public List<Tarefa> pegarTodasTarefas(int idPessoa,int idEquipe) {
		ModelTarefa mt = new ModelTarefa();
		List<Tarefa> listaTarefas = mt.modelPegarTarefas(idPessoa,idEquipe);
		return listaTarefas;
	}
	
	
	
	

	public boolean verificarNome(String nome) {
		nome.trim();
		if (nome.isEmpty() || nome.length() < 3) {
			msg = "Nome invalido.";
			return false;
		} else {
			return true;
		}
	}
	public boolean verificarDescricao(String descricao) {
		descricao.trim();
		if (descricao.isEmpty() ) {
			msg = "Descrição invalido.";
			return false;
		} else {
			return true;
		}
	}
	public Equipe pegarIdEquipe(String nome) {
		ModelTarefa mt = new ModelTarefa();
		return  mt.pegarIdEquipe(nome);
	}
	public boolean verificarHoraIni(String horaIni) { //Verifica Somente a quantidade de caracter
		if(horaIni.length()==5) {		
			String[] hora  = horaIni.split(":");
			int hh = Integer.parseInt(hora[0]);
			int mm = Integer.parseInt(hora[1]);
			int cont = 0;
			if(hh<24 && hh>-1  ) {
				//System.out.println("A hora ok");
				cont++;
			}
			if(mm>=0 && mm<60) {
			//	System.out.println("Os min ok");
				cont++;
			}
			//System.out.println(cont);
			if(cont == 2) {
				//System.out.println(hh+":"+mm);
				return true;
			}else{
			
				//System.out.println("ERRO: "+hh+":"+mm);
				return false;
			}
			
		}else {
			return false;
		}
	}
	public boolean verificarHoraFim(String horaFim) { //Verifica Somente a quantidade de caracter
		if(horaFim.length()==5) {		
			String[] hora  = horaFim.split(":");
			int hh = Integer.parseInt(hora[0]);
			int mm = Integer.parseInt(hora[1]);
			int cont = 0;
			if(hh<24 && hh>-1  ) {
			//	System.out.println("A hora ok");
				cont++;
			}
			if(mm>=0 && mm<60) {
			//	System.out.println("Os min ok");
				cont++;
			}
			if(cont == 2) {
			//	System.out.println(hh+":"+mm);
				return true;
			}else{
				return false;
			}
			
		}else {
			return false;
		}
	}
	public boolean verificarDataIni(String dataIni) { //Verifica Somente a quantidade de caracter
		if(dataIni.length()==10) {		
			int cont = 0;
			 String[] data = dataIni.split("/");			 
				   int dia = Integer.parseInt(data[0]);
				   int mes = Integer.parseInt(data[1]);
				   int ano = Integer.parseInt(data[2]);
			 if(dia>0 && dia<32 ) {
				 cont++;
				 
				// System.out.println("DIA OK "+dia);
			 }
			 if(mes>0 && mes<13 ) {
				 cont++;
				// System.out.println("MES OK "+mes);
			 }
			 if(ano>=1899) {
				 cont++;
				// System.out.println("ANO OK "+ano);
			 }else {
				// System.out.println("ANO NÃO "+ano);
			 }
			 
			   
			   if(cont == 3) { // CONTADOR PARA SABER SE O DIA / MES / ANO  == true 
				   return true;
			   }else {
				   return false;
			   }
			}else {
				return false;
			}
	}
	public boolean verificarDataFim(String dataFim) { //Verifica Somente a quantidade de caracter
		if(dataFim.length()==10) {
			//System.out.println("ENTRA DATA FIM");
			int cont = 0;
			 String[] data = dataFim.split("/");
			 
				   int dia = Integer.parseInt(data[0]);
				   int mes = Integer.parseInt(data[1]);
				   int ano = Integer.parseInt(data[2]);
			 if(dia>0 && dia<32 ) {
				
				 //System.out.println("dia OK");
				 cont++;
				 


			 }else{
				// System.out.println("dia nao ok");
			 }
			 if(mes>0 && mes<13 ) {
				
				 //System.out.println("mes OK");
				 cont++;
			
			 }else {
				 //System.out.println("mes nao ok");

			 }
			 if(ano>=1900) {
				// System.out.println("ano OK");
				 cont++;
				
			 }else {
				 
				// System.out.println("ANO NÃO "+ano);
			 }
			 
			   
			   if(cont == 3) { // CONTADOR PARA SABER SE O DIA / MES / ANO  == true 
				//   System.out.println("foi");
				   return true;
			   }else {
				 //  System.out.println(" algum ERRO 1 ");
				   return false;
			   }
			}else {
				//System.out.println(" super ERRO 2 ");
				return false;
			}
	}

	/*Quanto tempo falta para terminar o projeto ou tarefa
	 * pega a data atual e subtrai a data prevista
	 * */
	//FALTA PEGAR A DATA FINAL NO BANCO DEDADOS E REMOVER A PASSAGEM DE PARAMETRO
	public int calcPrazo(String prazo) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 											
													 //15/07/2020 12:40:54
		Date data1 = new Date();
		
		String dia = dateFormat.format(data1).substring(0,2); // PEGA O DIA DO SISTEMA
		String mes = dateFormat.format(data1).substring(3,5); // PEGA O MES DO SISTEMA
		String ano = dateFormat.format(data1).substring(6,10); // PEGA O ANO DO SISTEMA
		
		
		String diaPra = prazo.substring(0,2); // DIA DO TERMINO (PRAZO)
		String mesPra = prazo.substring(3,5); // MES DO TERMINO
		String anoPra = prazo.substring(6,10); //ANO DO TERMINO

		Date data2 = new Date();
		
		Calendar c1 = Calendar.getInstance();
		
		//Pega a primeira data do sistema
		c1.set(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia)); //YYYY/MM/DD
		data1.setTime(c1.getTimeInMillis());
		
		//Pega a segunda data do prazo
		c1.set(Integer.parseInt(anoPra), Integer.parseInt(mesPra), Integer.parseInt(diaPra));//YYYY/MM/DD
		data2.setTime(c1.getTimeInMillis());
		
		// FAZ O CALCULO E RETORNA O NUMERO DE DIAS QUE FALTAM
		 long calc = (data2.getTime() - data1.getTime()) /1000/60/60/24; 
		 System.out.println("FALTAA: "+calc+" Dias");
		int faltaNumDias = (int)calc;
	
		return faltaNumDias;
		
	}
	//FALTA PEGAR A DATA FINAL NO BANCO DEDADOS E REMOVER A PASSAGEM DE PARAMETRO
	public void qtdTempComeca(String horaIni,int tempAviso) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 											
													//15/07/2020 12:40:54
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		Date date = new Date(); 
		
		String h = dateFormat.format(date).substring(11,13); // pega hora DO SISTEMA
		String m = dateFormat.format(date).substring(14,16); // pega o minuto DO SISTEMA
		
		
		    String hIni = horaIni.substring(0,2); // HORA PRA COMEÇAR
		    String mIni = horaIni.substring(3,5); // MINUTOS PARA COMEÇAR
		 
		    int hora = Integer.parseInt(hIni) - Integer.parseInt(h);
		    int min = Integer.parseInt(mIni) - Integer.parseInt(m);
		    if(hora <= 0) {
		    	
		     if(min>0) {
		    	System.out.println("Falta "+ min+" min.");
		    }else {
		    	if(min == 0) {
		    		System.out.println("STARTA LOGO ISSO!");
		    	}else {
		    		System.out.println("JA PASSOU "+min+"min.");
		    		
		    	}
		    }
		    }else if(hora<=tempAviso) {
		    	if(Integer.parseInt(mIni)<min) {
		    		min = Integer.parseInt(m) - Integer.parseInt(mIni);
		    		System.out.println("FALTA "+hora+":"+min);
		    	}else {
		    		String regex = "" + min;
		 		   regex = regex.replaceAll("[^0-9]", "");
		 		   int minCorri = Integer.parseInt(regex);
		 		   
		    		System.out.println("FALTAs "+hora+":"+minCorri);
		    	}
		    }else {
		    	System.out.println("Ainda falta muito");
		    }
}
	public void qtdTempTerminar(String horaFim,int tempAviso) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 											
													//15/07/2020 12:40:54
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		Date date = new Date(); 
		
		String h = dateFormat.format(date).substring(11,13); // pega hora DO SISTEMA
		String m = dateFormat.format(date).substring(14,16); // pega o minuto DO SISTEMA
		
		
		    String hFim = horaFim.substring(0,2); // HORA PRA COMEÇAR
		    String mFim = horaFim.substring(3,5); // MINUTOS PARA COMEÇAR
		 
		    int hora = Integer.parseInt(hFim) - Integer.parseInt(h);
		    int min = Integer.parseInt(mFim) - Integer.parseInt(m);
		    if(hora <= 0) {
		    	
		     if(min>0) {
		    	System.out.println("Falta "+ min+" min.");
		    }else {
		    	if(min == 0) {
		    		System.out.println("STARTA LOGO ISSO!");
		    	}else {
		    		System.out.println("JA PASSOU "+min+"min.");
		    		
		    	}
		    }
		    }else if(hora<=tempAviso) {
		    	if(Integer.parseInt(mFim)<min) {
		    		min = Integer.parseInt(m) - Integer.parseInt(mFim);
		    		System.out.println("FALTA "+hora+":"+min);
		    	}else {
		    		String regex = "" + min;
		 		   regex = regex.replaceAll("[^0-9]", "");
		 		   int minCorri = Integer.parseInt(regex);
		 		   
		    		System.out.println("FALTAs "+hora+":"+minCorri);
		    	}
		    }else {
		    	System.out.println("Ainda falta muito");
		    }
}
	
	
	
	
public Tarefa() {}

// CONSTRUTOR ***SEM*** ID, id_responsavel E id_projeto
public Tarefa(String nome, String descricao,String dataIni, String dataFim,String horaIni, String horaFim,String status,String identificacao) {
	super();
	this.nome = nome;
	this.descricao = descricao;
	this.dataIni = dataIni;
	this.dataFim = dataFim;
	this.horaIni = horaIni;
	this.horaFim = horaFim;
	this.status = status;
	this.identificacao = identificacao;
}
public Tarefa(String nome, String descricao,String dataIni, String dataFim,String horaIni, String horaFim,String status,Equipe equipes,String identificacao) {
	super();
	this.nome = nome;
	this.descricao = descricao;
	this.dataIni = dataIni;
	this.dataFim = dataFim;
	this.horaIni = horaIni;
	this.horaFim = horaFim;
	this.status = status;
	this.equipes = equipes;
	this.identificacao = identificacao;
}
public Tarefa(String nome, String descricao,String dataIni, String dataFim,String horaIni, String horaFim,String status,Equipe equipes,String identificacao,ResponsavelTarefa responsavelTarefa) {
	super();
	this.nome = nome;
	this.descricao = descricao;
	this.dataIni = dataIni;
	this.dataFim = dataFim;
	this.horaIni = horaIni;
	this.horaFim = horaFim;
	this.status = status;
	this.equipes = equipes;
	this.identificacao = identificacao;
	this.responsavelTarefa = responsavelTarefa;
}

// CONSTRUTOR ***COM*** ID, id_responsavel E id_projeto
public Tarefa(int id, String nome, String descricao,  String dataIni, String dataFim,
		String horaIni, String horaFim, ResponsavelTarefa responsavelTarefa, Projeto projeto, Equipe equipes,String status,String identificacao) {
	super();
	this.id = id;
	this.nome = nome;
	this.descricao = descricao;
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
