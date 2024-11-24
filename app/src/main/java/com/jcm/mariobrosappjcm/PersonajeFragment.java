package com.jcm.mariobrosappjcm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

/**
 * PersonajeFragment muestra una lista de personajes utilizando un RecyclerView.
 * Permite al usuario seleccionar un personaje y navegar a sus detalles.
 */
public class PersonajeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar el diseño del RecyclerView para mostrar los personajes.
        RecyclerView personajeRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_personaje, container, false);

        // Mostrar un mensaje de bienvenida utilizando un Snackbar.
        personajeRecycler.post(() ->
                Snackbar.make(personajeRecycler, R.string.snackBarWelcome, Snackbar.LENGTH_LONG).show()
        );

        // Obtener datos de los personajes.
        int[] nombrePersonajes = new int[Personaje.personajes.length];
        for (int i = 0; i < nombrePersonajes.length; i++) {
            nombrePersonajes[i] = Personaje.personajes[i].getNombre();
        }

        int[] imagenPersonajes = new int[Personaje.personajes.length];
        for (int i = 0; i < imagenPersonajes.length; i++) {
            imagenPersonajes[i] = Personaje.personajes[i].getImageResourceID();
        }

        int[] descripcionPersonajes = new int[Personaje.personajes.length];
        for (int i = 0; i < descripcionPersonajes.length; i++) {
            descripcionPersonajes[i] = Personaje.personajes[i].getDescripcion();
        }

        int[] habilidadPersonajes = new int[Personaje.personajes.length];
        for (int i = 0; i < habilidadPersonajes.length; i++) {
            habilidadPersonajes[i] = Personaje.personajes[i].getHabilidades();
        }

        // Configurar el adaptador del RecyclerView.
        PersonajeAdapter adapter = new PersonajeAdapter(nombrePersonajes, imagenPersonajes, descripcionPersonajes, habilidadPersonajes);
        personajeRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        personajeRecycler.setLayoutManager(layoutManager);

        // Configurar el listener para manejar la selección de un personaje.
        adapter.setListener(position -> {
            // Mostrar un Toast al seleccionar un personaje.
            String personajeSeleccionado = getString(Personaje.personajes[position].getNombre());
            Toast.makeText(getActivity(), getString(R.string.toastCharSelected, personajeSeleccionado), Toast.LENGTH_SHORT).show();

            // Navegar a la actividad de detalles del personaje.
            Intent intent = new Intent(getActivity(), PersonajeDetalleActivity.class);
            intent.putExtra(PersonajeDetalleActivity.EXTRA_PERSONAJE_ID, position);
            getActivity().startActivity(intent);
        });

        return personajeRecycler;
    }
}

