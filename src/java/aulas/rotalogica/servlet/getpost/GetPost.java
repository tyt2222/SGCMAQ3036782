
package aulas.rotalogica.servlet.getpost;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@WebServlet(name = "GetPost", urlPatterns = {"/aulas/rotalogica/servlet/getpost"})
public class GetPost extends HttpServlet {

    private ArrayList<DadosFormulario> dados;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String campoA = request.getParameter("campoA");
        String opcaoA = request.getParameter("opcaoA");
        
        System.out.println(campoA + " " + opcaoA);
        
        DadosFormulario df = new DadosFormulario();
        df.setCampoA(campoA);
        df.setOpcaoA(opcaoA);
        
        dados.add(df);
        System.out.println(dados);
        
        String html = "";
        html += "<html>";
        html +="<head>";
        html +="<title>Servlet Ciclo</title>";
        html +="</head>";
        html +="<body>";
        html +=("<h1>Dados recebidos do formulario</h1>");
        
        html += "<table>";
                
        html += "<tr>";
        html += "<th>CampoA</th>";
        html += "<th>opcaoA</th>";
        html += "</tr>";
        
        for(DadosFormulario d : dados){
            html += "<tr>";
            html += "<td>" + d.getCampoA() + "</td>";
            html += "<td>" + d.getOpcaoA()+ "</td>";
            html += "</tr>";
        }
        
        html += "</table>";
        html += "<button onclick=\"window.location.href='/SGCMAQ3036782/aulas/rotafisica/servlet/getpost/formulario_getpost.html'\">adicionar</button>";
        
        html +="</body>";
        html +="</html>";
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.write(html);
        pw.close();
    }

    @Override
    public void init() throws ServletException {
       dados = new ArrayList<>(); 
    }

    @Override
    public void destroy() {
        dados.clear();
        dados = null;
    }
    
    

    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("\n\nget\n\n");
        processRequest(req, resp);
    }
    
    


}
