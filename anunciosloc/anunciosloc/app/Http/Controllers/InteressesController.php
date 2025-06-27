<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Requests\InteressesRequest;
use SoapClient;
use SoapFault;
class InteressesController extends Controller
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
        return view('utilizador.adicionarInteresses');
    }

  


    /**
     * Store a newly created resource in storage.
     */
    public function store(InteressesRequest $request)
    {

//
        try {
        $wsdl = 'http://192.168.43.74:8088/Servico/Servico?wsdl'; //

        // Inicializa o cliente SOAP
            $interesse = new SoapClient($wsdl);

            // Exemplo de chamada de método (somar dois números)
            $params = [
                'chave' => $request->areaInteresse,
                'valor' => $request->areaEspecifica,
                'id_utilizador' => 35,
            ];

            $response = $interesse->criar_perfil($params); // Chama a operação 'Add' do serviço

            // A 
            $result = $response->return;
            if($result<>'ok'){
            return back()->with('error', 'Não foi possível Adicionar o interesse. Erro: ' . $result);

            }else{
        return back()->with('success', 'Interresse adicionado com sucesso!');
            }
            
} catch (SoapFault $e) {
            // Trate erros SOAP (conexão, WSDL inválido, etc.)
                    return back()->with('error', 'Falha na conexão com o servidor');
        } catch (\Exception $e) {
            // Trate outros erros
                    return back()->with('error', $e->getMessage());

        }
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
        return view('utilizador.editarInteresses');

    }

    /**
     * Update the specified resource in storage.
     */
    public function update(InteressesRequest $request, string $id)
    {
          
    }

   public function atualizarInteresse(InteressesRequest $request)
    {
        try {
        
        ///Caso o interesse for actualizado com sucesso
        return back()->with('success', 'Interresse actualizado com sucesso!');
        } catch (\Exception $e) {
            // Em caso de erro
            return back()->with('error', 'Não foi possível actualizar o interesse. Erro: ' . $e->getMessage());
        }
        
    
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy2()
    {
        
        try {
        
      //Caso o interesse for eliminado com sucesso
        return back()->with('success', 'Interresse eliminado com sucesso!');
        } catch (\Exception $e) {
            // Em caso de erro
            return back()->with('error', 'Não foi possível eliminar o interesse. Erro: ' . $e->getMessage());
        }
    }
}