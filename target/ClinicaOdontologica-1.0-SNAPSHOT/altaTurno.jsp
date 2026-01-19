<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyInicio.jsp" %>

<div class="container">
    <div class="text-center my-5">
        <h1 class="display-4 text-gray-800" style="font-weight: 500;">Alta Turnos</h1>
        <div style="height: 4px; width: 60px; background-color: #4e73df; margin: 10px auto;"></div> 
    </div>

    <form class="user d-flex flex-column align-items-center" action="TurnoServlet" method="POST">

        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="fechaTurno" placeholder="Fecha de turno (DD/MM/YYYY)">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="horaTurno" placeholder="Hora turno (hh:mm)">
        </div>
        

        <div class="col-sm-6 mb-3">
            <button type="submit" class="btn btn-primary btn-user btn-block">
                Seleccionar paciente
            </button>
        </div>

    </form>
</div>

<%@include file="components/bodyFinal.jsp" %>