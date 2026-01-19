<%@page import="logica.Mensaje"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyInicio.jsp" %>

<%    
    if (!usuario.getRol().equals("ODONTOLOGO")) {
        
        Mensaje mensaje = (Mensaje) session.getAttribute("mensaje");
        if (mensaje != null) {%>

<div class="text-center my-5">
    <h1 class="display-4 text-gray-800" style="font-weight: 500;"><%= mensaje.getTitulo()%></h1>
    <p><%= mensaje.getDescripcion()%> </p>
    <div style="height: 4px; width: 60px; background-color: #4e73df; margin: 10px auto;"></div> 
</div>


<div class="user d-flex flex-column align-items-center">
    <div class="col-sm-6 mb-3">
        <a href="altaTurno.jsp" type="submit" class="btn btn-primary btn-user btn-block">
            <i class="fas fa-solid fa-plus"></i>
            Nuevo Turno
        </a>
    </div>
    <div class="col-sm-6 mb-3">

        <a href="TurnoServlet" type="submit" class="btn btn-primary btn-user btn-block">
            <i class="fas fa-regular fa-calendar"></i>
            Ver Turnos
        </a>
    </div>

</div>

<% }
    } else {
        response.sendRedirect("index.jsp");
    }%>

<%@include file="components/bodyFinal.jsp" %>
