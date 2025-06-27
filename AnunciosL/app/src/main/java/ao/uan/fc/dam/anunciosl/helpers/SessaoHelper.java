package ao.uan.fc.dam.anunciosl.helpers;

import android.content.Context;
import android.content.SharedPreferences;

import ao.uan.fc.dam.anunciosl.models.Utilizador;

public class SessaoHelper {

    private static final String PREF_NAME = "sessao_utilizador";
    private static final String KEY_UTILIZADOR_JSON = "utilizador_json";

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    public SessaoHelper(Context context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    // ✅ Guardar o utilizador atual na sessão
    public void guardarUtilizador(Utilizador utilizador) {
        String json = utilizador.toJson();  // Usa o método da tua classe Utilizador
        editor.putString(KEY_UTILIZADOR_JSON, json);
        editor.apply();
    }

    // ✅ Obter o utilizador da sessão
    public Utilizador obterUtilizador() {
        String json = prefs.getString(KEY_UTILIZADOR_JSON, null);
        if (json != null) {
            return Utilizador.fromJson(json); // Usa o método estático fromJson()
        }
        return null;
    }

    // ✅ Alias compatível com getUtilizadorLogado()
    public Utilizador getUtilizadorLogado() {
        return obterUtilizador();
    }

    // ✅ Verifica se existe sessão ativa
    public boolean estaAutenticado() {
        return prefs.contains(KEY_UTILIZADOR_JSON);
    }

    // ✅ Encerra a sessão atual
    public void encerrarSessao() {
        editor.clear();
        editor.apply();
    }
}
