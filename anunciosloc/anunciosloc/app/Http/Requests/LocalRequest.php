<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class LocalRequest extends FormRequest
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
            'nome_do_local' => ['required', 'string', 'max:50', 'regex:/^[a-zA-Z0-9\sÀ-ÿ]+$/'], 
            'areaEspecifica' => ['required', 'string', 'max:50', 'regex:/^[a-zA-Z0-9\sÀ-ÿ]+$/'],
            'latitude'=>['required','numeric','between:-90,90'], 
            'longitude'=>['required','numeric','between:-90,90'],    
             'raio' => ['required','numeric','min:0.01','max:500'],
            'capacidade_do_local'=>['required','numeric','between:0,9000'],   
     
        ];
    }

    public function messages(){
         return [

        'capacidade_do_local.required'=>'O campo Capacidade é obrigatório',
        'capacidade_do_local.numeric'=>'a Capacidade deve ser do tipo numérico',
        'capacidade_do_local.between'=>'O valor da Capacidade deve ser entre 0 a 9000',

        'raio.required'=>'O campo Raio é obrigatório',
        'raio.numeric'=>'O Raio deve ser do tipo numérico',
        'raio.min'=>'O valor Raio deve ser no mínimo 0.01',
        'raio.max'=>'O valor Raio deve ser no máximo 500',


        'latitude.required'=>'O campo Latitude é obrigatório',
        'latitude.numeric'=>'A Latitude deve ser do tipo numérico',
        'latitude.between'=>'A Latitude deve estar entre -90 a 90',


        'longitude.required'=>'O campo Longitude é obrigatório',
        'longitude.numeric'=>'A Longitude deve ser do tipo numérico',
        'longitude.between'=>'A Longitude deve estar entre -90 a 90',




         'areaEspecifica.required'=>'O campo Nome do local é obrigatório',
        'areaEspecifica.string'=>'O campo Nome do local só deve conter letras e espaços',
        'areaEspecifica.max'=>'O campo Nome do local só deve conter 50 caracteres',
        'areaEspecifica.regex'=>'O campo Nome do localdeve seguir o padrão normal',
        
        'nome_do_local.required'=>'O campo Nome do local é obrigatório',
        'nome_do_local.string'=>'O campo Nome do local só deve conter letras e espaços',
        'nome_do_local.max'=>'O campo Nome do local só deve conter 50 caracteres',
        'nome_do_local.regex'=>'O campo Nome do localdeve seguir o padrão normal',
    ];
    }
}