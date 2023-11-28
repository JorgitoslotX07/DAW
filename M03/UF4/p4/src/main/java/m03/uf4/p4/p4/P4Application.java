package m03.uf4.p4.p4;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;

import m03.uf4.p4.p4.objects.Complement;
import m03.uf4.p4.p4.objects.EmpresaAdministrativa;
import m03.uf4.p4.p4.objects.Encarregat;
import m03.uf4.p4.p4.objects.Fabrica;
import m03.uf4.p4.p4.objects.Gestor;
import m03.uf4.p4.p4.objects.Treballador;

public class P4Application {
	public static void main(String[] args) {
        Complement baix = Complement.BAIX;
        Complement mig = Complement.MIG;
        Complement alt = Complement.ALT;


        Treballador treballador1 = new Treballador("John", "Doe", "12345678A",
                LocalDate.of(1990, 5, 15),
                LocalDate.of(2021, 1, 1),
                2000);

        Treballador treballador2 = new Treballador("Jane", "Doe", "98765432B",
                LocalDate.of(1985, 8, 20),
                LocalDate.of(2022, 3, 10),
                2500);
		treballador2.afegirComplement(alt);

        Encarregat encarregat1 = new Encarregat("Manager", "One", "11111111X",
                LocalDate.of(1980, 3, 5),
                LocalDate.of(2010, 7, 1),
                3000, 500);


        Fabrica fabrica1 = new Fabrica("FAB001");
        EmpresaAdministrativa empresaAdmin1 = new EmpresaAdministrativa("EAD001");


        Gestor gestor = new Gestor();


        fabrica1.afegirTreballador(treballador1);
        empresaAdmin1.afegirTreballador(treballador2);

        gestor.transferirTreballador(fabrica1, empresaAdmin1, "12345678A");

		gestor.transferirTreballadorEncarregat(empresaAdmin1, encarregat1, "12345678A");
		gestor.transferirTreballadorEncarregat(empresaAdmin1, encarregat1, "98765432B");

		empresaAdmin1.afegirTreballador(encarregat1);

        
        System.out.println("Fabrica1: " + fabrica1.toString());
        System.out.println("EmpresaAdministrativa1: " + empresaAdmin1.toString());
		System.out.println(gestor.obtenirTipus(empresaAdmin1));
    }

}
