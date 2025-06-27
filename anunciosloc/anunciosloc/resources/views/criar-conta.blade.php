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

    <title>Criar Conta | AnúnciosLoc</title>
    <link rel="stylesheet" href="{{ url('css/app.css') }}">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/app.css" rel="stylesheet">

</head>

<body>
    <main class="d-flex w-100">
        <div class="container d-flex flex-column">
            <div class="row vh-100">
                <div class="col-sm-10 col-md-8 col-lg-6 col-xl-5 mx-auto d-table h-100">
                    <div class="d-table-cell align-middle">

                        <div class="card">
                            <div class="card-body">
                                <div class="m-sm-3">

                                    <form method="POST" action="{{route('guardar-conta')}}">
                                        @csrf



                                        <div class="text-center mt-4">

                                            <h1 class="h2"><strong>Criar Conta</strong></h1>

                                        </div>
                                        @if (session('success'))
                                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                                            {{ session('success') }}
                                            <button type="button" class="btn-close" data-bs-dismiss="alert"
                                                aria-label="Close"></button>
                                        </div>
                                        @endif
                                        {{-- alerta de erro --}}
                                        @if (session('error'))
                                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                                            {{ session('error') }}
                                            <button type="button" class="btn-close" data-bs-dismiss="alert"
                                                aria-label="Close"></button>
                                        </div>
                                        @endif
                                        <div class="mb-3">
                                            <label class="form-label"></label>Nome</label>
                                            <input class="form-control form-control-lg" type="text" name="nome"
                                                value="{{ old('nome') }}"
                                                placeholder="Digite o teu nome de utilizador" />
                                            @error('nome')
                                            <div style="color: red;">{{ $message }}</div>
                                            @enderror
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label">Email</label>
                                            <input class="form-control form-control-lg" type="email" name="email"
                                                placeholder="Digite o teu email" value="{{ old('email') }}" />
                                            @error('email')
                                            <div style="color: red;">{{ $message }}</div>
                                            @enderror
                                        </div>
                                        <div class="mb-3">
                                            <label class="form-label">Senha</label>
                                            <input class="form-control form-control-lg" type="password" name="password"
                                                placeholder="Digite uma senha" value="{{ old('password') }}" />
                                            @error('password')
                                            <div style="color: red;">{{ $message }}</div>
                                            @enderror
                                        </div>

                                        <div class="mb-3">
                                            <label class="form-label">Senha de confirmação</label>
                                            <input class="form-control form-control-lg" type="password"
                                                name="password_confirmation" placeholder="Confirma a senha"
                                                value="{{ old('password_confirmation') }}" />
                                            @error('password_confirmation')
                                            <div style="color: red;">{{ $message }}</div>
                                            @enderror
                                        </div>

                                        <div class="d-grid gap-2 mt-3">
                                            <button class="btn btn-lg btn-primary" type="submit">Guardar</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="text-center mb-3">
                            Já tens uma conta? <a href="{{route('voltar-no-login')}}">Fazer Login</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <script src="js/app.js"></script>

</body>

</html>