package ao.uan.fc.dam.anunciosl.activities;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import ao.uan.fc.dam.anunciosl.R;
import ao.uan.fc.dam.anunciosl.services.ApiService;

public class RecuperarSenhaActivity extends Activity {

    private EditText edtEmail;
    private Button btnEnviar;
    private TextView txtVoltar;
    private ProgressBar progressBar;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t3_1_activity_forgot_password);

        // Inicializar componentes
        edtEmail = findViewById(R.id.emailEditText);
        btnEnviar = findViewById(R.id.resetPasswordButton);
        txtVoltar = findViewById(R.id.backToLoginText);
        progressBar = findViewById(R.id.registerProgressBar); // ou crie um novo ID para a barra

        apiService = new ApiService();

        btnEnviar.setOnClickListener(v -> {
            String email = edtEmail.getText().toString().trim();
            if (email.isEmpty()) {
                Toast.makeText(this, "Insira o email", Toast.LENGTH_SHORT).show();
                return;
            }
            new RecuperarSenhaTask().execute(email);
        });

        txtVoltar.setOnClickListener(v -> finish());
    }

    private class RecuperarSenhaTask extends AsyncTask<String, Void, Boolean> {
        private String erro;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            btnEnviar.setEnabled(false);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {
                return apiService.recuperarSenha(params[0]);
            } catch (Exception e) {
                erro = e.getMessage();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean sucesso) {
            btnEnviar.setEnabled(true);
            progressBar.setVisibility(View.GONE);

            if (sucesso) {
                Toast.makeText(RecuperarSenhaActivity.this, "Instruções enviadas para o email.", Toast.LENGTH_LONG).show();
                finish();
            } else {
                Toast.makeText(RecuperarSenhaActivity.this,
                        erro != null ? erro : "Erro ao recuperar senha",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}
