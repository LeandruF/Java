package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Projeto;

/**
 * Servlet implementation class ServletIrProjeto
 */
@WebServlet("/ServletIrProjeto")
public class ServletIrProjeto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletIrProjeto() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("idProjeto");
		int idProjeto = Integer.parseInt(id.trim());
		Projeto p = new Projeto();
		p= p.localizarProjeto(idProjeto);
		if (p != null) {
			
			int tempoIni = p.calcPrazo(p.getDataIni());
			request.setAttribute("prazoComeca", tempoIni);
			int tempoFim = p.calcPrazo(p.getDataFim());
			request.setAttribute("prazoTermina", tempoFim);
			
			request.setAttribute("nome", p.getNome());
			request.setAttribute("idProjeto", p.getId());
			request.setAttribute("hIni", p.getHoraIni());
			request.setAttribute("hFim", p.getHoraFim());
			request.setAttribute("descricao", p.getDescricao());
			request.setAttribute("dIni", p.getDataIni());
			request.setAttribute("dFim", p.getDataFim());
			request.setAttribute("status",p.getStatus());
			request.setAttribute("identificacao", p.getIdentificacao());

			request.getRequestDispatcher("irProjeto.jsp").forward(request, response);
		} else {
			System.out.println("TNC PROGRAMA");
		}
	}

}
