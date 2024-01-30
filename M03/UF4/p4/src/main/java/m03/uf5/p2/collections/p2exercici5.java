package m03.uf5.p2.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class p2exercici5 {
    public static void main(String[] args) {
        // Crear HashMap con usuarios y contraseñas predefinidos
        Map<String, String> usuarios = new HashMap<>();
        usuarios.put("usu1", "contra1");
        usuarios.put("usu2", "contra2");
        usuarios.put("usu3", "contra3");

        Scanner scanner = new Scanner(System.in);

        int intentosRestantes = 3;

        while (intentosRestantes > 0) {
            System.out.print("Usuario -> ");
            String usuarioInput = scanner.nextLine();

            if (usuarios.containsKey(usuarioInput)) {
                System.out.print("Contraseña -> ");
                String contrasenaInput = scanner.nextLine();

                if (usuarios.get(usuarioInput).equals(contrasenaInput)) {
                    System.out.println("Felicitats, ets dins!");
                    break; 
                } else {
                    System.out.println("Contrasenya errònia");
                }
            } else {
                System.out.println("Usuari inexistent");
            }

            intentosRestantes--;

            if (intentosRestantes > 0) {
                System.out.println("Tienes " + intentosRestantes + " intentos restantes.");
            } else {
                System.out.println("S'ha quedat sense oportunitats...");
            }
        }

        scanner.close();
    }
}
