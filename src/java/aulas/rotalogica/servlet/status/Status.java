/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package aulas.rotalogica.servlet.status;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@WebServlet(name = "status", urlPatterns = {"/aulas/rotalogica/servlet/status"})
public class Status extends HttpServlet {

    // https://www.w3schools.com/tags/ref_httpmessages.asp
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
//        pw.write("https://www.w3schools.com/tags/ref_httpmessages.asp");
//        pw.close();

    resp.sendRedirect("https://www.w3schools.com/tags/ref_httpmessages.asp");

    }

}
