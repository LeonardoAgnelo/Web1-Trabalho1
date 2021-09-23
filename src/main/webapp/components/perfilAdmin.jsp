<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<main>
    <div class="texto-inicio">
        <h1>
            Olá ${sessionScope.usuarioLogado.nome},
        </h1>
        <p>
            Lembre-se das suas viagens...
        </p>
    </div>
    
<div align="center">
		<table border="1">
			<caption>Lista de Clientes</caption>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>CPF</th>
				<th>Email</th>
				<th>Sexo</th>
				<th>Telefone</th>
				<th>Data nascimneto</th>
			</tr>
			<c:forEach var="Cliente" items="${requestScope.listaCliente}">
				<tr>
					<td>${Cliente.id}</td>
					<td>${Cliente.nome}</td>
					<td>${Cliente.cpf}</td>
					<td>${Cliente.email}</td>
					<td>${Cliente.sexo}</td>
					<td>${Cliente.telefone}</td>
                    <td>${Cliente.dataNascimento}</td>
			    </tr>
            </c:forEach>
</div>

<div align="center">

            <table border="1">
			<caption>Lista de Agencia</caption>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>CNPJ</th>
				<th>Email</th>

			</tr>
			<c:forEach var="Agencia" items="${requestScope.listaAgencia}">
				<tr>
                <td>${Agencia.id}</td>
					<td>${Agencia.nome}</td>
					<td>${Agencia.cnpj}</td>
					<td>${Agencia.email}</td>
                    <td><a href="">edição</td>
                    <td><a hrf></td>
                    
			    </tr>
			</c:forEach>
		</table>
	</div>
</main>
