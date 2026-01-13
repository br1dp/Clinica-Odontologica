package servlets;

import jakarta.persistence.RollbackException;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logica.ControladoraLogica;
import logica.Mensaje;

@WebServlet(name = "EliminarUsuarioServlet", urlPatterns = {"/EliminarUsuarioServlet"})
public class EliminarUsuarioServlet extends HttpServlet {
    
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
        
        int idUsuario = Integer.parseInt(request.getParameter("id"));
        
        try {
            
            cL.eliminarUsuario(idUsuario);
            response.sendRedirect("UsuarioServlet");
            
        } catch (RollbackException e) {
            
            Mensaje mensaje = cL.crearMensaje("Error en la operacion", "No se puede eliminar el usuario porque tiene secretarios asignados. Antes de eliminar asegurese que no tenga secretarios asignados.");
            
            HttpSession session = request.getSession();
            session.setAttribute("mensaje", mensaje);
            
            response.sendRedirect("index.jsp");
        }
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
