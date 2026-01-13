
<%@page import="logica.Paciente"%>
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
            <h6 class="m-0 font-weight-bold text-primary">Asignar paciente al turno</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>DNI</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Fecha Nacimiento</th>
                            <th>Obra Social</th>
                            <th>Tipo de sangre</th>
                            <th>Responsable</th>
                            <th style="width: 210px;">Accion</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>DNI</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Fecha Nacimiento</th>
                            <th>Obra Social</th>
                            <th>Tipo de sangre</th>
                            <th>Responsable</th>
                            <th style="width: 210px;">Accion</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <%
                            List<Paciente> listaPacientes = (List) session.getAttribute("listaPacientes");

                            if (listaPacientes != null) {

                                for (Paciente pac : listaPacientes) {


                        %>
                        <tr>
                            <td><%= pac.getDni()%></td>
                            <td><%= pac.getNombre()%></td>
                            <td><%= pac.getApellido()%></td>
                            <td><%= pac.getFechaNac()%></td>
                            <% if (pac.isTieneOs()) {%>
                            <td>Si</td> <% } else { %>
                            <td>No</td> <% }%>
                            <td><%= pac.getTipoSangre()%></td>
                            <% if (pac.getResponsable().getNombre() == null) { %>
                            <td> No tiene </td> <% } else { %>
                            <% if (pac.getResponsable().getTipoResp() != null) {%>
                            <td><%= pac.getResponsable().getNombre() + " " + pac.getResponsable().getApellido() + " Rol: " + pac.getResponsable().getTipoResp()%></td>
                            <% } else {%>
                            <td><%= pac.getResponsable().getNombre() + " " + pac.getResponsable().getApellido() + " Rol: " + "No asignado"%></td> 
                            <% }
                                } %>
                            <td style="display:flex; width:100px;">
                                <form name="editar" action="AsignarPacienteTurno" method="GET">
                                    <button type="submit" class="btn btn-primary btn-user btn-block">
                                        <i class="fas fa-pencil-alt"></i> Ver Turnos
                                    </button>
                                    <input type="hidden" name="id" value="<%= pac.getId()%>">
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
