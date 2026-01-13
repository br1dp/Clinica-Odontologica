<%@page import="logica.Mensaje"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyInicio.jsp" %>
<% Mensaje mensaje = (Mensaje) session.getAttribute("mensaje");
    if(mensaje!=null){%>


<div class="text-center my-5">
    <h1 class="display-4 text-gray-800" style="font-weight: 500;"><%= mensaje.getTitulo()%></h1>
    <p><%= mensaje.getDescripcion()%> </p>
    <div style="height: 4px; width: 60px; background-color: #4e73df; margin: 10px auto;"></div> 
</div>

<div style="background-image: url('https://cdn.pixabay.com/photo/2016/07/06/20/50/tooth-1501321_1280.png');
     background-size: contain;
     background-repeat: no-repeat;
     background-position: center;
     height: 70vh;
     width: 100%;
     background-color: #f8f9fc;"> 
</div>
<% } %>
<%@include file="components/bodyFinal.jsp" %>