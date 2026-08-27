/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package aulas.rotalogica.servlet.ciclo;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "Ciclo", urlPatterns = {"/aulas/rotalogica/servlet/ciclo"})

public class Ciclo extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init(); 
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Teste");
        Enumeration headerNames = req.getHeaderNames();
        
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement().toString();
            System.out.println(header + " " + req.getHeader(header));
        }
        
            // https://www.w3schools.com/tools/tool_mime_types.php
        
            String html = ("<!DOCTYPE html>");
            html += ("<html>");
            html += ("<head>");
            html += ("<title>Servlet Ciclo</title>");
            html += ("</head>");
            html += ("<body>");
            html += ("<h1>Servlet Ciclo at </h1>");
            html += ("</body>");
            html += ("</html>");
            
            resp.setContentType("text/calendar");
            PrintWriter pw = resp.getWriter();
            pw.print(html);
            pw.close();
        
        

    }

    

    

   
    @Override
    public void destroy() {
        super.destroy(); 
    }
    
    
    
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Ciclo</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Ciclo at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>

}
