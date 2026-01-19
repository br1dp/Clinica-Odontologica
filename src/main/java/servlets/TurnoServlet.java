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
import logica.Paciente;
import logica.Turno;

@WebServlet(name = "TurnoServlet", urlPatterns = {"/TurnoServlet"})
public class TurnoServlet extends HttpServlet {

    ControladoraLogica cL = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        List<Turno> listaTurnos = cL.listarTurnos();
        
        session.setAttribute("listaTurnos", listaTurnos);
        
        response.sendRedirect("verTurnos.jsp");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        HttpSession session = request.getSession();
        
        String fechaTurno=null;
        String horaTurno=null;
        
        if (!request.getParameter("fechaTurno").isEmpty()) {
            fechaTurno = request.getParameter("fechaTurno");
        }
        if (!request.getParameter("horaTurno").isEmpty()) {
            horaTurno = request.getParameter("horaTurno");
        }
        
        cL.crearTurno(fechaTurno, horaTurno);
        List<Turno> listaTurnos = cL.listarTurnos();
        int idTurno = listaTurnos.getLast().getIdTurno();
        
        session.setAttribute("idTurno", idTurno);
        
        List<Paciente> listaPacientes = cL.listarPacientes();
        session.setAttribute("listaPacientes", listaPacientes);
        response.sendRedirect("asignarPacienteTurno.jsp");
        

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
