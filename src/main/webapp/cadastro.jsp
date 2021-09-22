<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro | Excellent Voyage</title>
    <link rel="stylesheet" href="styles/global.css" />
    <link rel="stylesheet" href="styles/cadastro.css" />
    <script type="text/javascript">
        var usuario = "<%= session.getAttribute("usuarioLogado")%>";
        if (usuario !== "null") {
            window.location.href="index.jsp";
        }
    </script>
</head>
<body>
    <div class="cadastro-container box">
        <a class="botao-voltar" href="javascript:history.go(-1)"><img src="assets/icons/arrow-left.svg" />Voltar</a>
        <img class="logo" src="assets/logo.svg" />
        <h1>Cadastre-se</h1>
        <div class="opcoes-usuario">
            <div class="opcao">
                <img src="assets/icons/airplane.svg"/>
                <a href="cadastroAgencia.jsp">Sou uma agência</a>
            </div>
            <div class="opcao">
                <img src="assets/icons/person.svg"/>
                <a href="cadastroCliente.jsp">Sou um cliente</a>
            </div>
        </div>
    </div>
</body>
</html>
