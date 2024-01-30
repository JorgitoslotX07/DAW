package m03.uf5.p2.collections.ex6;

import java.util.Random;

public class Carta {
    private String numero;
    private String pal;

    private static final String[] NUMEROS = {
        "As", 
        "Dos", 
        "Tres", 
        "Quatre", 
        "Cinc", 
        "Sis", 
        "Set", 
        "Vuit", 
        "Nou", 
        "Sota", 
        "Cavall", 
        "Rei"
    };
    private static final String[] PALOS = {
        "Copes", 
        "Oros", 
        "Espases", 
        "Bastos"
    };

    public Carta() {
        Random random = new Random();
        this.numero = NUMEROS[random.nextInt(NUMEROS.length)];
        this.pal = PALOS[random.nextInt(PALOS.length)];
    }

    @Override
    public String toString() {
        return "\"" + numero + "\" de \"" + pal + "\"";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Carta carta = (Carta) obj;

        return numero.equals(carta.numero) && pal.equals(carta.pal);
    }
}
