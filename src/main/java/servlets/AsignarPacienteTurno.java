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
import logica.Paciente;
import logica.Turno;

@WebServlet(name = "AsignarPacienteTurno", urlPatterns = {"/AsignarPacienteTurno"})
public class AsignarPacienteTurno extends HttpServlet {
    
    ControladoraLogica cL = new ControladoraLogica();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        HttpSession session = request.getSession();
        int idPaciente = Integer.parseInt(request.getParameter("id"));
        Paciente pacienteTurno = cL.traerPaciente(idPaciente);
        List<Turno> listaTurnos = cL.listarTurnos();
        
        session.setAttribute("listaTurnos", listaTurnos);
        session.setAttribute("pacienteTurno", pacienteTurno);
        
        response.sendRedirect("verTurnosPaciente.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        int idTurno = Integer.parseInt(request.getParameter("id"));
        Turno turnoPaciente = cL.traerTurno(idTurno);
        
        Paciente pacienteTurno = (Paciente) session.getAttribute("pacienteTurno");
        
        pacienteTurno.getListaTurnos().add(turnoPaciente);
        
        cL.editarPaciente(pacienteTurno);
        
        Mensaje mensaje = cL.crearMensaje("Gestion de turnos", "Turno asignado exitosamente al paciente "+pacienteTurno.getDni()+", "+pacienteTurno.getNombre()+" "+pacienteTurno.getApellido()+".");
        
        session.setAttribute("mensaje", mensaje);
        
        response.sendRedirect("menuTurnos.jsp");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
