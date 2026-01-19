
<%@page import="logica.Odontologo"%>
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


<%
    Turno turno = (Turno) session.getAttribute("turnoPaciente");
    List<Turno> listaTurnos = (List) session.getAttribute("listaTurnos");

%>

<div class="container-fluid">

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h5 class="m-0 font-weight-bold text-primary">Asignar turno para el paciente:  </h5>
            <h6 class="m-0 font-weight-bold text-primary" style="color: black;">DNI: </h6><h6 class="m-0" style="color: black;"><%= pacienteTurno.getDni()%></h6>
            <h6 class="m-0 font-weight-bold text-primary" style="color: black;">Nombre y apellido: </h6><h6 class="m-0" style="color: black;"><%= pacienteTurno.getNombre() + " " + pacienteTurno.getApellido()%></h6>

        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Fecha</th>
                            <th>Hora</th>
                            <th style="width: 150px;">Accion</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Fecha</th>
                            <th>Hora</th>
                            <th style="width: 150px;">Accion</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <%

                            if (listaTurnos != null) {


                        %>
                        <tr>

                            <td><%= turno.getFechaTurno()%></td>
                            <td><%= turno.getHoraTruno()%></td>
                            <td style="display:flex;">

                                <form name="editar" action="AsignarPacienteTurno" method="POST">
                                    <button type="submit" class="btn btn-primary btn-user btn-block">
                                        <i class="fas fa-regular fa-calendar"></i> Seleccionar
                                    </button>
                                    <input type="hidden" name="idTurno" value="<%= turno.getIdTurno()%>">
                                </form>

                            </td>
                        </tr>
                        <%

                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>

<%@include file="components/bodyFinal.jsp" %>
