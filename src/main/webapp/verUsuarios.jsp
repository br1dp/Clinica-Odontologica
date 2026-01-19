
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
            <h6 class="m-0 font-weight-bold text-primary">Usuarios</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Usuario</th>
                            <th>Rol</th>
                            <th>Estado</th>
                            <th style="width: 210px;">Accion</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>ID</th>
                            <th>Usuario</th>
                            <th>Rol</th>
                            <th>Estado</th>
                            <th style="width: 210px;">Accion</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <%
                            List<Usuario> listaUsuarios = (List) request.getSession().getAttribute("listaUsuarios");

                            if (listaUsuarios != null) {

                                for (Usuario usu : listaUsuarios) {


                        %>
                        <tr>
                            <td><%= usu.getIdUsuario()%></td>
                            <td><%= usu.getNombreUsuario()%></td>
                            <td><%= usu.getRol()%></td>
                            <td><%= usu.getEstado()%></td>
                            <td style="display:flex; width:230px;">


                                <%
                                    if (usuario.getRol().equals("ADMIN")) {
                                %>
                                <form name="eliminar" action="EliminarUsuarioServlet" method="POST">
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:red;margin-right: 5px;">
                                        <i class="fas fa-trash-alt"></i> Eliminar
                                    </button>
                                    <input type="hidden" name="id" value="<%= usu.getIdUsuario()%>">
                                </form>
                                <form name="editar" action="EditarUsuarioServlet" method="GET">
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px;">
                                        <i class="fas fa-pencil-alt"></i> Editar
                                    </button>
                                    <input type="hidden" name="id" value="<%= usu.getIdUsuario()%>">
                                </form>
                            </td>
                        </tr>
                        <%
                                    }

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
