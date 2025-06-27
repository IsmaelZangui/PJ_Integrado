<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class LoginRequest extends FormRequest
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
        'email' => 'sometimes|required|email', 
        'password' => 'sometimes|required|string|min:8',
    ];
    }
    

    /**
 * Get the error messages for the defined validation rules.
 *
 * @return array
 */
public function messages(): array
{
    return [
        'email.required' => 'O campo e-mail é obrigatório.',
        'email.email' => 'Por favor, insira um e-mail válido.',
        'password.required' => 'O campo senha é obrigatório.',
        'password.min' => 'O campo deve conter no mínimo 8 caracteres.',
        'nome.required'=>'O campo nome é obrigatório',
        'nome.string'=>'O campo nome só deve conter letras e espaços',
        'nome.max'=>'O campo nome só deve conter 50 caracteres',
        'nome.regex'=>'O campo nome deve seguir o padrão normal',



    ];
}
  
}