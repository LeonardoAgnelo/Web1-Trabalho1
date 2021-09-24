package br.ufscar.dc.dsw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.dao.UsuarioDAO;


@WebServlet(urlPatterns = { "/ClienteDelete" })
public class ClienteDeleteController extends HttpServlet{
    private static final long serialVersionUID = 1L;
	private UsuarioDAO dao;

	@Override
    public void init() {
        dao = new UsuarioDAO();
    }
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			doGet(request, response);
		}
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {

                Long id = Long.parseLong(request.getParameter("id"));
		
				Usuario usuario = new Usuario(id);
				dao.delete(usuario);
				response.sendRedirect("perfil");
    }
}