package m03.uf5.p1.excepcions;

import java.util.Scanner;

import org.antlr.v4.runtime.InputMismatchException;

public class ProvarPila {
    public static void main(String[] args) {

        System.out.print("Inicio");
        try {
            Scanner scanner = new Scanner(System.in);
            Pila pila = new Pila(10);

            System.out.print("Introduce -> ");
            for (int i = 0; i < 11; i++) {
                try {
                    pila.afegir(scanner.nextInt());
                } catch (InputMismatchException e) {
                    System.out.println("Input invalido");
                    break;
                }
            }

            System.out.println(pila);

            for (int i = 0; i < 3; i++) {
                pila.extreure();
            }

            System.out.println(pila);

            System.out.println(pila.getTop());

            pila.buidarPila();

            System.out.println(pila.getTop());

            pila.afegir(666);

            System.out.println(pila);
        } finally {
            System.out.print("Fin");
        }
    }
}