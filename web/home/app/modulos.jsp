<h1> menu </h1>

<menu>
    <%
        if (session != null && session.getAttribute("usuario_sessao") != null) {
            Usuario usuarioSessao = (Usuario) session.getAttribute("usuario_sessao");
    %>
    <li><%= usuarioSessao.getId() %> - <%= usuarioSessao.getNome() %></li>
    <% } %>
    <li><a href="/SGCMAQ3036782/home?task=logout">Logout</a></li>
</menu>