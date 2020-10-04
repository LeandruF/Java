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


@WebServlet("/ServletListarUpdateTarefa")
public class ServletListarUpdateTarefa extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ServletListarUpdateTarefa() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
	System.out.println(listaTarefas);
if(listaTarefas!=null) {
	
	request.setAttribute("listaTarefas",listaTarefas);

}else {
	System.out.println("ACHOU NADA");
}

		request.getRequestDispatcher("updateTarefa.jsp").forward(request, response);

}
}