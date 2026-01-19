
<%@page import="logica.Odontologo"%>
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
            <h6 class="m-0 font-weight-bold text-primary">Secretarios</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>DNI</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Telefono</th>
                            <th>Direccion</th>
                            <th>Fecha Nacimiento</th>
                            <th>Especialidad</th>
                            <th>ID</th>
                            <th>Usuario</th>
                            <th style="width: 210px;">Accion</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>DNI</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Telefono</th>
                            <th>Direccion</th>
                            <th>Fecha Nacimiento</th>
                            <th>Especialidad</th>
                            <th>ID</th>
                            <th>Usuario</th>
                            <th style="width: 210px;">Accion</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <%
                            List<Odontologo> listaOdontologos = (List) session.getAttribute("listaOdontologos");

                            if (listaOdontologos != null) {

                                for (Odontologo od : listaOdontologos) {


                        %>
                        <tr>
                            <td><%= od.getDni()%></td>
                            <td><%= od.getNombre()%></td>
                            <td><%= od.getApellido()%></td>
                            <td><%= od.getTelefono()%></td>
                            <td><%= od.getDireccion()%></td>
                            <td><%= od.getFechaNac()%></td>
                            <td><%= od.getEspecialidad()%></td>
                            <td><%= od.getUsuario().getIdUsuario()%></td>
                            <td><%= od.getUsuario().getNombreUsuario()%></td>
                            <td style="display:flex; width:230px;">

                                <% if (usuario.getRol().equals("ADMIN") || usuario.getIdUsuario() == od.getUsuario().getIdUsuario()) {%>

                                <form name="eliminar" action="EliminarOdontologoServlet" method="POST">
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:red;margin-right: 5px;">
                                        <i class="fas fa-trash-alt"></i> Eliminar
                                    </button>
                                    <input type="hidden" name="id" value="<%= od.getId()%>">
                                </form>

                                <form name="editar" action="EditarOdontologoServlet" method="GET">
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px;">
                                        <i class="fas fa-pencil-alt"></i> Editar
                                    </button>
                                    <input type="hidden" name="id" value="<%= od.getId()%>">
                                </form>

                            </td>
                        </tr>
                        <%   }

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
