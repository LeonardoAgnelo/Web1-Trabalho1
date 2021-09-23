package br.ufscar.dc.dsw.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "logout", urlPatterns = { "/logoutController" })
public class LogoutController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        request.getSession().removeAttribute("usuarioLogado");
        response.sendRedirect("index.jsp");
	}
}
