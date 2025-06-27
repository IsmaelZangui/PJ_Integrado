<?php

namespace App\Http\Controllers;

use App\Http\Controllers\InfrastruturaController;
use App\Http\Requests\InfrastruturaRequest;
use Illuminate\Http\Request;

class InfrastruturaController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        //
    }

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
        return view('gestor.editar_infrastrutura');
    }

        public function edit2()
    {
        return view('gestor.editar_infrastrutura');
    }
    

    /**
     * Update the specified resource in storage.
     */
    public function update(InfrastruturaController $request, string $id)
    {
         
    }

        public function update2(InfrastruturaRequest $request)
    {
               try {
        
      //Caso o interesse for eliminado com sucesso
      
                session()->flash('success', 'Infrastrutura Actualizada com sucesso!');
                return view('gestor.lista-de-infrastrutura');
        } catch (\Exception $e) {
            // Em caso de erro
            return back()->with('error', 'Não foi possível Actualizada a infrastrutura. Erro: ' . $e->getMessage());
        }
    }


    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
            try {
        
      //Caso o interesse for eliminado com sucesso
        return back()->with('success', 'Infrastrutura eliminado com sucesso!');
        } catch (\Exception $e) {
            // Em caso de erro
            return back()->with('error', 'Não foi possível eliminar a infrastrutura. Erro: ' . $e->getMessage());
        }
    }

        public function destroy2()
    {
            try {
        
      //Caso o interesse for eliminado com sucesso
        return back()->with('success', 'Infrastrutura eliminado com sucesso!');
        } catch (\Exception $e) {
            // Em caso de erro
            return back()->with('error', 'Não foi possível eliminar a infrastrutura. Erro: ' . $e->getMessage());
        }
    }
}