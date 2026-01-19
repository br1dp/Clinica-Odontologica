package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logica.ControladoraLogica;
import logica.Mensaje;

@WebServlet(name = "EliminarOdontologoServlet", urlPatterns = {"/EliminarOdontologoServlet"})
public class EliminarOdontologoServlet extends HttpServlet {

    ControladoraLogica cL = new ControladoraLogica();
    HttpSession session;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        session = request.getSession();
        int idOdontologo = Integer.parseInt(request.getParameter("id"));
        cL.eliminarOdontologo(idOdontologo);
        
        Mensaje mensaje = cL.crearMensaje("Odontologo eliminado", "El odontologo fue eliminado exitosamente en la base de datos.");
        session.setAttribute("mensaje", mensaje);
        
        response.sendRedirect("index.jsp");
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
