<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil | Excellent Voyage</title>
    <link rel="stylesheet" href="styles/global.css" />
    <link rel="stylesheet" href="styles/home.css" />
    <link rel="stylesheet" href="styles/perfil-cliente.css" />
    <link rel="stylesheet" href="styles/perfil-agencia.css" />
</head>
<body>
    <div class="home-container box">

        <nav class="navbar-container">
            <img class="logo" src="assets/logo.svg" />
            <div class="right-side">
                <a href="perfilusuario.jsp" class="botao-perfil">
                    Perfil
                </a>
                <a href="index.jsp" class="botao-perfil">
                    Sair
                </a>
            </div>
        </nav>
        <main>
            <div class="hero-container2">
                <div class="texto-inicio">
                    <h1>
                        Olá Agência,
                    </h1>
                    <p>
                        Confira os seus pacotes de viagens ofertados...
                    </p>
                </div>
                <button type="submit" class="botao-adicionarpacote">
                    Adcionar pacote
                </button>

            </div>
            
            <div class="pacotes-container">
                <button type="submit" class="botao-pacotesvigentes">
                    Visualizar apenas pacotes vigentes
                </button>
                <div class="lista-pacotes">
                    <div class="pacote">
                        <div class="pacote-image" style="background-image: url('assets/hero.png');"></div>
                        <div class="pacote-content">
                            <div class="pacote-dados">
                                <strong>Cidade</strong>
                                <p>Data de partida</p>
                                <p>10/12/19</p>
                            </div>
                            <div class="pacote-ver">
                                <a href="/compra/1">Ver detalhes</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
    
</body>