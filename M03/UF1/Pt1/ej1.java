import java.util.Scanner;
class NumeroCuadrado{
	public static void main(String[] args) {			
		Scanner sc = new Scanner(System.in);
		System.out.print("Insertar un numero -->  ");
		int numero = sc.nextInt(); 
		int resultado = numero * numero;
		System.out.println("Resultado:"+resultado);
		sc.close();
	}
}