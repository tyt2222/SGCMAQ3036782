package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import framework.dao.TipoUsuario;
import framework.dao.TipoUsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.util.ArrayList;

@WebServlet(name = "TipoUsuarioAPI", urlPatterns = {"/api/tipousuario/*"})
public class TipoUsuarioAPI extends HttpServlet {

    private Gson gson;

    @Override
    public void init() throws ServletException {
        super.init();

        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    // Read
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //        System.out.println( "request.getPathInfo() " + request.getPathInfo() );
        String id = req.getPathInfo();
        if (id != null) {
            id = id.replaceAll("/", "");
        }

        try {

            String json = "";
            
            if (id == null) {
                ArrayList<TipoUsuario> tipoUsuario = new TipoUsuarioDAO().getAll();
                
                json = gson.toJson(tipoUsuario);
            }else{
                TipoUsuario tipoUsuario = new TipoUsuarioDAO().getUnique(Integer.parseInt(id));
                json = gson.toJson(tipoUsuario);
            }

            ArrayList<TipoUsuario> tiposUsuario = new TipoUsuarioDAO().getAll();

//            json = gson.toJson( tiposUsuario );
            json = gson.toJson(tiposUsuario.get(0));

            resp.setContentType("application/json;charset=UTF-8");

            resp.setHeader("Access-Control-Allow-Origin", "*");
            resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");

            PrintWriter pw = resp.getWriter();
            resp.setStatus(200);
            pw.write(json);

        } catch (Exception ex) {
            resp.sendError(500, ex.getMessage());
        }

    }

    // Create
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String json = getReader(req);
        TipoUsuario tipoUsuario = gson.fromJson(json, TipoUsuario.class);
        System.out.println(tipoUsuario);

    }

    private String getReader(HttpServletRequest request) throws IOException {
        String reader = "", line;

        BufferedReader bufferedReader = request.getReader();
        line = bufferedReader.readLine();

        while (line != null) {
            reader += line;
            line = bufferedReader.readLine();
        }

        return reader;
    }

    @Override
    public void destroy() {
        super.destroy();
    }

}
