<?php

namespace App\Http\Controllers;

use HashContext;
use Illuminate\Http\Request;
use App\Http\Requests\CriarContaRequest;
use Illuminate\Support\Facades\Hash;
use SoapClient;
use SoapFault;


class criarContaController extends Controller
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
         return view('criar-conta');
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(CriarContaRequest $request)
    {

        //
         $wsdl = 'http://192.168.43.74:8088/Servico/Servico?wsdl'; //

        try {
            // Inicializa o cliente SOAP
            $client = new SoapClient($wsdl);

            // Exemplo de chamada de método (somar dois números)
            $params = [
                'nome' => $request->nome,
                'email' => $request->email,
                'senha' => Hash::make($request->password),
            ];

            $response = $client->registar_utilizador($params); // Chama a operação 'Add' do serviço

            // A resposta do SOAP geralmente vem como um objeto
            $result = $response->return;
            if($result<>'ok'){
                return back()->with('error', $result);

            }else{
                return redirect()->route('tela_login')->with('success', 'Conta criada com sucesso!');
            }
            

        } catch (SoapFault $e) {
            // Trate erros SOAP (conexão, WSDL inválido, etc.)
            return view('login', ['error' => $e->getMessage()]);
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
