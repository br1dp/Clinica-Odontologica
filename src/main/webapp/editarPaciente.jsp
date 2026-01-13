<%@page import="logica.Paciente"%>
<%@page import="logica.Secretario"%>
<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyInicio.jsp" %>

<%
    Paciente pacienteEditar = (Paciente) request.getSession().getAttribute("pacienteEditar");

%>


<div class="container">
    <div class="text-center my-5">
        <h1 class="display-4 text-gray-800" style="font-weight: 500;">Editar Pacientes</h1>
        <div style="height: 4px; width: 60px; background-color: #4e73df; margin: 10px auto;"></div> 
    </div>

    <form class="user d-flex flex-column align-items-center" action="EditarPaciente" method="POST">

        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="dni" placeholder="<%= pacienteEditar.getDni()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="nombre" placeholder="<%= pacienteEditar.getNombre()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="apellido" placeholder="<%= pacienteEditar.getApellido()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="telefono" placeholder="<%= pacienteEditar.getTelefono()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="direccion" placeholder="<%= pacienteEditar.getDireccion()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="fechaNac" placeholder="<%= pacienteEditar.getFechaNac()%>">
        </div>
        <div>
            <h1 class="h5 text-gray-900" style="text-align: center; margin-bottom: 5px; margin-top: 5px;">¿Tiene Obra Social?</h1>
            <div style="height: 4px; width: 60px; background-color: #4e73df; margin: 10px auto; margin-bottom: 20px;"></div>

            <div class="roles-container" style="display: flex; justify-content: center; align-items: center; gap: 10px; width: 100%;margin-bottom: 20px;margin-top: 0px;">

                <div style="display: flex; align-items: center; margin-right: 100px;">
                    <input type="radio" name="tieneOs" id="tieneOs" value="1">
                    <label for="tieneOs" style="margin-bottom: 0; margin-left: 5px;">SI</label>
                </div>

                <div style="display: flex; align-items: center;">
                    <input type="radio" name="tieneOs" id="tieneOs" value="0">
                    <label for="tieneOs" style="margin-bottom: 0; margin-left: 5px;">NO</label>
                </div>
            </div>    
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="tipoSangre" placeholder="<%= pacienteEditar.getTipoSangre()%>">
        </div>
        <div class="text-center my-5">
            <h1 class="display-4 text-gray-800" style="font-weight: 500;">¿Tiene responsable a cargo?</h1>
            <p>En caso de ser necesario, agregue un responsable. En caso contrario pulse el boton "Editar Paciente"</p>
            <div style="height: 4px; width: 60px; background-color: #4e73df; margin: 10px auto;"></div> 
        </div>

        <div class="col-sm-6 mb-3">

            <% if (pacienteEditar.getResponsable().getDni() != null) {%>
            <input type="text" class="form-control form-control-user" name="dniResp" 
                   placeholder="<%= pacienteEditar.getResponsable().getDni()%>">
            <% } else { %> 
            <input type="text" class="form-control form-control-user" name="dniResp" 
                   placeholder="DNI"> <% }%>
        </div>
        <div class="col-sm-6 mb-3">

            <% if (pacienteEditar.getResponsable().getNombre() != null) {%>
            <input type="text" class="form-control form-control-user" name="nombreResp" 
                   placeholder="<%= pacienteEditar.getResponsable().getNombre()%>">
            <% } else { %> 
            <input type="text" class="form-control form-control-user" name="nombreResp" 
                   placeholder="Nombre"> <% }%>
        </div>
        <div class="col-sm-6 mb-3">

            <% if (pacienteEditar.getResponsable().getApellido() != null) {%>
            <input type="text" class="form-control form-control-user" name="apellidoResp" 
                   placeholder="<%= pacienteEditar.getResponsable().getApellido()%>">
            <% } else { %> 
            <input type="text" class="form-control form-control-user" name="apellidoResp" 
                   placeholder="Apellido"> <% }%>
        </div>
        <div class="col-sm-6 mb-3">

            <% if (pacienteEditar.getResponsable().getTelefono() != null) {%>
            <input type="text" class="form-control form-control-user" name="telefonoResp" 
                   placeholder="<%= pacienteEditar.getResponsable().getTelefono()%>">
            <% } else { %> 
            <input type="text" class="form-control form-control-user" name="telefonoResp" 
                   placeholder="Telefono"> <% }%>
        </div>
        <div class="col-sm-6 mb-3">

            <% if (pacienteEditar.getResponsable().getDireccion() != null) {%>
            <input type="text" class="form-control form-control-user" name="direccionResp" 
                   placeholder="<%= pacienteEditar.getResponsable().getDireccion()%>">
            <% } else { %> 
            <input type="text" class="form-control form-control-user" name="direccionResp" 
                   placeholder="Direccion"> <% }%>
        </div>
        <div class="col-sm-6 mb-3">

            <% if (pacienteEditar.getResponsable().getFechaNac() != null) {%>
            <input type="text" class="form-control form-control-user" name="fechaNacResp" 
                   placeholder="<%= pacienteEditar.getResponsable().getFechaNac()%>">
            <% } else { %> 
            <input type="text" class="form-control form-control-user" name="fechaNacResp" 
                   placeholder="Fecha de Nacimiento (DD/MM/AAAA)"> <% }%>
        </div>
        <div class="col-sm-6 mb-3">

            <% if (pacienteEditar.getResponsable().getTipoResp() != null) {%>
            <input type="text" class="form-control form-control-user" name="tipoResp" 
                   placeholder="<%= pacienteEditar.getResponsable().getTipoResp()%>">
            <% } else { %> 
            <input type="text" class="form-control form-control-user" name="tipoResp" 
                   placeholder="Tipo de responsabilidad"> <% } %>
        </div>

        
        <button type="submit" class="col-sm-6 mb-3 btn btn-primary btn-user btn-block">
            Editar Paciente
        </button>


    </form>
</div>

<%@include file="components/bodyFinal.jsp" %>