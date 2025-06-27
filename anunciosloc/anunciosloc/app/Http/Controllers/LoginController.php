<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Session;
use App\Http\Requests\LoginRequest;

class LoginController extends Controller
{
    /**
     * Display a listing of the resource.
     */


         public function tela_login(LoginRequest $request)
    {

        // É AQUI que a variável é passada para a view!
        return view('login');

    }



    public function index(LoginRequest $request)
    {

        $userType = null;
     
        // Para sua simulação frontend sem login real no Laravel
        Session::put('tipo_utilizador', 'cliente');
        
        $tipo_utilizador = Session::get('tipo_utilizador'); 


        // É AQUI que a variável é passada para a view!
        return view('perfil', ['userType' => $tipo_utilizador]);
/**
*  
*        localStorage.setItem('user_type', userType);
 *   console.log(`Simulando login como: ${userType}`);
  *        return view('gestor.lista-de-local');
**
*/        

    }

        /**
     * Display a listing of the resource.
     */
 

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(string $id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        //
    }
}