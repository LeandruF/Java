package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Pessoa;
import controller.Projeto;


@WebServlet("/ServletUpdateProjeto")
public class ServletUpdateProjeto extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ServletUpdateProjeto() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); // salva no tomcat	
	String id = request.getParameter("idProjeto");	
	int idProjeto = Integer.parseInt(id.trim());
	Pessoa p = new Pessoa();
	p = p.localizarPessoa((int)session.getAttribute("idUser"));
	Projeto pro = new Projeto();
	pro= pro.localizarProjeto(idProjeto);
	if (pro != null) {
		request.setAttribute("nome", pro.getNome());
		request.setAttribute("idProjeto",pro.getId());
		request.setAttribute("hIni", pro.getHoraIni());
		request.setAttribute("hFim", pro.getHoraFim());
		request.setAttribute("descricao", pro.getDescricao());
		request.setAttribute("dIni", pro.getDataIni());
		request.setAttribute("dFim", pro.getDataFim());
		request.setAttribute("status",pro.getStatus());
		request.setAttribute("identificacao", pro.getIdentificacao());

	
		request.getRequestDispatcher("irUpdateProjeto.jsp").forward(request, response);
}
	 
}
}
