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
import logica.ControladoraLogica;
import logica.Mensaje;
import logica.Odontologo;

@WebServlet(name = "EditarOdontologoServlet", urlPatterns = {"/EditarOdontologoServlet"})
public class EditarOdontologoServlet extends HttpServlet {

    ControladoraLogica cL = new ControladoraLogica();
    HttpSession session;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        session = request.getSession();
        int idOdontologo = Integer.parseInt(request.getParameter("id"));

        Odontologo odontologoEditar = cL.traerOdontologo(idOdontologo);

        session.setAttribute("odontologoEditar", odontologoEditar);

        response.sendRedirect("editarOdontologo.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Odontologo odontologo = (Odontologo) session.getAttribute("odontologoEditar");

        if (!request.getParameter("dni").isEmpty()) {
            odontologo.setDni(request.getParameter("dni"));
        }
        if (!request.getParameter("nombre").isEmpty()) {
            odontologo.setNombre(request.getParameter("nombre"));
        }
        if (!request.getParameter("apellido").isEmpty()) {

            odontologo.setApellido(request.getParameter("apellido"));
        }
        if (!request.getParameter("telefono").isEmpty()) {

            odontologo.setTelefono(request.getParameter("telefono"));
        }
        if (!request.getParameter("direccion").isEmpty()) {

            odontologo.setDireccion(request.getParameter("direccion"));
        }
        if (!request.getParameter("fechaNac").isEmpty()) {

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            odontologo.setFechaNac(LocalDate.parse(request.getParameter("fechaNac"), dtf));
        }
        if (!request.getParameter("especialidad").isEmpty()) {

            odontologo.setEspecialidad(request.getParameter("especialidad"));
        }

        cL.editarOdontologo(odontologo);

        Mensaje mensaje = new Mensaje("Odontologo editado", "El odontologo fue editado exitosamente en la base de datos.");
        session.setAttribute("mensaje", mensaje);
        response.sendRedirect("index.jsp");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
