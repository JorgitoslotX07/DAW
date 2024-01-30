package m03.uf5.p2.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p2exercici8 {
    public static void main(String[] args) {
        Map<String, String> diccionario = new HashMap<>();

        diccionario.put("gat", "gato");
        diccionario.put("gos", "perro");
        diccionario.put("cotxe", "coche");
        diccionario.put("taula", "mesa");
        diccionario.put("cadira", "silla");
        diccionario.put("llibre", "libro");
        diccionario.put("sol", "sol");
        diccionario.put("lluna", "luna");
        diccionario.put("pluja", "lluvia");
        diccionario.put("arbre", "arbol");
        diccionario.put("mar", "mar");
        diccionario.put("muntanya", "montaña");
        diccionario.put("flor", "flor");
        diccionario.put("verd", "verde");
        diccionario.put("blau", "azul");
        diccionario.put("roig", "rojo");
        diccionario.put("porta", "puerta");
        diccionario.put("finestra", "ventana");
        diccionario.put("ordinador", "ordenador");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Introduce -> ");
            String paraula = scanner.nextLine().toLowerCase();

            if (paraula.equals("99")) {
                System.out.println("Adeu!");
                break;
            }

            if (diccionario.containsKey(paraula)) {
                System.out.println("Traduccion -> " + diccionario.get(paraula));
            } else {
                System.out.println("No tengo esta palabra.");
                String opcio = scanner.nextLine();

                if (opcio.equals("1")) {
                    System.out.print("Introduce la traduccion -> ");
                    String traduccioNova = scanner.nextLine();
                    diccionario.put(paraula, traduccioNova);
                    System.out.println("Palabra agregada");
                }
            }
        }
        scanner.close();
    }
}

