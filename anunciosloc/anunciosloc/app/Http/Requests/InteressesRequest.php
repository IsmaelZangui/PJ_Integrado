<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class InteressesRequest extends FormRequest
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
            'areaInteresse' => ['required', 'string', 'max:50', 'regex:/^[a-zA-Z0-9\sÀ-ÿ]+$/'], 
            'areaEspecifica' => ['required', 'string', 'max:50', 'regex:/^[a-zA-Z0-9\sÀ-ÿ]+$/'],      
     
        ];
    }

    public function messages(){
         return [
        'areaInteresse.required'=>'O campo Area de interesse é obrigatório',
        'areaInteresse.string'=>'O campo Area de interesse só deve conter letras e espaços',
        'areaInteresse.max'=>'O campo Area de interesse só deve conter 50 caracteres',
        'areaInteresse.regex'=>'O campo Area de interesse deve seguir o padrão normal',

        'areaEspecifica.required'=>'O campo Area específica é obrigatório',
        'areaEspecifica.string'=>'O campo Area específica só deve conter letras e espaços',
        'areaEspecifica.max'=>'O campo Area específica só deve conter 50 caracteres',
        'areaEspecifica.regex'=>'O campo Area específica deve seguir o padrão normal',
    ];
    }
}
