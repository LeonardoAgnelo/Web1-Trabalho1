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
        <nav class="navbar-container">
            <img class="logo" src="assets/logo.svg" />
            <div class="right-side">
                <a href="login.jsp" class="botao-login">
                    Login
                </a>
                <a href="cadastro.jsp" class="botao-cadastro">
                    Cadastre-se
                </a>
            </div>
        </nav>
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
                <div class="lista-pacotes">
                    <div class="pacote">
                        <div class="pacote-image" style="background-image: url('assets/hero.png');"></div>
                        <div class="pacote-content">
                            <div class="pacote-dados">
                                <strong>Cidade</strong>
                                <p>Data de partida</p>
                                <p>10/12/19</p>
                            </div>
                            <div class="pacote-compra">
                                <span>R$ 969</span>
                                <a href="/compra/1">Comprar</a>
                            </div>
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
                            <div class="pacote-compra">
                                <span>R$ 969</span>
                                <a href="/compra/1">Comprar</a>
                            </div>
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
                            <div class="pacote-compra">
                                <span>R$ 969</span>
                                <a href="/compra/1">Comprar</a>
                            </div>
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
                            <div class="pacote-compra">
                                <span>R$ 969</span>
                                <a href="/compra/1">Comprar</a>
                            </div>
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
                            <div class="pacote-compra">
                                <span>R$ 969</span>
                                <a href="/compra/1">Comprar</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</body>
</html>
