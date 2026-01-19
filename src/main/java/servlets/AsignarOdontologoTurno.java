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
import logica.Mensaje;
import logica.Odontologo;
import logica.Paciente;
import logica.Turno;

@WebServlet(name = "AsignarOdontologoTurno", urlPatterns = {"/AsignarOdontologoTurno"})
public class AsignarOdontologoTurno extends HttpServlet {

    ControladoraLogica cL = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    HttpSession session = request.getSession();

    int idOdontologo = Integer.parseInt(request.getParameter("idOdontologo"));
    Turno turnoActual = (Turno) session.getAttribute("turnoPaciente");
    
    Odontologo odontologoSeleccionado = cL.traerOdontologo(idOdontologo);

    List<Turno> listaTurnos = cL.traerTurnos();
    
    boolean existeConflicto = false;

    for (Turno t : listaTurnos) {
        if (t.getIdTurno() == turnoActual.getIdTurno()) {
            continue; 
        }

        boolean mismaFecha = t.getFechaTurno().equals(turnoActual.getFechaTurno());
        boolean mismaHora = t.getHoraTruno().equals(turnoActual.getHoraTruno());
        boolean mismoOdontologo = t.getOdontologo().getId() == idOdontologo;

        if (mismaFecha && mismaHora && mismoOdontologo) {
            existeConflicto = true;
            break;
        }
    }

    if (existeConflicto) {
        Mensaje mensaje = new Mensaje("Error al cargar turno", "El odontólogo ya tiene un turno en esa fecha y hora.");
        session.setAttribute("mensaje", mensaje);
        response.sendRedirect("index.jsp");

    } else {
        turnoActual.setOdontologo(odontologoSeleccionado);
        cL.editarTurno(turnoActual);
        
        Mensaje mensaje = new Mensaje("Turno creado", "El turno fue asignado exitosamente.");
        session.setAttribute("mensaje", mensaje);
        response.sendRedirect("index.jsp");
    }
}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
