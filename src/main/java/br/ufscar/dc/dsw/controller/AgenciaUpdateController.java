package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.domain.Agencia;
import br.ufscar.dc.dsw.dao.AgenciaDAO;
import br.ufscar.dc.dsw.util.Erro;
import br.ufscar.dc.dsw.util.Validator;

@WebServlet(urlPatterns = { "/AgenciaUpdate" })
public class AgenciaUpdateController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			doGet(request, response);
		}
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");

    Erro erros = new Erro();
				
    Long id = Long.parseLong(request.getParameter("id"));
    String nome = request.getParameter("nome");
    String email = request.getParameter("email");
    String cnpj = request.getParameter("cnpj");
    String descricao = request.getParameter("descricao");
    String senha = request.getParameter("senha");
    String confirmarSenha = request.getParameter("confirmar-senha");

    erros = new Validator<String>("Nome", nome).required().addErro(erros);
    erros = new Validator<String>("Email", email).required().email().addErro(erros);
    erros = new Validator<String>("CNPJ", cnpj).required().addErro(erros);
    erros = new Validator<String>("Descrição", descricao).required().addErro(erros);
    erros = new Validator<String>("Senha", senha).required().addErro(erros);
    erros = new Validator<String>("Confirmação de senha", confirmarSenha).required().compare(senha).addErro(erros);

    if (!erros.isExisteErros()) {
        AgenciaDAO dao = new AgenciaDAO();
        Agencia agencia = new Agencia(id, nome, email, senha, "agencia", cnpj, descricao);

        dao.update(agencia);

        response.sendRedirect("perfil");
    } else {
        request.getSession().invalidate();

        request.setAttribute("mensagens", erros);

        request.setAttribute("id", id);
        request.setAttribute("nome", nome);
        request.setAttribute("email", email);
        request.setAttribute("cnpj", cnpj);
        request.setAttribute("descricao", descricao);

        RequestDispatcher rd = request.getRequestDispatcher("admin/FormularioEdicaoAgencia.jsp");
        rd.forward(request, response);

    }
}
}
