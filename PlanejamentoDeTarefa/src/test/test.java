package test;

import java.util.List;

import org.hibernate.Session;

import controller.Projeto;
import controller.ResponsavelProjeto;
import controller.Tarefa;
import model.HibernateUtil;

public class test {

	public static void main(String[] args) {
		/*Acessando o bd. considerando o hibernate.cfg.xml com hdm2ddl.auto com update
		 * neste modelo acessa o bd o sistema ira criar todas as tabelas listadas no mapeamento do hibernate.cfg.xml*/
		
		
			Session session = HibernateUtil.abrirSession();
			session.beginTransaction();
			//seleciona...
			//deletar...
	
		//ModelPessoa p = new ModelPessoa();
		
			//session.close();//fechando conexao
		//p.cadastrarPessoa();
			//p.verificarLogin("test@test.com", "123456Test");
		//p.verificarEmail("leandrufernandes@outlook.com");
		// p.verificarPassword("92534455");
		//ModelPessoa mp = new ModelPessoa() ;
		//mp.ModelLoginPessoa("leandrufernandes@outlook.com", "Leandro123");
		//Pessoa p = new Pessoa();
		//p.verificarLogin("leandrufernandes@outlook.com", "Leandro123");
			//(String nome, String descricao, String listaPessoas, String dataIni, String dataFim,String horaIni, String horaFim) 
		
	
//TEST PESSOA
			
			//Pessoa p = new Pessoa("Fernanda","113.111.111-13","(21)21511-6969","test@test.com","123456Test","nada nao");
			//Pessoa p = new Pessoa();
			//p.cadastrarPessoa(); // hibernate cadastra aqui
			//mp.modelLoginPessoa("leandro@leandro.com", "Leandro123");
			//p.localizarPessoa("152.660.587-22");
			//p.localizarPessoa("152.660.587-22");
			//VeriProjetoTarefa veri = new VeriProjetoTarefa();
			//veri.calcPrazo("15/08/2020");
			//veri.qtdTempComeca("19:44",3);
			
			//p.modelLoginPessoa("leandro@leandro.com", "Leandro123");
		//	Pessoa p = new Pessoa();
		//	p.login("leandro@leandro.com", "Leandro123");
			
			//p.pegarIdPessoa("111.111.111-13");
			//p.updateNome("Leandro","111.111.111-11");
			
			//ModelPessoa mp = new ModelPessoa();
			//mp.modelDeletePessoa("1");
			
// TEST PROJETO
			ResponsavelProjeto rp = new ResponsavelProjeto(1); // DADOS DO RESPONSAVEL
			List <Tarefa> listaTarefas; // LOOP COM AS LISTAS DE TAREFAS id, nome, descricao, dataIni,dataFim...
								 //( nome, responsavel,           descricao,         dataIni,    dataFim,    horaIni, horaFim, status, identi,  responsavelProjeto) 
			Projeto pro = new Projeto("Cotidiano","Leandro","Atividades do dia a dia.","09/07/2020","10/07/2020","07:59","21:00","Inativo","abcd",rp);
			//Projeto pro = new Projeto();
			//pro.cadastrarProjeto();
		//	pro.localizarProjeto("Cotidiano", "Leandro");
			
//TEST TAREFA
			//Tarefa t = new Tarefa("Algo","Cantar","07:00","08:00",1,2);
			//t.cadastrarTarefa();
			// (nome,descricao,ini,fim,idEquipe,idPessoa)
			//Tarefa t = new Tarefa("Leandro","Atividades do dia a dia.","Leandro","09/07/2020","10/07/2020","07:00","21:00");
			//t.cadastrarTarefa();
	}

}
