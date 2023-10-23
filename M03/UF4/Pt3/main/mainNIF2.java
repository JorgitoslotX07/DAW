package UF4.Pt3.main;

import UF4.Pt3.act.NIF2;

public class mainNIF2 {
    public static void main(String[] args) {
        int numeroDNI_1 = 12345678;
        char letra_1 = 'Z';

        int numeroDNI_2 = 87654321;
        char letra_2 = 'T';

        System.out.println(numeroDNI_1 + String.valueOf(letra_1));
        correcto(numeroDNI_1, letra_1);

        System.out.println(numeroDNI_2 + String.valueOf(letra_2));
        correcto(numeroDNI_2, letra_2);
    }

    public static void correcto(int numeroDNI, char letra) {
        boolean correcto = NIF2.comprovarLetra(numeroDNI, letra);

        if (correcto) {
            System.out.println("El NIF és correcte.");
        } else {
            System.out.println("El NIF és incorrecte.");
        }
    }
}
