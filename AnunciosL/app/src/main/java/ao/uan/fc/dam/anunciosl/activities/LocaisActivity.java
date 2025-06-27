package ao.uan.fc.dam.anunciosl.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.maps.GoogleMap;
import ao.uan.fc.dam.anunciosl.helpers.*;
import ao.uan.fc.dam.anunciosl.adapters.*;
import ao.uan.fc.dam.anunciosl.services.ApiService;
import ao.uan.fc.dam.anunciosl.models.Anuncio;

public class LocaisActivity extends Activity {

    private RecyclerView recyclerLocais;
    private LocalAdapter adapter;
    private EditText edtNome, edtLatitude, edtLongitude, edtRaio;
    private GpsLocationHelper gpsHelper;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.layout_correspondente);
        // Inicializar componentes aqui
    }
}
