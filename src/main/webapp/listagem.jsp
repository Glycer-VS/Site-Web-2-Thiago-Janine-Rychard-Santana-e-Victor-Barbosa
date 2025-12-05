<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Ações</title>
    <link rel="stylesheet" href="css/estilo.css">
    <style>
        /* Pequeno ajuste inline para o formulário de busca ficar alinhado */
        .form-busca {
            margin: 20px 0;
            display: flex;
            gap: 10px;
            align-items: center;
        }
        .input-busca {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            width: 300px;
        }
    </style>
</head>
<body>

<%@ include file="WEB-INF/header.jsp" %>

<div class="container">

    <h2>Ações de Extensão</h2>
    
    <div class="form-busca">
        <form action="acoes" method="get" style="display: flex; gap: 10px;">
            <input type="text" name="busca" class="input-busca" placeholder="Buscar por título ou descrição..." value="${param.busca}">
            <button type="submit" class="botao">Pesquisar</button>
        </form>
        <a href="acoes" class="botao" style="background-color: #777;">Limpar</a>
    </div>
    
    <div style="margin-bottom: 20px;">
        <a href="index.jsp" class="botao">Página Inicial</a>
    </div>

    <table>
        <tr>
            <th>Título</th>
            <th>Responsável</th>
            <th>Período</th>
            <th>Ver detalhes</th>
        </tr>

        <c:forEach var="acao" items="${lista}">
            <tr>
                <td>${acao.titulo}</td>
                <td>${acao.responsavel}</td>
                <td>
                    ${acao.dataInicio} até ${acao.dataFim}
                </td>
                <td>
                    <a class="botao" href="acoes?acao=detalhes&id=${acao.id}">Abrir</a>
                </td>
            </tr>
        </c:forEach>

        <c:if test="${empty lista}">
            <tr>
                <td colspan="4" style="text-align: center; padding: 20px;">
                    Nenhuma ação encontrada.
                </td>
            </tr>
        </c:if>

    </table>

</div>

<%@ include file="WEB-INF/footer.jsp" %>

</body>
</html>