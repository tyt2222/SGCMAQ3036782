package controller;

import framework.dao.Usuario;
import framework.dao.UsuarioDAO;
import framework.log.ExceptionLogTrack;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String task = req.getParameter("task");

        try {
            if ("usuario".equals(task)) {
                doGetUsuario(req, resp);
            } else {
                doDefault(req, resp);
            }
        } catch (Exception ex) {
            ExceptionLogTrack.getInstance().addLog(ex);
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String task = req.getParameter("task");

        try {
            if ("usuario".equals(task)) {
                doPostUsuario(req, resp);
            } else {
                doDefault(req, resp);
            }
        } catch (Exception ex) {
            ExceptionLogTrack.getInstance().addLog(ex);
            throw new ServletException(ex);
        }
    }

    private void doDefault(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/home/login.jsp").forward(req, resp);
    }

    private void doGetUsuario(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/home/app/adm/usuario.jsp").forward(req, resp);
    }

    private void doPostUsuario(HttpServletRequest req, HttpServletResponse resp)
            throws Exception {
        String action = req.getParameter("action");
        int id = Integer.parseInt(req.getParameter("id"));
        String nome = req.getParameter("nome");
        String senha = req.getParameter("senha");

        Usuario usuario = new Usuario(id);
        usuario.setNome(nome);
        usuario.setSenha(senha);

        UsuarioDAO dao = new UsuarioDAO();
        if ("new".equals(action)) {
            dao.insert(usuario);
        } else if ("update".equals(action)) {
            dao.update(usuario);
        }

        resp.sendRedirect(req.getContextPath() + "/home?task=usuario");
    }
    
}
