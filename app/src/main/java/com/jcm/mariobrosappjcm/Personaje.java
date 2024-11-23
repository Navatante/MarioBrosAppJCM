package com.jcm.mariobrosappjcm;

public class Personaje {
    private String nombre;
    private String descripcion;
    private String habilidades;
    private int imageResourceID;

    public static final Personaje[] personajes = {
            new Personaje("Mario", R.drawable.mario, "Personaje principal.", "Gran saltador.\nUsa potenciadores como la flor de fuego o estrella." ),
            new Personaje("Luigi",R.drawable.luigi, "Hermano de Mario.", "Salta más alto y más lejos que Mario.\nExperto en cazar fantasmas."),
            new Personaje("Peach",R.drawable.princesa, "Gobernante del Reino Champiñón.", "Flota gracias a su vestido.\nDispone de habilidades mágicas."),
            new Personaje("Toad",R.drawable.seta, "Habitante del Reino Champiñón.", "Muy rápido.\nExcelente recolector de objetos."),
            new Personaje("Yoshi",R.drawable.dino, "Dinosaurio amistoso.", "Atrapa enemigos con su lengua.\nGran saltador.")
    };

    private Personaje(String nombre, int imageResourceID, String descripcion, String habilidades) {
        this. nombre = nombre;
        this. imageResourceID = imageResourceID;
        this.descripcion = descripcion;
        this.habilidades = habilidades;
    }

    // GETTERS

    public String getNombre() {
        return nombre;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getHabilidades() {
        return habilidades;
    }
}
