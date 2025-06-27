package ao.uan.fc.dam.anunciosl.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import ao.uan.fc.dam.anunciosl.R;
import ao.uan.fc.dam.anunciosl.services.ApiService;

public class RegisterActivity extends Activity {

    private EditText edtNome, edtEmail, edtSenha, edtConfirmarSenha;
    private Button btnRegistrar;
    private ProgressBar progressBar;
    private TextView txtIrParaLogin;

    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t3_activity_register); // usa o nome correto do XML

        // Referências
        edtNome = findViewById(R.id.usernameEditText);
        edtEmail = findViewById(R.id.emailEditText);
        edtSenha = findViewById(R.id.passwordEditText);
        edtConfirmarSenha = findViewById(R.id.confirmPasswordEditText);
        btnRegistrar = findViewById(R.id.registerButton);
        progressBar = findViewById(R.id.registerProgressBar);
        txtIrParaLogin = findViewById(R.id.goToLoginText);

        apiService = new ApiService();

        btnRegistrar.setOnClickListener(v -> {
            String nome = edtNome.getText().toString().trim();
            String email = edtEmail.getText().toString().trim();
            String senha = edtSenha.getText().toString();
            String confirmar = edtConfirmarSenha.getText().toString();

            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || confirmar.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!senha.equals(confirmar)) {
                Toast.makeText(this, "As senhas não coincidem", Toast.LENGTH_SHORT).show();
                return;
            }

            new RegistarUtilizadorTask().execute(nome, email, senha);
        });

        txtIrParaLogin.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }

    // AsyncTask para registar utilizador
    private class RegistarUtilizadorTask extends AsyncTask<String, Void, Boolean> {
        private String erro;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
            btnRegistrar.setEnabled(false);
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {
                return apiService.registarUtilizador(params[0], params[1], params[2]);
            } catch (Exception e) {
                erro = e.getMessage();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean sucesso) {
            progressBar.setVisibility(View.GONE);
            btnRegistrar.setEnabled(true);

            if (sucesso) {
                Toast.makeText(RegisterActivity.this, "Registo concluído com sucesso", Toast.LENGTH_LONG).show();
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            } else {
                Toast.makeText(RegisterActivity.this,
                        erro != null ? erro : "Falha ao registar utilizador",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}
