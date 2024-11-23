package com.jcm.mariobrosappjcm;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class PersonajeAdapter extends RecyclerView.Adapter<PersonajeAdapter.ViewHolder> {
    private int[] nombres;
    private int[] imageIds;
    private int[] descripciones;
    private int[] habilidades;
    private Listener listener;

    interface Listener {
        void onClick(int position);
    }

    public PersonajeAdapter(int[] nombres, int[] imageIds, int[] descripciones, int[] habilidades) {
        this.nombres = nombres;
        this.imageIds = imageIds;
        this.descripciones = descripciones;
        this.habilidades = habilidades;
    }

    @Override
    public int getItemCount() {
        return nombres.length;
    }

    @Override
    public PersonajeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_personaje, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.info_image);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);
        imageView.setImageDrawable(drawable);

        TextView textView = (TextView) cardView.findViewById(R.id.info_text);
        textView.setText(nombres[position]);
        cardView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onClick(position);
            }
        });
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    // VIEWHOLDER INNER CLASS
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }
 }
