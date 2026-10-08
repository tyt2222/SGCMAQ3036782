
<%@page import="java.util.ArrayList"%>
<%@page import="framework.dao.Usuario"%>
<%@page import="framework.dao.UsuarioDAO"%>

<h1> menu </h1>

<%
    String nomeUsuarioSessao = "";
    if( ( session != null ) && ( session.getAttribute("usuario_sessao") != null ) ) {
        Usuario usuarioSessao = (Usuario) session.getAttribute("usuario_sessao");
        nomeUsuarioSessao =  usuarioSessao.getId() + " " + usuarioSessao.getNome();
    }
%>



<menu>
    <li><a href="/SGCMAQ3036782/home?task=logout"><%= nomeUsuarioSessao %> -- Logout</a></li>
</menu>