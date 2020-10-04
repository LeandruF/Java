	package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Pessoa;


@WebServlet("/ServletCadastrarPessoa")
public class ServletCadastrarPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ServletCadastrarPessoa() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String cell = request.getParameter("cell");
		String nomeEquipe = request.getParameter("nomeEquipe");
		if(nomeEquipe == "" || nomeEquipe.isEmpty()) {
			nomeEquipe = "none";
		}
		String password = request.getParameter("password");
		//String repetirPassword =  request.getParameter("repetirPassword");

		Pessoa p = new Pessoa(nome,cpf,cell,nomeEquipe,email,password);
		if(p.cadastrarPessoa()) {
			
			request.getRequestDispatcher("respostaCadastrar.jsp").forward(request, response);
			
		}else {
			
			String erro = p.getMsg();
			request.setAttribute("erro", erro);
			request.getRequestDispatcher("erroCadastrarPessoa.jsp").forward(request, response);
		}
		
	}

}
