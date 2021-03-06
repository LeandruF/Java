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

@WebServlet("/ServletLocalizarProjeto")
public class ServletLocalizarProjeto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletLocalizarProjeto() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); // salva no tomcat	
		Pessoa p = new Pessoa();
		p = p.localizarPessoa((int)session.getAttribute("idUser"));
	Projeto pro = new Projeto();
	List<Projeto> listaProjetos = pro.pegarTodosProjetos(p.getCpf());
	if(listaProjetos != null) {
		request.setAttribute("listaProjetos", listaProjetos);
	}else {
		System.out.println("PROJETO = NULL");
	}

		request.getRequestDispatcher("localizarProjeto.jsp").forward(request, response);

}
}
