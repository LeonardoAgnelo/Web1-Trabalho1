<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login | Excellent Voyage</title>
    <link rel="stylesheet" href="styles/global.css" />
    <link rel="stylesheet" href="styles/login.css" />
</head>
<body>
    <div class="login-container box">
        <a class="botao-voltar" href="javascript:history.go(-1)"><img src="assets/icons/arrow-left.svg" />Voltar</a>
        <img class="logo" src="assets/logo.svg" />
        <form class="form-login">
            <h1>Login</h1>
            <input type="text" class="campo" placeholder="Digite seu e-mail" />
            <input type="password" class="campo" placeholder="Digite sua senha" />
            <button type="submit" >Entrar</button>
            <a href="cadastro.jsp">cadastre-se</a>
        </form>
    </div>
</body>
</html>
