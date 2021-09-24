package br.ufscar.dc.dsw.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.PacoteTuristico;
import br.ufscar.dc.dsw.dao.PacoteTuristicoDAO;
//import br.ufscar.dc.dsw.util.Erro;

@WebServlet(urlPatterns = "/pacote")
public class PacoteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
	private PacoteTuristicoDAO pDAO;

	@Override
    public void init() {
		pDAO = new PacoteTuristicoDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
    	//Erro erros = new Erro();

        if (usuario == null) {
            response.sendRedirect("/ExcellentVoyage/login.jsp");
        } else if (usuario.getTipo().equals("cliente")){
            Integer id =Integer.parseInt(request.getParameter("id"));

            PacoteTuristico pacote = pDAO.getById(id);
            request.setAttribute("pacote", pacote);
            RequestDispatcher dispatcher = request.getRequestDispatcher("pacote.jsp");
			dispatcher.forward(request, response);

        }else{
            response.sendRedirect("/ExcellentVoyage/index.jsp");
        }

    }
}