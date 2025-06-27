<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <link rel="shortcut icon" href="img/icons/icon-48x48.png" />

    <title>Anunciar | AnúnciosLoc</title>

    <link href="css/app.css" rel="stylesheet">
</head>

<body>
    <div class="wrapper">

        @include('utilizador.menu-utilizador')
        <div class="main ">
            <nav class="navbar navbar-expand navbar-light navbar-bg">
                <a class="sidebar-toggle js-sidebar-toggle">
                    <i class="hamburger align-self-center"></i>
                </a>
                @include('utilizador.cabecalho-utilizador')

            </nav>
            <main class="w-100">
                <div class="container d-flex flex-column">

                    <div class="row ">
                        <div class="col-sm-10 col-md-8 col-lg-6 col-xl-5 mx-auto d-table h-100">
                            <div class="d-table-cell align-middle">

                                <div class="text-center mt-4">
                                    <h1 class="h2"><strong>Novo Anúncio</strong></h1>

                                </div>
                                @if (session('success'))
                                <div class="alert alert-success alert-dismissible fade show" role="alert">
                                    {{ session('success') }}
                                    <button type="button" class="btn-close" data-bs-dismiss="alert"
                                        aria-label="Close"></button>
                                </div>
                                @endif

                                {{-- ALERTA DE ERRO --}}
                                @if (session('error'))
                                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                                    {{ session('error') }}
                                    <button type="button" class="btn-close" data-bs-dismiss="alert"
                                        aria-label="Close"></button>
                                </div>
                                @endif

                                <div class="card">
                                    <div class="card-body">
                                        <div class="m-sm-3">
                                            <form method="post" action="{{ route('registar_anuncio_passo2') }}">
                                                @csrf
                                                <div class="mb-3">
                                                    <label class="form-label">Título</label>
                                                    <input value="{{ old('titulo') }}"
                                                        class="form-control form-control-lg" type="text" name="titulo"
                                                        placeholder="Digite o nome do local" />
                                                    @error('titulo')
                                                    <div style="color: red;">{{ $message }}</div>
                                                    @enderror
                                                </div>

                                                <div class="mb-3">
                                                    <label class="form-label"></label>Descrição</label>
                                                    <textarea name="descricao" class="form-control" rows="3"
                                                        class="form-control @error('descricao') is-invalid @enderror"
                                                        placeholder="Descreva aqui o anúncio">{{ old('descricao') }}</textarea>
                                                    @error('descricao')
                                                    <div style="color: red;">{{ $message }}</div>
                                                    @enderror
                                                </div>

                                                <div class="mb-3 ">
                                                    <label class="form-label"></label>Modo de entrega</label>
                                                    <select name="modo_de_entrega" class="form-select mb-3">
                                                        <option selected>Escolha um modo de entrega</option>
                                                        <option value="c"
                                                            {{ old('modo_de_entrega') == 'c' ? 'selected' : '' }}>
                                                            Centralizado</option>
                                                        <option value="d"
                                                            {{ old('modo_de_entrega') == 'd' ? 'selected' : '' }}>
                                                            Descentralizado</option>



                                                    </select>
                                                    @error('modo_de_entrega')
                                                    <div style="color: red;">{{ $message }}</div>
                                                    @enderror
                                                </div>

                                                <div class="d-inline">

                                                    <div class="mb-3 ">
                                                        <label class="form-label"></label>Data e Hora de Início</label>
                                                        <input value="{{ old('data_inicio') }}"
                                                            class="mb-3 form-control form-control-lg" type="date"
                                                            name="data_inicio" placeholder="" />

                                                        <input value="{{ old('hora_inicio') }}"
                                                            class="mb-3 form-control form-control-lg" type="time"
                                                            name="hora_inicio" placeholder="" />
                                                        @error('data_inicio')
                                                        <div style="color: red;">{{ $message }}</div>
                                                        @enderror
                                                        @error('hora_inicio')
                                                        <div style="color: red;">{{ $message }}</div>
                                                        @enderror
                                                    </div>

                                                    <div class="mb-3">
                                                        <label class="form-label"></label>Data e Hora Limite</label>
                                                        <input value="{{ old('data_fim') }}"
                                                            class="mb-3 form-control form-control-lg" type="date"
                                                            name="data_fim" placeholder="" />

                                                        <input value="{{ old('hora_fim') }}"
                                                            class="mb-3 form-control form-control-lg" type="time"
                                                            name="hora_fim" placeholder="" />
                                                        @error('hora_fim')
                                                        <div style="color: red;">{{ $message }}</div>
                                                        @enderror
                                                        @error('data_fim')
                                                        <div style="color: red;">{{ $message }}</div>
                                                        @enderror
                                                    </div>

                                                    @error('restricao')
                                                    <div style="color: red;">{{ $message }}</div>
                                                    @enderror


                                                </div>

                                                <div class="d-grid gap-2 mt-3">
                                                    <button class="btn btn-lg btn-primary" type="submit">A
                                                        seguir</button>

                                                </div>
                                            </form>
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