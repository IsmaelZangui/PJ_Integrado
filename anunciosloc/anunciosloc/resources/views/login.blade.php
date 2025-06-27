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
    <link href="css/bootstrap.min.css" rel="stylesheet">

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
                                            <img src="{{ asset('images/logo/logo.png') }}" alt="Logo AnunciosLoc"
                                                class="img-fluid rounded imagem-bottom mb-2 mt-2" width="100"
                                                height="150" />

                                            <h1 class="h2 mt-0"><strong>Seja Bem Vindo!</strong></h1>
                                            <p class="lead">
                                                Faça Login na Tua Conta
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
                                        <div class="mb-3">
                                            <label class="form-label">Palavra Passe</label>
                                            <input class="form-control form-control-lg" type="password" name="password"
                                                placeholder="Digite a Palavra passe" value="{{ old('password') }}" />
                                            @error('password')
                                            <div style="color: red;">{{ $message }}</div>
                                            @enderror
                                        </div>
                                        <div>
                                            <div class="form-check align-items-center">
                                                <input id="customControlInline" type="checkbox" class="form-check-input"
                                                    value="remember-me" name="remember-me" checked>
                                                <label class="form-check-label text-small"
                                                    for="customControlInline">Salvar as credenciais</label>
                                            </div>
                                        </div>
                                        <div class="d-grid gap-2 mt-3">
                                            <button class="btn btn-lg btn-primary" type="submit">Entrar</button>
                                        </div>
                                        <div class="text-center mb-3">
                                            Não tens um Conta? <a href="{{route('criar-conta')}}">Criar uma</a>
                                        </div>

                                        <div class="text-center mb-3">
                                            <a href="{{route('recuperar_senha')}}">Esqueceu a senha?</a>
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

    <script src="js/app.js"></script>
    <script src="js/meujs.js"></script>


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
            }, 3000); // 3000 milissegundos = 2 segundos
        });
    });
    </script>



</body>

</html>