<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="br.ufscar.dc.dsw.util.Util" %>

<!DOCTYPE html>
<html>
<fmt:bundle basename="message">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home | Excellent Voyage</title>
    <link rel="stylesheet" href="styles/global.css" />
    <link rel="stylesheet" href="styles/home.css" />
    <link rel="stylesheet" href="styles/pacote.css" />
    <script type="text/javascript">
        var usuario = "<%= session.getAttribute("usuarioLogado")%>";
        if (usuario === "null") {
            window.location.href="login.jsp";
        }
    </script>
</head>
<body>
    <div class="home-container box">
        <jsp:include page="components/navbar.jsp" />
        <main>

            <div class="pacote-container">
            
                <div class="lista-fotos" var="fotos" items="${pacote.fotos}">
                <c:forEach  var="fotos" items="${pacote.fotos}">
                        <div class="foto" style="background-image: url('${fotos.url}');"></div>
                        <!--<div class="foto" style="background-image: url('assets/hero.png');"></div>
                        <div class="foto" style="background-image: url('assets/hero.png');"></div>-->
                </c:forEach>
                </div>       

                <div class="informacoes-pacote">
                        <div class="pacote-infos">
                            <h1>${pacote.destino.cidade}</h1>
                            <h2><fmt:message key="pacote.viagemPor"/> <strong>${pacote.agencia.nome}</strong></h2>
                            <p><fmt:message key="pacote.valor"/></p>
                            <h2 id="pacote-preco"><fmt:message key="listapacote.moeda"/>${pacote.valor}</h2>
                            <h2 id="info-adicionais"><fmt:message key="pacote.infos"/></h2>
                            <p><fmt:message key="pacote.estado"/></p>
                            <h3>${pacote.destino.estado}</h3>
                            <p><fmt:message key="pacote.pais"/></p>
                            <h3>${pacote.destino.pais}</h3>
                            <p><fmt:message key="pacote.dataPartida"/></p>
                            <h3>${Util.convertTimestampToString(pacote.dataPartida)}</h3>
                            <p><fmt:message key="pacote.duracao"/></p>
                            <h3>${pacote.duracaoDias}</h3>
                            <p><fmt:message key="pacote.descricao"/></p>
                            <h3 href="${pacote.descricao}"> <fmt:message key="pacote.descricao"/></h3>
                        </div>
                        <c:if test="${sessionScope.usuarioLogado.tipo == 'cliente'}">
                            <div class="pacote-compra">
                                <a href="/compra/${pacote.id}"><fmt:message key="pacote.comprar"/></a>
                            </div>
                        </c:if>
                </div>
            </div>
        </main>
</body>
</fmt:bundle>
</html>