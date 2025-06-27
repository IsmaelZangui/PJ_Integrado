package ao.uan.fc.dam.anunciosl.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.recyclerview.widget.RecyclerView;

import ao.uan.fc.dam.anunciosl.R;
import ao.uan.fc.dam.anunciosl.adapters.PerfilAdapter;
import ao.uan.fc.dam.anunciosl.helpers.SessaoHelper;
import ao.uan.fc.dam.anunciosl.models.Utilizador;

public class PerfilActivity extends Activity {

    private TextView txtNome, txtEmail, txtSaldo;
    private Button btnLogout;
    private SessaoHelper sessaoHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t9_activity_perfil);

        txtNome = findViewById(R.id.txtNome);
        txtEmail = findViewById(R.id.txtEmail);
        txtSaldo = findViewById(R.id.txtSaldo);
        btnLogout = findViewById(R.id.btnLogout);

        sessaoHelper = new SessaoHelper(this);

        Utilizador utilizador = sessaoHelper.obterUtilizador();
        if (utilizador != null) {
            txtNome.setText(utilizador.getNome());
            txtEmail.setText(utilizador.getEmail());
            txtSaldo.setText("Kz " + String.format("%.2f", utilizador.getSaldo()));
        }

        btnLogout.setOnClickListener(v -> {
            sessaoHelper.encerrarSessao();
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }
}
