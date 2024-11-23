package com.jcm.mariobrosappjcm;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;


public class PersonajeDetalleActivity extends AppCompatActivity {

    public static final String EXTRA_PERSONAJE_ID = "personajeId";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaje_detalle);


        // Ponemos el toolbar como la app bar del activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Detalles del personaje");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Mostrar detalles del personaje
        int personjaeId = (Integer)getIntent().getExtras().get(EXTRA_PERSONAJE_ID); // Desde el intent, coge el personaje que el usuario elija.

        String personajeNombre = Personaje.personajes[personjaeId].getNombre();
        TextView textViewNombre = (TextView) findViewById(R.id.personaje_texto);
        textViewNombre.setText(personajeNombre);

        int personajeImagen = Personaje.personajes[personjaeId].getImageResourceID();
        ImageView imageView = (ImageView) findViewById((R.id.personage_imagen));
        imageView.setImageDrawable(ContextCompat.getDrawable(this, personajeImagen));
        imageView.setContentDescription(personajeNombre);

        String personajeDescripcion = Personaje.personajes[personjaeId].getDescripcion();
        TextView textViewDescripcion = findViewById((R.id.personaje_descripcion));
        textViewDescripcion.setText(personajeDescripcion);

        String personajeHabilidades = Personaje.personajes[personjaeId].getHabilidades();
        TextView textViewHabilidades = findViewById((R.id.personaje_habilidades));
        textViewHabilidades.setText(personajeHabilidades);
    }
}