<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro | Excellent Voyage</title>
    <link rel="stylesheet" href="styles/global.css" />
    <link rel="stylesheet" href="styles/cadastro-agencia.css" />
    <script type="text/javascript">
        var usuario = "<%= session.getAttribute("usuarioLogado")%>";
        if (usuario !== "null") {
            window.location.href="index.jsp";
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
        <form class="form-cadastro-cliente" action="cadastroAgencia" method="POST" >
            <h1>Formulário de cadastro</h1>
            <div class="campos">
                <div class="campo-container">
                    <label for="nome">Nome</label>
                    <input class="campo" id="nome" name="nome" type="text" value="${nome}"/>
                </div>
                <div class="campo-container">
                    <label for="email">Email</label>
                    <input class="campo" id="email" name="email" type="email" value="${email}"/>
                </div>
                <div class="campo-container">
                    <label for="cnpj">CNPJ</label>
                    <input class="campo" id="cnpj" name="cnpj" type="text" value="${cnpj}"/>
                </div>
                <div class="campo-container">
                    <label for="senha">Senha</label>
                    <input class="campo" id="senha" name="senha" type="password"/>
                </div>
                <div class="campo-container">
                    <label for="descricao">Descrição</label>
                    <textarea class="campo" id="descricao" name="descricao" type="text">${descricao}</textarea>
                </div>
                <div class="campo-container">
                    <label for="confirmar-senha">Confirmar senha</label>
                    <input class="campo" id="confirmar-senha" name="confirmar-senha" type="password"/>
                </div>
            </div>
            <input class="submit" type="submit" name="bOK" value="Cadastrar" />
        </form>
    </div>
</body>
</html>
