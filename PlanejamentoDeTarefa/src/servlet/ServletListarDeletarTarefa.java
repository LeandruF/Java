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
import controller.Tarefa;


@WebServlet("/ServletListarDeletarTarefa")
public class ServletListarDeletarTarefa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletListarDeletarTarefa() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); // salva no tomcat	
		Pessoa p = new Pessoa();
		p = p.localizarPessoa((int)session.getAttribute("idUser"));
			Tarefa t = new Tarefa();
			int idEquipe = p.getEquipes().getId();
			int id = p.getId();
			// passa toda a lista de tarefas da equipe
			List<Tarefa> listaTarefas = t.pegarTodasTarefas(id,idEquipe);
		if(listaTarefas!=null) {
		
				request.setAttribute("listaTarefas", listaTarefas);
			
			request.getRequestDispatcher("deletarTarefa.jsp").forward(request, response);
		
		}else {
			System.out.println("ACHOU NADA");
		}
	}
}
