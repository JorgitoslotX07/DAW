package m03.uf5.p2.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p2exercici4 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.print("Introduce 'algo' -> ");
            String n = scanner.nextLine();
            list.add(n);
        }
        scanner.close();

        Collections.sort(list);

        System.out.println("Lista -> " + list);
    }
}
