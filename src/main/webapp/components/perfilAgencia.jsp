<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<main>
<fmt:bundle basename="message">
    <div class="header-container">
        <div class="texto-inicio">
            <h1>
                <fmt:message key="agencia.saudacao"/> ${sessionScope.usuarioLogado.nome},
            </h1>
            <p>
                <fmt:message key="agencia.text"/>
            </p>
        </div>
        <a href="adicionarPacote.jsp" type="submit" class="botao-adicionarpacote">
            <fmt:message key="agencia.addPacote"/>
        </a>
    </div>
    
    <div class="pacotes-container">
        <button type="submit" class="botao-pacotesvigentes">
            <fmt:message key="agencia.pacotesVigentes"/>
        </button>
        <jsp:include page="listaPacotes.jsp">
            <jsp:param name="comprar" value="false" />
        </jsp:include>
    </div>
</fmt:bundle>
</main>
