package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.Contato;
import model.ModelContato;

public class ViewContato {

	public void vCadastrarContato(Scanner ler) {

		System.out.println("Nome: ");
		String nome = ler.nextLine();
		System.out.println("Cpf: ");
		String cpf = ler.nextLine();
		System.out.println("Identidade: ");
		String idt = ler.nextLine();
		System.out.println("Email: ");
		String email = ler.nextLine();
		System.out.println("Cell: ");
		String cell = ler.nextLine();
		System.out.println("Canal: ");
		int valorCanal = Integer.parseInt(ler.nextLine());

		Contato c = new Contato(nome, cpf, idt, email, valorCanal, cell);
		c.cadastrarContato();
		System.out.println(c.msg);
	}

	public int vLocalizarContatoCpf(Scanner ler) {
		Contato c = new Contato();
		System.out.println("\tLocalizar Contato Por Cpf:");
		System.out.println("Cpf:");
		String cpf = ler.nextLine();

		c.localizarContatoCpf(cpf);
		if (c.msg == "" || c.msg.isEmpty()) {
			System.out.println("\nId: " + c.getId());
			System.out.println("Nome: " + c.getNome());
			System.out.println("Cpf: " + c.getCpf());
			System.out.println("Idt: " + c.getIdt());
			System.out.println("Email: " + c.getEmail());
			System.out.println("Cell: " + c.getCell());
			System.out.println("Canal: " + c.getValorCanal() + "\n");
			return c.getId();
		} else {
			System.out.println(c.msg);
			return -1;

		}
	}

	public void vLocalizarContatoNome(Scanner ler) {
		System.out.println("\tLocalizar Por Nome:");
		System.out.println("Nome: ");
		String nome = ler.nextLine();

		Contato c = new Contato();
		List<Contato> lista = new ArrayList<Contato>();
		lista = c.localizarContatoNome(nome);
		if (lista != null) {
			for (int i = 0; i < lista.size(); i++) {

				System.out.println("\n****************** POSIÇÃO " + (i+1) + " ***********************");
				System.out.println("Id: " + lista.get(i).getId());
				System.out.println("Nome: " + lista.get(i).getNome());
				System.out.println("Cpf: " + lista.get(i).getCpf());
				System.out.println("Identidade: " + lista.get(i).getIdt());
				System.out.println("Email: " + lista.get(i).getEmail());
				System.out.println("Cell: " + lista.get(i).getCell());
				System.out.println("Canal: " + lista.get(i).getValorCanal());
			}
			if(lista.size() == 1) {		
				System.out.println("****************************************************");
				
			}else {
				
			System.out.println("*************************************************************************");
			System.out.println("Qual posição deseja pegar?");
			int posicao = Integer.parseInt(ler.nextLine());
			posicao = posicao - 1;

			System.out.println("Id: " + lista.get(posicao).getId());
			System.out.println("Nome: " + lista.get(posicao).getNome());
			System.out.println("Cpf: " + lista.get(posicao).getCpf());
			System.out.println("Identidade: " + lista.get(posicao).getIdt());
			System.out.println("Email: " + lista.get(posicao).getEmail());
			System.out.println("Cell: " + lista.get(posicao).getCell());
			System.out.println("Canal: " + lista.get(posicao).getValorCanal());
			}
		} else {
			System.out.println(c.msg);
		}

	}

	public void vDeletarContato(Scanner ler) {
		System.out.println("Deletar Contato:");
		System.out.println("Digite o cpf a ser deletado: ");
		String cpf = ler.nextLine();
		Contato c = new Contato();
		if(c.verificarCpf(cpf) != "") {
			ModelContato mc = new ModelContato();
			mc.mDeletarContato(cpf);
			System.out.println(mc.msg);
		}else {
			System.out.println("Cpf invalido!");
		}
	}

	public void vListarContato(Scanner ler) {
		Contato c = new Contato();
		List<Contato> lista = new ArrayList<Contato>();
		System.out.println("Deseja listar quantos contatos?");
		String qtd  = ler.nextLine();
		if(qtd.isEmpty() || qtd == null) {
			lista = c.listarContato();
			for(int i = 0;i<lista.size();i++) {
				System.out.println("\n****************** POSIÇÃO " + (i + 1) + " ***********************");
				System.out.println("Id: "+lista.get(i).getId());
				System.out.println("Nome: "+lista.get(i).getNome());
				System.out.println("Cpf: "+lista.get(i).getCpf());
				System.out.println("Identidade: "+lista.get(i).getIdt());
				System.out.println("Email: "+lista.get(i).getEmail());
				System.out.println("Cell: "+lista.get(i).getCell());
				System.out.println("Canal: "+lista.get(i).getValorCanal());
			}
		}else {
			lista = c.listarContato(Integer.parseInt(qtd));
		
			
			for(int i = 0;i<lista.size();i++) {
				System.out.println("\n****************** POSIÇÃO " + (i + 1) + " ***********************");
				System.out.println("Id: "+lista.get(i).getId());
				System.out.println("Nome: "+lista.get(i).getNome());
				System.out.println("Cpf: "+lista.get(i).getCpf());
				System.out.println("Identidade: "+lista.get(i).getIdt());
				System.out.println("Email: "+lista.get(i).getEmail());
				System.out.println("Cell: "+lista.get(i).getCell());
				System.out.println("Canal: "+lista.get(i).getValorCanal());
				
			}
		}
	}
	
