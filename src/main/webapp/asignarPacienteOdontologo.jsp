
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
    
    List<Odontologo> listaOdontologos = (List) session.getAttribute("listaOdontologos");
    Turno turno = (Turno) session.getAttribute("turnoPaciente");

%>

<div class="container-fluid">

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h5 class="m-0 font-weight-bold text-primary">Asignar odontologo para el paciente:  </h5>
            <h6 class="m-0 font-weight-bold text-primary" style="color: black;">DNI: </h6><h6 class="m-0" style="color: black;"><%= turno.getPaciente().getDni()%></h6>
            <h6 class="m-0 font-weight-bold text-primary" style="color: black;">Nombre y apellido: </h6><h6 class="m-0" style="color: black;"><%= turno.getPaciente().getNombre() + " " + turno.getPaciente().getApellido()%></h6>
            <h6 class="m-0 font-weight-bold text-primary" style="color: black;">Turno: </h6><h6 class="m-0" style="color: black;"><%= turno.getFechaTurno() + " " + turno.getHoraTruno()%></h6>

        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>DNI</th>
                            <th>Odontologo</th>
                            <th>Especialidad</th>
                            <th style="width: 150px;">Accion</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>DNI</th>
                            <th>Odontologo</th>
                            <th>Especialidad</th>
                            <th style="width: 150px;">Accion</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <%

                            if (listaOdontologos != null) {

                                for (Odontologo od : listaOdontologos) {


                        %>
                        <tr>

                            <td><%= od.getDni()%></td>
                            <td><%= od.getNombre() + ", " + od.getApellido()%></td>
                            <td><%= od.getEspecialidad()%></td>
                            <td style="display:flex;">

                                <form name="editar" action="AsignarOdontologoTurno" method="GET">
                                    <button type="submit" class="btn btn-primary btn-user btn-block">
                                        <i class="fas fa-solid fa-teeth"></i> Asignar Odontologo
                                    </button>
                                    <input type="hidden" name="idOdontologo" value="<%= od.getId()%>">
                                    <input type="hidden" name="idTurno" value="<%= turno.getIdTurno()%>">
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
