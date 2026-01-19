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
import logica.Paciente;
import logica.Responsable;

@WebServlet(name = "EditarPaciente", urlPatterns = {"/EditarPaciente"})
public class EditarPaciente extends HttpServlet {

    ControladoraLogica cL = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Paciente pacienteEditar = cL.traerPaciente(Integer.parseInt(request.getParameter("id")));

        session.setAttribute("pacienteEditar", pacienteEditar);

        response.sendRedirect("editarPaciente.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        Paciente pacienteEditar = (Paciente) session.getAttribute("pacienteEditar");
        Responsable respEditar = pacienteEditar.getResponsable();

        if (!request.getParameter("dni").equals("")) {
            pacienteEditar.setDni(request.getParameter("dni"));
        }
        if (!request.getParameter("nombre").equals("")) {
            pacienteEditar.setNombre(request.getParameter("nombre"));
        }
        if (!request.getParameter("apellido").equals("")) {
            pacienteEditar.setApellido(request.getParameter("apellido"));
        }
        if (!request.getParameter("telefono").equals("")) {
            pacienteEditar.setTelefono(request.getParameter("telefono"));
        }
        if (!request.getParameter("direccion").equals("")) {
            pacienteEditar.setDireccion(request.getParameter("direccion"));
        }

        if (!request.getParameter("fechaNac").equals("")) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaNacLocalDate = LocalDate.parse(request.getParameter("fechaNac"), dtf);
            pacienteEditar.setFechaNac(fechaNacLocalDate);
        }

        if (request.getParameter("tieneOs") != null) {

            if (Integer.parseInt(request.getParameter("tieneOs")) == 1) {
                pacienteEditar.setTieneOs(true);
            } else {
                pacienteEditar.setTieneOs(false);
            }

        } else {
            pacienteEditar.setTieneOs(false);
        }

        if (!request.getParameter("tipoSangre").equals("")) {
            pacienteEditar.setTipoSangre(request.getParameter("tipoSangre"));
        }

        if (!request.getParameter("dniResp").equals("")) {
            respEditar.setDni(request.getParameter("dniResp"));
        }
        if (!request.getParameter("nombreResp").equals("")) {
            respEditar.setNombre(request.getParameter("nombreResp"));
        }
        if (!request.getParameter("apellidoResp").equals("")) {
            respEditar.setApellido(request.getParameter("apellidoResp"));
        }
        if (!request.getParameter("telefonoResp").equals("")) {
            respEditar.setTelefono(request.getParameter("telefonoResp"));
        }
        if (!request.getParameter("direccionResp").equals("")) {
            respEditar.setDireccion(request.getParameter("direccionResp"));
        }

        if (!request.getParameter("fechaNacResp").equals("")) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaNacLocalDate = LocalDate.parse(request.getParameter("fechaNacResp"), dtf);
            respEditar.setFechaNac(fechaNacLocalDate);
        }
        
        if (!request.getParameter("tipoResp").equals("")) {
            respEditar.setTipoResp(request.getParameter("tipoResp"));
        }
        
        cL.editarResponsable(respEditar);
        pacienteEditar.setResponsable(respEditar);
        cL.editarPaciente(pacienteEditar);
        
        Mensaje mensaje = cL.crearMensaje("Paciente modificado", "El paciente fue modificado exitosamente en la base de datos.");
        session.setAttribute("mensaje", mensaje);
        
        response.sendRedirect("index.jsp");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
