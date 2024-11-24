package com.jcm.mariobrosappjcm;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the custom Toolbar as the ActionBar
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Remove the title programmatically
        getSupportActionBar().setTitle("");  // This removes the title from the toolbar

        if (savedInstanceState == null) {
            PersonajeFragment fragment = new PersonajeFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_container, fragment);
            transaction.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflar el menú (añadir opciones a la barra de acción)
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Manejar clics en los ítems del menú
        int id = item.getItemId();

        if (id == R.id.menuId) {
            // Mostrar el diálogo "Acerca de..."
            showAboutDialog();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showAboutDialog() {
        // Crear un AlertDialog
        new AlertDialog.Builder(this)
                .setTitle(R.string.acercaDe)
                .setMessage(R.string.acercaDeMensaje)
                .setIcon(R.mipmap.ic_launcher) // Reemplaza con el icono de tu app
                .setPositiveButton(R.string.ok, null)
                .show();
    }
}
