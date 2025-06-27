<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Responsive Admin &amp; Dashboard Template based on Bootstrap 5">
    <meta name="author" content="AdminKit">
    <meta name="keywords"
        content="adminkit, bootstrap, bootstrap 5, admin, dashboard, template, responsive, css, sass, html, theme, front-end, ui kit, web">

    <link rel="shortcut icon" href="img/icons/icon-48x48.png" />


    <title>Meus Anúncios | AdminKit Demo</title>

    <link href="css/app.css" rel="stylesheet">
</head>

<body>
    <div class="wrapper">
        @include('utilizador.menu-utilizador')
        <div class="main">
            <nav class="navbar navbar-expand navbar-light navbar-bg">
                <a class="sidebar-toggle js-sidebar-toggle">
                    <i class="hamburger align-self-center"></i>
                </a>
                @include('utilizador.cabecalho-utilizador')

            </nav>



            <main class="content">
                <div class="container d-flex flex-column">

                    <div class="row  ">
                        <div class="">
                            <div class="">

                                <div class="text-center">
                                    <h1 class="h2"><strong>Registar Local</strong></h1>
                                </div>


                                <div class="card col-sm-10 col-md-30 col-lg-30 col-xl-8 mx-auto">
                                    <div class="card-body">
                                        <div class="m-sm-3">




                                            <img class="card-img-top" src="{{ asset('images/anuncio/viatura.jpeg') }}"
                                                alt="Unsplash">

                                            <div class="card-header ">
                                                <h5 class="card-title mb-0"> Queirós Lamborghini - "Moradia espaçosa em
                                                    Luanda"
                                                </h5>
                                            </div>

                                            <div class="card-body d-flex align-items-start">
                                                <p class="card-text">Moradia T3. com uma vista pra o mar</p>
                                                <p>contacto: 933719919.</p>
                                            </div>

                                            <div class="d-flex align-items-start mb-2">

                                                <div class="flex-grow-1">

                                                    <strong class="">Hoje as 7:51 pm</strong>

                                                    <a href="editar-local.html" class="float-end  ">
                                                        <i class="link-danger align-middle me-2"
                                                            data-feather="trash-2"></i>
                                                    </a>


                                                    <a href="{{route('editar_anuncio') }}" class="float-end">
                                                        <i class="link-primary align-middle me-2"
                                                            data-feather="edit-2"></i>
                                                    </a>

                                                    <a href="#" class="float-end  ">
                                                        <i class="link-success align-middle me-2"
                                                            data-feather="save"></i>
                                                    </a>

                                                </div>
                                            </div>




                                        </div>
                                    </div>
                                </div>



                                <div class="card col-sm-10 col-md-30 col-lg-30 col-xl-8 mx-auto">
                                    <div class="card-body">
                                        <div class="m-sm-3">




                                            <img class="card-img-top" src="{{ asset('images/anuncio/casa2.jpeg') }}"
                                                alt="Unsplash">

                                            <div class="card-header ">
                                                <h5 class="card-title mb-0">Queirós Lamborghini - "Moradia espaçosa em
                                                    Luanda"
                                                </h5>
                                            </div>

                                            <div class="card-body d-flex align-items-start">
                                                <p class="card-text">Moradia T3. com uma vista pra o mar</p>
                                                <p>
                                                    contacto: 933719919.</p>
                                            </div>

                                            <div class="d-flex align-items-start mb-2">

                                                <div class="flex-grow-1">

                                                    <strong class="">Hoje as 7:51 pm</strong>

                                                    <a href="editar-local.html" class="float-end  ">
                                                        <i class="link-danger align-middle me-2"
                                                            data-feather="trash-2"></i>
                                                    </a>


                                                    <a href="{{route('editar_anuncio') }}" class="float-end">
                                                        <i class="link-primary align-middle me-2"
                                                            data-feather="edit-2"></i>
                                                    </a>

                                                     <a href="#" class="float-end  ">
                                                        <i class="link-success align-middle me-2"
                                                            data-feather="save"></i>
                                                    </a>

                                                </div>
                                            </div>




                                        </div>
                                    </div>
                                </div>



                            </div>
                        </div>
                    </div>
                </div>
            </main>


            @include('utilizador.rodape')

        </div>
    </div>

    <script src="js/app.js"></script>

</body>

</html>