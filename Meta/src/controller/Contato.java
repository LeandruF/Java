package controller;

import java.util.ArrayList;
import java.util.List;

import model.ModelContato;

public class Contato {
private int id;
private String nome,cpf,idt;
private String email,cell;;
private int valorCanal;
public String msg="";

//VERIFICAÇÕES
	public String verificarNome(String nome) {
		nome.trim();
		if (nome.isEmpty() || nome.length() > 3) {
			return msg = "Nome invalido.";
					
		} else {
			return "";
		}
	}
	public String verificarCpf(String cpf) {
		cpf.trim();
		if (cpf.length() == 11) { // Se cpf nao tiver ..-
			 ModelContato mc = new ModelContato();
			 if(mc.mVerificarCpf(cpf) != -1) {
				 return msg ="Erro cpf ja cadastrado";
			 } else {
				 return "";
		}
		 }else {
			 return msg = "Cpf invalido.";
		 }
	}
	public String verificarIdt(String idt) {
		idt.trim();
		if (idt.length() == 9) { // Se idt nao tiver . . -

			 ModelContato mc = new ModelContato();
			 if(mc.mVerificarIdt(idt) != -1) {
				 System.out.println("Ja cadastrado");
				 return msg ="Erro idt ja cadastrado";
		} else {
			return "";
		}
		 }else {
			 System.out.println("INVALIDO");
			 return msg = "Idt invalido.";
		 }
	}
	public String verificarCell(String cell) {
		cell.trim();
		if (cell.length() != 11) { // SE NAO TIVER ()   -    
			return msg = "Celular invalido.";
			
		} else {
			return "";
		}
	}
	public String verificarEmail(String email) {
		int indiceEmail = email.indexOf('@'); // VERIFICA SE TEM @ | OBS:-1 = INVALIDO
		

		if (!email.isEmpty()) {

			if (indiceEmail > 0) {
				if (indiceEmail > 0) {
					email = email.substring(0, indiceEmail);
					msg = "";
				}
			} else {
				msg = "Email invalido.";
			}
		
		} else {
			msg = "Email em branco.";
		}
		System.out.println("Retorno : "+msg);
		return msg;
	}
	public String verificarValorCanal(int valorCanal) {
		if(valorCanal<0) {
			return msg = "Canal invalido.";
		}else {
			return msg = "";
			
		}
	}
	
	//Cadastrar contato
	public boolean cadastrarContato() {
	msg +="\n"+ verificarNome(nome);
	msg +="\n"+verificarCpf(cpf);
	msg +="\n"+verificarIdt(idt);
	msg +="\n"+verificarCell(cell);
	msg +="\n"+verificarEmail(email);
	msg +="\n"+verificarValorCanal(valorCanal);
	
	ModelContato mc = new ModelContato();
	if(mc.mCadastrar(this)) {
		msg = "Cadastrado com sucesso!";
		return true;
	}else {
		msg +="\n"+mc.msg;	
		return false;
		
	}
}
	//Localizar por nome
	public List<Contato> localizarContatoNome(String nome) {

		ModelContato mc = new ModelContato();
		List<Contato> lista = mc.mLocalizarNome(nome);
		if(lista .isEmpty()) {
			msg = mc.msg;
			return null;
		}else {
			return lista;
			
		}
	}
	//Localizar por Cpf
	public Contato localizarContatoCpf(String cpf) {
		ModelContato mc = new ModelContato();
		Contato c = mc.mLocalizarCpf(cpf);
		if(c!=null) {
			this.id = c.getId();
			this.nome = c.getNome();
			this.cpf = c.getCpf();
			this.idt = c.getIdt();
			this.email = c.getEmail();
			this.cell = c.getCell();
			this.valorCanal = c.getValorCanal();
			
			return c;
		}else {
			msg = mc.msg;
			return null;
		}
		
	}

	
public String updateNome(String nome, String cpf) {	
	if(verificarNome(nome) == "" ) {
		msg = "Erro no nome";
		return  msg;
	}else {

		ModelContato mc = new ModelContato();
		mc.mUpdateNome(nome, cpf);
		return msg = mc.msg;
		
	}
}
public String updateCpf(String cpf,String idt) {
	if(verificarCpf(cpf) != "") {
		
		return "Erro no cpf.";
	}else {
		ModelContato mc = new ModelContato();
		mc.mUpdateCpf(cpf, idt);
		return msg = mc.msg;	
	}
}
public String updateIdt(String idt, String cpf) {	
	if(verificarIdt(idt) != "") {
		return "Erro na Identidade";
	}else {
		ModelContato mc = new ModelContato();
		mc.mUpdateIdt(idt, cpf);
		return msg = mc.msg;
}
}
public String updateEmail(String email, String cpf) {	
	if(verificarEmail(email) != "" ) {
		return "Erro no Email.";
	}else {
		ModelContato mc = new ModelContato();
		mc.mUpdateEmail(email, cpf);
		return msg = mc.msg;
}
}
public String updateCell(String cell, String cpf) {	
	if(verificarCell(cell) != "") {
		return "Erro no cell." ;
	}else {
		ModelContato mc = new ModelContato();
		mc.mUpdateCell(cell, cpf);
		return msg = mc.msg;
}
}
public String updateValorCanal(int valorCanal, String cpf) {	
	if(verificarValorCanal(valorCanal) != "") {
		return "Erro no canal" ;
	}else {
		ModelContato mc = new ModelContato();
		mc.mUpdateValorCanal(valorCanal, cpf);
		return msg = mc.msg;
}
}


public boolean excluirContato(String cpf) {	
	ModelContato mc = new ModelContato();
	boolean bool = mc.mDeletarContato(cpf);
	msg = mc.msg;
	
	return bool;
}
public List<Contato> listarContato() {
	ModelContato mc = new ModelContato();
	List<Contato> lista = new ArrayList<Contato>();
	lista = mc.mListarRegistro();
	return lista;
}
public List<Contato> listarContato(int qtd) {
	ModelContato mc = new ModelContato();
	List<Contato> lista = new ArrayList<Contato>();

			lista = mc.mListarRegistro(qtd);
		
	return lista;
}

//CONSTRUTOR VAZIO
public Contato(){}
//CONSTRUTOR CHEIO ***SEM*** ID
public Contato(String nome, String cpf, String idt ,String email, int valorCanal, String cell) {
	this.nome = nome;
	this.cpf = cpf;
	this.idt = idt;
	this.email = email;
	this.valorCanal = valorCanal;
	this.cell = cell;
}
//CONSTRUTOR CHEIO ***COM*** ID
public Contato(int id,String nome, String cpf, String idt ,String email, int valorCanal, String cell) {
	this.id=id;
	this.nome = nome;
	this.cpf = cpf;
	this.idt = idt;
	this.email = email;
	this.valorCanal = valorCanal;
	this.cell = cell;
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
public String getIdt() {
	return idt;
}
public void setIdt(String idt) {
	this.idt = idt;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getValorCanal() {
	return valorCanal;
}
public void setValorCanal(int valorCanal) {
	this.valorCanal = valorCanal;
}
public String getCell() {
	return cell;
}
public void setCell(String cell) {
	this.cell = cell;
}

}
