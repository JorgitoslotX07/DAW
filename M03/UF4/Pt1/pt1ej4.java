import java.util.Scanner;

class pt1ej4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de dinero -->  ");
        //Vigila amb els noms de les variables, que siguin entendibles.
        float x = sc.nextFloat();
        System.out.print("Indique una tasa de interes -->  ");
        float y = sc.nextFloat();
        System.out.print("Indique la cantidad de años -->  ");
        float z = sc.nextFloat();
        //Error en la fòrmula
        
        double xyz = x * Math.pow(1 + y/100,z);
        System.out.println(xyz);
        sc.close();
    }
}