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

@WebServlet("/ServletPerfil")
public class ServletPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletPerfil() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			
			HttpSession session = request.getSession(); // salva no tomcat	
	
			Pessoa p = new Pessoa();
			p = p.localizarPessoa((int)session.getAttribute("idUser"));
				Tarefa t = new Tarefa();
				int idEquipe = p.getEquipes().getId();
				int id = p.getId();
				// passa toda a lista de tarefas da equipe
				List<Tarefa> listaTarefas = t.pegarTodasTarefas(id,idEquipe);
			if(listaTarefas!=null) {
				
				request.setAttribute("listaTarefas",listaTarefas);
			
			}else {
				System.out.println("ACHOU NADA");
			}
			Projeto pro = new Projeto();
			List<Projeto> listaProjetos = pro.pegarTodosProjetos(p.getCpf());
			if(listaProjetos != null) {
			
				request.setAttribute("listaProjetos", listaProjetos);
			}else {
				System.out.println("PROJETO = NULL");
			}

				request.getRequestDispatcher("perfilUser.jsp").forward(request, response);
			

			 
		
		}
	}
