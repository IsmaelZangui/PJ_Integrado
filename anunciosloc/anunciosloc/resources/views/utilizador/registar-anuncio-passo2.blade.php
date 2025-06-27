<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">



    <title>Restrições | AnúnciosLoc</title>
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
                <div class="container d-flex flex-column">


                    <div class="row ">

                        <div class="col-sm-10 col-md-8 col-lg-6 col-xl-5 mx-auto d-table h-100">
                            <div class="d-table-cell align-middle">

                                <div class="text-center mt-4">
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

                                    <h1 class="h2"><strong>Novo Anúncio</strong></h1>

                                </div>
                                <div class="card">
                                    <div class="card-body">
                                        <div class="m-sm-3">
                                            <form id="myForm" action="{{route('publicar_anuncio')}}" method="POST">
                                                @csrf
                                                <div class="mb-3">
                                                    <label class="form-label"></label>Restrições</label>
                                                    <select name="restricao" class="form-select mb-3">
                                                        <option value="i"> Seleciona o tipo de restrição </option>
                                                        <option value="w"
                                                            {{ old('restricao') == 'w' ? 'selected' : '' }}>
                                                            WhiteList</option>
                                                        <option value="b"
                                                            {{ old('restricao') == 'b' ? 'selected' : '' }}>
                                                            BlackList</option>
                                                    </select>

                                                    @error('restricao')
                                                    <div style="color: red;">{{ $message }}</div>
                                                    @enderror
                                                    <label class="form-label"></label>Perfis</label>

                                                    <div class="align-items-start">
                                                        <ul name="perfis" class="list-group" id="lista_itens">

                                                        </ul>

                                                    </div>
                                                    <div class="d-flex align-items-start mt-3">
                                                        <select id="item_do_select" name="perfis"
                                                            class="form-select mb-3">
                                                            <option value="i"> Seleciona um perfil </option>
                                                            <option value="nanaa"
                                                                {{ old('perfis') == 'nana' ? 'selected' : '' }}>
                                                                Cantor: Nagrelha</option>
                                                            <option value="barçaa"
                                                                {{ old('perfis') == 'Barça' ? 'selected' : '' }}>
                                                                Equipe: Barcelona</option>
                                                        </select>

                                                        @error('perfis')
                                                        <div style="color: red;">{{ $message }}</div>
                                                        @enderror
                                                    </div>
                                                </div>

                                                <div class="mb-3">
                                                    <label class="form-label"></label>Localização</label>
                                                    <input name="localizacao" list="localizacoes" class="form-control"
                                                        type="text" placeholder="Informe a localização">

                                                    <datalist id="localizacoes">
                                                        <option data-id="123" value="Luanda, Angola"></option>
                                                        <option value="Cabinda, Angola"></option>
                                                        <option value="Benguela, Angola"></option>
                                                        <option value="Huambo, Angola"></option>
                                                        <option value="Lobito, Angola"></option>
                                                        <option value="Lubango, Angola"></option>
                                                        <option value="Namibe, Angola"></option>
                                                        <option value="Soyo, Angola"></option>
                                                    </datalist>
                                                    @error('localizacao')
                                                    <div style="color: red;">{{ $message }}</div>
                                                    @enderror
                                                </div>

                                                <div class="d-grid gap-2 mt-3">
                                                    <button type="submit" class="btn btn-success"
                                                        data-bs-dismiss="modal">Publicar</button>

                                                    <a href="{{route('voltar_anuncio')}}"
                                                        class="btn btn-lg btn-danger">Voltar</a>

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

        <div class="card">

            <!-- inicio adicionar perfil -->
            <div class="modal  fade" data-bs-backdrop="static" id="modalAdicionarPerfil" tabindex="-1"
                aria-labelledby="modalEditarNomeLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header card-header">
                            <h5 class="card-title mb-0" id="modalEditarNomeLabel">Editar Nome
                            </h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body ">

                            <nav class="navbar navbar-light bg-light ">
                                <input class="form-control mr-sm-2" type="search" placeholder="Pesquisar"
                                    aria-label="Search">
                                <button class="btn btn-outline-success  my-2 my-sm-0" type="submit">Search</button>
                            </nav>

                            <form class="form-inline">

                                <div class="card">
                                    <div class="card-body">

                                        <label class="form-check">
                                            <span class="form-check-label">
                                                <strong>Time: </strong>Barcelona
                                            </span><input class="form-check-input" type="checkbox" value="option1"
                                                name="radios-example" checked>

                                        </label>
                                        <label class="form-check">

                                            <span class="form-check-label">
                                                <strong>Cantor: </strong>50 Cent
                                            </span><input class="form-check-input" type="checkbox" value="option2"
                                                name="radios-example">
                                        </label>
                                        <label class="form-check">

                                            <span class="form-check-label">
                                                <strong>Hobby: </strong> Música
                                            </span> <input class="form-check-input" type="checkbox" value="option2"
                                                name="radios-example">
                                        </label>

                                    </div>
                                </div>

                                <button type="submit" class="w-100% btn btn-success"
                                    data-bs-dismiss="modal">Publicar</button>
                            </form>





                        </div>
                        <div class="modal-footer card-header">

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- fim adicionar perfil -->
    </div>
    <script src="js/bootstrap.bundle.min.js"></script>

    <script src="js/app.js"></script>





    <script>
    document.addEventListener('DOMContentLoaded', function() {
        const selectElement = document.getElementById('item_do_select');
        const listaItensUl = document.getElementById('lista_itens');
        const myForm = document.getElementById('myForm'); // Obtenha o seu formulário pelo ID

        // NOTA: O array item_do_select agora é mais para controle interno de duplicatas
        // e não o que será enviado diretamente. Os inputs hidden farão isso.
        let selectedValues = []; // Usamos um nome mais claro para os valores selecionados

        // --- Função para Remover um Item ---
        function removeItem(itemId) {
            // Remove do array de controle
            selectedValues = selectedValues.filter(item => item !== itemId);

            // Remove o elemento visual da lista (<li>)
            const liToRemove = document.querySelector(`#lista_itens li[data-item-id="${itemId}"]`);
            if (liToRemove) {
                liToRemove.remove();
            }

            // --- REMOVE O INPUT HIDDEN CORRESPONDENTE ---
            const hiddenInputToRemove = myForm.querySelector(`input[name="perfis[]"][value="${itemId}"]`);
            if (hiddenInputToRemove) {
                hiddenInputToRemove.remove();
            }
            console.log('Item removido:', itemId, 'Valores atuais para envio:', selectedValues);
        }

        // --- Listener para Adicionar Item no Select ---
        selectElement.addEventListener('change', function() {
            const selectedValue = this.value;
            const selectedText = this.options[this.selectedIndex].text;

            // Verifica se um valor foi selecionado e se já não está na lista
            if (selectedValue && !selectedValues.includes(selectedValue)) {
                // Adiciona ao array de controle
                selectedValues.push(selectedValue);

                // --- 1. CRIA E ADICIONA O ELEMENTO VISUAL (<li>) ---
                const listItem = document.createElement('li');
                listItem.className = 'list-group-item d-flex justify-content-between align-items-center'; // Bootstrap classes
                listItem.textContent = selectedText;
                listItem.setAttribute('data-item-id', selectedValue); // Armazena o ID no LI para fácil remoção
                // Não precisa do name="perfis" ou data-value="x" no LI, pois não será enviado diretamente

                // Adiciona o ícone de remoção
                const removeIcon = document.createElement('i');
                removeIcon.className = 'text-danger'; // Apenas a classe de cor do Bootstrap
                removeIcon.innerHTML = '&times;'; // Símbolo 'X'
                removeIcon.style.marginLeft = '30px';
                removeIcon.style.cursor = 'pointer';
                removeIcon.style.fontSize = '1.2em';
                removeIcon.onclick = function() {
                    removeItem(selectedValue);
                };

                listItem.appendChild(removeIcon);
                listaItensUl.appendChild(listItem);

                // --- 2. CRIA E ADICIONA O INPUT HIDDEN PARA SUBMISSÃO ---
                const hiddenInput = document.createElement('input');
                hiddenInput.type = 'hidden';
                hiddenInput.name = 'perfis[]'; // Importante: 'perfis[]' para que o backend receba como array
                hiddenInput.value = selectedValue;
                myForm.appendChild(hiddenInput); // Adiciona o input oculto diretamente ao formulário

                console.log('Item adicionado:', selectedValue, 'Valores atuais para envio:', selectedValues);

                // Reseta o select para o placeholder
                this.value = "";
            }
        });
    });
</script>






</body>

</html>