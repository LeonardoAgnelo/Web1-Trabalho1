<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
</head>
<body>
    <div class="home-container box">
        <jsp:include page="components/navbar.jsp" />
        <main>
            <div class="pacote-container">
                <div class="lista-fotos">
                        <div class="foto" style="background-image: url('assets/hero.png');"></div>
                        <div class="foto" style="background-image: url('assets/hero.png');"></div>
                        <div class="foto" style="background-image: url('assets/hero.png');"></div>
                </div>       
                    

                <div class="informacoes-pacote">
                        <div class="pacote-infos">
                            <h1>Cidade</h1>
                            <h2><fmt:message key="pacote.viagemPor"/> <strong>Delano</strong></h2>
                            <p><fmt:message key="pacote.valor"/></p>
                            <h2 id="pacote-preco">R$ 700,00</h2>
                            <h2 id="info-adicionais"><fmt:message key="pacote.infos"/></h2>
                            <p><fmt:message key="pacote.estado"/></p>
                            <h3>São Paulo</h3>
                            <p><fmt:message key="pacote.pais"/></p>
                            <h3>Brasil</h3>
                            <p><fmt:message key="pacote.dataPartida"/></p>
                            <h3>20/09/2021</h3>
                            <p><fmt:message key="pacote.duracao"/></p>
                            <h3>12 dias</h3>
                            <p><fmt:message key="pacote.descricao"/></p>
                            <h3>Arquivo aqui</h3>
                        </div>
                        <div class="pacote-compra">
                            <a href="/compra/1"><fmt:message key="pacote.comprar"/></a>
                        </div>
                </div>
            </div>
        </main>
</body>
</fmt:bundle>
</html>