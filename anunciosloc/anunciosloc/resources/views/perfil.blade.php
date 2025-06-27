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


    <title>{{ config('app.name', 'Laravel') }}</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">

    <link href="css/app.css" rel="stylesheet">
</head>

<body>
    <div class="wrapper">


        {{--verifica qual dos menus chamar --}}
        @if($userType === 'gestor')

        @include('gestor.menu')

        @elseif($userType === 'cliente')

        @include('utilizador.menu-utilizador')
        @endif



        <div class="main">
            <nav class="navbar navbar-expand navbar-light navbar-bg">
                <a class="sidebar-toggle js-sidebar-toggle">
                    <i class="hamburger align-self-center"></i>
                </a>

                @if($userType === 'gestor')
                @include('gestor.cabecalho')


                @elseif($userType === 'cliente')


                @include('utilizador.cabecalho-utilizador')

                @endif

            </nav>

            <main class="content">
                <div class="container-fluid p-0">

                    <div class="mb-3">
                        <h1 class="h3 d-inline align-middle">Prefil</h1>

                    </div>
                    @if (session('success'))
                    <div class="alert alert-success alert-dismissible fade show" role="alert">
                        {{ session('success') }}
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                    @endif

                    {{-- ALERTA DE ERRO --}}
                    @if (session('error'))
                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
                        {{ session('error') }}
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                    @endif
                    <div class="row">
                        <div class="col-md-4 col-xl-3">
                            <div class="card mb-3">
                                <div class="card-header">
                                    <h5 class="card-title mb-0">Meu Prefil</h5>
                                </div>
                                <div class="card-body text-center">
                                    <img src="{{ asset('images/logo/logo.png') }}" alt="Christina Mason"
                                        class="img-fluid rounded mb-2" width="100" height="128" />

                                    <h5 class="card-title text-muted mb-0"> Queirós Lamborghini

                                        <a data-toggle="modal" href="#modal-editar-nome">
                                            <i class="link-primary align-middle me-2" data-feather="edit-2"
                                                data-bs-toggle="modal" data-bs-target="#modalEditarNome"></i>
                                        </a>

                                    </h5>
                                    <div class="text-muted mb-2">antonioqueiros744@gmail.com
                                    </div>

                                    <div>

                                        <a class="btn btn-primary btn-sm" href="#">
                                            <span data-feather="dollar-sign"></span> 12.000 Kzs</a>
                                    </div>
                                </div>
                                <hr class="my-0" />

                            </div>
                        </div>

                        <div class="col-md-8 col-xl-9">
                            <div class="card">
                                <div class="card-header">

                                    <h5 class="card-title mb-0">Meus Interesses
                                        <a href="{{route('adicionar-interesses')}}" class="">
                                            <i class="link-success align-middle" data-feather="plus-circle"></i>
                                        </a>
                                    </h5>

                                </div>
                                <div class="card-body h-100">

                                    <div class="d-flex align-items-start">

                                        <div class="flex-grow-1">

                                            <a class="float-end  ">
                                                <i class="link-danger align-middle me-2" data-feather="trash-2"
                                                    data-bs-toggle="modal" data-bs-target="#modalEliminar"></i>
                                            </a>

                                            <a href="{{route('editar-interesses')}}" class="float-end ">
                                                <i class="link-primary align-middle me-2" data-feather="edit-2"></i>
                                            </a>

                                            <strong>Cantor</strong> 50 Cent <br />

                                        </div>
                                    </div>

                                    <hr />
                                    <div class="d-flex align-items-start">

                                        <div class="flex-grow-1">

                                            <a href="#" class="float-end  ">
                                                <i class="link-danger align-middle me-2" data-feather="trash-2"
                                                    data-bs-toggle="modal" data-bs-target="#modalEliminar"></i>
                                            </a>

                                            <a href="{{route('editar-interesses')}}" class="float-end ">
                                                <i class="link-primary align-middle me-2" data-feather="edit-2"></i>
                                            </a>

                                            <strong>Team</strong> Barcelona <br />

                                        </div>
                                    </div>


                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </main>

            {{-- Verifica qual dos rodapes deve chamar --}}
            @if($userType === 'gestor')


            @include('gestor.rodape')

            @elseif($userType === 'cliente')

            @include('utilizador.rodape')

            @endif


        </div>

    </div>

    <div class="card">

        <!-- inicio confirmação -->
        <div class="modal  fade" id="modalEliminar" tabindex="-1" aria-labelledby="modalEliminar" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header card-header">
                        <h5 class="card-title mb-0" id="modalEliminar">
                        </h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body mx-auto">
                        <form action="{{ route('eliminar_interesse') }}" method="POST">
                            @csrf
                            Deseja realmente eliminar?
                            <div class="modal-footer card-header">
                                <button type="submit" class="btn btn-danger" data-bs-dismiss="modal">Cancelar</button>

                                <button type="submit" class="btn btn-success" data-bs-dismiss="modal">Sim</button>

                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
        <!-- fim confirmação -->

        <!-- inicio editar nome -->
        <div class="modal  fade" data-bs-backdrop="static" id="modalEditarNome" tabindex="-1"
            aria-labelledby="modalEditarNomeLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header card-header">
                        <h5 class="card-title mb-0" id="modalEditarNomeLabel">Editar Nome
                        </h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body mx-auto">
                        <form class="" method="POST" action="{{route('validar-nome')}}">
                            @csrf
                            <div class="d-inline-flex ">
                                <input type="text" class="mr-8 form-control" id="campoExemplo" name="nome">
                                @error('nome')
                                <div style="color: red;">{{ $message }}</div>
                                @enderror
                                <button type="submit" class="btn btn-success">Salvar</button>

                            </div>
                        </form>
                    </div>
                    <div class="modal-footer card-header">

                    </div>
                </div>
            </div>
        </div>
        <!-- fim editar nome -->

    </div>

    <script src="js/bootstrap.bundle.min.js"></script>

    <script src="js/app.js"></script>
    <script src="js/meujs.js"></script>



</body>

</html>