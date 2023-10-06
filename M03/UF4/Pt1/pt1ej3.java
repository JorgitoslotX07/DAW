import java.util.Scanner;

class pt1ej3 {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Seleccione una de las opciones a continuacion:\n 1. Calcular perimetro y area de un rectangulo\n 2. Clacular perimetro y area de un circulo\n\nIndique la opcion elegida -->  ");
        Thread.sleep(500);
        int x = sc.nextInt();

        if (x == 1) {
            System.out.print("Indique la base -->  ");
            float b = sc.nextFloat();
            System.out.print("Indique la altura -->  ");
            float h = sc.nextFloat();
            System.out.println("El perimetro es: " + (b*2) * (h*2) + "\nLa area es: " + (b*h));
        }
        else if (x == 2) {
            System.out.print("Indique el radio -->  ");
            float r = sc.nextFloat();
            System.out.println("El perimetro es: " + 2 * Math.PI * r + "\n La area es: " + Math.PI * Math.pow(r,2));
        }
        else {
            System.out.print("¡¡ERROR!! \nSelecione una de las opciones indicadas");
        }
        sc.close();
    }
}