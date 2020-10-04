package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Pessoa;
import controller.ResponsavelTarefa;
import controller.Tarefa;

@WebServlet("/ServletCadastrarTarefa")
public class ServletCadastrarTarefa extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ServletCadastrarTarefa() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		
		String nomeTarefa = request.getParameter("nomeTarefa");
		String dataIni = request.getParameter("dataIni");
		System.out.println("DATA INI: "+dataIni);
		String dataTerm = request.getParameter("dataTerm");
		String horaIni = request.getParameter("horaIni");
		String horaTerm = request.getParameter("horaTerm");
		String status = request.getParameter("status");
		String identificacao = request.getParameter("idtTarefa");
		String descricao = request.getParameter("descricao");		
		
		
		int idResp = (int) session.getAttribute("idUser");
	
		
		Pessoa p = new Pessoa();
		p=p.localizarPessoa(idResp);	// pega a equipe de pessoa
	
		
		ResponsavelTarefa rt = new ResponsavelTarefa();
		String cpf = (String)session.getAttribute("cpf");
		rt.setCpfResponsavel(cpf);
		rt.setIdentTarefa(identificacao);
	
		Tarefa t = new Tarefa(nomeTarefa,descricao,dataIni,dataTerm,horaIni,horaTerm,status,p.getEquipes(),identificacao,rt);
		//(String nome, String descricao,String dataIni, String dataFim,String horaIni, String horaFim,String status,Equipe equipes,String identificacao)
		if(t.cadastrarTarefa()) {
			//SE CADASTRAR JOGA PRA PAGINA PERFIL COM A LISTAGEM DE TAREFAS ATUALIZADA 
			//POR ISSO DE SETAR OS DADOS NA PAGINA AGAIN
			
			int id = (int) session.getAttribute("idUser");
			int idEquipe = (int) session.getAttribute("idEquipe");
		
			request.setAttribute("nome", p.getNome());
			request.setAttribute("cpf", p.getCpf());
			request.setAttribute("cell", p.getCell());
			request.setAttribute("nomeE", p.getNomeEquipe());
			request.setAttribute("equipes", p.getEquipes().getId());
			
			
			
			List<Tarefa> listaTarefas = t.pegarTodasTarefas(id,idEquipe);
			request.setAttribute("listaTarefas", listaTarefas);
			
			request.getRequestDispatcher("ServletPerfil").forward(request, response);
			
		}else {
			
			String erro = t.getMsg();
			request.setAttribute("erro", erro);
			request.getRequestDispatcher("erroCadastrar.jsp").forward(request, response);
		}
		
	}
	

}
