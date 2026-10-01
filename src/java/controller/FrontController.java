package controller;

import framework.dao.TipoUsuario;
import framework.dao.TipoUsuarioDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import framework.log.ExceptionLogTrack;
import model.Usuario;
import model.UsuarioDAO;

public class FrontController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String task = req.getParameter("task");
        
        try {
        
            switch (task) {

                case "tipousuario": doGetTipoUsuario(req, resp); break;
                
                case "usuario": doGetUsuario(req, resp); break;

                case null:
                default:
                    doDefault(req, resp);

            }
            
        } catch(Exception ex) {
            ExceptionLogTrack.getInstance().addLog(ex);
            throw new ServletException( ex );
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String task = req.getParameter("task");
        
        try {
        
            switch (task) {

                case "tipousuario": doPostTipoUsuario(req, resp); break;
                
                case "usuario": doPostUsuario(req, resp); break;

                case null:
                default:
                    doDefault(req, resp);

            }
            
        } catch(Exception ex) {
            ExceptionLogTrack.getInstance().addLog(ex);
            throw new ServletException( ex );
        }
        
    }


    
    
    private void doDefault(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.getRequestDispatcher("/home/login.jsp").forward(req, resp);
        
    }
    
    
    
    
    private void doGetTipoUsuario(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        
        String action = req.getParameter("action");
        
        if( ( action != null ) && ( action.equals("delete") ) ) {
            
            int id = Integer.parseInt( req.getParameter("id") );
            
            TipoUsuario usTp = new TipoUsuario(id); // bean
            
            TipoUsuarioDAO dao = new TipoUsuarioDAO(); // dao
            
            dao.delete(usTp);
            
        }
        
        req.getRequestDispatcher("/home/app/adm/tipousuario.jsp").forward(req, resp);
        
        
    }
    
    private void doGetUsuario(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        
        String action = req.getParameter("action");
        
        if( ( action != null ) && ( action.equals("delete") ) ) {
            
            int id = Integer.parseInt( req.getParameter("id") );
            
            Usuario us = new Usuario(id); // bean
            
            UsuarioDAO dao = new UsuarioDAO(); // dao
            
            dao.delete(us);
            
        }
        
        req.getRequestDispatcher("/home/app/adm/usuario.jsp").forward(req, resp);
        
        
    }
    
    
    
    
    private void doPostTipoUsuario(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        
        String action = req.getParameter("action"); // new || update
        
        int id = Integer.parseInt( req.getParameter("id") );
        
        String moduloAdministrativo = req.getParameter("modulo_administrativo");
        if( moduloAdministrativo == null ) moduloAdministrativo = "N";
        
        String moduloAgendamento = req.getParameter("modulo_agendamento");
        if( moduloAgendamento == null ) moduloAgendamento = "N";
        
        String moduloAtendimento = req.getParameter("modulo_atendimento");
        if( moduloAtendimento == null ) moduloAtendimento = "N";
        
        TipoUsuario usTp = new TipoUsuario(id); // bean
        usTp.setModuloAdministrativo(moduloAdministrativo);
        usTp.setModuloAtendimento(moduloAtendimento);
        usTp.setModuloAgendamento(moduloAgendamento);
        
        TipoUsuarioDAO dao = new TipoUsuarioDAO(); // dao
        
        if( action.equals("new") ) dao.insert( usTp );
        
        if( action.equals("update") ) dao.update( usTp );
        
        req.getRequestDispatcher("/home/app/adm/tipousuario.jsp").forward(req, resp);
        
    }
    
    private void doPostUsuario(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        
        String action = req.getParameter("action"); // new || update
        
        int id = Integer.parseInt( req.getParameter("id") );
        String nome = req.getParameter("nome");
        String senha = req.getParameter("senha");
        int tipoUsuarioId = Integer.parseInt( req.getParameter("tipo_usuario_id") );
        
        Usuario us = new Usuario(id); // bean
        us.setNome(nome);
        
        if( senha.length() > 20 ) {
            us.setSenhaHash(senha);
        } else {
            us.setSenha(senha);
        }
        
        us.setTipoUsuarioId(tipoUsuarioId);
        
        UsuarioDAO dao = new UsuarioDAO(); // dao
        
        if( action.equals("new") ) dao.insert( us );
        
        if( action.equals("update") ) dao.update( us );
        
        req.getRequestDispatcher("/home/app/adm/usuario.jsp").forward(req, resp);
        
    }
    

}