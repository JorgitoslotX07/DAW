package m03.uf4.p4.p4.objects;

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

    private List<String> obtenerDnis() {
        List<String> dnis = new ArrayList<>();
        for (Treballador existent : llistaTreballadors) {
            if (existent != null) {
                dnis.add(existent.getDni());
            }
        }
        return dnis;
    }

    public boolean afegirTreballador(Treballador treballador) {
        List<String> dnis = obtenerDnis();

        if (!dnis.contains(treballador.getDni())) {
            for (int i = 0; i < llistaTreballadors.length; i++) {
                if (llistaTreballadors[i] == null) {
                    llistaTreballadors[i] = treballador;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean borrarTreballador(Treballador treballador) {
        List<String> dnis = obtenerDnis();

        if (dnis.contains(treballador.getDni())) {
            for (int i = 0; i < llistaTreballadors.length; i++) {
                if (llistaTreballadors[i] == treballador) {
                    llistaTreballadors[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public int nivellEncarregat() {
        int nivell = 0;

        for (Treballador treballador : llistaTreballadors) {
            if (treballador instanceof Encarregat) {
                nivell += contarNivellsEncarregats((Encarregat) treballador);
            }
        }

        return nivell;
    }

    private int contarNivellsEncarregats(Encarregat encarregat) {
        int nivells = 0;
    
        for (Treballador subencarregat : encarregat.getLlistaTreballadors()) {
            if (subencarregat instanceof Encarregat) {   
                nivells += contarNivellsEncarregats((Encarregat) subencarregat);
            }
        }
    
        return nivells;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Encarregat [ ")
            .append(getCognoms())
            .append(", ")
            .append(getNom())
            .append(" | ")
            .append(getDni())
            .append(" | ")
            .append(getDataNaixement())
            .append(" | ")
            .append(getSalariBase())
            .append("€ ]\n");

        result.append(toStringEmpleats());


        return result.toString();
    }

    private String toStringEmpleats() {
        StringBuilder result = new StringBuilder();

        result.append("Llistat treballadors de [ ")
            .append(getDni())
            .append(" ]:\n");

        for (int i = 0; i < llistaTreballadors.length; i++) {
            Treballador treballador = llistaTreballadors[i];
            if (treballador != null) {
                result.append("\t")
                    .append(i)
                    .append(" - ");
                
                if (treballador instanceof Encarregat) {
                    result.append(((Encarregat) treballador).toString());
                        
                } else {
                    result.append(treballador.toString())
                    .append("\n");
                }
            }
        }

        return result.toString();
    }
}
