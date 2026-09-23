<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="framework.dao.Usuario" %>
<%@page import="framework.dao.UsuarioDAO" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuários</title>
    </head>
    <body>
        <%
            ArrayList<Usuario> lista = new UsuarioDAO().getAll();
        %>

        <h1>Usuários</h1>
        <a href="<%= request.getContextPath() %>/home/app/adm/usuario_form.jsp">Novo usuário</a>

        <table>
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th></th>
                <th></th>
            </tr>
            <% for (Usuario usuario : lista) { %>
                <tr>
                    <td><%= usuario.getId() %></td>
                    <td><%= usuario.getNome() %></td>
                    <td><a href="<%= request.getContextPath() %>/home/app/adm/usuario_form.jsp?id=<%= usuario.getId() %>">Alterar</a></td>
                    <td><a href="#">Excluir</a></td>
                </tr>
            <% } %>
        </table>
    </body>
</html>
