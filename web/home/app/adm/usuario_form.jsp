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
            Usuario usuario = null;
            String id = request.getParameter("id");
            if (id != null) {
                usuario = new UsuarioDAO().getUnique(Integer.parseInt(id));
                if (usuario != null) {
                    action = "update";
                }
            }
        %>

        <h1>Cadastro Usuário</h1>
        <form action="<%= request.getContextPath() %>/home?task=usuario&action=<%= action %>" method="post">
            <label for="id">Id:</label>
            <input type="number" id="id" name="id"
                   value="<%= usuario != null ? usuario.getId() : "" %>" required
                   <%= usuario != null ? "readonly" : "" %>><br>

            <label for="nome">Nome:</label>
            <input type="text" id="nome" name="nome"
                   value="<%= usuario != null ? usuario.getNome() : "" %>"><br>

            <label for="senha">Senha:</label>
            <input type="password" id="senha" name="senha"
                   value="<%= usuario != null ? usuario.getSenha() : "" %>" required><br>

            <input type="submit" value="Salvar">
        </form>
    </body>
</html>
