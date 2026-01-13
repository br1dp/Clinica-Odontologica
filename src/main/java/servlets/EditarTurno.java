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
import logica.Turno;

@WebServlet(name = "EditarTurno", urlPatterns = {"/EditarTurno"})
public class EditarTurno extends HttpServlet {

    ControladoraLogica cL = new ControladoraLogica();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        int idTurno = Integer.parseInt(request.getParameter("id"));
        Turno turnoEditar = cL.traerTurno(idTurno);

        session.setAttribute("turnoEditar", turnoEditar);

        response.sendRedirect("editarTurno.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Turno turnoEditar = (Turno) session.getAttribute("turnoEditar");
        
        
        String fechaTurno = request.getParameter("fechaTurno");
        String horaTurno = request.getParameter("horaTurno");
        String afeccion = request.getParameter("afeccion");

        if (!fechaTurno.isEmpty()) {
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            fechaTurno = request.getParameter("fechaTurno");
            LocalDate fechaTurnoLocalDate = LocalDate.parse(fechaTurno, dtf);
            turnoEditar.setFechaTurno(fechaTurnoLocalDate);
            
        }
        if (!horaTurno.isEmpty()) {
            
            turnoEditar.setHoraTruno(horaTurno);
            
        }
        if (!afeccion.isEmpty()) {
            
            turnoEditar.setAfeccion(afeccion);
        }

        
        cL.editarTurno(turnoEditar);
        
        Mensaje mensaje = cL.crearMensaje("Turno modificado", "El turno fue modificado exitosamente en la base de datos.");
        session.setAttribute("mensaje", mensaje);
        
        response.sendRedirect("menuTurnos.jsp");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
