package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.PacoteTuristicoDAO;
import br.ufscar.dc.dsw.domain.PacoteTuristico;
import br.ufscar.dc.dsw.util.Util;

@WebServlet(urlPatterns = { "/home" })
public class IndexController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        PacoteTuristicoDAO pacoteDao = new PacoteTuristicoDAO();

        String destino = request.getParameter("destino");
        String agencia = request.getParameter("agencia");
        Timestamp dataPartida = Util.convertStringToTimestamp(request.getParameter("data-partida"));

        List<PacoteTuristico> listaPacotes = pacoteDao.getAll(destino, agencia, dataPartida);

        request.setAttribute("listaPacotes", listaPacotes);

        request.setAttribute("destino", destino);
        request.setAttribute("agencia", agencia);
        request.setAttribute("dataPartida", request.getParameter("data-partida"));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}
