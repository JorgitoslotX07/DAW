package m03.uf5.p2.collections;

import java.util.ArrayList;
import java.util.Random;

public class p2exercici2 {
    public static void main(String[] args) {
        Random r = new Random();

        int n = r.nextInt(11) + 10;

        ArrayList<Integer> lista = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            lista.add(r.nextInt(101));
        }

        System.out.println("Lista -> " + lista);
        System.out.println("Cantiadad lista -> " + lista.size());

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int valor : lista) {
            sum += valor;
            max = Math.max(max, valor);
            min = Math.min(min, valor);
        }

        double media = (double) sum / n;

        System.out.println("Sum -> " + sum);
        System.out.println("Media -> " + media);
        System.out.println("Max -> " + max);
        System.out.println("Min -> " + min);
    }
}
