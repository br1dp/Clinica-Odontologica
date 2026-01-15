
<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%

        session = request.getSession();

        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario == null) {

            response.sendRedirect("login.jsp");

        } else {

    %>
    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="MenuServlet">
                    <div class="sidebar-brand-icon rotate-n-15">
                        <i class="fas fa-light fa-tooth"></i>
                    </div>

                    <div class="sidebar-brand-text mx-3">- TEDIEN - Clinica Odontologica</div>

                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0">

                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Heading -->
                <div class="sidebar-heading">
                    Gestion
                </div>

                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                       aria-expanded="true" aria-controls="collapseTwo">
                        <i class="fas fa-teeth"></i>
                        <span>Odontologos</span>
                    </a>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Acciones:</h6>
                            <% if (usuario.getRol().equals("SECRETARIO")) { %>
                            <a class="collapse-item" href="buttons.html">Ver Odontologos</a>
                            <%} else {%>
                            <a class="collapse-item" href="altaOdontologo.jsp">Crear Odontologos</a>
                            <a class="collapse-item" href="buttons.html">Ver Odontologos</a>
                            <% }; %>
                        </div>
                    </div>
                </li>

                <!-- Nav Item - Utilities Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                       aria-expanded="true" aria-controls="collapseUtilities">
                        <i class="fas fa-thin fa-tooth"></i>
                        <span>Pacientes</span>
                    </a>
                    <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                         data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Acciones:</h6>
                            <% if (usuario.getRol().equals("ODONTOLOGO")) { %>
                            <a class="collapse-item" href="TurnoServlet">Ver Turnos</a>
                            <% } else { %>
                            <a class="collapse-item" href="altaPaciente.jsp">Crear Pacientes</a>
                            <a class="collapse-item" href="MenuTurnoServlet">Asignar Turnos</a>
                            <a class="collapse-item" href="PacienteServlet">Ver Pacientes</a>
                            <% }; %>
                        </div>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities3"
                       aria-expanded="true" aria-controls="collapseUtilities">
                        <i class="fas fa-briefcase"></i>
                        <span>Secretarios</span>
                    </a>
                    <div id="collapseUtilities3" class="collapse" aria-labelledby="headingUtilities"
                         data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Acciones:</h6>
                            <% if (usuario.getRol().equals("ODONTOLOGO")) {%>
                            <a class="collapse-item" href="SecretarioServlet">Ver Secretarios</a>
                            <% } else { %>
                            <a class="collapse-item" href="altaSecretario.jsp">Crear Secretarios</a>
                            <a class="collapse-item" href="SecretarioServlet">Ver Secretarios</a>
                            <% }; %>
                        </div>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities2"
                       aria-expanded="true" aria-controls="collapseUtilities">
                        <i class="fas fa-user"></i>
                        <span>Usuarios</span>
                    </a>
                    <div id="collapseUtilities2" class="collapse" aria-labelledby="headingUtilities"
                         data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Acciones:</h6>
                            <a class="collapse-item" href="altaUsuarioIndex.jsp">Crear Usuario</a>
                            <a class="collapse-item" href="UsuarioServlet">Ver Usuarios</a>
                        </div>
                    </div>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">


                <div class="sidebar-card d-none d-lg-flex">
                    <img class="sidebar-card-illustration mb-2" src="img/dienteimg.png" alt="...">

                </div>

            </ul>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>

                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">

                            <div class="topbar-divider d-none d-sm-block"></div>

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">

                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%=usuario.getNombreUsuario() + " (" + usuario.getRol() +")"%> </span>
                                    <img class="img-profile rounded-circle"
                                         src="img/undraw_profile.svg">
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                     aria-labelledby="userDropdown">
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Salir
                                    </a>
                                </div>
                            </li>

                        </ul>

                    </nav>
                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid">

                        <!-- Page Heading -->

                        </html>
                        <%}%>