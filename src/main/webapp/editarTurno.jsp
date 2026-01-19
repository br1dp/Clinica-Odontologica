<%@page import="java.time.LocalDate"%>
<%@page import="logica.Turno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyInicio.jsp" %>

<%
    Turno turnoEditar = (Turno) request.getSession().getAttribute("turnoEditar");

%>
<div class="container">
    <div class="text-center my-5">
        <h1 class="display-4 text-gray-800" style="font-weight: 500;">Editar Turnos</h1>
        <div style="height: 4px; width: 60px; background-color: #4e73df; margin: 10px auto;"></div> 
    </div>

    <form class="user d-flex flex-column align-items-center" action="EditarTurno" method="POST">

        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="fechaTurno" placeholder="Fecha de turno (DD/MM/YYYY)">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="horaTurno" placeholder="Hora turno (hh:mm)">
        </div>
        <div class="col-sm-6 mb-3">
            <% if (turnoEditar.getPaciente() == null) {%>
            <label class="form-label d-block text-gray-800" style="text-align: center; text-decoration: underline;">Paciente</label>
            <span class="form-control-plaintext px-2 font-weight-bold" style="text-align: center;">
                No asignado
            </span>
            <% } else {%>
            <label class="form-label d-block text-gray-800" style="text-align: center; text-decoration: underline;">Paciente</label>
            <span class="form-control-plaintext px-2 font-weight-bold" style="text-align: center;">
                <%= turnoEditar.getPaciente().getDni() + ", " + turnoEditar.getPaciente().getNombre() + ", " + turnoEditar.getPaciente().getApellido()%>
            </span>
            <% }%>

        </div>
        <div class="col-sm-6 mb-3">
            <% if (turnoEditar.getOdontologo() == null) {%>
            <label class="form-label d-block text-gray-800" style="text-align: center; text-decoration: underline;">Odontologo</label>
            <span class="form-control-plaintext px-2 font-weight-bold" style="text-align: center;">
                No asignado
            </span>
            <% } else {%>
            <label class="form-label d-block text-gray-800" style="text-align: center; text-decoration: underline;">Odontologo</label>
            <span class="form-control-plaintext px-2 font-weight-bold" style="text-align: center;">
                <%= turnoEditar.getOdontologo().getNombre() + ", " + turnoEditar.getOdontologo().getApellido()%>
            </span>
            <% }%>

        </div>


        <button type="submit" class="col-sm-6 mb-3 btn btn-primary btn-user btn-block">
            Editar Turno
        </button>
    </form>
</div>

<%@include file="components/bodyFinal.jsp" %>