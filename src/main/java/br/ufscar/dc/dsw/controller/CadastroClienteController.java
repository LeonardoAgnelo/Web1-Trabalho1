package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.ClienteDAO;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.util.Erro;
import br.ufscar.dc.dsw.util.Util;
import br.ufscar.dc.dsw.util.Validator;

@WebServlet(urlPatterns = { "/cadastroClienteController" })
public class CadastroClienteController extends HttpServlet{
    private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        Erro erros = new Erro();
        if (request.getParameter("bOK") != null) {
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String cpf = request.getParameter("cpf");
            String telefone = request.getParameter("telefone");
            String sexo = request.getParameter("sexo");
            Timestamp dataNascimento = Util.convertStringToTimestamp(request.getParameter("data-nascimento"));
            String senha = request.getParameter("senha");
            String confirmarSenha = request.getParameter("confirmar-senha");

            erros = new Validator<String>("Nome", nome).required().addErro(erros);
            erros = new Validator<String>("Email", email).required().email().addErro(erros);
            erros = new Validator<String>("CPF", cpf).required().addErro(erros);
            erros = new Validator<String>("Telefone", telefone).required().addErro(erros);
            erros = new Validator<String>("Sexo", sexo).required().addErro(erros);
            erros = new Validator<Timestamp>("Data de nascimento", dataNascimento).required().addErro(erros);
            erros = new Validator<String>("Senha", senha).required().addErro(erros);
            erros = new Validator<String>("Confirmação de senha", confirmarSenha).required().compare(senha).addErro(erros);

            if (!erros.isExisteErros()) {
                ClienteDAO dao = new ClienteDAO();
                Cliente cliente = new Cliente(nome, email, senha, "cliente", cpf, telefone, sexo, dataNascimento);
        
                dao.insert(cliente);

                request.getSession().setAttribute("usuarioLogado", cliente);
                response.sendRedirect("index.jsp");
            } else {
                request.getSession().invalidate();

                request.setAttribute("mensagens", erros);

                request.setAttribute("nome", nome);
                request.setAttribute("email", email);
                request.setAttribute("cpf", cpf);
                request.setAttribute("telefone", telefone);
                request.setAttribute("sexo", sexo);
                if (dataNascimento != null) {
                    request.setAttribute("dataNascimento", dataNascimento.toString());
                }

                RequestDispatcher rd = request.getRequestDispatcher("cadastroCliente.jsp");
                rd.forward(request, response);
            }
        }
	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
