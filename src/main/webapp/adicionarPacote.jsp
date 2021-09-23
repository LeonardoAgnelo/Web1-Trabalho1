<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Adicionar pacote | Excellent Voyage</title>
    <link rel="stylesheet" href="styles/global.css" />
    <link rel="stylesheet" href="styles/cadastro-cliente.css" />
    <script type="text/javascript">
        var usuario = "<%= session.getAttribute("usuarioLogado")%>";
        if (usuario === "null") {
            window.location.href="login.jsp";
        }
    </script>
</head>
<body>
    <div class="cadastro-cliente-container box">
        <a class="botao-voltar" href="javascript:history.go(-1)"><img src="assets/icons/arrow-left.svg" />Voltar</a>
        <c:if test="${mensagens.existeErros}">
            <div class="form-erro">
                <ul>
                    <c:forEach var="erro" items="${mensagens.erros}">
                        <li> ${erro} </li>
                        </c:forEach>
                </ul>
            </div>
        </c:if>
        <form class="form-cadastro-cliente" action="adicionarPacote" method="POST" >
            <h1>Adicionar pacote</h1>
            <div class="campos">
                <div class="campo-container">
                    <label for="cidade">Cidade</label>
                    <input class="campo" id="cidade" name="cidade" type="text" value="${cidade}"/>
                </div>
                <div class="campo-container">
                    <label for="estado">Estado</label>
                    <input class="campo" id="estado" name="estado" type="text" value="${estado}"/>
                </div>
                <div class="campo-container">
                    <label for="pais">País</label>
                    <input class="campo" id="pais" name="pais" type="text" value="${pais}"/>
                </div>
                <div class="campo-container">
                    <label for="data-partida">Data de partida</label>
                    <input class="campo" id="data-partida" name="data-partida" type="date" value="${dataPartida}"/>
                </div>
                <div class="campo-container">
                    <label for="valor">Valor (em R$)</label>
                    <input class="campo" id="valor" name="valor" type="valor" value="${valor}"/>
                </div>
                <div class="campo-container">
                    <label for="duracao">Duração (em dias)</label>
                    <input class="campo" id="duracao" name="duracao" type="text" value="${duracao}"/>
                </div>
                <div class="campo-container">
                    <label for="descricao">Descrição</label>
                    <input type="hidden" id="descricao" name="descricao" value="${descricao}" />
                    <input style="font-size: 20px;" type="file"/>
                </div>
                <div class="campo-container">
                    <label for="foto">Fotos</label>
                    <input type="hidden" id="foto" name="foto" value="${foto}" />
                    <input style="font-size: 20px;" type="file"/>
                </div>
            </div>
            <input class="submit" type="submit" name="bOK" value="Adicionar" />
        </form>
    </div>
</body>
</html>
