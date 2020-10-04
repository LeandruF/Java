package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Equipe;
import controller.Pessoa;
import controller.Projeto;
import controller.ResponsavelTarefa;
import controller.Tarefa;

@WebServlet("/servletConfirmaUpdateTarefa")
public class servletConfirmaUpdateTarefa extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public servletConfirmaUpdateTarefa() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); // salva no tomcat	
		Pessoa p = new Pessoa();
		p = p.localizarPessoa((int)session.getAttribute("idUser"));
		
		String id = request.getParameter("id");
		int idTarefa = Integer.parseInt(id.trim());
		String nome = request.getParameter("nome");
		String identificacao = request.getParameter("identificacao");
		String hIni = request.getParameter("hIni");
		String hFim = request.getParameter("hFim");
		String dIni = request.getParameter("dIni");
		String dFim = request.getParameter("dFim");
		String status = request.getParameter("status").toLowerCase();
		String descricao = request.getParameter("descricao");
		
		String idProjeto = request.getParameter("idProjeto");
		
		ResponsavelTarefa rt = new ResponsavelTarefa();
		rt.setCpfResponsavel((String)session.getAttribute("cpf"));
		rt.setIdentTarefa(identificacao);
		
		Tarefa t = new Tarefa();
		
		t = t.localizarTarefa(idTarefa);
		t.setNome(nome);
		t.setIdentificacao(identificacao);
		t.setDataIni(dIni);
		t.setHoraIni(hIni);
		t.setDataFim(dFim);
		t.setHoraFim(hFim);
		t.setStatus(status);
		t.setDescricao(descricao);
		
		//t.setProjeto(p); //CLASSE PROJETO
	
		String idEquipe = request.getParameter("nomeEquipe"); // pega
		Equipe e = t.pegarIdEquipe(idEquipe);
		t.setEquipes(e);
		
		Projeto pro = new Projeto();
		System.out.println("O ID DO PROJETO SELECIONADO É >>>>>>>> "+idProjeto);
		
		if(idProjeto.equals("null")) {	
			
			t.setProjeto(null);
			request.setAttribute("idProjeto", " ");
				
		}else {

			int idPro = Integer.parseInt(idProjeto.trim());
			System.out.println("ID PROJETO INT>>>>>>>>>>>>>>>>>>>>>"+idPro);
		pro = pro.localizarProjeto(idPro);
		request.setAttribute("idProjeto", pro.getNome()); //(DEPOIS COLOCAR>>>>>>>>>>>>>>>>)//t.getProjeto().getNome() 
		t.setProjeto(pro);
		}
		
		request.setAttribute("idTarefa",t.getId());
		request.setAttribute("nome", t.getNome());
		request.setAttribute("idt", t.getIdentificacao());
		request.setAttribute("hIni", t.getHoraIni());
		request.setAttribute("hFim", t.getHoraFim());
		request.setAttribute("dIni", t.getDataIni());
		request.setAttribute("dFim", t.getDataFim());
		request.setAttribute("cpf", rt.getCpfResponsavel());
		request.setAttribute("status", t.getStatus());
		request.setAttribute("descricao", t.getDescricao());
		request.setAttribute("idEquipe", t.getEquipes().getNome());
		boolean bool = t.updateTarefa(t);
		if(bool) {
			request.getRequestDispatcher("confirmadoUpdateTarefa.jsp").forward(request, response);
		}else {
			String erro ="Não alterou nada!";
			request.setAttribute("erro", erro);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}

}
