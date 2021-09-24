<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<main>
    <div class="header-container">
        <div class="texto-inicio">
            <h1>
                Olá ${sessionScope.usuarioLogado.nome},
            </h1>
            <p>
                Confira os seus pacotes de viagens ofertados...
            </p>
        </div>
        <a href="adicionarPacote.jsp" type="submit" class="botao-adicionarpacote">
            Adcionar pacote
        </a>
    </div>
    
    <div class="pacotes-container">
        <button type="submit" class="botao-pacotesvigentes">
            Visualizar apenas pacotes vigentes
        </button>
        <jsp:include page="listaPacotes.jsp">
            <jsp:param name="comprar" value="false" />
        </jsp:include>
    </div>
</main>
