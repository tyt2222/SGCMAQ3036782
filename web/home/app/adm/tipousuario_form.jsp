<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="framework.dao.TipoUsuario" %>
<%@page import="framework.dao.TipoUsuarioDAO" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Tipo Usuário</title>
    </head>
    <body>
        
        <%
            String action = "new";
            TipoUsuario tpUs = null;
            String id = request.getParameter("id");
            if( id != null ) {
                tpUs = new TipoUsuarioDAO().getUnique( Integer.parseInt( id ) );
                
                if( tpUs != null ) action = "update";
            }
        %>
        
        <h1>Cadastro Tipo Usuário</h1>
        
        <form action="/SGCMAQ3036782/home?task=tipousuario&action=<%= action %>" method="post">
            
            <label for="id">Id:</label>
            <input type="number" id="id" name="id" value="<%= tpUs != null ? tpUs.getId() : "" %>" required <%= tpUs != null ? "readonly" : "" %>> <br/>
            
            <input type="checkbox" id="modulo_administrativo" name="modulo_administrativo" value="S" <%= ( (tpUs != null) && ( tpUs.getModuloAdministrativo().equals("S") ) ) ? "checked" : "" %> >
            <label for="modulo_administrativo">Módulo Administrativo</label> <br> <br>
            
            <input type="checkbox" id="modulo_agendamento" name="modulo_agendamento" value="S" <%= ( (tpUs != null) && ( tpUs.getModuloAgendamento().equals("S") ) ) ? "checked" : "" %> >
            <label for="modulo_agendamento">Módulo Agendamento</label> <br> <br>
            
            <input type="checkbox" id="modulo_atendimento" name="modulo_atendimento" value="S" <%= ( (tpUs != null) && ( tpUs.getModuloAtendimento().equals("S") ) ) ? "checked" : "" %> >
            <label for="modulo_atendimento">Módulo Atendimento</label> <br> <br>
            
            <input type="submit" value="Salvar">
            
        </form>
        
    </body>
</html>
