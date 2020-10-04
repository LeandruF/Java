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
import controller.ResponsavelProjeto;


@WebServlet("/servletConfirmaUpdateProjeto")
public class servletConfirmaUpdateProjeto extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public servletConfirmaUpdateProjeto() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); // salva no tomcat	
		Pessoa pessoa = new Pessoa();
		pessoa = pessoa.localizarPessoa((int)session.getAttribute("idUser"));
		
		String id = request.getParameter("id");
		int idProjeto = Integer.parseInt(id.trim());
		String nome = request.getParameter("nome");
		String identificacao = request.getParameter("identificacao");
		String hIni = request.getParameter("hIni");
		String hFim = request.getParameter("hFim");
		String dIni = request.getParameter("dIni");
		String dFim = request.getParameter("dFim");
		
		String status = request.getParameter("status");
	
		String descricao = request.getParameter("descricao");
		String cpf = request.getParameter("cpf");
		System.out.println("CPF PEGO FOI O :::::::"+cpf);
		//String cpf = (String)session.getAttribute("cpf"); // FUTURAMENTE PEGAR DO JSP
		
		ResponsavelProjeto rp = new ResponsavelProjeto();
		rp.setCpfResponsavel(cpf);
		rp.setIdentProjeto(identificacao);
		
		Projeto p = new Projeto();
		p = p.localizarProjeto(idProjeto);
		p.setNome(nome);
		p.setIdentificacao(identificacao);
		p.setHoraIni(hIni);
		p.setHoraFim(hFim);
		p.setDataIni(dIni);
		p.setDataFim(dFim);
		p.setCpfResponsavel(cpf);
		p.setStatus(status);
		p.setDescricao(descricao);
		p.setResponsavelProjeto(rp);
		
		request.setAttribute("idProjeto",p.getId());
		request.setAttribute("nome", p.getNome());
		request.setAttribute("idt", p.getIdentificacao());
		request.setAttribute("hIni", p.getHoraIni());
		request.setAttribute("hFim", p.getHoraFim());
		request.setAttribute("dIni", p.getDataIni());
		request.setAttribute("dFim", p.getDataFim());
		request.setAttribute("cpf", p.getCpfResponsavel());
		request.setAttribute("status", p.getStatus());
		request.setAttribute("descricao", p.getDescricao());
		
		
		boolean bool = p.updateProjeto(p);
		if(bool) {
			request.getRequestDispatcher("confirmadoUpdate.jsp").forward(request, response);
		}else {
			String erro ="Não alterou nada!";
			request.setAttribute("erro", erro);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
		
		
		
	}

}
