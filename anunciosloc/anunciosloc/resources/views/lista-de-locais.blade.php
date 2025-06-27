<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <link rel="shortcut icon" href="img/icons/icon-48x48.png" />

    <title>AnúnciosLoc</title>
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
              
                            {{--verifica qual dos cabeçalho chamar --}}

                @if($userType === 'gestor')
                @include('gestor.cabecalho')


                @elseif($userType === 'cliente')


                @include('utilizador.cabecalho-utilizador')

                @endif

            </nav>

            <main class="content">
                <div class="container-fluid p-0">

                    <h1 class="h3 mb-3"><strong>Locais</strong></h1>


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
                        <div class="col-12 col-lg-8 col-xl-12 d-flex">
                            <div class="card flex-fill">
                                <div class="card-header">

                                    <h5 class="card-title mb-0">Lista de Locais</h5>
                                </div>
                                <table class="table table-hover my-0">
                                    <thead>
                                        <tr>
                                            <th>Nome</th>
                                            <th class=" d-xl-table-cell">Latitude</th>
                                            <th class=" d-xl-table-cell">Longitude</th>
                                            <th class=" d-xl-table-cell">Raio</th>
                                            <th class=" d-xl-table-cell">WiFi</th>
                                            <th class=" d-xl-table-cell">Infrastrutura</th>

                                            <th class=" d-xl-table-cell"> </th>
                                            <th class=" d-xl-table-cell"> </th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                    
                                            <td class=" d-xl-table-cell">Hotel Futila</td>
                                            <td class=" d-xl-table-cell">38.7343829</td>
                                            <td class=" d-xl-table-cell">-9.1403882</td>
                                            <td class=" d-xl-table-cell">20m</td>
                                            <td class=" d-md-table-cell">10</td>

                                            <td class=" d-md-table-cell">D9_Infrastrutura1</td>

                                            <td class=" d-md-table-cell">
                                                <a href="{{route('utilizador-editar-local') }}">
                                                    <i class="link-primary align-middle me-2" data-feather="edit-3"></i>
                                                </a>
                                            </td>
                                            <td class="d-none d-md-table-cell">
                                                <a href="#">
                                                    <i class="link-danger align-middle me-2" data-feather="trash-2"
                                                        data-bs-toggle="modal" data-bs-target="#modalConfirmar">
                                                    </i></a>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
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
        <div class="modal  fade" id="modalConfirmar" tabindex="-1" aria-labelledby="modalConfirmar" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header card-header">
                        <h5 class="card-title mb-0" id="modalConfirmar">
                        </h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body mx-auto">
                        Deseja realmente eliminar?
                    </div>
                    <div class="modal-footer card-header">
                        <button type="submit" class="btn btn-danger" data-bs-dismiss="modal">Cancelar</button>

                        <button type="submit" class="btn btn-success" data-bs-dismiss="modal">Sim</button>

                    </div>
                </div>
            </div>
        </div>
        <!-- fim confirmação -->

    </div>

    <script src="js/bootstrap.bundle.min.js"></script>

    <script src="js/app.js"></script>


<script>
    document.addEventListener('DOMContentLoaded', function() {
        const alerts = document.querySelectorAll('.alert.alert-dismissible'); // Seleciona apenas os alerts

        alerts.forEach(function(alertElement) {
            setTimeout(function() {
                // Remove a classe 'show' para iniciar a transição de saída
                alertElement.classList.remove('show');

                // Espera a transição terminar antes de remover o elemento do DOM
                alertElement.addEventListener('transitionend', function() {
                    alertElement.remove();
                }, {
                    once: true
                }); // { once: true } garante que o listener só será executado uma vez
            }, 2000); // 2000 milissegundos = 2 segundos
        });
    });
    </script>
</body>

</html>