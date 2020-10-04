package test;

import controller.Projeto;

public class test {

	public static void main(String[] args) {
		/*Acessando o bd. considerando o hibernate.cfg.xml com hdm2ddl.auto com update
		 * neste modelo acessa o bd o sistema ira criar todas as tabelas listadas no mapeamento do hibernate.cfg.xml*/
		
		
		//	Session session = HibernateUtil.abrirSession();
			//session.beginTransaction();
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
		
		
	//	Pessoa p = new Pessoa();
		//List<Pessoa> lista = new ArrayList<Pessoa>();
		//lista = p.listarPessoa();

		//	for(int i = 0 ;i<lista.size();i++) {
		//		System.out.println("Nome::::"+lista.get(i).getNome());
		//		System.out.println("CPF::::"+lista.get(i).getCpf());
		//	}
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
			//Pessoa p = new Pessoa();
		//	p.pegarPessoa(1);
		//	p.login("leandro@leandro.com", "Leandro123");
			
			//p.pegarIdPessoa("111.111.111-13");
			//p.updateNome("Leandro","111.111.111-11");
			
		//	ModelPessoa mp = new ModelPessoa();
			//mp.pegarIdEquipeNone("none");
			//mp.modelDeletePessoa("1");
		
			
// TEST PROJETO
			//List <Tarefa> listaTarefas; // LOOP COM AS LISTAS DE TAREFAS id, nome, descricao, dataIni,dataFim...
								 //( nome, responsavel,           descricao,         dataIni,    dataFim,    horaIni, horaFim, status, identi,  responsavelProjeto) 
		//	List<Projeto> listaProjetos;
		//	listaProjetos.add(pro);
			//ResponsavelProjeto rp = new ResponsavelProjeto(pro); // DADOS DO RESPONSAVEL
		//	Projeto pro = new Projeto("Cotidiano","Maria","Atividades do dia a dia.","09/07/2020","10/07/2020","07:59","21:00","Inativo","PROJETO_123");
			
		//	ResponsavelProjeto rp = new ResponsavelProjeto();
		//	rp.setCpfResponsavel("111.111.111-11");
		//	rp.setIdentProjeto("PROJETO_123");
		//Projeto pro = new Projeto("Cotidiano","Leandro" ,  "Atividades do dia a dia.",  "09/07/2020", "10/07/2020",  "07:59",  "21:00",  "PROJETO_123",  "Inativo", rp);	
		//	pro.cadastrarProjeto();
		//	pro.localizarProjeto("Cotidiano", "Leandro");
		Projeto p = new Projeto();
		//p.calcPrazo("30/08/2020");
		p.calcPrazo("19/09/2020");
		//p.qtdTempComeca("11:40", 1);

			
//TEST TAREFA
			//Tarefa t = new Tarefa("Algo","Cantar","07:00","08:00",1,2);
			// (nome,descricao,ini,fim,idEquipe,idPessoa)
			//Equipe e = new Equipe();
			//e.setId(1);
			//e.setNome("5");
		
			//ResponsavelTarefa rt = new ResponsavelTarefa();
			//rt.setId(6);
			//rt.setCpfResponsavel("111.111.111-11");
			//rt.setIdentTarefa("Identificaca 1");
			
						// nome, descricao, dataIni, dataFim,  horaIni,  horaFim,  status,Equipe equipes, identificacao,ResponsavelTarefa responsavelTarefa
			//Tarefa t = new Tarefa("NomeAtividade1","Descricao1","01/01/2021","10/07/2022","08:00","09:00","inativo",e,"Identificaca 1",rt);
			// nome,  descricao, dataIni,  dataFim, horaIni,  horaFim, status,Equipe equipes, identificacao,ResponsavelTarefa responsavelTarefa)
			//t.cadastrarTarefa();
		
		//	ModelTarefa mt = new ModelTarefa();
		//	mt.modeLocalizarTarefa(1);
			//mt.modelPegarResponsavelTarefa(1);
		//	mt.modelPegarTarefas(1, 1);
		
	}

}
