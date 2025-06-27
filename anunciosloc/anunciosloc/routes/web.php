<?php

use App\Http\Controllers\InfrastruturaController;
use App\Http\Controllers\LocalController;
use Illuminate\Foundation\Application;
use Illuminate\Support\Facades\Route;
use Inertia\Inertia;
use App\Http\Controllers\LoginController;
use App\Http\Controllers\criarContaController;
use App\Http\Controllers\validarEdicaoController;
use App\Http\Controllers\InteressesController;
use App\Http\Controllers\AnuncioController;







Route::get('/', [LoginController::class, 'tela_login'])->name('tela_login');


Route::get('/Editar Infrastrutura', [InfrastruturaController::class, 'edit2'])->name('editar_infrastrutura');
Route::post('/Actualizar Infrastrutura', [InfrastruturaController::class, 'update2'])->name('actualizar_infrastrutura');

Route::post('/Eliminar Infrastrutura', [InfrastruturaController::class, 'destroy2'])->name('eliminar_infrastrutura');



Route::get('/Perfil',function(){
    $tipo_utilizador = Session::get('tipo_utilizador'); 


        // É AQUI que a variável é passada para a view!
        return view('perfil', ['userType' => $tipo_utilizador]);
    
})->name('');
Route::post('/Perfil', [LoginController::class, 'index'])->name('ir-ao-perfil');

Route::post('/Fazer Login', [LoginController::class, 'index'])->name('fazer-login');
Route::get('/Criar conta', [criarContaController::class, 'create'])->name('criar-conta');

Route::post('/Guardar conta', [criarContaController::class, 'store'])->name('guardar-conta');
Route::post('/Editar nome', [validarEdicaoController::class, 'editarNome'])->name('validar-nome');




Route::get('/Anuncios', action: [AnuncioController::class, 'index'])->name('ir_ao_anuncio');
//responde a requisição "registar anúncio" vinda do menu
Route::get('/Registar Anuncio', action: [AnuncioController::class, 'create'])->name('registar_anuncio');
//responde a requisição "registar anúncio" spra chamar o segundo formulário vinda do primeiro formulário
Route::match(['get', 'post'],'/Registar Anuncio passo2', action: [AnuncioController::class, 'create2'])->name('registar_anuncio_passo2');
Route::post('/Voltar ao passo 1', action: [AnuncioController::class, 'voltar_passo1'])->name('voltar_anuncio');
//responde a requisição para salvar o anúncio apartir do segundo formulário
Route::post('/Publicar Anuncio', action: [AnuncioController::class, 'store'])->name('publicar_anuncio');



Route::post('/ Anuncios', action: [AnuncioController::class, 'edit2'])->name('editar_anuncio');



Route::post('/Salvar Local', action: [LocalController::class, 'store'])->name('salvar_local');
Route::get('/Adicionar Local', [LocalController::class, 'create'])->name('registar-local');
Route::get('/Listar Local', [LocalController::class, 'index'])->name('listar-local');
Route::get('/Editar Local', [LocalController::class, 'edit2'])->name('utilizador-editar-local');
Route::post('/Actualizar Local', [LocalController::class, 'update2'])->name('actualizarLocal');



Route::get('/Adicionar Interresses', [InteressesController::class, 'create'])->name('adicionar-interesses');
Route::get('/Salvar Interresses', [InteressesController::class, 'store'])->name('salvar_interesses');

Route::post('/Salvar Interresses', [InteressesController::class, 'store'])->name('salvar_interesses');
Route::get('/Eliminar Interesse', [InteressesController::class, 'destroy2'])->name('eliminar_interesse');

Route::get('/Editar Interresses', [InteressesController::class, 'edit2'])->name('editar-interesses');
Route::post('/Salvar actualização', [InteressesController::class, 'atualizarInteresse'])->name('salvar-alteracao');




Route::get('/Recuperar',function(){
    return view('recuperacao_conta');
})->name('recuperar_senha');


Route::get('/Perfil do utilizador',function(){
    return view('utilizador.perfil-utilizador');
})->name('entrar');


Route::get('/Infrastruturas',function(){
    return view('gestor.lista-de-infrastrutura');
})->name('listar-infrastrutura');

















Route::get('/Novo anuncio',function(){
    return view('utilizador.editar_anuncio');
})->name('editar_anuncio');




Route::get('/Fazerr Login',function(){
    return view('login');
})->name('voltar-no-login');