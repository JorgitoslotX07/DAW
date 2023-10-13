
import java.util.Scanner;

class pt1ej2 {
	public static void main(String[] args) throws InterruptedException{
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce tu nombre -->  ");
		String nom = sc.nextLine();
		System.out.println("Hola " + nom + ", que tenga un buen dia.");
		//Per què poses un sleep? 
		Thread.sleep(500);
		
		System.out.print("Inserte un numero -->  ");
		//Si reserves en memòria un float, llegeix un float utilitzant un nextFloat(). Potser amb un double n'hauries tingut prou.
		float num1 = sc.nextInt();
		System.out.print("Inserte otro numero -->  ");
		float num2 = sc.nextInt();
		//La variable num3 té un nom poc explicatiu per ser el resultat de la multiplicació.
		float num3 = num1 * num2;
		System.out.println(num3);
		sc.close();
	}
}
