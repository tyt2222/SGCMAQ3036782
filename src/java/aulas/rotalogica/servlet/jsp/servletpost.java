/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package aulas.rotalogica.servlet.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import aulas.rotalogica.servlet.getpost.DadosFormulario;

@WebServlet(name = "servletpost", urlPatterns = {"/aulas/rotalogica/jsp/servletpost"})
public class servletpost extends HttpServlet {
    
    private ArrayList<DadosFormulario> dados;

    @Override
    public void init() throws ServletException {
        super.init();
        dados = new ArrayList<>();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String campoA = request.getParameter("campoA");
        String opcaoA = request.getParameter("opcaoA");
        DadosFormulario df = new DadosFormulario();
        
        df.setCampoA(campoA);
        df.setOpcaoA(opcaoA);
        
        dados.add(df);
        String url = "/aulas/rotafisica/jsp/dados.jsp";
        
        request.setAttribute("lista", dados);
        request.getRequestDispatcher(url).forward(request, response);
        
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("\n\npost\n\n");
        processRequest(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        dados.clear();
        dados = null;
    }
    
    

}
