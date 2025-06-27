package ao.uan.fc.dam.anunciosl.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import ao.uan.fc.dam.anunciosl.R;
import ao.uan.fc.dam.anunciosl.helpers.SessaoHelper;
import ao.uan.fc.dam.anunciosl.models.Utilizador;

public class SplashScreenActivity extends Activity {

    private SessaoHelper sessionManager;
    private Button proceedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t1_activity_splash);

        proceedButton = findViewById(R.id.proceedButton);
        proceedButton.setVisibility(View.GONE); // Oculta o botão inicialmente
        sessionManager = new SessaoHelper(this);

        new Handler().postDelayed(() -> {
            Utilizador utilizador = sessionManager.getUtilizadorLogado();

            proceedButton.setVisibility(View.VISIBLE); // Mostra o botão após delay
            proceedButton.setOnClickListener(v -> {
                Intent intent;
                if (utilizador != null) {
                    intent = new Intent(this, MainHomeActivity.class);
                } else {
                    intent = new Intent(this, LoginActivity.class);
                }
                startActivity(intent);
                finish();
            });
        }, 2000); // Delay de 2 segundos
    }
}
