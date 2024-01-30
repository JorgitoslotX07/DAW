package m03.uf5.p2.collections;

import m03.uf5.p2.collections.ex7.Carta;

import java.util.ArrayList;
import java.util.Collections;

public class p2exercici7 {
    public static void main(String[] args) {
        ArrayList<Carta> cartas = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Carta nuevaCarta = new Carta();
            while (cartas.contains(nuevaCarta)) {
                nuevaCarta = new Carta();
            }
            cartas.add(nuevaCarta);
        }

        // Casting explícito a ArrayList<Comparable>
        Collections.sort(cartas);

        for (Carta carta : cartas) {
            System.out.println(carta);
        }
    }
}
