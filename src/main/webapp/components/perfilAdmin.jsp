<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
		String contextPath = request.getContextPath().replace("/", "");
	%>

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
				<th>Editar</th>
				<th>Remover</th>

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
					<td><a href="/<%=contextPath%>/ClienteEditar?id=${Cliente.id}">Edição </a></td>
					<td><a href="/<%= contextPath%>/UsuarioDelete?id=${Cliente.id}"
						onclick="return confirm('Tem certeza de que deseja excluir este usuário?');">Remover </a></td>

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
				<th>Editar</th>
				<th>Remover</th>

			</tr>
			<c:forEach var="Agencia" items="${requestScope.listaAgencia}">
				<tr>
                <td>${Agencia.id}</td>
					<td>${Agencia.nome}</td>
					<td>${Agencia.cnpj}</td>
					<td>${Agencia.email}</td>
                    <td><a href="/<%=contextPath%>/AgenciaEditar?id=${Agencia.id}">Edição </a></td>
                    <td><a href="/<%= contextPath%>/UsuarioDelete?id=${Agencia.id}"
						onclick="return confirm('Tem certeza de que deseja excluir este usuário?');">Remover </a></td>
                    
			    </tr>
			</c:forEach>
		</table>
	</div>
</main>
