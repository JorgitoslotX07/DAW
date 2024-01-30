package m03.uf5.p1.excepcions;

import java.util.InputMismatchException;
import java.util.Scanner;

//import com.heavenark.infrastructure.web.exception.ori.LogicException;


class DividirMajorEntreMenor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Introdueix el valor de a: ");
            int a = scanner.nextInt();

            System.out.print("Introdueix el valor de b: ");
            int b = scanner.nextInt();

            dividirMajorEntreMenor(a, b);
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Has introduir nombres enters.");
        } catch (ArithmeticException e) {
            System.out.println("ERROR: Division por 0.");
        } catch (LogicException e) {
            System.out.println("ERROR logico: " + e.getMessage());
        } finally {
            System.out.println("Programa acabat.");
        }
    }

    public static void dividirMajorEntreMenor(int a, int b) throws LogicException {
        if (b > a) {
            throw new LogicException("El parametro b tiene que ser menor o igual que a.");
        }

        int resultat = a / b;
        System.out.println("Resultado: " + resultat);
    }
}