<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="lista-pacotes">
<fmt:bundle basename="message">
    <div class="pacote">
        <div class="pacote-image" style="background-image: url('assets/hero.png');"></div>
        <div class="pacote-content">
            <div class="pacote-dados">
                <strong> Cidade </strong>
                <p> <fmt:message key="listapacote.datapartida"/> </p>
                <p> 11/02/2021 </p>
            </div>
            <c:choose>
                <c:when test="${param.comprar}">
                    <div class="pacote-compra">
                        <span><fmt:message key="listapacote.moeda"/> 969</span>
                        <a href="pacote.jsp"> <fmt:message key="listapacote.comprar"/> </a>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="pacote-ver">
                        <a href="/pacote/1"> <fmt:message key="listapacote.detalhes"/> </a>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <div class="pacote">
        <div class="pacote-image" style="background-image: url('assets/hero.png');"></div>
        <div class="pacote-content">
            <div class="pacote-dados">
                <strong>Cidade</strong>
                <p>Data de partida</p>
                <p>10/12/19</p>
            </div>
            <c:choose>
                <c:when test="${param.comprar}">
                    <div class="pacote-compra">
                        <span>R$ 969</span>
                        <a href="pacote.jsp">Comprar</a>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="pacote-ver">
                        <a href="/pacote/1">Ver detalhes</a>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</fmt:bundle>
</div>
