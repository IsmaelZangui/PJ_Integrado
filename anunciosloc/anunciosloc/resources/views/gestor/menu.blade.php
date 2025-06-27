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
    <nav id="sidebar" class="sidebar js-sidebar">
        <div class="sidebar-content js-simplebar">
            <a class="sidebar-brand" href="index.html">
                <span class="align-middle">AnúnciosLoc</span>
            </a>

            <ul class="sidebar-nav">

                <li class="sidebar-header">
                    Gestão de Infrastrutura
                </li>

                <li class="sidebar-item active">
                    <a class="sidebar-link" href="{{route('listar-infrastrutura')}}">
                        <i class="align-middle" data-feather="server"></i> <span
                            class="align-middle">Infrastruturas</span>
                    </a>
                </li>

                <li class="sidebar-header">
                    Gestão de Locais
                </li>

                <li class="sidebar-item active">
                    <a class="sidebar-link" href="{{route('listar-local')}}">
                        <i class="align-middle" data-feather="map-pin"></i> <span class="align-middle">Locais</span>
                    </a>
                </li>

                <li class="sidebar-item">
                    <a class="sidebar-link" href="{{route('registar-local')}}">
                        +<i class="align-middle" data-feather="map-pin"></i> <span class="align-middle">Novo
                            Local</span>
                    </a>
                </li>
                <li class="sidebar-header">
                    Gestão Estatística
                </li>

                <li class="sidebar-item active">
                    <a class="sidebar-link" href="{{route('listar-local')}}">
                        <i class="align-middle" data-feather="link"></i> <span class="align-middle">Conexões</span>
                    </a>
                </li>
            </ul>
        </div>
    </nav>






    <script src="js/app.js"></script>


</body>

</html>