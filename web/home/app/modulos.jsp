<h1> menu </h1>

<% 
    String nome = "";
    if (session != null && session.getAttribute("usuario_sessao") != null) {
        Usuario usuarioSessao = (Usuario) session.getAttribute("usuario_sessao");
        nome = usuarioSessao.getNome();
    }
    
%>


<menu>
    <li><a href="/SGCMAQ3036782/home?task=logout">Logout</a></li>
</menu>