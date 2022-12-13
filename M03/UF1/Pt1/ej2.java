import java.util.Scanner;
class Hola{
	public static void main(String[] args) throws InterruptedException{
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce tu nombre -->  ");
		String nom = sc.nextLine();
		System.out.println("Hola " + nom + ", que tenga un buen dia.");
	
		Thread.sleep(500);
		
		System.out.print("Inserte un numero -->  ");
		float num1 = sc.nextInt();
		System.out.print("Inserte otro numero -->  ");
		float num2 = sc.nextInt();
		float num3 = num1 * num2;
		System.out.println(num3);
		sc.close();
	}
}
