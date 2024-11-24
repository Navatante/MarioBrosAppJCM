package com.jcm.mariobrosappjcm;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Adaptador para gestionar y mostrar una lista de personajes en un RecyclerView.
 */
public class PersonajeAdapter extends RecyclerView.Adapter<PersonajeAdapter.ViewHolder> {

    private int[] nombres;
    private int[] imageIds;
    private int[] descripciones;
    private int[] habilidades;
    private Listener listener;

    /**
     * Listener para manejar eventos de clic en un elemento de la lista.
     */
    interface Listener {
        void onClick(int position);
    }

    /**
     * Constructor del adaptador.
     *
     * @param nombres Array de IDs de recursos para los nombres de los personajes.
     * @param imageIds Array de IDs de recursos para las imágenes de los personajes.
     * @param descripciones Array de IDs de recursos para las descripciones de los personajes.
     * @param habilidades Array de IDs de recursos para las habilidades de los personajes.
     */
    public PersonajeAdapter(int[] nombres, int[] imageIds, int[] descripciones, int[] habilidades) {
        this.nombres = nombres;
        this.imageIds = imageIds;
        this.descripciones = descripciones;
        this.habilidades = habilidades;
    }

    @Override
    public int getItemCount() {
        return nombres.length; // Devuelve el número de elementos en la lista.
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Infla la vista del CardView para cada elemento.
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_personaje, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // Vincula los datos del personaje a las vistas del CardView.
        CardView cardView = holder.cardView;
        ImageView imageView = cardView.findViewById(R.id.info_image);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);
        imageView.setImageDrawable(drawable);

        TextView textView = cardView.findViewById(R.id.info_text);
        textView.setText(nombres[position]);

        cardView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onClick(position);
            }
        });
    }

    /**
     * Establece el listener para manejar eventos de clic en un elemento.
     *
     * @param listener Listener para los eventos de clic.
     */
    public void setListener(Listener listener) {
        this.listener = listener;
    }

    /**
     * ViewHolder para gestionar las vistas individuales del RecyclerView.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        /**
         * Constructor del ViewHolder.
         *
         * @param v CardView que contiene las vistas del personaje.
         */
        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }
}
