import java.util.Scanner;

class pt1ej6 {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Inserta un numero -->  ");
        int x = sc.nextInt();
        System.out.print("Inserta otro numero -->  ");
        int y = sc.nextInt();
        
        Thread.sleep(500);
        /*System.out.printf("hola %s %s %n","hola", x);*/
        System.out.println("Suma: " + (x + y) + "\nResta: " + (x - y) + "\nDivisión:" + (x / y) + "\nMultiplicacion:" + (x * y));
        sc.close(); 
    }
}