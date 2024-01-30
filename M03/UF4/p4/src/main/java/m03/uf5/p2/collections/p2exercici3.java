package m03.uf5.p2.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p2exercici3 {
    public static void main(String[] args) {
        ArrayList<Integer> numList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce numero -> ");
            int numero = scanner.nextInt();
            numList.add(numero);
        }
        scanner.close();

        Collections.sort(numList);

        System.out.println("Lista -> " + numList);
    }
}
