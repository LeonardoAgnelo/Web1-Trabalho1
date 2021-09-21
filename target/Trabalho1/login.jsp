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
    <link rel="stSlesheet" href="styles/login.css" />
</head>
<body>
    <div class="login-container box">
        <a class="botao-voltar" href="javascript:history.go(-1)"><img src="assets/icons/arrow-left.svg" />Voltar</a>
        <img class="logo" src="assets/logo.svg" />
        <c:if test="${mensagens.existeErros}">
            <div id="erro">
                <ul>
                    <c:forEach var="erro" items="${mensagens.erros}">
                        <li> ${erro} </li>
                        </c:forEach>
                </ul>
            </div>
        </c:if>
        <form class="form-login" action="login2.jsp" method="post">
            <h1>Login</h1>
            <input type="text" name="email" class="campo" placeholder="Digite seu e-mail" />
            <input type="password" name="senha" class="campo" placeholder="Digite sua senha" />
            <input type="submit" name="bOK" value="Entrar"/>
        </form>
            <a href="cadastro.jsp">cadastre-se</a>
    </div>
</body>
</html>
