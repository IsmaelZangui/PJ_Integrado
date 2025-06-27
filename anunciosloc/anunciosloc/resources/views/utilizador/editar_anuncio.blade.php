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
                <div class="container-fluid p-0">

                    <div class="mb-3">
                        <h1 class="h3 d-inline align-middle">Editar Anúncio</h1>

                    </div>
                    <div class="row">

                        <div class="col-12 col-md-6 ">
                            <div class="card">
                                <div class="card-header">
                                </div>
                                <div class="card-body">

                                    <form method="post" action="{{ route('registar_anuncio_passo2') }}">
                                        @csrf
                                        <label class="form-label">Título</label>

                                        <div class=" mb-3 ">

                                            <div class="d-flex align-items-center">
                                                <input value="{{ old('titulo') }}"
                                                    class="form-control form-control-lg me-2" type="text" name="titulo"
                                                    placeholder="Digite o nome do local"  /> <a
                                                    href="#" class="">
                                                    <i class="link-primary align-middle" data-feather="save"></i>
                                                </a>
                                            </div>
                                            @error('titulo')
                                            <div style="color: red;">{{ $message }}</div>
                                            @enderror
                                        </div>

                                        <div class="mb-3">
                                            <label class="form-label"></label>Descrição</label>
                                            <div class="d-flex align-items-center">
                                                <textarea name="descricao" class="form-control me-1" rows="3"
                                                    class="form-control @error('descricao') is-invalid @enderror"
                                                    placeholder="Descreva aqui o anúncio">{{ old('descricao') }}</textarea>
                                                <a href="#" class="">
                                                    <i class="link-primary align-middle" data-feather="save"></i>
                                                </a>
                                            </div>
                                            @error('descricao')
                                            <div style="color: red;">{{ $message }}</div>
                                            @enderror
                                        </div>

                                        <div class="mb-3 ">
                                            <label class="form-label"></label>Modo de entrega</label>

                                            <div class="d-flex align-items-center">
                                                <select name="modo_de_entrega" class="form-select me-2">
                                                    <option selected>Escolha um modo de entrega</option>
                                                    <option value="c"
                                                        {{ old('modo_de_entrega') == 'c' ? 'selected' : '' }}>
                                                        Centralizado</option>
                                                    <option value="d"
                                                        {{ old('modo_de_entrega') == 'd' ? 'selected' : '' }}>
                                                        Descentralizado</option>
                                                </select>
                                                <a href="#" class="">
                                                    <i class="link-primary align-middle" data-feather="save"></i>
                                                </a>
                                            </div>

                                            @error('modo_de_entrega')
                                            <div style="color: red;">{{ $message }}</div>
                                            @enderror
                                        </div>

                                        <div class="mb-3 ">
                                            <label class="form-label"></label>Data Início</label>

                                            <div class="d-flex align-items-center">
                                                <input value="{{ old('data_inicio') }}"
                                                    class=" form-control form-control-lg me-2" type="date"
                                                    name="_inicio" />
                                                    <a href="#"class="">
                                                    <i class="link-primary align-middle" data-feather="save"></i>
                                                </a>
                                            </div>
                                            @error('data_inicio')
                                            <div style="color: red;">{{ $message }}</div>
                                            @enderror
                                        </div>

                                        <div class="mb-3">
                                            <label class="form-label"></label>Data Limite</label>

                                            <div class="d-flex align-items-center">
                                                <input value="{{ old('data_fim') }}"
                                                    class="form-control form-control-lg me-2" type="date"
                                                    name="data_fim" /><a href="{{ route('editar_anuncio') }}" class="">
                                                    <i class="link-primary align-middle" data-feather="save"></i>
                                                </a>
                                            </div>

                                            @error('data_fim')
                                            <div style="color: red;">{{ $message }}</div>
                                            @enderror
                                        </div>

                                    </form>
                                </div>
                            </div>
                        </div>

                        <div class="col-12 col-md-6">
                            <div class="card">
                                <div class="card-header">
                                    <h5 class="card-title mb-0"></h5>
                                </div>
                                <div class="card-body">

                                    <form method="post" action="{{ route('registar_anuncio_passo2') }}">
                                        @csrf

                                        <div class="mb-3">
                                            <label class="form-label"></label>Restrições</label>
                                            <div class="d-flex align-items-center">
                                                <select class="form-select me-2">

                                                    <option selected>
                                                        Seleciona o tipo de restrição
                                                    </option>
                                                    <option>
                                                        WhiteList
                                                    </option>
                                                    <option>
                                                        BlackList
                                                    </option>
                                                </select><a href="{{ route('editar_anuncio') }}" class="">
                                                    <i class="link-primary align-middle" data-feather="save"></i>
                                                </a>
                                            </div>

                                            @error('data_fim')
                                            <div style="color: red;">{{ $message }}</div>
                                            @enderror
                                        </div>

                                        <div class="mb-3">

                                            <div class="d-flex align-items-start">
                                                <input class="form-control me-2" type="text" placeholder="Barcelona, 50 Cent"
                                                    readonly>

                                                <a href="#" class="float-end m-lg-1">
                                                    <i class="link-danger align-middle"
                                                        data-feather="minus-circle"></i>
                                                </a>

                                            </div>
                                            <div class="d-flex align-items-start mt-3">
                                                <input class="form-control me-2 " type="text" placeholder="Adicionar perfil">

                                                <a href="#" class="float-end m-lg-1">
                                                    <i class="link-success align-middle"
                                                        data-feather="plus-circle"></i>
                                                </a>
                                            </div>
                                        </div>

                                        <iframe style="border:0; width: 100%;min-width: 100px;" loading="lazy"
                                            allowfullsreen src="https:/maps.google.com/?cid=158628434337504000882">

                                        </iframe>
                                        <div class="mb-3">
                                            <label class="form-label"></label>Localização</label>
                                            <input class="form-control" type="text" placeholder="Luanda, Angola"
                                                readonly>
                                        </div>

                                    </form>
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