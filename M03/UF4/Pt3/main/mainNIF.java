package UF4.Pt3.main;

import UF4.Pt3.act.NIF;

//Recorda nomenclatura classes
public class mainNIF {
    public static void main(String[] args) {
        NIF nif1 = new NIF(12345678, 'Z');
        NIF nif2 = new NIF(87654321, 'T');

        System.out.println("NIF 1: " + nif1.getNIF());
        System.out.println("NIF 2: " + nif2.getNIF());

        nif1.setNIF(87654321, 'T');
        System.out.println("NIF 1 (després de canviar): " + nif1.getNIF());
    }
}
