package m03.uf5.p2.collections.ex7;

import java.util.Random;

public class Carta implements Comparable<Carta> {
    private int numero;
    private String pal;

    private static final String[] PALOS = {"Copes", "Oros", "Espases", "Bastos"};

    public Carta() {
        Random random = new Random();
        this.numero = random.nextInt(12) + 1;
        this.pal = PALOS[random.nextInt(PALOS.length)];
    }

    @Override
    public String toString() {
        String numeroString;
        switch (numero) {
            case 1:
                numeroString = "As";
                break;
            case 11:
                numeroString = "Sota";
                break;
            case 12:
                numeroString = "Cavall";
                break;
            case 13:
                numeroString = "Rei";
                break;
            default:
                numeroString = String.valueOf(numero);
                break;
        }
        return "\"" + numeroString + "\" de \"" + pal + "\"";
    }

    @Override
    public int compareTo(Carta otraCarta) {
        int comparacionPalo = this.pal.compareTo(otraCarta.pal);
        if (comparacionPalo != 0) {
            return comparacionPalo;
        }

        return Integer.compare(this.numero, otraCarta.numero);
    }
}
