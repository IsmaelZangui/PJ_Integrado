<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class edicaoRequest extends FormRequest
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
            'nome' => ['required', 'string', 'max:50', 'regex:/^[a-zA-Z\sÀ-ÿ]+$/'],      
        ];
    }

    public function mesages(){
         return [
        'nome.required'=>'O campo nome é obrigatório',
        'nome.string'=>'O campo nome só deve conter letras e espaços',
        'nome.max'=>'O campo nome só deve conter 50 caracteres',
        'nome.regex'=>'O campo nome deve seguir o padrão normal',
    ];
    }
}