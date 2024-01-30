package m03.uf5.p2.collections;

import m03.uf5.p2.collections.ex6.Carta;
import java.util.ArrayList;

public class p2exercici6 {
    public static void main(String[] args) {
        ArrayList<Carta> cartas = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Carta nuevaCarta = new Carta();
            
            while (cartas.contains(nuevaCarta)) {
                nuevaCarta = new Carta();
            }

            cartas.add(nuevaCarta);
        }

        for (Carta carta : cartas) {
            System.out.println(carta);
        }
    }
}
