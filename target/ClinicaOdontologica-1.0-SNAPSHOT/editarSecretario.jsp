<%@page import="logica.Secretario"%>
<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyInicio.jsp" %>

<%
    Secretario secEditar = (Secretario) request.getSession().getAttribute("secEditar");

%>


<div class="container">
    <div class="text-center my-5">
        <h1 class="display-4 text-gray-800" style="font-weight: 500;">Editar Secretarios</h1>
        <div style="height: 4px; width: 60px; background-color: #4e73df; margin: 10px auto;"></div> 
    </div>

    <form class="user d-flex flex-column align-items-center" action="EditarSecretarioServlet" method="POST">

        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="dni" placeholder="<%= secEditar.getDni()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="nombre" placeholder="<%= secEditar.getNombre()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="apellido" placeholder="<%= secEditar.getApellido()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="telefono" placeholder="<%= secEditar.getTelefono()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="direccion" placeholder="<%= secEditar.getDireccion()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="fechaNac" placeholder="<%= secEditar.getFechaNac()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="sector" placeholder="<%= secEditar.getSector()%>">
        </div>


        <button type="submit" class="col-sm-6 mb-3 btn btn-primary btn-user btn-block">
            Editar Secretario
        </button>


    </form>
</div>

<%@include file="components/bodyFinal.jsp" %>