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
import logica.Paciente;
import logica.Responsable;

@WebServlet(name = "PacienteServlet", urlPatterns = {"/PacienteServlet"})
public class PacienteServlet extends HttpServlet {

    ControladoraLogica cL = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<Paciente> listaPacientes = cL.listarPacientes();

        session.setAttribute("listaPacientes", listaPacientes);

        response.sendRedirect("verPacientes.jsp");

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
        String fechaNac = request.getParameter("fechaNac");
        int tieneOs = 0;
        
        if(request.getParameter("tieneOs") != null){
            
            tieneOs = Integer.parseInt(request.getParameter("tieneOs"));
                    
        }
        
        String tipoSangre = request.getParameter("tipoSangre");

        Responsable responsable = new Responsable();

        String dniResp;
        String nombreResp;
        String apellidoResp;
        String telefonoResp;
        String direccionResp;
        String fechaNacResp;
        String tipoResp;

        if (!request.getParameter("dniResp").isEmpty()) {
            dniResp = request.getParameter("dniResp");
            responsable.setDni(dniResp);
        }
        if (!request.getParameter("nombreResp").isEmpty()) {
            nombreResp = request.getParameter("nombreResp");
            responsable.setNombre(nombreResp);
        }
        if (!request.getParameter("apellidoResp").isEmpty()) {
            apellidoResp = request.getParameter("apellidoResp");
            responsable.setApellido(apellidoResp);
        }
        if (!request.getParameter("telefonoResp").isEmpty()) {
            telefonoResp = request.getParameter("telefonoResp");
            responsable.setTelefono(telefonoResp);
        }
        if (!request.getParameter("direccionResp").isEmpty()) {
            direccionResp = request.getParameter("direccionResp");
            responsable.setDireccion(direccionResp);
        }
        if (!request.getParameter("fechaNacResp").isEmpty()) {
            fechaNacResp = request.getParameter("fechaNacResp");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaNacRespLocalDate = LocalDate.parse(fechaNacResp, dtf);
            responsable.setFechaNac(fechaNacRespLocalDate);
        }
        if (!request.getParameter("tipoResp").isEmpty()) {
            tipoResp = request.getParameter("tipoResp");
            responsable.setTipoResp(tipoResp);
        }

        cL.crearPaciente(dni, nombre, apellido, telefono, direccion, fechaNac, tieneOs, tipoSangre, responsable);

        Mensaje mensaje = cL.crearMensaje("Paciente guardado", "El paciente fue guardado exitosamente en la base de datos.");
        session.setAttribute("mensaje", mensaje);
        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
