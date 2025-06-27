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
        @include('gestor.menu')

        <div class="main">
            <nav class="navbar navbar-expand navbar-light navbar-bg">
                <a class="sidebar-toggle js-sidebar-toggle">
                    <i class="hamburger align-self-center"></i>
                </a>
                @include('gestor.cabecalho')

            </nav>


            <main class="content">
                <div class="container d-flex flex-column">

                    <div class="row ">
                        <div class="col-sm-10 col-md-8 col-lg-6 col-xl-5 mx-auto d-table h-100">
                            <div class="d-table-cell align-middle">

                                <div class="text-center mt-4">
                                    <h1 class="h2"><strong>Editar Infrastrutura</strong></h1>

                                </div>


                    {{-- ALERTA DE ERRO --}}
                    @if (session('error'))
                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
                        {{ session('error') }}
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                    @endif
                                <div class="card">
                                    <div class="card-body">
                                        <div class="m-sm-3">
                                            <form method="POST" action="{{route('actualizar_infrastrutura')}}">
                                                @csrf
                                                <div class="mb-3">
                                                    <label class="form-label"></label>Nome da infrastrutura</label>
                                                    <input value="{{ old('nome_do_local') }}" 
                                                        class="form-control form-control-lg" type="text"
                                                        name="nome_da_infrastrutura" placeholder="Digite o nome da infrastrutura" />
                                                    @error('nome_da_infrastrutura')
                                                    <div style="color: red;">{{ $message }}</div>
                                                    @enderror
                                                </div>

                                                <div class="mb-3">
                                                    <label class="form-label"></label>Estado</label>
                                                    <input class="form-control form-control-lg" type="number"
                                                        name="capacidade_da_infrastrutura"
                                                        placeholder="Digite a capacidade da infrastrutura" />
                                                    @error('capacidade_da_infrastrutura')
                                                    <div style="color: red;">{{ $message }}</div>
                                                    @enderror
                                                </div>

                                                          <div class="mb-3">
                                                    <label class="form-label"></label>Bonos</label>
                                                    <input class="form-control form-control-lg" type="number"
                                                        name="bono"
                                                        placeholder="Digite o valor do bono" />
                                                    @error('bono')
                                                    <div style="color: red;">{{ $message }}</div>
                                                    @enderror
                                                </div>


                                                    <div class="d-grid gap-2 mt-3">
                                                        <button class="btn btn-lg btn-primary" type="submit"> Salvar edição </button> 
                                                            
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
            @include('gestor.rodape')

        </div>
    </div>

        <script src="js/bootstrap.bundle.min.js"></script>


    <script src="js/app.js"></script>


</body>

</html>