<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="br.ufrrj.extensao.model.AcaoExtensao" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalhes da Ação</title>
    <link rel="stylesheet" href="css/estilo.css">
</head>
<body>

<%@ include file="WEB-INF/header.jsp" %>

<%
    AcaoExtensao acao = (AcaoExtensao) request.getAttribute("acao");

    if (acao == null) {
%>
        <div class="container">
            <h2>Ação não encontrada</h2>
            <a href="acoes" class="botao">Voltar</a>
        </div>
<%
        return;
    }

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
%>




<div class="container">
    

    <h2><%= acao.getTitulo() %></h2>

    <p><strong>Responsável:</strong> <%= acao.getResponsavel() %></p>
    <p><strong>Descrição:</strong> <%= acao.getDescricao() %></p>

    <p><strong>Período:</strong>
        <%= acao.getDataInicio().format(fmt) %>
        até
        <%= acao.getDataFim().format(fmt) %>
    </p>

    <p><strong>Local:</strong> <%= acao.getLocal() %></p>

    <p><strong>Público-alvo:</strong> <%= acao.getPublicoAlvo() %></p>

    <p><strong>Possui taxa?</strong> <%= acao.isPossuiTaxa() ? "Sim" : "Não" %></p>

    <p><strong>Link externo:</strong>
        <a href="<%= acao.getLinkExterno() %>" target="_blank">
            <%= acao.getLinkExterno() %>
        </a>
    </p>

    <p><strong>Status:</strong> <%= acao.getStatus() %></p>

    <a href="acoes" class="botao">Voltar</a>
    <a href="index.jsp" class="botao">Página Inicial</a>
</div>

<%@ include file="WEB-INF/footer.jsp" %>

</body>
</html>
