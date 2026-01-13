package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import logica.ControladoraLogica;
import logica.Secretario;
import logica.Usuario;

@WebServlet(name = "SecretarioServlet", urlPatterns = {"/SecretarioServlet"})
public class SecretarioServlet extends HttpServlet {

    ControladoraLogica cL = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<Secretario> listaSecretarios = cL.listarSecretarios();

        session.setAttribute("listaSecretarios", listaSecretarios);
        
        response.sendRedirect("verSecretarios.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String sector = request.getParameter("sector");
        String fechaNac = request.getParameter("fechaNac");
        
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        String nombreUsuario = usuario.getNombreUsuario();
        String passwordUsuario = usuario.getPassword();

        int idUsuario = cL.traerUsuario(nombreUsuario, passwordUsuario);

        if (idUsuario != -1) {

            cL.crearSecretario(dni, nombre, apellido, telefono, direccion, sector, fechaNac, idUsuario);
            response.sendRedirect("SecretarioServlet");

        } else {
            
            response.sendRedirect("altaSecretario.jsp");
            
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
