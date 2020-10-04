package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Pessoa;
import controller.Tarefa;

@WebServlet("/ServletUpdateTarefa")
public class ServletUpdateTarefa extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ServletUpdateTarefa() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); // salva no tomcat	
	String id = request.getParameter("idTarefa");	
	int idTarefa = Integer.parseInt(id.trim());
	Pessoa p = new Pessoa();
	p = p.localizarPessoa((int)session.getAttribute("idUser"));
	Tarefa t = new Tarefa();
	t = t.localizarTarefa(idTarefa);
	if(t!=null) {

		request.setAttribute("idTarefa", t.getId());
		request.setAttribute("nome", t.getNome());
		request.setAttribute("identificacao", t.getIdentificacao());
		request.setAttribute("dIni", t.getDataIni());
		request.setAttribute("dFim",t.getDataFim());
		request.setAttribute("hIni", t.getHoraIni());
		request.setAttribute("hFim", t.getHoraFim());
		request.setAttribute("status",t.getStatus());
		request.setAttribute("nomeEquipe", t.getEquipes().getNome());

		if(t.getProjeto() == null ) {
		request.setAttribute("idProjeto", "");
		}else {
		request.setAttribute("idProjeto", t.getProjeto().getNome());	
		}
		//LISTAR TODOS OS PROJETOS PARA ENCAIXAR AQUI OU NAO
		request.setAttribute("idResponsavel",t.getResponsavelTarefa().getCpfResponsavel());
		//LISTAR TODOS AS PESSOAS PARA ENCAIXAR AQUI
		request.setAttribute("descricao", t.getDescricao());
		request.getRequestDispatcher("irUpdateTarefa.jsp").forward(request, response);
	}else {
		
	}
	}

}
