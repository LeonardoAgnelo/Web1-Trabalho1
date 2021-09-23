<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login | Excellent Voyage</title>
    <link rel="stylesheet" href="styles/global.css" />
    <link rel="stylesheet" href="styles/login.css" />
    <script type="text/javascript">
        var usuario = "<%= session.getAttribute("usuarioLogado")%>";
        if (usuario !== "null") {
            window.location.href="index.jsp";
        }
    </script>
</head>
<body>
    <c:set var="session" scope = "session" />
    <div class="login-container box">
        <a class="botao-voltar" href="javascript:history.go(-1)"><img src="assets/icons/arrow-left.svg" />Voltar</a>
        <img class="logo" src="assets/logo.svg" />
        <c:if test="${mensagens.existeErros}">
            <div class="form-erro">
                <ul>
                    <c:forEach var="erro" items="${mensagens.erros}">
                        <li> ${erro} </li>
                        </c:forEach>
                </ul>
            </div>
        </c:if>
        <form class="form-login" action="login" method="POST">
            <h1>Login</h1>
            <input type="text" name="email" class="campo" placeholder="Digite seu e-mail" value="${email}"/>
            <input type="password" name="senha" class="campo" placeholder="Digite sua senha" />
            <input type="submit" name="bOK" value="Entrar"/>
            <a href="cadastro.jsp">cadastre-se</a>
        </form>
    </div>
</body>
</html>
