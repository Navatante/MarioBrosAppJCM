package com.jcm.mariobrosappjcm;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

/**
 * MainActivity es la actividad principal de la aplicación.
 * Gestiona la barra de herramientas (Toolbar), el menú lateral (DrawerLayout) y los eventos de navegación.
 */
public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configuración de la barra de herramientas
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.marioblock);
        getSupportActionBar().setTitle(""); // Quitamos el título de la Toolbar

        // Configurar DrawerLayout y NavigationView
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);

        // Cargar el fragmento inicial si no hay estado guardado
        if (savedInstanceState == null) {
            PersonajeFragment fragment = new PersonajeFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_container, fragment);
            transaction.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Infla el menú para añadir opciones a la barra de acción.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Maneja clics en los elementos del menú.
        int id = item.getItemId();

        if (id == R.id.menuId) {
            showAboutDialog(); // Mostrar diálogo "Acerca de..."
            return true;
        }

        if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START); // Abrir menú lateral
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Maneja los clics en los elementos del menú de navegación lateral.
     *
     * @param item el elemento del menú seleccionado.
     * @return true si se maneja el evento.
     */
    private boolean onNavigationItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.nav_home) {
            // Recargar el fragmento principal de personajes
            PersonajeFragment fragment = new PersonajeFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.commit();
        } else if (itemId == R.id.nav_settings) {
            // Abrir actividad de ajustes
            startActivity(new Intent(this, SettingActivity.class));
        }

        drawerLayout.closeDrawer(GravityCompat.START); // Cerrar menú lateral
        return true;
    }

    /**
     * Muestra un diálogo "Acerca de..." con información sobre la aplicación.
     */
    private void showAboutDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.acercaDe)
                .setMessage(R.string.acercaDeMensaje)
                .setIcon(R.mipmap.ic_launcher) // Icono de la app
                .setPositiveButton(R.string.ok, null)
                .show();
    }
}
