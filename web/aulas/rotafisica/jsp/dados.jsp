<%-- 
    Document   : dados
    Created on : 10 de set. de 2026, 10:14:09
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="aulas.rotalogica.servlet.getpost.DadosFormulario"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <%
        ArrayList<DadosFormulario> dados = (ArrayList<DadosFormulario>) request.getAttribute("lista");
    %>


    <body>
        <h1>Dados funcionarios JSP!</h1>
        <table border="1">
            <tr>
                <th>Campo A</th>
                <th>Opção A</th>
            </tr>

            <% for (DadosFormulario df : dados) {%>
            <tr>
                <td><%= df.getCampoA()%></td>
                <td><%= df.getOpcaoA()%></td>
            </tr>

            <% }%>

        </table>


        <button onclick="window.location.href = '/SGCMAQ3036782/aulas/rotafisica/jsp/formulario.jsp'">
            adicionar
        </button>

    </body>
</html>
