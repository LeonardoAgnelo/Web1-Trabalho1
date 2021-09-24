package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Agencia;
import br.ufscar.dc.dsw.dao.ClienteDAO;
import br.ufscar.dc.dsw.dao.AgenciaDAO;
//import br.ufscar.dc.dsw.util.Erro;

@WebServlet(urlPatterns = "/perfil")
public class PerfilController extends HttpServlet {
    private static final long serialVersionUID = 1L;
	private ClienteDAO cDAO;
	private AgenciaDAO aDAO;

	@Override
    public void init() {
		cDAO = new ClienteDAO();
		aDAO = new AgenciaDAO();
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
    		response.sendRedirect(request.getContextPath());
    	} else if (usuario.getTipo().equals("admin")) {

            List<Cliente> listaCliente = cDAO.getAll();
            request.setAttribute("listaCliente", listaCliente);
            List<Agencia> listaAgencia = aDAO.getAll();
            request.setAttribute("listaAgencia", listaAgencia);

    		RequestDispatcher dispatcher = request.getRequestDispatcher("perfil.jsp");
            dispatcher.forward(request, response);
    	} else if(usuario.getTipo().equals("cliente")){

            RequestDispatcher dispatcher = request.getRequestDispatcher("perfil.jsp");
            dispatcher.forward(request, response);     
    	}else if (usuario.getTipo().equals("agencia")){      
            RequestDispatcher dispatcher = request.getRequestDispatcher("perfil.jsp");
            dispatcher.forward(request, response);
        }
    }
}