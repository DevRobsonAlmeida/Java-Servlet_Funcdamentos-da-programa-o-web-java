<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/listaEmpresa" var="linkServeletListaEmpresa" />
<c:url value="/formNovaEmpresa.jsp" var="cadastroEmpresa" />
<!DOCTYPE html>
<html>
    <body>
        <c:if test="${not empty nomeEmpresa}" >
            <p> Empresa ${nomeEmpresa} -  <fmt:formatDate value="${dataAbertura}" pattern="dd/MM/yyyy" /> cadastrada com sucesso !</p>
        </c:if>

        <c:if test="${empty nomeEmpresa}" >
            <p> Nenhuma empresa cadastrada ! </p>
        </c:if> 

        <a href="${cadastroEmpresa}"><button> Cadastrar Empresa </button></a>
        <a href="${linkServeletListaEmpresa}"><button> Lista de Empresas </button></a>
    </body>
</html>
