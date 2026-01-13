package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logica.ControladoraLogica;
import logica.Mensaje;

@WebServlet(name = "EliminarPaciente", urlPatterns = {"/EliminarPaciente"})
public class EliminarPaciente extends HttpServlet {
    
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
        
        HttpSession session = request.getSession();
        
        int idPaciente = Integer.parseInt(request.getParameter("id"));
        
        cL.eliminarPaciente(idPaciente);
        
        Mensaje mensaje = cL.crearMensaje("Paciente eliminado", "El paciente fue eliminado exitosamente en la base de datos.");
        session.setAttribute("mensaje", mensaje);
        
        response.sendRedirect("index.jsp");
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
