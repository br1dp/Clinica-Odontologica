package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import logica.ControladoraLogica;
import logica.Mensaje;
import logica.Odontologo;
import logica.Usuario;

@WebServlet(name = "OdontologoServlet", urlPatterns = {"/OdontologoServlet"})
public class OdontologoServlet extends HttpServlet {

    ControladoraLogica cL = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        List<Odontologo> listaOdontologos = cL.traerOdontologos();
        session.setAttribute("listaOdontologos", listaOdontologos);
        response.sendRedirect("verOdontologo.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
        String dni="";
        String nombre="";
        String apellido="";
        String telefono="";
        String direccion="";
        String fechaNac="";
        String especialidad="";
        LocalDate fechaNacLocalDate = LocalDate.now();
        
        if(!request.getParameter("dni").isEmpty()){
            dni = request.getParameter("dni");
        }
        if(!request.getParameter("nombre").isEmpty()){
            nombre = request.getParameter("nombre");
        }
        if(!request.getParameter("apellido").isEmpty()){
            apellido = request.getParameter("apellido");
        }
        if(!request.getParameter("telefono").isEmpty()){
            telefono = request.getParameter("telefono");
        }
        if(!request.getParameter("direccion").isEmpty()){
            direccion = request.getParameter("direccion");
        }
        if(!request.getParameter("fechaNac").isEmpty()){
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            fechaNacLocalDate = LocalDate.parse(request.getParameter("fechaNac"), dtf);
        }
        if(!request.getParameter("especialidad").isEmpty()){
            especialidad = request.getParameter("especialidad");
        }
        
        int idUsuario = usuario.getIdUsuario();
        
        cL.crearOdontologo(dni, nombre, apellido, telefono, direccion, fechaNacLocalDate,especialidad, idUsuario);
        
        Mensaje mensaje = new Mensaje("Odontologo guardado", "El odontologo fue guardado exitosamente en la base de datos.");
        session.setAttribute("mensaje", mensaje);
        response.sendRedirect("index.jsp");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
