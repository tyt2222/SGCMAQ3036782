<%-- 
    Document   : formulario.jsp
    Created on : 10 de set. de 2026, 09:15:17
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! JSP</h1>
        
        <form action="/SGCMAQ3036782/aulas/rotalogica/jsp/servletpost" method="post">
            <label for="campoA">campoA</label>
            <input type="number" name="campoA" id="campoA" required="">
            <br>
            <label for="opcaoA">opcaoA</label>
            <input type="checkbox" name="opcaoA" id="opcaoA" value="S">
            <br>
            
            <input type="submit" name="name" value="Salvar">
        </form>
        
    </body>
</html>
