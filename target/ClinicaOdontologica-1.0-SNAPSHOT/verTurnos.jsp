
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
                            <th>Afeccion</th>
                            <th>Paciente</th>
                            <th>Odontologo</th>
                            <th style="width: 210px;">Accion</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Fecha turno</th>
                            <th>Hora turno</th>
                            <th>Afeccion</th>
                            <th>Paciente</th>
                            <th>Odontologo</th>
                            <th style="width: 210px;">Accion</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <%
                            List<Turno> listaTurnos = (List) session.getAttribute("listaTurnos");

                            if (listaTurnos != null) {

                                for (Turno turno : listaTurnos) {


                        %>
                        <tr>
                            <% 
                                String diaTurno = String.valueOf(turno.getFechaTurno().getDayOfMonth());
                                String mesTurno = String.valueOf(turno.getFechaTurno().getMonthValue());
                                String anioTurno = String.valueOf(LocalDate.now().getYear());
                            %>
                            <td><%= anioTurno+"-"+mesTurno+"-"+diaTurno %></td>
                            <td><%= turno.getHoraTruno()%></td>
                            <td><%= turno.getAfeccion()%></td>
                            <% if (turno.getPaciente() != null) {%>
                            <td><%= turno.getPaciente().getDni() + ", " + turno.getPaciente().getNombre() + ", " + turno.getPaciente().getApellido()%></td>
                            <% } else { %>
                            <td>No asignado</td> <% }%>
                            <% if (turno.getOdontologo() != null) {%>
                            <td><%= turno.getOdontologo().getNombre() + ", " + turno.getOdontologo().getApellido()%></td>
                            <% } else { %>
                            <td>No asignado</td> <% }%>
                            <td style="display:flex; width:230px;">

                                <form name="eliminar" action="EliminarTurno" method="POST">
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:red;margin-right: 5px;">
                                        <i class="fas fa-trash-alt"></i> Eliminar
                                    </button>
                                    <input type="hidden" name="id" value="<%= turno.getIdTurno()%>">
                                </form>

                                <form name="editar" action="EditarTurno" method="GET">
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px;">
                                        <i class="fas fa-pencil-alt"></i> Editar
                                    </button>
                                    <input type="hidden" name="id" value="<%= turno.getIdTurno()%>">
                                </form>

                            </td>
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
