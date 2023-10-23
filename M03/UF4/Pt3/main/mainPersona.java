package UF4.Pt3.main;

import UF4.Pt3.act.*;

public class mainPersona {
    public static void main(String[] args) {
        Data data1 = new Data(23, 10, 1985);
        NIF nif1 = new NIF(12345678, 'Z');
        Persona persona1 = new Persona("Paco", data1, nif1);

        Data data2 = new Data(15, 5, 1990);
        NIF nif2 = new NIF(87654321, 'T');
        Persona persona2 = new Persona("Pepe", data2, nif2);

        System.out.println("Informacion de Persona 1:");
        persona1.mostrarInfo();

        System.out.println("\nInformacion de Persona 2:");
        persona2.mostrarInfo();
    }
}
