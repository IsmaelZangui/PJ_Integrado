package ao.uan.fc.dam.anunciosl.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import ao.uan.fc.dam.anunciosl.R;
import ao.uan.fc.dam.anunciosl.helpers.SessaoHelper;
import ao.uan.fc.dam.anunciosl.models.Utilizador;
import ao.uan.fc.dam.anunciosl.services.ApiService;

public class LoginActivity extends Activity {

    private EditText edtEmail, edtPassword;
    private Button btnLogin;
    private ProgressBar progressBar;
    private TextView txtCriarConta, txtEsqueciSenha;

    private SessaoHelper sessaoHelper;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t2_activity_login);

        // Referências
        edtEmail = findViewById(R.id.emailEditText);
        edtPassword = findViewById(R.id.passwordEditText);
        btnLogin = findViewById(R.id.loginButton);
        progressBar = findViewById(R.id.loginProgressBar);
        txtCriarConta = findViewById(R.id.goToRegisterText);
        txtEsqueciSenha = findViewById(R.id.forgotPasswordText);

        // Helpers
        sessaoHelper = new SessaoHelper(this);
        apiService = new ApiService();

        // Ação Login
        btnLogin.setOnClickListener(v -> {
            String email = edtEmail.getText().toString().trim();
            String senha = edtPassword.getText().toString().trim();

            if (email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                return;
            }

            new LoginTask().execute(email, senha);
        });

        // Ir para Registo
        txtCriarConta.setOnClickListener(v -> {
            startActivity(new Intent(this, RegisterActivity.class));
        });

        // Ir para Recuperar Senha
        txtEsqueciSenha.setOnClickListener(v -> {
            startActivity(new Intent(this, RecuperarSenhaActivity.class));
        });
    }

    // Tarefa assíncrona para autenticação
    private class LoginTask extends AsyncTask<String, Void, Utilizador> {
        private String erro;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
            btnLogin.setEnabled(false);
        }

        @Override
        protected Utilizador doInBackground(String... params) {
            try {
                String email = params[0];
                String senha = params[1];

                // Chamada real ao WebService (deves implementar no ApiService)
                return apiService.login(email, senha);
            } catch (Exception e) {
                erro = e.getMessage();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Utilizador utilizador) {
            progressBar.setVisibility(View.GONE);
            btnLogin.setEnabled(true);

            if (utilizador != null) {
                sessaoHelper.guardarUtilizador(utilizador);
                Intent intent = new Intent(LoginActivity.this, MainHomeActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(LoginActivity.this,
                        erro != null ? erro : "Credenciais inválidas",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}
