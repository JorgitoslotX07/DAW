package com.interfaces;

import com.negoci.Punt;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Punt punt1 = new Punt(0, 0);
        Punt punt2 = new Punt(3, 4);

        while (true) {
            System.out.println("Escoje una opcion:");
            System.out.println("1. Consultar coordenadas Punto 1");
            System.out.println("2. Consultar coordenadas Punto 2");
            System.out.println("3. Desplazar un punt");
            System.out.println("4. Calcular distancia entre puntos");
            System.out.println("5. Calcular punto medio entre puntos");
            System.out.println("0. Salir");
            System.out.print("Opció: ");

            int opcio = scanner.nextInt();

            switch (opcio) {
                case 1:
                    System.out.println("Coordenades del punt 1: " + punt1.toString());
                    break;
                case 2:
                    System.out.println("Coordenades del punt 2: " + punt2.toString());
                    break;
                case 3:
                    System.out.print("Que putno quieres desplazar (1 o 2)? ");
                    int punt = scanner.nextInt();
                    System.out.print("Desplazar en el eje 'x' o 'y'? ");
                    char coordenada = scanner.next().charAt(0);
                    System.out.print("Quantitat a desplazar: ");
                    double valor = scanner.nextDouble();

                    if (punt == 1) {
                        punt1.desplazar(coordenada, valor);
                    } else if (punt == 2) {
                        punt2.desplazar(coordenada, valor);
                    }

                    break;
                case 4:
                    double dist = punt1.distancia(punt2);
                    System.out.println("Distancia entre los puntos: " + dist);
                    break;
                case 5:
                    Punt mig = punt1.puntMig(punt2);
                    System.out.println("Punto medio entre los puntos: " + mig.toString());
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opcion no valida. Vuelve a intentarlo.");
            }
        }
    }
}
