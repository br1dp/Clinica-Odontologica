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

        int idPaciente = Integer.parseInt(request.getParameter("idPaciente"));
        int idTurno = Integer.parseInt(request.getParameter("idTurno"));
        
        Paciente paciente = cL.traerPaciente(idPaciente);
        Turno turno = cL.traerTurno(idTurno);
        List<Odontologo> listaOdontologos = cL.traerOdontologos();
        turno.setPaciente(paciente);
        session.setAttribute("listaOdontologos", listaOdontologos);
        session.setAttribute("turnoPaciente", turno);

        response.sendRedirect("asignarPacienteOdontologo.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        int idTurno = Integer.parseInt(request.getParameter("idTurno"));
        Turno turnoPaciente = cL.traerTurno(idTurno);

        Paciente pacienteTurno = (Paciente) session.getAttribute("pacienteTurno");
        List<Turno> listaTurnos = cL.traerTurnos();
        

        
            
            pacienteTurno.getListaTurnos().add(turnoPaciente);

            session.setAttribute(("turnoPaciente"), turnoPaciente);

            cL.editarPaciente(pacienteTurno);

            List<Odontologo> listaOdontologos = cL.traerOdontologos();
            session.setAttribute("listaOdontologos", listaOdontologos);

            response.sendRedirect("asignarPacienteOdontologo.jsp");

      
            
        

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
