
<%@page import="java.util.ArrayList"%>
<%@page import="framework.dao.Usuario"%>
<%@page import="framework.dao.UsuarioDAO"%>
<%@page import="framework.dao.TipoUsuario"%>

<h1> menu </h1>

<%
    String nomeUsuarioSessao = "";
    if ((session != null) && (session.getAttribute("usuario_sessao") != null)) {
        
        Usuario usuarioSessao = (Usuario) session.getAttribute("usuario_sessao");
        nomeUsuarioSessao = usuarioSessao.getId() + " " + usuarioSessao.getNome();
        
    }

    TipoUsuario tipoUsuarioSessao = null;
    
    if ((session != null) && (session.getAttribute("tipo_usuario_sessao") != null)) {
        
        tipoUsuarioSessao = (TipoUsuario) session.getAttribute("tipo_usuario_sessao");
        
    }
%>



<menu>
    <li><a href="/SGCMAQ3036782/home/app/menu.jsp">Home</a></li>
    <% if((tipoUsuarioSessao != null) && (tipoUsuarioSessao.getModuloAdministrativo().equals("S"))){%>
        
        <li><a href="/SGCMAQ3036782/home/app/adm/tipousuario.jsp">Tipos Usuario</a></li>
        <li><a href="/SGCMAQ3036782/home/app/adm/usuario.jsp">Usuarios</a></li>
    
    <%}%>
    
    <li><a href="/SGCMAQ3036782/home?task=logout"><%= nomeUsuarioSessao%> -- Logout</a></li>
</menu>