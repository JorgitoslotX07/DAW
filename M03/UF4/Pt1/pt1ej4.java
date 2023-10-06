import java.util.Scanner;

class pt1ej4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de dinero -->  ");
        float x = sc.nextFloat();
        System.out.print("Indique una tasa de interes -->  ");
        float y = sc.nextFloat();
        System.out.print("Indique la cantidad de años -->  ");
        float z = sc.nextFloat();
        float xyz = x * (1 + y/100);
        System.out.println(Math.pow(xyz, z));
        sc.close();
    }
}