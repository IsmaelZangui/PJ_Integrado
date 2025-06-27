<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class InfrastruturaRequest extends FormRequest
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
            'nome_da_infrastrutura' => ['required', 'string', 'max:50', 'regex:/^[a-zA-Z0-9\sÀ-ÿ]+$/'], 
            'capacidade_da_infrastrutura'=>['required','numeric','between:0,9000'],   
                        'bono'=>['required','numeric','between:0,9000'],   

     
        ];
    }
     public function messages(){
         return [

        'capacidade_da_infrastrutura.required'=>'O campo capacidade é obrigatório',
        'capacidade_da_infrastrutura.numeric'=>'a Capacidade deve ser do tipo numérico',
        'capacidade_da_infrastrutura.between'=>'O valor da Capacidade deve ser entre 0 a 9000',

          'bono.required'=>'O campo bono é obrigatório',
        'bono.numeric'=>'o bono deve ser do tipo numérico',
        'bono.between'=>'O valor do bono deve ser entre 0 a 9000',

        'nome_da_infrastrutura.required'=>'O campo Nome doa infrastrutura é obrigatório',
        'nome_da_infrastrutura.string'=>'O campo Nome da infrastrutura só deve conter letras e espaços',
        'nome_da_infrastrutura.max'=>'O campo Nome da infrastrutura só deve conter 50 caracteres',
        'nome_da_infrastrutura.regex'=>'O campo Nome da infrastrutura seguir o padrão normal',
    ];
    }
}
