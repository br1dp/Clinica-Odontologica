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

@WebServlet(name = "EditarUsuarioServlet", urlPatterns = {"/EditarUsuarioServlet"})
public class EditarUsuarioServlet extends HttpServlet {

    ControladoraLogica cL = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        int idUsuario = Integer.parseInt(request.getParameter("id"));
        Usuario usuario = cL.traerUsuario(idUsuario);

        session.setAttribute("usuarioEditar", usuario);

        response.sendRedirect("editarUsuario.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioEditar");
        
        if (!request.getParameter("nombre").equals("")) {
            usuario.setNombreUsuario(request.getParameter("nombre"));
        }
        if (!request.getParameter("password").equals("")) {
            usuario.setPassword(request.getParameter("password"));
        }
        if (request.getParameter("rol") != null) {
            usuario.setRol(request.getParameter("rol"));
        }
        if(request.getParameter("estado") != null){
            usuario.setEstado(request.getParameter("estado"));
        }

        cL.editarUsuario(usuario);
        
        Mensaje mensaje = cL.crearMensaje("Usuario modificado", "El usuario fue modificado exitosamente en la base de datos.");
        session.setAttribute("mensaje", mensaje);
        
        response.sendRedirect("index.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
