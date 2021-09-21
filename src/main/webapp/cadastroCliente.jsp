<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro | Excellent Voyage</title>
    <link rel="stylesheet" href="styles/global.css" />
    <link rel="stylesheet" href="styles/cadastro-cliente.css" />
</head>
<body>
    <div class="cadastro-cliente-container box">
        <a class="botao-voltar" href="javascript:history.go(-1)"><img src="assets/icons/arrow-left.svg" />Voltar</a>
        <form class="form-cadastro-cliente">
            <h1>Formulário de cadastro</h1>
            <div class="campos">
                <div class="campo-container">
                    <label for="nome">Nome</label>
                    <input class="campo" id="nome" type="text"/>
                </div>
                <div class="campo-container">
                    <label for="email">Email</label>
                    <input class="campo" id="email" type="text"/>
                </div>
                <div class="campo-container">
                    <label for="cpf">Cpf</label>
                    <input class="campo" id="cpf" type="text"/>
                </div>
                <div class="campo-container">
                    <label for="telefone">Telefone</label>
                    <input class="campo" id="telefone" type="text"/>
                </div>
                <div class="campo-container">
                    <label for="sexo">Sexo</label>
                    <input class="campo" id="sexo" type="text"/>
                </div>
                <div class="campo-container">
                    <label for="data-nascimento">Data de nascimento</label>
                    <input class="campo" id="data-nascimento" type="text"/>
                </div>
                <div class="campo-container">
                    <label for="senha">Senha</label>
                    <input class="campo" id="senha" type="text"/>
                </div>
                <div class="campo-container">
                    <label for="confirmar-senha">Confirmar senha</label>
                    <input class="campo" id="confirmar-senha" type="text"/>
                </div>
            </div>
            <button type="submit">Cadastrar</button>
        </form>
    </div>
</body>
</html>
