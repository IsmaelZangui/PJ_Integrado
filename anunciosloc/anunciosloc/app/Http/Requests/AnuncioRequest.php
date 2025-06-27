<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;


class AnuncioRequest extends FormRequest
{
    /**
     * Determine if the user is authorized to make this request.
     */
    public function authorize(): bool
    {
        return true;
    }

    /**
     * Get the validation rules that apply to the request.
     *
     * @return array<string, \Illuminate\Contracts\Validation\ValidationRule|array<mixed>|string>
     */
    public function rules(): array
    {
        return [
            'titulo' => ['required', 'string', 'max:100', 'regex:/^[a-zA-Z0-9\sÀ-ÿ]+$/'], 
            'descricao' => ['required', 'string', 'max:500'], 
            'modo_de_entrega' => ['required', 'string', 'max:1','regex:/^[cCdD]$/'],
            'hora_inicio' => 'required', // Não pode ser antes de hoje
            'hora_fim' => 'required', // Não pode ser antes de hoje
            'localizacao'=> 'required|sometimes',
            'data_inicio' => 'required|date_format:Y-m-d|after_or_equal:today', // Não pode ser antes de hoje
            'data_fim'    => 'required|date_format:Y-m-d|after:data_inicio',     // Deve ser depois da data_inicio
           
        ];
    }

       public function messages(){
         return [

        'localizacao.required'=>'O Campo localização é obrigatório',
        'descricao.required'=>'O campo descrição é obrigatório',
        'descricao.max'=>'O campo descrição de conter no máximo 500 caracteres',

        'modo_de_entrega.required'=>'O campo Modo de entrega é obrigatório',
        'modo_de_entrega.string'=>'O campo Modo de entrega deve ser apena Centralizado ou Descentralizado',
        'modo_de_entrega.max'=>'Opções válidas: Centralizado ou Descentralizado',

        'modo_de_entrega.regex'=>'O campo Modo de entrega deve ser apena Centralizado ou Descentralizado',

        'data_inicio.required'=>'O campo data é obrigatório',
        'data_inicio.after_or_equal'=>'A data deve ser de hoje ou posterior',

        'data_fim.after'=>'A data fim deve ser posterior a data de início',

        'data_inicio.date_format'=>'Formato da data inválido',

        'data_fim.required'=>'O campo data é obrigatório',







        'titulo.required'=>'O campo titulo é obrigatório',
        'titulo.string'=>'O campo titulo só deve conter letras e espaços',
        'titulo.max'=>'O campo titulo só deve conter 100 caracteres',
        'titulo.regex'=>'O campo titulo deve seguir o padrão normal',

    ];
    }

}