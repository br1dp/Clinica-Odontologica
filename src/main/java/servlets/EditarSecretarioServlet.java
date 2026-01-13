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
import logica.Secretario;

@WebServlet(name = "EditarSecretarioServlet", urlPatterns = {"/EditarSecretarioServlet"})
public class EditarSecretarioServlet extends HttpServlet {

    ControladoraLogica cL = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        int idUsuario = Integer.parseInt(request.getParameter("id"));

        Secretario secEditar = cL.traerSecretario(idUsuario);

        session.setAttribute("secEditar", secEditar);

        response.sendRedirect("editarSecretario.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Secretario secretarioEditar = (Secretario) request.getSession().getAttribute("secEditar");

        if (!request.getParameter("dni").equals("")) {
            secretarioEditar.setDni(request.getParameter("dni"));
        }
        if (!request.getParameter("nombre").equals("")) {
            secretarioEditar.setNombre(request.getParameter("nombre"));
        }
        if (!request.getParameter("apellido").equals("")) {
            secretarioEditar.setApellido(request.getParameter("apellido"));
        }
        if (!request.getParameter("telefono").equals("")) {
            secretarioEditar.setTelefono(request.getParameter("telefono"));
        }
        if (!request.getParameter("direccion").equals("")) {
            secretarioEditar.setDireccion(request.getParameter("direccion"));
        }

        if (!request.getParameter("fechaNac").equals("")) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaNacLocalDate = LocalDate.parse(request.getParameter("fechaNac"), dtf);
            secretarioEditar.setFechaNac(fechaNacLocalDate);
        }
        if (!request.getParameter("sector").equals("")) {
            secretarioEditar.setSector(request.getParameter("sector"));
        }

        cL.editarSecretario(secretarioEditar);

        response.sendRedirect("SecretarioServlet");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
