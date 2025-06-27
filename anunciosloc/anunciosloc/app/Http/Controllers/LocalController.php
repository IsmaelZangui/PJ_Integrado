<?php

namespace App\Http\Controllers;

use App\Http\Requests\LocalRequest;
use Illuminate\Support\Facades\Session;


class LocalController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $tipo_utilizador = Session::get('tipo_utilizador'); 

        return view('lista-de-locais', ['userType' => $tipo_utilizador]);

    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
           /**
     * Se for um gestor.
     *  
     */                
    $tipo_utilizador = Session::get('tipo_utilizador'); 
    return view('registar-local', ['userType' => $tipo_utilizador]);

        /**
     * Se for um utilizador.
     *  return view('utilizador.registar-local');

     */

    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(LocalRequest $request)
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
       public function edit2()
    {
        $tipo_utilizador = Session::get('tipo_utilizador'); 
        return view('editarlocal', ['userType' => $tipo_utilizador]);    
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(LocalRequest $request, string $id)
    
    {
        //
    }
      public function update2(LocalRequest $request)
    {
        //Salva actualização 
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        $tipo_utilizador = Session::get('tipo_utilizador'); 
    return view('registar-local', ['userType' => $tipo_utilizador]);
    }
}
