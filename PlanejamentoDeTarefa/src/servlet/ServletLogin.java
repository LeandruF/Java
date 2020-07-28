package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Pessoa;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletLogin() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email").toLowerCase();
		String password = request.getParameter("password");
		Pessoa p = new Pessoa();
		// List<Pessoa> pe = p.efetuarLogin(email,password);
		/*
		 * if(pe!=null) {
		 * 
		 * 
		 * session.setAttribute("idUser",pe.get(0).getId());// SALVA O ID NA SESSAO DO
		 * TOMCAT
		 * 
		 * request.setAttribute("nome", pe.get(0).getNome());
		 * request.setAttribute("cpf", pe.get(0).getCpf()); request.setAttribute("cell",
		 * pe.get(0).getCell()); request.setAttribute("equipe",
		 * pe.get(0).getNomeEquipe());
		 * 
		 * request.getRequestDispatcher("perfilUser.jsp").forward(request, response);
		 * 
		 * }else { session = request.getSession(false); // se livra da sessao do tomcat
		 * (serve como logout) String erro = "Login ou senha invalidos!";
		 * request.setAttribute("erro", erro);
		 * request.getRequestDispatcher("loginErro.jsp").forward(request, response); }
		 */
		boolean bool = p.efetuarLogin(email, password);
		HttpSession session = request.getSession(); // salva no tomcat
		if (bool) {

			session.setAttribute("idUser", p.getId());// SALVA O ID NA SESSAO DO TOMCAT
			session.setAttribute("nome", p.getNome());
			session.setAttribute("cpf", p.getCpf());
			session.setAttribute("idEquipe", p.getEquipes().getId());

			request.setAttribute("nome", p.getNome());
			request.setAttribute("cpf", p.getCpf());
			request.setAttribute("cell", p.getCell());
			request.setAttribute("nomeE", p.getNomeEquipe());
			request.setAttribute("equipes", p.getEquipes().getId());

			request.getRequestDispatcher("perfilUser.jsp").forward(request, response);
		} else {
			session = request.getSession(false); // se livra da sessao do tomcat (serve como logout)
			String erro = "Login ou senha invalidos!";
			request.setAttribute("erro", erro);
			request.getRequestDispatcher("loginErro.jsp").forward(request, response);
		}

	}

}
