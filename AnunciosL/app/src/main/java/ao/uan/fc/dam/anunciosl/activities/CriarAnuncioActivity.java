package ao.uan.fc.dam.anunciosl.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import androidx.annotation.Nullable;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ao.uan.fc.dam.anunciosl.helpers.SessaoHelper;
import ao.uan.fc.dam.anunciosl.services.ApiService;
import ao.uan.fc.dam.anunciosl.models.Anuncio;
import ao.uan.fc.dam.anunciosl.models.Chave;
import ao.uan.fc.dam.anunciosl.models.Restricao;
import ao.uan.fc.dam.anunciosl.models.Utilizador;

public class CriarAnuncioActivity extends Activity {

    private EditText edtTitulo, edtDescricao;
    private Spinner spinnerLocal, spinnerModo, spinnerPolitica;
    private EditText edtDataInicio, edtDataFim;
    private EditText edtChaveFiltro;
    private ChipGroup chipGroupFiltros;
    private Button btnPublicar;
    private ApiService apiService;
    private List<Chave> filtros = new ArrayList<>();
    private SessaoHelper sessionManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_anuncio);

        edtTitulo = findViewById(R.id.edtTitulo);
        edtDescricao = findViewById(R.id.edtDescricao);
        spinnerLocal = findViewById(R.id.spinnerLocal);
        spinnerModo = findViewById(R.id.spinnerModo);
        spinnerPolitica = findViewById(R.id.spinnerPolitica);
        edtDataInicio = findViewById(R.id.edtDataInicio);
        edtDataFim = findViewById(R.id.edtDataFim);
        edtChaveFiltro = findViewById(R.id.edtFiltro);
        chipGroupFiltros = findViewById(R.id.chipGroupFiltros);
        btnPublicar = findViewById(R.id.btnPublicar);

        sessionManager = new SessaoHelper(this);
        apiService = new ApiService() {
            @Override public Utilizador login(String email, String senha) { return null; }
            @Override public boolean registrar(Utilizador user) { return false; }
            @Override public boolean publicarAnuncio(Anuncio anuncio) { return true; }
            @Override public List<String> listarLocais() { return null; }
            @Override public List<Anuncio> obterMensagensPorLocal(String gps, String ssid) { return null; }
            @Override public boolean atualizarPerfil(List<Chave> perfil) { return false; }
            @Override public String obterEstatisticas(String idUtilizador) { return null; }
            @Override public boolean recuperarSenha(String email) { return false; }
        };

        edtChaveFiltro.setOnEditorActionListener((v, actionId, event) -> {
            String texto = edtChaveFiltro.getText().toString().trim();
            if (!texto.isEmpty()) {
                Chave chave = new Chave();
                chave.chave = texto;
                chave.valor = "";
                filtros.add(chave);
                adicionarChip(texto);
                edtChaveFiltro.setText("");
            }
            return true;
        });

        btnPublicar.setOnClickListener(v -> publicarAnuncio());
    }

    private void adicionarChip(String texto) {
        Chip chip = new Chip(this);
        chip.setText(texto);
        chip.setCloseIconVisible(true);
        chip.setOnCloseIconClickListener(v -> {
            chipGroupFiltros.removeView(chip);
            filtros.removeIf(f -> f.chave.equals(texto));
        });
        chipGroupFiltros.addView(chip);
    }

    private void publicarAnuncio() {
        String titulo = edtTitulo.getText().toString();
        String descricao = edtDescricao.getText().toString();
        String modo = spinnerModo.getSelectedItem().toString();
        String politicaTipo = spinnerPolitica.getSelectedItem().toString();

        if (titulo.isEmpty() || descricao.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos obrigatórios.", Toast.LENGTH_SHORT).show();
            return;
        }

        Restricao politica = new Restricao();
        politica.tipo = politicaTipo;
        politica.chaves = filtros;

        Anuncio anuncio = new Anuncio();
        anuncio.titulo = titulo;
        anuncio.descricao = descricao;
        anuncio.modo = modo;
        anuncio.mensagem = descricao;
        anuncio.localDestino = spinnerLocal.getSelectedItem().toString();
        anuncio.dataInicio = new Date();
        anuncio.dataFim = new Date();
        anuncio.horaInicio = "09:00";
        anuncio.horaFim = "17:00";
        anuncio.autor = new Utilizador();
        anuncio.politica = politica;

        if (modo.equalsIgnoreCase("Centralizado")) {
            boolean publicado = apiService.publicarAnuncio(anuncio);
            if (publicado) {
                Toast.makeText(this, "Anúncio publicado com sucesso!", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Erro ao publicar anúncio!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Anúncio salvo localmente para envio por WiFi Direct.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}