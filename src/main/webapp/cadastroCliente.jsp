<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro | Excellent Voyage</title>
    <link rel="stylesheet" href="styles/global.css" />
    <link rel="stylesheet" href="styles/cadastro-cliente.css" />
    <script type="text/javascript">
        var usuario = "<%= session.getAttribute("usuarioLogado")%>";
        if (usuario !== "null") {
            window.location.href="index.jsp";
        }
    </script>
</head>
<body>
    <div class="cadastro-cliente-container box">
        <a class="botao-voltar" href="javascript:history.go(-1)"><img src="assets/icons/arrow-left.svg" />Voltar</a>
        <c:if test="${mensagens.existeErros}">
            <div id="erro">
                <ul>
                    <c:forEach var="erro" items="${mensagens.erros}">
                        <li> ${erro} </li>
                        </c:forEach>
                </ul>
            </div>
        </c:if>
        <form method="POST" class="form-cadastro-cliente" action="cadastroCliente">
            <h1>Formulário de cadastro</h1>
            <div class="campos">
                <div class="campo-container">
                    <label for="nome">Nome</label>
                    <input class="campo" id="nome" name="nome" type="text"/>
                </div>
                <div class="campo-container">
                    <label for="email">Email</label>
                    <input class="campo" id="email" name="email" type="text"/>
                </div>
                <div class="campo-container">
                    <label for="cpf">CPF</label>
                    <input class="campo" id="cpf" name="cpf" type="text"/>
                </div>
                <div class="campo-container">
                    <label for="telefone">Telefone</label>
                    <input class="campo" id="telefone" name="telefone" name="telefone" type="text"/>
                </div>
                <div class="campo-container">
                    <label for="sexo">Sexo</label>
                    <select class="campo" id="sexo" name="sexo" name="sexo" type="text">
                        <option value="masculino">Masculino</option>
                        <option value="feminio">Feminio</option>
                    </select>
                </div>
                <div class="campo-container">
                    <label for="data-nascimento">Data de nascimento</label>
                    <input class="campo" id="data-nascimento" name="data-nascimento" type="date"/>
                </div>
                <div class="campo-container">
                    <label for="senha">Senha</label>
                    <input class="campo" id="senha" name="senha" type="password"/>
                </div>
                <div class="campo-container">
                    <label for="confirmar-senha">Confirmar senha</label>
                    <input class="campo" id="confirmar-senha" name="confirmar-senha" type="password"/>
                </div>
            </div>
            <input class="submit" type="submit" name="bOK" value="Cadastrar" />
        </form>
    </div>
</body>
</html>
