package com.example.entrenamiento2;

public class Entrenamiento {
    private String nom;
    private String descripcio;
    private int imagen;

    public static final Entrenamiento[] entrenaments = {
            new Entrenamiento("Extremitats a Tope",
                    "5 Flexions a terra\n" +
                            "10 Inclinacions d'una cama\n" +
                            "15 Flexions dorsals\n",
                    R.drawable.deporte1),
            new Entrenamiento("Agonia Màxima",
                    "100 Flexions inclinades\n" +
                            "100 Flexions\n" +
                            "100 Abdominals\n" +
                            "100 Esquats\n",
                    R.drawable.deporte2),
            new Entrenamiento("Entrenament especial",
                    "5 Dorsals\n" +
                            "10 Flexions\n" +
                            "15 Esquats\n",
                    R.drawable.deporte3),
            new Entrenamiento("Força i longitud",
                    "500 Metres màxima velocitat\n" +
                            "21 Llançaments de pes \n" +
                            "21 Flexions\n",
                    R.drawable.deporte4)
    };


    private Entrenamiento(String nom, String descripcio, int imagen) {
        this.nom = nom;
        this.descripcio = descripcio;
        this.imagen = imagen;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public String getNom() {
        return nom;
    }

    public String toString() {
        return this.nom;
    }

    public int getImagen(){ return this.imagen;}
}
