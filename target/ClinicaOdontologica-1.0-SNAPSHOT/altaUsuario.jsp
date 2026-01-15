<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Iniciar sesion</title>

    <!-- Custom fonts for this template-->
    <link href="img/favicon.ico" rel="icon">
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

    <div class="container">


        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">

                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-login-image" 
                                 style="background: url('https://cdn.pixabay.com/photo/2025/10/02/14/13/dentist-9868527_1280.png');
                                 background-size: cover;
                                 background-repeat: no-repeat;">
                            </div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900">Crear usuario</h1>
                                        <div style="height: 4px; width: 60px; background-color: #4e73df; margin: 10px auto; margin-bottom: 20px;"></div>
                                    </div>
                                    <form class="user d-flex flex-column align-items-center" action="UsuarioServlet" method="POST">

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
                                        <p style="text-align: center;">Informacion: El usuario creado debe ser APROBADO por el administrador.</p>
                                    </form>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

</body>


