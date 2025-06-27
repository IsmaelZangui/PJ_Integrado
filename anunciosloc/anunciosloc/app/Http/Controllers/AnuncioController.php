<?php

namespace App\Http\Controllers;

use App\Http\Requests\AnuncioRequest;
use Illuminate\Http\Request;
use SoapClient;
use SoapFault;

class AnuncioController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        //
            return view('utilizador.anuncios');
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        //Chamada do primeiro formulário para registar anúncio
        return view('utilizador.registar-anuncio-passo1');

    }

     /**
     * Show the form for creating a new resource. AnuncioRequest $request
     */

    public function create2(AnuncioRequest $request)
    {
        //Chamada do segundo formulário para registar anúncio

         // 2. Armazena os dados na sessão
        $request->session()->put('formulario1', $request->all());
            //$form1 = $request->session()->get('formulario1');
            //var_dump($form1);die();
            return view('utilizador.registar-anuncio-passo2');
    }

        public function voltar_passo1()
    {
        return view('utilizador.registar-anuncio-passo1');
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $request->session()->put('formulario2', $request->all());
         try {
           
     // 1. Verifica se os dados da Parte 1 existem na sessão
        if (!$request->session()->has('formulario1')) {
            return redirect()->route('registar-anuncio-passo1')->with('error', 'Por favor, preencha a primeira parte do cadastro.');
        }


        $wsdl = 'http://192.168.43.74:8088/Servico/Servico?wsdl'; //
     
        // Inicializa o cliente SOAP
            $anuncio = new SoapClient($wsdl);

                // pegando os dados do primeiro formulário
                $form1 = $request->session()->get('formulario1');
                // pegando os dados do segundo formulário
                $form2 = $request->session()->get('formulario2');
               // var_dump(value: $form1);
                //var_dump(value: $form2);die();


            $params = [
                'utilizador' => 35,
                'restricao' => $request->restricao,
                'mensagem' => $request->descricao,
                'titulo' => $request->titulo,
                'local' => 1,
                'data' => $request->data_inicio,
                'hora' => $request->hora_inicio,
                'data_fim' => $request->data_fim,
                'hora_fim' => $request->hora_fim,
                'modo' => $request->modo_de_entrega,

            ];

            $response = $anuncio->postar_mensagem($params); // Chama a operação 'Add' do serviço
                       $result = $response->return;
            if($result<>'ok'){
                var_dump($result);
            }else{
        return back()->with('success', value: 'Anúncio adicionado com sucesso!'.$result);
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

      public function edit2(string $id)
    {
        return view('utilizador.editar-anuncio');
    }


    /**
     * Update the specified resource in storage.
     */
    public function update(AnuncioRequest $request, string $id)
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