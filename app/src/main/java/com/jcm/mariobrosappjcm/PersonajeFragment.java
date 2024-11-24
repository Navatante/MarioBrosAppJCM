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

public class PersonajeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        RecyclerView personajeRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_personaje, container, false);

        //Snackbar al cargar la lista de personajes
        personajeRecycler.post(() ->
                Snackbar.make(personajeRecycler, R.string.snackBarWelcome, Snackbar.LENGTH_LONG).show()
        );

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

        PersonajeAdapter adapter = new PersonajeAdapter(nombrePersonajes, imagenPersonajes, descripcionPersonajes, habilidadPersonajes);
        personajeRecycler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager((getActivity()));
        personajeRecycler.setLayoutManager(layoutManager);

        adapter.setListener(position -> {
            // Mostrar el Toast al seleccionar un personaje
            String personajeSeleccionado = getString(Personaje.personajes[position].getNombre());
            Toast.makeText(getActivity(),getString(R.string.toastCharSelected, personajeSeleccionado), Toast.LENGTH_SHORT).show();

            // Navegar a los detalles del personaje
            Intent intent = new Intent(getActivity(), PersonajeDetalleActivity.class);
            intent.putExtra(PersonajeDetalleActivity.EXTRA_PERSONAJE_ID, position);
            getActivity().startActivity(intent);
        });

        return personajeRecycler;
    }
}
