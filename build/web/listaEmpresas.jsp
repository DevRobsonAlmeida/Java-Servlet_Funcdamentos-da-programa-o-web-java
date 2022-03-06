<%@page import="java.util.List, br.com.alura.empresa.entity.Empresa" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="formNovaEmpresa.jsp" var="cadastroEmpresa" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Empresas</title>
    </head>
    <body>
        <c:if test="${not empty nomeEmpresa}" >
            <p> Empresa ${nomeEmpresa} -  <fmt:formatDate value="${dataAbertura}" pattern="dd/MM/yyyy" /> cadastrada com sucesso !</p>
        </c:if>
            
        <h3> Lista de empresas </h3> 
        <a href="${cadastroEmpresa}"><button> Cadastrar Empresa </button></a>
        <ul>
            <c:forEach items="${empresas}" var="empresa">
                <li>
                    ${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" />  
                    <a href="/empresa/mostrarEmpresa?id=${empresa.id}"><button>Editar</button></a>
                    <a href="/empresa/removeEmpresa?id=${empresa.id}" ><button>Remover</Button></a>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>