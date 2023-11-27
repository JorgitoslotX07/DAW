package m03.uf4.p4.objects;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Encarregat extends Treballador {
    private double souExtra;
    private Treballador[] llistaTreballadors;

    public Encarregat() {
        super();
        this.souExtra = 0;
        this.llistaTreballadors = new Treballador[50];
    }

    public Encarregat(String nom, String cognoms, String dni, 
                      LocalDate dataNaixement, LocalDate dataIniciContracte, 
                      double salariBase, double souExtra) {
        super(nom, cognoms, dni, dataNaixement, dataIniciContracte, salariBase);
        this.souExtra = souExtra;
        this.llistaTreballadors = new Treballador[50];
    }

    public double getSouExtra() {
        return souExtra;
    }

    public void setSouExtra(double souExtra) {
        this.souExtra = souExtra;
    }

    public Treballador[] getLlistaTreballadors() {
        return llistaTreballadors;
    }

    public void setLlistaTreballadors(Treballador[] llistaTreballadors) {
        this.llistaTreballadors = llistaTreballadors;
    }

    public double getSalari() {
        double salari = super.getSalari();

        return salari + souExtra;
    }

    public void afegirTreballador(Treballador treballador) {
        List<String> dnis = new ArrayList<>();
        for (Treballador existent : llistaTreballadors) {
            if (existent != null) {
                dnis.add(existent.getDni());
            }
        }

        if (!dnis.contains(treballador.getDni())) {
            for (int i = 0; i < llistaTreballadors.length; i++) {
                if (llistaTreballadors[i] == null) {
                    llistaTreballadors[i] = treballador;
                    break;
                }
            }
        }
    }
}
