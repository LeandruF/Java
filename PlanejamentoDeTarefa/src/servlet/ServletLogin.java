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
import controller.Tarefa;

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
	
		boolean bool = p.efetuarLogin(email, password);
		HttpSession session = request.getSession(); // salva no tomcat
		if (bool) {

			session.setAttribute("idUser", p.getId());// SALVA O ID NA SESSAO DO TOMCAT
			session.setAttribute("nomeUser", p.getNome());
			session.setAttribute("cpf", p.getCpf());
			session.setAttribute("cell", p.getCell());
			session.setAttribute("email", p.getEmail());
			session.setAttribute("password", p.getPassword());
			session.setAttribute("idEquipe", p.getEquipes().getId());
			session.setAttribute("nomeEquipe", p.getEquipes().getNome());
			
			request.setAttribute("nome", p.getNome());
			request.setAttribute("cpf", p.getCpf());
			request.setAttribute("cell", p.getCell());
			request.setAttribute("nomeE", p.getNomeEquipe());
			request.setAttribute("equipes", p.getEquipes().getId());
			
			Tarefa t = new Tarefa();
			int idEquipe = p.getEquipes().getId();
			int id = p.getId();
			// passa toda a lista de tarefas da equipe
			List<Tarefa> listaTarefas = t.pegarTodasTarefas(id,idEquipe);
		if(listaTarefas!=null) {
			
			request.setAttribute("listaTarefas",listaTarefas);
		
		}else {
			System.out.println("TAREFA = NULL");
		}
		Projeto pro = new Projeto();
		List<Projeto> listaProjetos = pro.pegarTodosProjetos(p.getCpf());
		if(listaProjetos != null) {
		/*	for(int i = 0;i<listaProjetos.size();i++) {
				System.out.println("PROJETO =========="+i+"================");
				System.out.println("Nome do PROJETO: "+listaProjetos.get(i).getNome());
				System.out.println("DESCRICAO do PROJETO: "+listaProjetos.get(i).getDescricao());
			}
			*/
			request.setAttribute("listaProjetos", listaProjetos);
		}else {
			System.out.println("PROJETO = NULL");
		}

			request.getRequestDispatcher("perfilUser.jsp").forward(request, response);
		} else {
			session = request.getSession(false); // se livra da sessao do tomcat (serve como logout)
			String erro = "Login ou senha invalidos!";
			request.setAttribute("erro", erro);
			request.getRequestDispatcher("loginErro.jsp").forward(request, response);
		}

	}

}
