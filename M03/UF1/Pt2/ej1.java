import java.util.Scanner;
class pt2_ej1 {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Inserta un numero -->  ");
        int num = sc.nextInt();
        String par_o_senar = "";
        if (num % 2 == 0) {
            par_o_senar = "PARELL";
        }
        else {
            par_o_senar = "SENAR";
        }
        Thread.sleep(500);
        System.out.println("El numero introduciso es " + par_o_senar);
        sc.close(); 
    }
}