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
import controller.Projeto;
import controller.ResponsavelProjeto;
import controller.Tarefa;


@WebServlet("/ServletCadastrarProjeto")
public class ServletCadastrarProjeto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletCadastrarProjeto() {  }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		
		String nomeProjeto = request.getParameter("nomeProjeto");
		String dataIni = request.getParameter("dataIni");
		String dataTerm = request.getParameter("dataTerm");
		String horaIni = request.getParameter("horaIni");
		String horaTerm = request.getParameter("horaTerm");
		String status = request.getParameter("status");
		String identificacao = request.getParameter("idtProjeto");
		String descricao = request.getParameter("descricao");
		
		int idResp = (int) session.getAttribute("idUser");
		String cpf = (String) session.getAttribute("cpf");
		
		Pessoa p = new Pessoa();
		p=p.localizarPessoa(idResp);	// pega a equipe de pessoa
		
		ResponsavelProjeto rp = new ResponsavelProjeto();
		rp.setCpfResponsavel(cpf);
		rp.setIdentProjeto(identificacao);
		
		String cpfResponsavel = (String)session.getAttribute("cpf");
//SEM TAREFA
//nome,  responsavel,  descricao,  dataIni, dataFim,  horaIni,  horaFim,  identificacao,  status,ResponsavelProjeto responsavelProjeto)
		Projeto pro = new Projeto(nomeProjeto,cpfResponsavel ,  descricao,  dataIni, dataTerm,  horaIni,  horaTerm,  identificacao,  status, rp);	
//COM TAREFA
// nome,  responsavel,  descricao,  dataIni, dataFim,  horaIni,  horaFim,  identificacao,  status,ResponsavelProjeto responsavelProjeto, List<Tarefa> listaTarefas) 
		if(pro.cadastrarProjeto()) {
			int id = (int) session.getAttribute("idUser");
			int idEquipe = (int) session.getAttribute("idEquipe");
		
			request.setAttribute("nome", p.getNome());
			request.setAttribute("cpf", p.getCpf());
			request.setAttribute("cell", p.getCell());
			request.setAttribute("nomeE", p.getNomeEquipe());
			request.setAttribute("equipes", p.getEquipes().getId());
			
			
			p = p.localizarPessoa((int)session.getAttribute("idUser"));
				Tarefa t = new Tarefa();
		
				// passa toda a lista de tarefas da equipe
				List<Tarefa> listaTarefas = t.pegarTodasTarefas(id,idEquipe);
			if(listaTarefas!=null) {
				
				request.setAttribute("listaTarefas",listaTarefas);
			
			}else {
				System.out.println("ACHOU NADA");
			}
				
			
				
				request.getRequestDispatcher("ServletPerfil").forward(request, response);
			

			 
		
		}else {
		
		String erro = pro.getMsg();
		request.setAttribute("erro", erro);
		request.getRequestDispatcher("erro.jsp").forward(request, response);
	}
		
		
	}

}
