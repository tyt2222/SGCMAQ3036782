<%-- 
    Document   : helloworld
    Created on : 10 de set. de 2026, 08:53:22
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello World Jsp</title>
    </head>
    
    <%
    
        ArrayList<String> cores = new ArrayList<>();
        cores.add("azul");
        cores.add("branco");
        cores.add("vermelho");
        cores.add("preto");
        
        %>
    
    
    
    <%
    
        int a = 4;
        int b = 2;
        int c = 6;
        
        out.print(a /b);

        %>
        
        
    
    <body>
        <h1>Hello World Jsp</h1>
    </body>
    
    <ul>
        <% for(String s : cores){ %>
        <li><%= s%></li>
        <% } %>
    </ul>

</html>newjsp
