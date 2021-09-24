<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<fmt:bundle basename="message">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> <fmt:message key="index.title" /> | Excellent Voyage</title>
    <link rel="stylesheet" href="styles/global.css" />
    <link rel="stylesheet" href="styles/home.css" />
</head>
<body>
    <div class="home-container box">
        <jsp:include page="components/navbar.jsp" />
        <main>
            <div class="hero-container">
                <p>
                    <fmt:message key="index.text"/> 
                </p>
                <img src="assets/hero.png" />
            </div>
            <div class="pacotes-container">
                <div class="filtro">
                    <input type="text" class="campo" placeholder="<fmt:message key='index.destino'/>" style="width: 350px;" />
                    <input type="text" class="campo" placeholder="<fmt:message key='index.agencia'/>" style="width: 350px;" />
                    <input type="text" class="campo" placeholder="<fmt:message key='index.data'/>" onfocus="(this.type='date')" style="width: 250px;"/>
                    <button type="submit" class="botao-filtrar">
                        <fmt:message key="index.filtro"/>
                    </button>
                </div>
                <jsp:include page="components/listaPacotes.jsp">
                    <jsp:param name="comprar" value="true" />
                </jsp:include>
            </div>
        </main>
    </div>
</body>

</fmt:bundle>
</html>
