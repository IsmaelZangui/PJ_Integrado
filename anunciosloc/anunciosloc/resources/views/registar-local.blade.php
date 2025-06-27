<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


	<link rel="shortcut icon" href="img/icons/icon-48x48.png" />

	<title>AnúnciosLoc</title>

	<link href="css/app.css" rel="stylesheet">
</head>

<body>
	<div class="wrapper">

    
        @include('gestor.menu')
´
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
									<h1 class="h2"><strong>Registar Local</strong></h1>

								</div>

								<div class="card">
									<div class="card-body">
										<div class="m-sm-3">
											<form method="POST" action="{{route('salvar_local')}}">
                                                @csrf
                                                <div class="mb-3">
                                                    <label class="form-label"></label>Nome do local</label>
                                                    <input value="{{ old('nome_do_local') }}" 
                                                        class="form-control form-control-lg" type="text"
                                                        name="nome_do_local" placeholder="Digite o nome do local" />
                                                    @error('nome_do_local')
                                                    <div style="color: red;">{{ $message }}</div>
                                                    @enderror
                                                </div>

                                                <div class="mb-3">
                                                    <label class="form-label"></label>Capacidade do local</label>
                                                    <input class="form-control form-control-lg" type="number"
                                                        name="capacidade_do_local"
                                                        placeholder="Digite a capacidade do local" />
                                                    @error('capacidade_do_local')
                                                    <div style="color: red;">{{ $message }}</div>
                                                    @enderror
                                                </div>


                                                <div class="mb-3">
                                                    <label class="form-label"></label>Coordenadas GPS</label>
                                                    <div class="d-inline-flex">
                                                        <input value="{{ old('latitude') }}" name="latitude" class="form-control" type="text"
                                                            placeholder="38.7343829" readonly>

                                                        <input value="{{ old('longitude') }}"  name="longitude" class="form-control" type="text"
                                                            placeholder="-9.1403882" readonly>

                                                        <input value="{{ old('raio') }}"  name="raio" class="form-control" type="text"
                                                            placeholder="20m" readonly>
                                                    </div>
                                                    @error('latitude')
                                                    <div  style="color: red;">{{ $message }}</div>
                                                    @enderror
                                                    @error('longitude')
                                                    <div style="color: red;">{{ $message }}</div>
                                                    @enderror
                                                    @error('raio')
                                                    <div style="color: red;">{{ $message }}</div>
                                                    @enderror

                                                    <div class="mt-3">

                                                        <iframe width="600" height="450" style="border:0" loading="lazy"
                                                            allowfullsreen
                                                            src="https:/maps.google.com/?cid=158628434337504000882">

                                                        </iframe>
                                                    </div>

                                                    <div class="d-grid gap-2 mt-3">
                                                        <button class="btn btn-lg btn-primary" type="submit"> Salvar </button> 
                                                            
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

	<script src="js/app.js"></script>


</body>

</html>