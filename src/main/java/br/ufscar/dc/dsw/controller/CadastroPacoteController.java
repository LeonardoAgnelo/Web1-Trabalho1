package br.ufscar.dc.dsw.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.PacoteTuristicoDAO;
import br.ufscar.dc.dsw.domain.Agencia;
import br.ufscar.dc.dsw.domain.Destino;
import br.ufscar.dc.dsw.domain.Foto;
import br.ufscar.dc.dsw.domain.PacoteTuristico;
import br.ufscar.dc.dsw.util.Erro;
import br.ufscar.dc.dsw.util.Util;
import br.ufscar.dc.dsw.util.Validator;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import static br.ufscar.dc.dsw.util.Constants.*;

public class CadastroPacoteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        Erro erros = new Erro();
        if (request.getParameter("bOK") != null) {
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            String pais = request.getParameter("pais");
            Timestamp dataPartida = Util.convertStringToTimestamp(request.getParameter("data-partida"));
            Integer duracaoDias = Integer.parseInt(request.getParameter("duracao-dias"));
            Float valor = Float.parseFloat(request.getParameter("valor"));
            String descricao = request.getParameter("descricao");

            erros = new Validator<String>("Cidade", cidade).required().addErro(erros);
            erros = new Validator<String>("Estado", estado).required().addErro(erros);
            erros = new Validator<String>("País", pais).required().addErro(erros);
            erros = new Validator<String>("Data de partida", dataPartida.toString()).required().addErro(erros);
            erros = new Validator<String>("duracaoDias", duracaoDias.toString()).required().addErro(erros);
            erros = new Validator<String>("valor", valor.toString()).required().addErro(erros);
            erros = new Validator<String>("descricao", descricao).required().addErro(erros);

            if (ServletFileUpload.isMultipartContent(request)) {
                DiskFileItemFactory factory = new DiskFileItemFactory();
                factory.setSizeThreshold(MEMORY_THRESHOLD);
                factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

                ServletFileUpload upload = new ServletFileUpload(factory);
                upload.setFileSizeMax(MAX_FILE_SIZE);
                upload.setSizeMax(MAX_REQUEST_SIZE);
                // String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
                // File uploadDir = new File(uploadPath);
                // if (!uploadDir.exists()) {
                //     uploadDir.mkdir();
                // }

                try {
                    List<FileItem> formItems = upload.parseRequest(request);
    
                    if (formItems != null && formItems.size() > 0) {
                        for (FileItem item : formItems) {
                            if (!item.isFormField()) {
                                String fileName = new File(item.getName()).getName();
                                // String filePath = uploadPath + File.separator + fileName;
                                // File storeFile = new File(filePath);
                                // item.write(storeFile);
                                erros.add(fileName);
                            }
                        }
                    }
                } catch (Exception ex) {
                    erros.add("There was an error: " + ex.getMessage());
                }
            }

            if (!erros.isExisteErros()) {
                Agencia agencia = (Agencia) request.getSession().getAttribute("usuarioLogado");
                Destino destino = new Destino(cidade, estado, pais);
                List<Foto> fotos = new ArrayList<Foto>();
                PacoteTuristicoDAO dao = new PacoteTuristicoDAO();
                PacoteTuristico pacoteTuristico = new PacoteTuristico(agencia, destino, dataPartida, duracaoDias, valor, descricao, 0, fotos);
        
                dao.insert(pacoteTuristico);

                response.sendRedirect("perfil.jsp");
            } else {
                request.getSession().invalidate();

                request.setAttribute("mensagens", erros);

                request.setAttribute("cidade", cidade);
                request.setAttribute("estado", estado);
                request.setAttribute("pais", pais);
                if (dataPartida != null) {
                    request.setAttribute("data-partida", dataPartida.toString());
                }
                request.setAttribute("duracao-dias", duracaoDias);
                request.setAttribute("valor", valor);
                request.setAttribute("descricao", descricao);

                RequestDispatcher rd = request.getRequestDispatcher("cadastroCliente.jsp");
                rd.forward(request, response);
            }
        }
    }
}
