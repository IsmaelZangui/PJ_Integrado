package ao.uan.fc.dam.anunciosl.services;

import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import ao.uan.fc.dam.anunciosl.models.Utilizador;

public class ApiService {

    private static final String TAG = "ApiService";
    private static final String BASE_URL = "http://192.168.48.148:8081/api"; // <- URL da ponte REST

    private JSONObject post(String endpoint, JSONObject payload) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(BASE_URL + endpoint);
            connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(60000);
            connection.setConnectTimeout(60000);
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            // Envia o JSON
            OutputStream os = new BufferedOutputStream(connection.getOutputStream());
            os.write(payload.toString().getBytes());
            os.flush();

            // Lê a resposta
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String linha;
            while ((linha = br.readLine()) != null) {
                sb.append(linha);
            }

            return new JSONObject(sb.toString());

        } catch (Exception e) {
            Log.e(TAG, "Erro na requisição REST: " + endpoint, e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }

    public Utilizador login(String email, String senha) {
        try {
            JSONObject json = new JSONObject();
            json.put("email", email);
            json.put("senha", senha);

            JSONObject resposta = post("/login", json);
            if (resposta != null) {
                return new Utilizador(
                        resposta.getString("id"),
                        resposta.getString("nome"),
                        resposta.getString("email"),
                        senha,
                        resposta.getString("tipo"),
                        resposta.optDouble("saldo", 0.0)
                );
            }
        } catch (Exception e) {
            Log.e(TAG, "Erro ao fazer login", e);
        }
        return null;
    }

    public boolean registarUtilizador(String nome, String email, String senha) {
        try {
            JSONObject json = new JSONObject();
            json.put("nome", nome);
            json.put("email", email);
            json.put("senha", senha);

            JSONObject resposta = post("/utilizador", json);
            return resposta != null && "sucesso".equalsIgnoreCase(resposta.optString("status"));
        } catch (Exception e) {
            Log.e(TAG, "Erro ao registar utilizador", e);
        }
        return false;
    }

    public boolean postarMensagem(String titulo, String corpo) {
        try {
            JSONObject json = new JSONObject();
            json.put("titulo", titulo);
            json.put("mensagem", corpo);

            JSONObject resposta = post("/mensagem", json);
            return resposta != null && "ok".equalsIgnoreCase(resposta.optString("status"));
        } catch (Exception e) {
            Log.e(TAG, "Erro ao postar mensagem", e);
        }
        return false;
    }

    public boolean criarRestricao(String descricao, String tipo) {
        try {
            JSONObject json = new JSONObject();
            json.put("descricao", descricao);
            json.put("tipo", tipo);

            JSONObject resposta = post("/restricao", json);
            return resposta != null && "ok".equalsIgnoreCase(resposta.optString("status"));
        } catch (Exception e) {
            Log.e(TAG, "Erro ao criar restrição", e);
        }
        return false;
    }

    public boolean smsDescentralizada(String destino, String conteudo) {
        try {
            JSONObject json = new JSONObject();
            json.put("destino", destino);
            json.put("conteudo", conteudo);

            JSONObject resposta = post("/sms", json);
            return resposta != null && "enviado".equalsIgnoreCase(resposta.optString("status"));
        } catch (Exception e) {
            Log.e(TAG, "Erro ao enviar SMS", e);
        }
        return false;
    }

    public boolean criarPerfil(String utilizadorId, String biografia, String localidade) {
        try {
            JSONObject json = new JSONObject();
            json.put("utilizadorId", utilizadorId);
            json.put("biografia", biografia);
            json.put("localidade", localidade);

            JSONObject resposta = post("/perfil", json);
            return resposta != null && "criado".equalsIgnoreCase(resposta.optString("status"));
        } catch (Exception e) {
            Log.e(TAG, "Erro ao criar perfil", e);
        }
        return false;
    }

    public boolean recuperarSenha(String email) {
        try {
            JSONObject json = new JSONObject();
            json.put("email", email);

            JSONObject resposta = post("/recuperar-senha", json);
            return resposta != null && "sucesso".equalsIgnoreCase(resposta.optString("status"));
        } catch (Exception e) {
            Log.e(TAG, "Erro ao recuperar senha", e);
        }
        return false;
    }
}
