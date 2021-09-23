<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<main>
    <div class="texto-inicio">
        <h1>
            Olá ${sessionScope.usuarioLogado.nome},
        </h1>
        <p>
            Lembre-se das suas viagens...
        </p>
    </div>
    
    <div class="pacotes-container">
        <jsp:include page="listaPacotes.jsp">
            <jsp:param name="comprar" value="false" />
        </jsp:include>
    </div>
</main>
