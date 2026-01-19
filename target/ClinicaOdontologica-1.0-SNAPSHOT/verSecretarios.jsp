
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
                            <th>Sector</th>
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
                            <th>Sector</th>
                            <th>ID</th>
                            <th>Usuario</th>
                            <th style="width: 210px;">Accion</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <%
                            List<Secretario> listaSecretarios = (List) session.getAttribute("listaSecretarios");

                            if (listaSecretarios != null) {

                                for (Secretario sec : listaSecretarios) {


                        %>
                        <tr>
                            <td><%= sec.getDni()%></td>
                            <td><%= sec.getNombre()%></td>
                            <td><%= sec.getApellido()%></td>
                            <td><%= sec.getTelefono()%></td>
                            <td><%= sec.getDireccion()%></td>
                            <td><%= sec.getFechaNac()%></td>
                            <td><%= sec.getSector()%></td>
                            <td><%= sec.getUsuario().getIdUsuario()%></td>
                            <td><%= sec.getUsuario().getNombreUsuario()%></td>
                            <td style="display:flex; width:230px;">

                                <% if (usuario.getRol().equals("ADMIN") || usuario.getIdUsuario() == sec.getUsuario().getIdUsuario()) {%>

                                <form name="eliminar" action="EliminarSecretarioServlet" method="POST">
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:red;margin-right: 5px;">
                                        <i class="fas fa-trash-alt"></i> Eliminar
                                    </button>
                                    <input type="hidden" name="id" value="<%= sec.getId()%>">
                                </form>

                                <form name="editar" action="EditarSecretarioServlet" method="GET">
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px;">
                                        <i class="fas fa-pencil-alt"></i> Editar
                                    </button>
                                    <input type="hidden" name="id" value="<%= sec.getId()%>">
                                </form>

                            </td>
                        </tr>
                        <%       }

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
