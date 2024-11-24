package com.jcm.mariobrosappjcm;

/**
 * La clase Personaje representa un personaje del universo de Mario Bros.
 * Incluye atributos como nombre, descripción, habilidades e imagen.
 */
public class Personaje {

    private int nombre;
    private int descripcion;
    private int habilidades;
    private int imageResourceID;

    public static final Personaje[] personajes = {
            new Personaje(R.string.marioName, R.drawable.mario, R.string.marioDescription, R.string.marioAbilities),
            new Personaje(R.string.luigiName, R.drawable.luigi, R.string.luigiDescription, R.string.luigiAbilities),
            new Personaje(R.string.peachName, R.drawable.princesa, R.string.peachDescription, R.string.peachAbilities),
            new Personaje(R.string.toadName, R.drawable.seta, R.string.toadDescription, R.string.toadAbilities),
            new Personaje(R.string.yoshiName, R.drawable.dino, R.string.yoshiDescription, R.string.yoshiAbilities)
    };

    /**
     * Constructor privado para inicializar un personaje.
     *
     * @param nombre ID del recurso del nombre del personaje.
     * @param imageResourceID ID del recurso de la imagen del personaje.
     * @param descripcion ID del recurso de la descripción del personaje.
     * @param habilidades ID del recurso de las habilidades del personaje.
     */
    private Personaje(int nombre, int imageResourceID, int descripcion, int habilidades) {
        this.nombre = nombre;
        this.imageResourceID = imageResourceID;
        this.descripcion = descripcion;
        this.habilidades = habilidades;
    }

    /**
     * @return ID del recurso del nombre del personaje.
     */
    public int getNombre() {
        return nombre;
    }

    /**
     * @return ID del recurso de la imagen del personaje.
     */
    public int getImageResourceID() {
        return imageResourceID;
    }

    /**
     * @return ID del recurso de la descripción del personaje.
     */
    public int getDescripcion() {
        return descripcion;
    }

    /**
     * @return ID del recurso de las habilidades del personaje.
     */
    public int getHabilidades() {
        return habilidades;
    }
}