	public void vMenuContato(Scanner ler) {
		String op;
		do {
			
		System.out.println("\n\t|********MENU************|");
		System.out.println("\t| 1 - Cadastrar Contato  |");
		System.out.println("\t| 2 - Localizar Contato  |");
		System.out.println("\t| 3 - Alterar Contato    |");
		System.out.println("\t| 4 - Listar Contato     |");
		System.out.println("\t| 5 - Deletar Contato    |");
		System.out.println("\t|     0 - SAIR           |");
		System.out.println("\t|************************|");
		op = ler.nextLine();
		switch (op) {
		case "1":{
			vCadastrarContato(ler);
			
			
			break;
		}
	case "2":{
			vMenuLocalizar(ler);
			
			break;
		}
	case "3":{
		vMenuUpdate(ler);
		
		
		break;
	}
	case "4":{
		vListarContato(ler);
		
		break;
	}
	case "5":{
		vDeletarContato(ler);
		
		break;
	}
	case"0":{
		System.out.println("SAINDO!");
		ler.close();
		break;
	}

		default:
			System.out.println("OPÇÃO INVALIDA!");
			break;
		}
		}while(op!="0");
	}
	public void vMenuUpdate(Scanner ler) {
		String op;
		Contato c = new Contato();
			System.out.println("Digite o cpf:");
			String cpf = ler.nextLine();
			c.localizarContatoCpf(cpf);
			if(c.localizarContatoCpf(cpf) == null) {
				
			}else {
				do {
					
				
				System.out.println("\nId: " + c.getId());
				System.out.println("Nome: " + c.getNome());
				System.out.println("Cpf: " + c.getCpf());
				System.out.println("Idt: " + c.getIdt());
				System.out.println("Email: " + c.getEmail());
				System.out.println("Cell: " + c.getCell());
				System.out.println("Canal: " + c.getValorCanal() + "\n");
			
			
						
			System.out.println("******* Update Contato : *******");
			System.out.println("*  1 - Nome:                   *");
			System.out.println("*  2 - Cpf:                    *");
			System.out.println("*  3 - Identidade:             *");
			System.out.println("*  4 - Email:                  *");
			System.out.println("*  5 - Cell:                   *");
			System.out.println("*  6 - Canal:                  *");
			System.out.println("*  0 - Sair:                   *");
			System.out.println("*******************************");
			op = ler.nextLine();
			switch (op) {
			case "1":{
			
				System.out.println("Digite o nome alterado: ");
				String nome = ler.nextLine();
				System.out.println(c.updateNome(nome, cpf));
				
				
				break;
			}
			case "2":{
				System.out.println("Digite a idt: ");
				String idt = ler.nextLine();
				System.out.println("Digite o cpf alterado: ");
				String cpfUp = ler.nextLine();
				System.out.println(c.updateCpf(cpfUp, idt));
				
				
				break;
			}
			case "3":{
				
				System.out.println("Digite a identidade alterado: ");
				String idt = ler.nextLine();
				//c.updateIdt(idt, cpf);
				System.out.println(c.updateIdt(idt, cpf));
				
				break;
			}
			case "4":{
				
				System.out.println("Digite o Email alterado: ");
				String email = ler.nextLine();
				System.out.println(c.updateEmail(email, cpf));
			
				
				break;
			}
			case "5":{
				
				System.out.println("Digite o Cell alterado: ");
				String cell = ler.nextLine();
				System.out.println(c.updateCell(cell, cpf));
				
				
				break;
			}
			case "6":{
				
				System.out.println("Digite o Canal alterado: ");
				int canal = Integer.parseInt(ler.nextLine());
				System.out.println(c.updateValorCanal(canal, cpf));
			
				
				break;
			}
			case"0":{
				System.out.println("SAINDO! \n");
				break;
			}

			default:
				System.out.println("Opção invalida. \n");
				break;
			}
			}while(op!="0");
				vMenuContato(ler);
			}
	}
	public void vMenuLocalizar(Scanner ler) {
		String op;
		System.out.println("\n\t|*******Localizar********|");
		System.out.println("\t| 1 - Localizar Cpf      |");
		System.out.println("\t| 2 - Localizar Nome     |");
		System.out.println("\t|     0 - SAIR           |");
		System.out.println("\t|************************|");
		op = ler.nextLine();
		switch (op) {
		case "1":{
			vLocalizarContatoCpf(ler);
			
			break;
		}
	case "2":{
			vLocalizarContatoNome(ler);
			
			break;
		}
	case"0":{
		System.out.println("SAINDO.");
		break;
	}
		default:
			System.out.println("OPÇÃO INVALIDA!");
			break;
		}
	}
}
