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

import br.ufscar.dc.dsw.dao.ClienteDAO;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(urlPatterns = { "/cadastroClienteController" })
public class CadastroClienteController extends HttpServlet{
    private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        Erro erros = new Erro();
        if (request.getParameter("bOK") != null) {
            String nome = request.getParameter("nome");
            if (nome == null || nome.isEmpty()) {
                erros.add("Nome não informado!");
            }
            String email = request.getParameter("email");
            if (email == null || email.isEmpty()) {
                erros.add("email não informado!");
            }
            String cpf = request.getParameter("cpf");
            if (cpf == null || cpf.isEmpty()) {
                erros.add("cpf não informado!");
            }
            String telefone = request.getParameter("telefone");
            if (telefone == null || telefone.isEmpty()) {
                erros.add("telefone não informado!");
            }
            String sexo = request.getParameter("sexo");
            if (sexo == null || sexo.isEmpty()) {
                erros.add("sexo não informado!");
            }
            String dataNascimentoParam = request.getParameter("data-nascimento");
            if (dataNascimentoParam == null || dataNascimentoParam.isEmpty()) {
                erros.add("data nascimento não informado!");
            }
            Timestamp dataNascimento = null;
            
            if (dataNascimentoParam != null && !dataNascimentoParam.isEmpty()) {
                try {
                    DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    Date date = formatter.parse(dataNascimentoParam);
                    dataNascimento = new Timestamp(date.getTime());
                } catch (java.text.ParseException e) {
                    erros.add(e.toString());
                }
            }

            String senha = request.getParameter("senha");
            if (senha == null || senha.isEmpty()) {
                erros.add("senha não informado!");
            }

            if (!erros.isExisteErros()) {
                ClienteDAO dao = new ClienteDAO();
                Cliente cliente = new Cliente(nome, email, senha, "cliente", cpf, telefone, sexo, dataNascimento);
        
                dao.insert(cliente);
                response.sendRedirect("index.jsp");
            } else {
                request.setAttribute("mensagens", erros);

                RequestDispatcher rd = request.getRequestDispatcher("cadastroCliente.jsp");
                rd.forward(request, response);
            }
        }
	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        // request.setAttribute("mensagens", erros);
    }
}
