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

@WebServlet(name = "VerPacientesAsignarTurnoServlet", urlPatterns = {"/VerPacientesAsignarTurnoServlet"})
public class VerPacientesAsignarTurnoServlet extends HttpServlet {

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

        response.sendRedirect("asignarPacienteTurno.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
