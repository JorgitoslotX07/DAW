package m03.application;

import java.time.LocalDate;

import m03.uf4.p4.p4.objects.Encarregat;
import m03.uf4.p4.p4.objects.Treballador;

import m03.view.Ventana;
/**
 * Application
 */
public class Application {

    public static void main(String[] args) {
        Treballador treballador1 = new Treballador("John", "Ramirez", 
                "12345678Z",
                LocalDate.of(2023, 1, 1),
                LocalDate.of(2024, 1, 1),
                1500
        );
        Treballador treballador2 = new Treballador("James", "Fernandez", 
                "00000000T",
                LocalDate.of(2023, 4, 3),
                LocalDate.of(2024, 1, 1),
                2500
        );
        Treballador treballador3 = new Treballador("Antonio", "Hernandez", 
                "11111111A",
                LocalDate.of(2015, 11, 21),
                LocalDate.of(2024, 1, 1),
                1000
        );
        Treballador treballador4 = new Treballador("Laura", "Perez",
                "22222222B",
                LocalDate.of(2019, 1, 1),
                LocalDate.of(2024, 1, 1),
                1300
        );
        Treballador treballador5 = new Treballador("Toni", "Jorda",
                "98765432B",
                LocalDate.of(2004, 6, 28),
                LocalDate.of(2024, 1, 1),
                2000
        );

        Encarregat encarregat1 = new Encarregat("Manager", "One", 
                "11111111X",
                LocalDate.of(1980, 3, 5),
                LocalDate.of(2010, 7, 1),
                3000, 500
        );

        encarregat1.afegirTreballador(treballador1);
        encarregat1.afegirTreballador(treballador2);
        encarregat1.afegirTreballador(treballador3);
        encarregat1.afegirTreballador(treballador4);
        encarregat1.afegirTreballador(treballador5);

        Ventana ventana = new Ventana(encarregat1);
        ventana.setVisible(true);

    }
}