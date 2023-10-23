package UF4.Pt3.main;

import UF4.Pt3.act.Empleat;

public class mainEmpleat {
    public static void main(String[] args) {
        Empleat empleat1 = new Empleat("Pepe", 30, 50000.0);
        Empleat empleat2 = new Empleat("Paco", 25, 45000.0);

        System.out.println("Nombre d'empleats: " + Empleat.getNEmpleados());

        System.out.println("Informacion del empleado 1:");
        empleat1.mostrarInformacio();

        System.out.println("Informacion del empleado 2:");
        empleat2.mostrarInformacio();
    }

}
