<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html> <html> <head> <meta charset="UTF-8"> <title>Login</title> </head>
    <body>
        <%
            String id = "";

            Cookie[] cookies = request.getCookies();

            if (cookies != null) {
                for (Cookie cookie : cookies) {

                    if (cookie.getName().equals("id")) {
                        id = cookie.getValue();
                        break;
                    }

                }
            }
        %>

        <h1>Login</h1>

        <form action="${pageContext.request.contextPath}/home?task=login" method="post">

            <input type="hidden" name="task" value="login">

            <label for="id">Id:</label>
            <input type="number" id="id" name="id" value="<%= id%>" required>

            <br><br>

            <label for="senha">Senha:</label>
            <input type="password" id="senha" name="senha" required>

            <br><br>

            <input type="submit" value="Entrar">

        </form>

    </body> 

</html>