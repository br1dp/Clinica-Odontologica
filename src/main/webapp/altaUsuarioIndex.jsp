<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/bodyInicio.jsp" %>

<div class="container">
    <div class="text-center my-5">
        <h1 class="display-4 text-gray-800" style="font-weight: 500;">Alta Usuarios</h1>
        <div style="height: 4px; width: 60px; background-color: #4e73df; margin: 10px auto;"></div> 
    </div>

    <form class="user d-flex flex-column align-items-center" action="CrearUsuarioIndexServlet" method="POST">

        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" name="nombre" placeholder="Nombre">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="password" class="form-control form-control-user" name="password" placeholder="Password">
        </div>
        <div>

            <h1 class="h5 text-gray-900" style="text-align: center; margin-bottom: 5px; margin-top: 5px;">Rol</h1>
            <div style="height: 4px; width: 60px; background-color: #4e73df; margin: 10px auto; margin-bottom: 20px;"></div>

            <div class="roles-container" style="display: flex; justify-content: center; align-items: center; gap: 10px; width: 100%;margin-bottom: 20px;margin-top: 0px;">

                <div style="display: flex; align-items: center;">
                    <input type="radio" name="rol" id="odontologo" value="ODONTOLOGO">
                    <label for="odontologo" style="margin-bottom: 0; margin-left: 10px;">ODONTOLOGO</label>
                </div>

                <div style="display: flex; align-items: center;">
                    <input type="radio" name="rol" id="secretario" value="SECRETARIO">
                    <label for="secretario" style="margin-bottom: 0; margin-left: 10px;">SECRETARIO</label>
                </div>

            </div>
        </div>


        <div class="col-sm-6 mb-3">
            <button type="submit" class="btn btn-primary btn-user btn-block">
                Guardar Usuario
            </button>
        </div>

    </form>
</div>

<%@include file="components/bodyFinal.jsp" %>