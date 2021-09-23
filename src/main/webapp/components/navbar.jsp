<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="br.ufscar.dc.dsw.domain.Usuario" %>

<nav class="navbar-container">
    <img class="logo" src="assets/logo.svg" />

    <c:choose>
        <c:when test="${sessionScope.usuarioLogado != null}">
            <div class="right-side">
                <a href="perfil.jsp" class="botao-logado">
                    <img src="assets/icons/person-circle.svg"/> ${sessionScope.usuarioLogado.nome}
                </a>
                <a href="${pageContext.request.contextPath}/logout" class="botao-logado">
                    <img src="assets/icons/exit.svg"/> Sair
                </a>
            </div>
        </c:when>
        <c:otherwise>
            <div class="right-side">
                <a href="login.jsp" class="botao-login">
                    Login
                </a>
                <a href="cadastro.jsp" class="botao-cadastro">
                    Cadastre-se
                </a>
            </div>
        </c:otherwise>
    </c:choose>
</nav>