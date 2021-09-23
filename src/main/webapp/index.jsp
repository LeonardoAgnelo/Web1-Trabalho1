<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home | Excellent Voyage</title>
    <link rel="stylesheet" href="styles/global.css" />
    <link rel="stylesheet" href="styles/home.css" />
</head>
<body>
    <div class="home-container box">
        <jsp:include page="components/navbar.jsp" />
        <main>
            <div class="hero-container">
                <p>
                    A viagem dos seus sonhos começa aqui.
                </p>
                <img src="assets/hero.png" />
            </div>
            <div class="pacotes-container">
                <div class="filtro">
                    <input type="text" class="campo" placeholder="Escolha um destino" style="width: 350px;" />
                    <input type="text" class="campo" placeholder="Escolha uma agência" style="width: 350px;" />
                    <input type="text" class="campo" placeholder="Data de partida" onfocus="(this.type='date')" style="width: 250px;"/>
                    <button type="submit" class="botao-filtrar">
                        Filtrar
                    </button>
                </div>
                <jsp:include page="components/listaPacotes.jsp">
                    <jsp:param name="comprar" value="true" />
                </jsp:include>
            </div>
        </main>
    </div>
</body>
</html>
