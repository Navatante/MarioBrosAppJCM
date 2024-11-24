package com.jcm.mariobrosappjcm;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;


/**
 * PersonajeDetalleActivity muestra los detalles de un personaje seleccionado.
 */
public class PersonajeDetalleActivity extends AppCompatActivity {

    // Clave extra para pasar el ID del personaje a través del Intent.
    public static final String EXTRA_PERSONAJE_ID = "personajeId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaje_detalle);

        // Configurar Toolbar como la barra de herramientas de la actividad.
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.characterDetailsTitle);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Mostrar detalles del personaje seleccionado.
        int personajeId = getIntent().getExtras().getInt(EXTRA_PERSONAJE_ID);

        // Configurar el nombre del personaje.
        int personajeNombre = Personaje.personajes[personajeId].getNombre();
        TextView textViewNombre = findViewById(R.id.personaje_texto);
        textViewNombre.setText(personajeNombre);

        // Configurar la imagen del personaje.
        int personajeImagen = Personaje.personajes[personajeId].getImageResourceID();
        ImageView imageView = findViewById(R.id.personage_imagen);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, personajeImagen));

        // Configurar la descripción del personaje.
        int personajeDescripcion = Personaje.personajes[personajeId].getDescripcion();
        TextView textViewDescripcion = findViewById(R.id.personaje_descripcion);
        textViewDescripcion.setText(personajeDescripcion);

        // Configurar las habilidades del personaje.
        int personajeHabilidades = Personaje.personajes[personajeId].getHabilidades();
        TextView textViewHabilidades = findViewById(R.id.personaje_habilidades);
        textViewHabilidades.setText(personajeHabilidades);
    }
}
