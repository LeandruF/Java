package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Projeto;

@WebServlet("/ServletDeletarProjeto")
public class ServletDeletarProjeto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletDeletarProjeto() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idProjeto");
		int idProjeto = Integer.parseInt(id.trim());
		Projeto pro = new Projeto();
		boolean bool = pro.deletarProjeto(idProjeto);
		
		if(bool) {
			request.getRequestDispatcher("irDeletarProjeto.jsp").forward(request, response);
		}else {
			String erro = "Erro ao deletar o projeto! ";
			request.setAttribute("erro", erro);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
		
	}

}
