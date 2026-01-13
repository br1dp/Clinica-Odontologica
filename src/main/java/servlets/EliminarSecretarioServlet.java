
package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logica.ControladoraLogica;


@WebServlet(name = "EliminarSecretarioServlet", urlPatterns = {"/EliminarSecretarioServlet"})
public class EliminarSecretarioServlet extends HttpServlet {
    
    ControladoraLogica cL = new ControladoraLogica();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        int idSecretario = Integer.parseInt(request.getParameter("id"));
        cL.eliminarSecretario(idSecretario);
        
        response.sendRedirect("SecretarioServlet");
        
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
