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
        
        <table>
            
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Tipo Usuário Id</th>
                <th></th>
                <th></th>
            </tr>
            
            <% for( Usuario us : lista ) { %>
                <tr>
                    
                    <td><%= us.getId() %></td>
                    <td><%= us.getNome() %></td>
                    <td><%= us.getTipoUsuarioId() %></td>
                    
                    <td><a href="/SGCMAQ3036782/home/app/adm/usuario_form.jsp?id=<%= us.getId() %>">Alterar</a></td>
                    
                    <td><a href="/SGCMAQ3036782/home?task=usuario&action=delete&id=<%= us.getId()%>" onclick="return confirm('Deseja realmente excluir Usuário <%= us.getId() %> -- <%= us.getNome() %>')" >Excluir</a></td>
                    
                </tr>
            <% } %>
            
        </table>
            
        <button onclick="window.location.href='/SGCMAQ3036782/home/app/adm/usuario_form.jsp'">Adicionar</button>
        
    </body>
</html>
