package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Tarefa;


@WebServlet("/ServletIrTarefa")
public class ServletIrTarefa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletIrTarefa() {
        super();

    }
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String id = request.getParameter("idTarefa");
		
		System.out.println("ID PEGO>>>>>"+id);
		
		int idTarefa  = Integer.parseInt(id.trim());
		Tarefa t = new Tarefa();
		t = t.localizarTarefa(idTarefa);
		if(t!=null) {
			int tempoIni = t.calcPrazo(t.getDataIni());
			request.setAttribute("prazoComeca", tempoIni);
			int tempoFim = t.calcPrazo(t.getDataFim());
			request.setAttribute("prazoTermina", tempoFim);
			
			
			request.setAttribute("nome", t.getNome());
			request.setAttribute("idTarefa", t.getId());
			request.setAttribute("hIni", t.getHoraIni());
			request.setAttribute("hFim", t.getHoraFim());
			request.setAttribute("descricao", t.getDescricao());
			request.setAttribute("dIni", t.getDataIni());
			request.setAttribute("dFim", t.getDataFim());
			request.setAttribute("identificacao", t.getIdentificacao());
			request.setAttribute("status",t.getStatus());
			if(t.getProjeto()!= null) {
			request.setAttribute("projeto", t.getProjeto().getNome());
			}
			request.getRequestDispatcher("irTarefa.jsp").forward(request, response);
		}else {
			System.out.println("TNC PROGRAMA");
		}
	
	}

}
