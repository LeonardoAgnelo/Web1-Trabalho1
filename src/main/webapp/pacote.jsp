<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
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
                            <h2>Viagem promovida por <strong>Delano</strong></h2>
                            <p>Valor</p>
                            <h2 id="pacote-preco">R$ 700,00</h2>
                            <h2 id="info-adicionais">Informações adicionais</h2>
                            <p>Estado</p>
                            <h3>São Paulo</h3>
                            <p>País</p>
                            <h3>Brasil</h3>
                            <p>Data de partida</p>
                            <h3>20/09/2021</h3>
                            <p>Duração</p>
                            <h3>12 dias</h3>
                        </div>
                        <div class="pacote-compra">
                            <a href="/compra/1">Comprar</a>
                        </div>
                </div>
            </div>
        </main>
</body>