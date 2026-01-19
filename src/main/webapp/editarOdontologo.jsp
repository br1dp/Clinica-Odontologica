<%@page import="logica.Odontologo"%>
<%@page import="logica.Paciente"%>
<%@page import="logica.Secretario"%>
<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyInicio.jsp" %>

<%
    Odontologo odontologoEditar = (Odontologo) request.getSession().getAttribute("odontologoEditar");

%>


<div class="container">
    <div class="text-center my-5">
        <h1 class="display-4 text-gray-800" style="font-weight: 500;">Editar Odontologo</h1>
        <div style="height: 4px; width: 60px; background-color: #4e73df; margin: 10px auto;"></div> 
    </div>

    <form class="user d-flex flex-column align-items-center" action="EditarOdontologoServlet" method="POST">

        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="dni" placeholder="<%= odontologoEditar.getDni()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="nombre" placeholder="<%= odontologoEditar.getNombre()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="apellido" placeholder="<%= odontologoEditar.getApellido()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="telefono" placeholder="<%= odontologoEditar.getTelefono()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="direccion" placeholder="<%= odontologoEditar.getDireccion()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="fechaNac" placeholder="<%= odontologoEditar.getFechaNac()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="especialidad" placeholder= <%= odontologoEditar.getEspecialidad()%>>
        </div>

        <button type="submit" class="col-sm-6 mb-3 btn btn-primary btn-user btn-block">
            Editar Odontologo
        </button>


    </form>
</div>

<%@include file="components/bodyFinal.jsp" %>