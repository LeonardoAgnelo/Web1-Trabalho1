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

import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.dao.ClienteDAO;
import br.ufscar.dc.dsw.util.Erro;
import br.ufscar.dc.dsw.util.Validator;

@WebServlet(urlPatterns = { "/ClienteUpdate" })
public class ClienteUpdateController extends HttpServlet{
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
    String cpf = request.getParameter("cpf");
    String telefone = request.getParameter("telefone"); 
    String sexo = request.getParameter("sexo"); 
    String dataNascimentoParam = request.getParameter("data-nascimento");
    String senha = request.getParameter("senha");
    String confirmarSenha = request.getParameter("confirmar-senha");

    erros = new Validator("Nome", nome).required().addErro(erros);
    erros = new Validator("Email", email).required().email().addErro(erros);
    erros = new Validator("CPF", cpf).required().addErro(erros);
    erros = new Validator("Telefone", telefone).required().addErro(erros);
    erros = new Validator("Sexo", sexo).required().addErro(erros);
    erros = new Validator("Data de nascimento", dataNascimentoParam).required().addErro(erros);
    erros = new Validator("Senha", senha).required().addErro(erros);
    erros = new Validator("Confirmação de senha", confirmarSenha).required().compare(senha).addErro(erros);

    Timestamp dataNascimento = null;
    
    if (dataNascimentoParam != null && !dataNascimentoParam.isEmpty()) {
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(dataNascimentoParam);
            dataNascimento = new Timestamp(date.getTime());
        } catch (java.text.ParseException e) {
            erros.add(e.toString());
        }
    }
    if (!erros.isExisteErros()) {
        ClienteDAO dao = new ClienteDAO();
        Cliente cliente = new Cliente(id, nome, email, senha, "cliente", cpf, telefone, sexo, dataNascimento);

        dao.update(cliente);

        response.sendRedirect("perfil");
    } else {
        request.getSession().invalidate();

        request.setAttribute("mensagens", erros);

        request.setAttribute("nome", nome);
        request.setAttribute("email", email);
        request.setAttribute("cpf", cpf);
        request.setAttribute("telefone", telefone);
        request.setAttribute("sexo", sexo);
        request.setAttribute("dataNascimento", dataNascimentoParam);

        RequestDispatcher rd = request.getRequestDispatcher("admin/FormularioEdicaoCliente.jsp");
        rd.forward(request, response);

    }
}
}
