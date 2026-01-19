
<%@page import="logica.Paciente"%>
<%@page import="java.time.LocalDate"%>
<%@page import="logica.Turno"%>
<%@page import="logica.Secretario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyInicio.jsp" %>


<div class="container-fluid">

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Turnos</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Fecha turno</th>
                            <th>Hora turno</th>
                            <th>Paciente</th>
                            <th>Afeccion</th>
                            <th>Odontologo</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Fecha turno</th>
                            <th>Hora turno</th>
                            <th>Paciente</th>
                            <th>Afeccion</th>
                            <th>Odontologo</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <%
                            Paciente paciente = (Paciente) session.getAttribute("pacienteVer");
                            List<Turno> listaTurnosPaciente = paciente.getListaTurnos();

                            if (listaTurnosPaciente != null) {

                                for (Turno turno : listaTurnosPaciente) {


                        %>
                        <tr>
                            <%                                
                                
                                
                                String diaTurno = String.valueOf(turno.getFechaTurno().getDayOfMonth());
                                String mesTurno = String.valueOf(turno.getFechaTurno().getMonthValue());
                                String anioTurno = String.valueOf(LocalDate.now().getYear());
                            %>
                            <td><%= anioTurno + "-" + mesTurno + "-" + diaTurno%></td>
                            <td><%= turno.getHoraTruno()%></td>
                            <% if (turno.getPaciente() != null) {%>
                            <td><%= paciente.getDni() + ", " + paciente.getNombre() + " " + paciente.getApellido()%></td>
                            <% } else { %>
                            <td>No asignado</td> <% }%>
                            <td><%= paciente.getAfeccion()%></td>
                            <% if (turno.getOdontologo() != null) {%>
                            <td><%= turno.getOdontologo().getNombre() + " " + turno.getOdontologo().getApellido()%></td>
                            <% } else { %>
                            <td>No asignado</td> <% }%>

                        </tr>
                        <%

                                }

                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>

<%@include file="components/bodyFinal.jsp" %>
