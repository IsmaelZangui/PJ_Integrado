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
	<link rel="stylesheet" href="{{ url('css/app.css') }}">


	<title></title>

</head>

<body>
	
		<nav id="sidebar" class="sidebar js-sidebar">
			<div class="sidebar-content js-simplebar">
				<a class="sidebar-brand" href="index.html">
					<span class="align-middle">AnúnciosLoc</span>
				</a>

				<ul class="sidebar-nav">
					<li class="sidebar-header">
						Início
					</li>

					<li class="sidebar-item active">
						<a class="sidebar-link" href="{{route('ir-ao-perfil')}}">
							<i class="align-middle" data-feather="home"></i> <span class="align-middle">Home</span>
						</a>
					</li>

					<li class="sidebar-item ">
						<a class="sidebar-link" href="{{route('ir-ao-perfil')}}">
							<i class="align-middle" data-feather="user"></i> <span class="align-middle">Perfil</span>
						</a>
					</li>

					<li class="sidebar-header">
						Gestão de Anúncios
					</li>

					<li class="sidebar-item">
						<a class="sidebar-link" href="{{route('ir_ao_anuncio')}}">
							<i class="align-middle" data-feather="square"></i> <span
								class="align-middle">Anúncios</span>
						</a>
					</li>

					<li class="sidebar-item">
						<a class="sidebar-link" href="{{route('registar_anuncio')}}">
							+<i class="align-middle" data-feather="square"></i> <span
								class="align-middle">Anúncio</span>
						</a>
					</li>

				</ul>

			</div>
		</nav>
	

	<script src="js/app.js"></script>

</body>

</html>