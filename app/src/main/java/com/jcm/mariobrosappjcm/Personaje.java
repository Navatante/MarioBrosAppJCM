package com.jcm.mariobrosappjcm;

public class Personaje {
    private int nombre;
    private int descripcion;
    private int habilidades;
    private int imageResourceID;

    public static final Personaje[] personajes = {
            new Personaje(R.string.marioName, R.drawable.mario, R.string.marioDescription, R.string.marioAbilities ),
            new Personaje(R.string.luigiName,R.drawable.luigi, R.string.luigiDescription, R.string.luigiAbilities),
            new Personaje(R.string.peachName,R.drawable.princesa, R.string.peachDescription, R.string.peachAbilities),
            new Personaje(R.string.luigiName,R.drawable.seta, R.string.toadDescription, R.string.toadAbilities),
            new Personaje(R.string.yoshiName,R.drawable.dino, R.string.yoshiDescription, R.string.yoshiAbilities)
    };

    private Personaje(int nombre, int imageResourceID, int descripcion, int habilidades) {
        this. nombre = nombre;
        this. imageResourceID = imageResourceID;
        this.descripcion = descripcion;
        this.habilidades = habilidades;
    }

    // GETTERS

    public int getNombre() {
        return nombre;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public int getDescripcion() {
        return descripcion;
    }

    public int getHabilidades() {
        return habilidades;
    }
}
