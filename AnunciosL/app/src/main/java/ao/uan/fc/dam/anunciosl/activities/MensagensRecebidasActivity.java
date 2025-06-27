package ao.uan.fc.dam.anunciosl.activities;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.*;
import org.ksoap2.transport.HttpTransportSE;
import java.util.*;
import ao.uan.fc.dam.anunciosl.R;
import ao.uan.fc.dam.anunciosl.adapters.AnuncioAdapter;
import ao.uan.fc.dam.anunciosl.helpers.SessaoHelper;
import ao.uan.fc.dam.anunciosl.models.Anuncio;
import ao.uan.fc.dam.anunciosl.models.Utilizador;

public class MensagensRecebidasActivity extends Activity {

    private RecyclerView recyclerMensagens;
    private AnuncioAdapter adapter;
    private List<Anuncio> listaMensagens = new ArrayList<>();
    private SessaoHelper sessaoHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t6_mensagens_recebidas_activity);

        recyclerMensagens = findViewById(R.id.recyclerMensagens);
        recyclerMensagens.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AnuncioAdapter(listaMensagens);
        recyclerMensagens.setAdapter(adapter);

        sessaoHelper = new SessaoHelper(this);
        Utilizador utilizador = sessaoHelper.obterUtilizador();

        if (utilizador != null) {
            new BuscarMensagensTask().execute(utilizador.getId());
        } else {
            Toast.makeText(this, "Sessão expirada.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private class BuscarMensagensTask extends AsyncTask<String, Void, List<Anuncio>> {

        @Override
        protected List<Anuncio> doInBackground(String... params) {
            String utilizadorId = params[0];
            List<Anuncio> mensagens = new ArrayList<>();

            try {
                String NAMESPACE = "http://tempuri.org/";
                String METHOD_NAME = "ListarMensagensRecebidas";
                String SOAP_ACTION = NAMESPACE + METHOD_NAME;
                String URL = "http://teu-endpoint.com/ws.asmx";

                SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
                request.addProperty("utilizadorId", utilizadorId);

                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet = true;
                envelope.setOutputSoapObject(request);

                HttpTransportSE transport = new HttpTransportSE(URL);
                transport.call(SOAP_ACTION, envelope);

                SoapObject response = (SoapObject) envelope.getResponse();
                for (int i = 0; i < response.getPropertyCount(); i++) {
                    SoapObject obj = (SoapObject) response.getProperty(i);
                    Anuncio anuncio = new Anuncio();
                    anuncio.setTitulo(obj.getProperty("Titulo").toString());
                    anuncio.setDescricao(obj.getProperty("Descricao").toString());
                    // Adicione mais campos conforme necessário
                    mensagens.add(anuncio);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return mensagens;
        }

        @Override
        protected void onPostExecute(List<Anuncio> anuncios) {
            listaMensagens.clear();
            listaMensagens.addAll(anuncios);
            adapter.notifyDataSetChanged();
        }
    }
}
