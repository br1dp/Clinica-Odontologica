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
import logica.Usuario;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    
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
        
        String nombreUsuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        boolean validacion = false;
        
        validacion = cL.comprobarIngreso(nombreUsuario, password);
        
        if (validacion == true) {
            
            int idUsuario = cL.traerUsuario(nombreUsuario, password);
            Usuario usuario = cL.traerUsuario(idUsuario);
            
            HttpSession session = request.getSession(true);
            session.setAttribute("usuario", usuario);
            
            Mensaje mensaje = cL.crearMensaje("Clinica Odontologica", "Hola " + usuario.getNombreUsuario() + ", bienvenido a la aplicacion de gestion de la clinica TEDIEN.");
            session.setAttribute("mensaje", mensaje);
            
            response.sendRedirect("index.jsp");
            
        } else {
            
            response.sendRedirect("login.jsp");
        }
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
