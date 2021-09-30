package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.mail.internet.InternetAddress;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.util.EmailService;
import br.ufscar.dc.dsw.util.Util;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Compra;
import br.ufscar.dc.dsw.domain.PacoteTuristico;
import br.ufscar.dc.dsw.dao.CompraDAO;
import br.ufscar.dc.dsw.dao.PacoteTuristicoDAO;

@WebServlet(urlPatterns = "/pacote")
public class PacoteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
	private PacoteTuristicoDAO pDAO;
	private CompraDAO coDAO;

	@Override
    public void init() {
		pDAO = new PacoteTuristicoDAO();
        coDAO = new CompraDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");

        PacoteTuristico pacote = pDAO.getById(id);
        request.setAttribute("pacote", pacote);

        String comprou = request.getParameter("comprou");

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");

        if (usuario == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        if (usuario.getTipo().equals("cliente")) {
            Cliente cliente = (Cliente) usuario;

            Boolean clienteComprou = coDAO.verificaCompraClienteByIdPacote(cliente, id);

            request.setAttribute("jacomprou", clienteComprou);

            if (comprou != null && comprou.equals("1")) {
    
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date date = new java.util.Date();
                date.setTime(date.getTime() + 1000 * 60 * 60 * 24 * 7);
                String dataReuniaoDate = dateFormat.format(date);

                String linkReuniao = "meet.google.com/" + UUID.randomUUID().toString();
    
                Timestamp dataReuniao = Util.convertStringToTimestamp(dataReuniaoDate);
                Compra compra = new Compra(cliente, pacote, dataReuniao, linkReuniao);
                coDAO.insert(compra);

                EmailService service = new EmailService();

                InternetAddress from = new InternetAddress("contatoexcellentvoyage@gmail.com", "Excellent Voyage");
		        InternetAddress toCliente = new InternetAddress(cliente.getEmail(), cliente.getNome());
		        InternetAddress toAgencia = new InternetAddress(pacote.getAgencia().getEmail(), pacote.getAgencia().getNome());

                String subject = "Compra efetuada!";

                String body = "<div>" +
                    "<h1>" + cliente.getNome() + " efetuou uma compra para " + pacote.getDestino().getCidade() + "</h1>" +
                    "<p>Uma reunião foi marcada para o dia " + Util.convertTimestampToString(pacote.getDataPartida()) +" as 19h</p>" +
                    "<p>Link da reunião: " + linkReuniao + "</p>" +
                "</div>";

                service.send(from, toCliente, subject, body);
                service.send(from, toAgencia, subject, body);

                request.setAttribute("jacomprou", true);
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("pacote.jsp");
        dispatcher.forward(request, response);
    }
}