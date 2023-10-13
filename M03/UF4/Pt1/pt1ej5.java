
import java.util.Scanner;

class pt1ej5 {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Selecione una de las siguentes opciones: \n1. Pasar grados Fahrenheit a Celsius. \n2. Pasar grados Celsius a Fahrenheit.\n---->   ");
        Thread.sleep(500);
        int x = sc.nextInt();

        if (x == 1) {
            System.out.print("Indique los grados Fahrenheit -->  ");
            float f = sc.nextFloat();
            float c = (f - 32) * 5 / 9;
            System.out.println(c + " grados Celsius");
        }
        else if (x == 2) {
            System.out.print("Indique los grados Celsius -->  ");
            float c = sc.nextFloat();
            float f = 9*c/5 + 32; //Vigila les fòrmules que encara que sembli que les enten correctament, pot fallar.
            System.out.println(f + " grados Fahrenheit");
        }
        else {
            System.out.print("¡¡ERROR!! \nSelecione una de las opciones indicadas");
        }
        sc.close();
    }
}