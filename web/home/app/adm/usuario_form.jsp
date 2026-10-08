<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="framework.dao.Usuario" %>
<%@page import="framework.dao.UsuarioDAO" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Usuário</title>
    </head>
    <body>

        <%
            String action = "new";
            Usuario us = null;
            String id = request.getParameter("id");
            if (id != null) {
                us = new UsuarioDAO().getUnique(Integer.parseInt(id));

                if (us != null) {
                    action = "update";
                }
            }
        %>

        <h1>Cadastro Usuário</h1>

        <form action="/SGCMAQ3036782/home?task=usuario&action=<%= action%>" method="post">

            <label for="id">Id:</label>
            <input type="number" id="id" name="id" value="<%= us != null ? us.getId() : ""%>" required <%= us != null ? "readonly" : ""%>> <br/>

            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome" value="<%= us != null ? us.getNome() : ""%>"><br/>

            <label for="senha">Senha:</label>
            <input type="password" id="senha" name="senha" value="<%= us != null ? us.getSenha() : ""%>" required><br/>

            <label for="tipo_usuario_id">Tipo Usuário Id:</label>
            <input type="number" id="tipo_usuario_id" name="tipo_usuario_id" value="<%= us != null ? us.getTipoUsuarioId() : ""%>" required> <br/>

            <input type="submit" value="Salvar">

        </form>

        <%@include file="/home/app/modulos.jsp" %>

    </body>


</html>
