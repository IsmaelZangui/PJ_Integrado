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



    <title>{{ config('app.name', 'Laravel') }}</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">

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
                <div class="container-fluid p-0">

                    <div class="mb-3">
                        <h1 class="h3 d-inline align-middle">Adicionar Interesses</h1>

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
                        <div class="card">

                            <form class="" action="{{route('salvar_interesses')}}" method="POST">
                                @csrf
                                <div class="mb-3">

                                    <label class="form-label">Área de interesse</label>
                                    <input value="{{old('areaInteresse')}}" name="areaInteresse" type="text"
                                        class="form-control mb-2" placeholder="Informe a área de interesse">
                                    @error('areaInteresse')
                                    <div style="color: red;">{{ $message }}</div>
                                    @enderror
                                    <label class="form-label">Específico</label>
                                    <input value="{{old('areaEspecifica')}}" name="areaEspecifica" type="text"
                                        class="form-control mb-2" placeholder="Especifique">
                                    @error('areaEspecifica')
                                    <div style="color: red;">{{ $message }}</div>
                                    @enderror
                                    <button type="submit" class="btn btn-success w-100">Salvar</button>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>

            </main>

            @include('utilizador.rodape')



        </div>



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
            }, 3000); // 5000 milissegundos = 5 segundos
        });
    });
    </script>
</body>

</html>