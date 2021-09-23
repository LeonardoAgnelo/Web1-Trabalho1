<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil | Excellent Voyage</title>
    <link rel="stylesheet" href="styles/global.css" />
    <link rel="stylesheet" href="styles/perfil.css" />
    <script type="text/javascript">
        var usuario = "<%= session.getAttribute("usuarioLogado")%>";
        if (usuario === "null") {
            window.location.href="login.jsp";
        }
    </script>
</head>
<body>
    <div class="perfil-container box">
        <jsp:include page="components/navbar.jsp" />
        <c:if test="${sessionScope.usuarioLogado.tipo == 'agencia'}">
            <jsp:include page="components/perfilAgencia.jsp"/>
        </c:if>
        <c:if test="${sessionScope.usuarioLogado.tipo == 'cliente'}">
            <jsp:include page="components/perfilCliente.jsp"/>
        </c:if>
        <c:if test="${sessionScope.usuarioLogado.tipo == 'admin'}">
            <p>Admin</p>
        </c:if>
    </div>
</body>
</html>
