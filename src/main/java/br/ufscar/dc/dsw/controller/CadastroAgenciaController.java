package br.ufscar.dc.dsw.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.AgenciaDAO;
import br.ufscar.dc.dsw.domain.Agencia;
import br.ufscar.dc.dsw.util.Erro;
import br.ufscar.dc.dsw.util.Validator;

@WebServlet(urlPatterns = { "/cadastroAgenciaController" })
public class CadastroAgenciaController extends HttpServlet{
    private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        Erro erros = new Erro();
        if (request.getParameter("bOK") != null) {
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String cnpj = request.getParameter("cnpj");
            String descricao = request.getParameter("descricao");
            String senha = request.getParameter("senha");
            String confirmarSenha = request.getParameter("confirmar-senha");

            erros = new Validator("Nome", nome).required().addErro(erros);
            erros = new Validator("Email", email).required().email().addErro(erros);
            erros = new Validator("CNPJ", cnpj).required().addErro(erros);
            erros = new Validator("Descrição", descricao).required().addErro(erros);
            erros = new Validator("Senha", senha).required().addErro(erros);
            erros = new Validator("Confirmação de senha", confirmarSenha).required().compare(senha).addErro(erros);


            if (!erros.isExisteErros()) {
                AgenciaDAO dao = new AgenciaDAO();
                Agencia agencia = new Agencia(nome, email, senha, "agencia", cnpj, descricao);

                dao.insert(agencia);
                response.sendRedirect("index.jsp");
            } else {
                request.setAttribute("mensagens", erros);

                request.setAttribute("nome", nome);
                request.setAttribute("email", email);
                request.setAttribute("cnpj", cnpj);
                request.setAttribute("descricao", descricao);

                RequestDispatcher rd = request.getRequestDispatcher("cadastroAgencia.jsp");
                rd.forward(request, response);
            }
        }
	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
