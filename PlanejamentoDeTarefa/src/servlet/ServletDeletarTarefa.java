package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Tarefa;

@WebServlet("/ServletDeletarTarefa")
public class ServletDeletarTarefa extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ServletDeletarTarefa() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ENTROU NO DELETAR TAREFA");
		String id = request.getParameter("idTarefa");
		int idTarefa = Integer.parseInt(id.trim());
		Tarefa t = new Tarefa();
		boolean bool = t.deletarTarefa(idTarefa);
		if(bool) {
			System.out.println("DELETADO");
			request.getRequestDispatcher("irDeletarTarefa.jsp").forward(request, response);
		}else {
			System.out.println("nao deletou");
			String erro = "Erro ao deletar a Tarefa! ";
			request.setAttribute("erro", erro);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
		
	}

}
