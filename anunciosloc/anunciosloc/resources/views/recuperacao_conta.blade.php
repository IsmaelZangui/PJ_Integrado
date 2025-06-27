<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Responsive Admin &amp; Dashboard Template based on Bootstrap 5">
    <meta name="author" content="AdminKit">
    <meta name="keywords" <link rel="shortcut icon" href="img/icons/icon-48x48.png" />


    <title>Log In | AnunciosLoc</title>

    <link rel="stylesheet" href="{{ url('css/app.css') }}">

</head>

<body>
    <main class="d-flex ">
        <div class="container d-flex flex-column">
            <div class="row vh-100">
                <div class="col-sm-10 col-md-8 col-lg-6 col-xl-5 mx-auto d-table">
                    <div class="d-table-cell align-middle">
                        <div class="card">

                            <div class="card-body">
                                <div class="m-sm-3">

                                    <form method="POST" action="{{route('fazer-login')}}">
                                        @csrf

                                        <div class="text-center mt-4 p">

                                            <img src="{{ asset('images/logo/logo.png') }}" alt="Logo AnunciosLoc"
                                                class="img-fluid rounded-circle imagem-bottom" width="150"
                                                height="128" />

                                            <h1 class="h2 mt-0"><strong>Recuperação de Conta</strong></h1>
                                            <p class="lead">
                                                Enviaremos um código de recuperação teu email
                                            </p>
                                        </div>

                                        <div class="mb-3">
                                            <label class="form-label">Email</label>
                                            <input class="form-control form-control-lg" type="email" name="email"
                                                placeholder="Digite o Teu Email" value="{{ old('email') }}" />
                                            @error('email')
                                            <div style="color: red;">{{ $message }}</div>
                                            @enderror
                                        </div>

                                        <div class="d-grid gap-2 mt-3">
                                            <button class="btn btn-lg btn-primary" type="submit">Enviar</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="text-center mb-1">
                            Já tens uma conta? <a href="{{route('voltar-no-login')}}">Fazer Login</a>
                        </div>
                        <div class="text-center mb-3">
                            Não tens um Conta? <a href="{{route('criar-conta')}}">Criar uma</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <script src="js/app.js"></script>
    <script src="js/meujs.js"></script>


</body>

</html>