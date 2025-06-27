package ao.uan.fc.dam.anunciosl.activities;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.*;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.*;
import org.ksoap2.transport.HttpTransportSE;

import java.util.*;

import ao.uan.fc.dam.anunciosl.R;
import ao.uan.fc.dam.anunciosl.adapters.PerfilAdapter;
import ao.uan.fc.dam.anunciosl.helpers.SessaoHelper;
import ao.uan.fc.dam.anunciosl.models.Chave;
import ao.uan.fc.dam.anunciosl.models.Utilizador;

public class EditarPerfilActivity extends Activity {

    private EditText edtChave, edtValor;
    private RecyclerView recyclerPerfil;
    private PerfilAdapter adapter;
    private List<Chave> listaChaves;
    private SessaoHelper sessaoHelper;
    private Utilizador utilizador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t10_activity_editar_perfil);

        edtChave = findViewById(R.id.edtChave);
        edtValor = findViewById(R.id.edtValor);
        recyclerPerfil = findViewById(R.id.recyclerAtributos);

        sessaoHelper = new SessaoHelper(this);
        utilizador = sessaoHelper.obterUtilizador();

        listaChaves = carregarChavesLocais();

        adapter = new PerfilAdapter(listaChaves, position -> {
            listaChaves.remove(position);
            adapter.notifyItemRemoved(position);
        });

        recyclerPerfil.setLayoutManager(new LinearLayoutManager(this));
        recyclerPerfil.setAdapter(adapter);

        findViewById(R.id.btnVoltar).setOnClickListener(v -> finish());

        findViewById(R.id.btnAdicionarAtributo).setOnClickListener(v -> {
            String chave = edtChave.getText().toString().trim();
            String valor = edtValor.getText().toString().trim();
            if (!chave.isEmpty() && !valor.isEmpty()) {
                listaChaves.add(new Chave(chave, valor, false));
                adapter.notifyItemInserted(listaChaves.size() - 1);
                edtChave.setText("");
                edtValor.setText("");
            }
        });

        findViewById(R.id.btnRemoverTodos).setOnClickListener(v -> {
            listaChaves.clear();
            adapter.notifyDataSetChanged();
        });

        findViewById(R.id.btnGuardar).setOnClickListener(v -> {
            guardarChavesLocais(listaChaves);
            new AtualizarPerfilTask().execute(listaChaves);
        });
    }

    private List<Chave> carregarChavesLocais() {
        SharedPreferences prefs = getSharedPreferences("perfil", MODE_PRIVATE);
        String json = prefs.getString("chaves", "[]");
        List<Chave> chaves = new ArrayList<>();
        try {
            JSONArray arr = new JSONArray(json);
            for (int i = 0; i < arr.length(); i++) {
                JSONObject o = arr.getJSONObject(i);
                chaves.add(new Chave(
                        o.getString("chave"),
                        o.getString("valor"),
                        o.optBoolean("padrao", false)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return chaves;
    }

    private void guardarChavesLocais(List<Chave> chaves) {
        SharedPreferences prefs = getSharedPreferences("perfil", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        JSONArray arr = new JSONArray();
        for (Chave c : chaves) {
            JSONObject o = new JSONObject();
            try {
                o.put("chave", c.getChave());
                o.put("valor", c.getValor());
                o.put("padrao", c.isPadrao());
                arr.put(o);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        editor.putString("chaves", arr.toString());
        editor.apply();
    }

    private class AtualizarPerfilTask extends AsyncTask<List<Chave>, Void, Boolean> {
        @Override
        protected Boolean doInBackground(List<Chave>... params) {
            List<Chave> lista = params[0];
            try {
                if (utilizador == null) return false;

                String NAMESPACE = "http://tempuri.org/";
                String URL = "http://teu-endpoint.com/ws.asmx";
                String METHOD_NAME = "AtualizarPerfil";
                String SOAP_ACTION = NAMESPACE + METHOD_NAME;

                SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
                request.addProperty("utilizadorId", utilizador.getId());

                SoapObject listaSoap = new SoapObject(NAMESPACE, "chaves");
                for (Chave c : lista) {
                    SoapObject item = new SoapObject(NAMESPACE, "Chave");
                    item.addProperty("Chave", c.getChave());
                    item.addProperty("Valor", c.getValor());
                    item.addProperty("Padrao", c.isPadrao());
                    listaSoap.addSoapObject(item);
                }

                request.addSoapObject(listaSoap);
                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet = true;
                envelope.setOutputSoapObject(request);

                HttpTransportSE http = new HttpTransportSE(URL);
                http.call(SOAP_ACTION, envelope);

                return true;

            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean success) {
            Toast.makeText(EditarPerfilActivity.this,
                    success ? "Perfil atualizado com sucesso!" : "Erro ao atualizar perfil.",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
