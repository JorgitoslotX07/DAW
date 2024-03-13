package m03.objects;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Encarregat extends Treballador {
    private double souExtra;
    private LocalDate dataIngres;
    private String diagnostic;
    private List<Treballador> llistaTreballadors;

    public Encarregat() {
        super();
        this.souExtra = 0;
        this.llistaTreballadors = new ArrayList<>();
    }

    public Encarregat(String nom, String cognoms, String dni,
            LocalDate dataNaixement, double salariBase, double souExtra) {
        super(nom, cognoms, dni, dataNaixement, salariBase);
        this.souExtra = souExtra;
        this.dataIngres = LocalDate.now();
        this.llistaTreballadors = new ArrayList<>();
    }

    public void Persona(String dni, LocalDate dataNaixement, LocalDate dataIngres, String diagnostic) {
        super.Persona(dni, dataNaixement);
        setDataIngres(dataIngres);
        setDiagnostic(diagnostic);
    }

    public LocalDate getDataIngres() {
        return dataIngres;
    }

    public void setDataIngres(LocalDate dataIngres) {
        this.dataIngres = dataIngres;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public double getSouExtra() {
        return souExtra;
    }

    public void setSouExtra(double souExtra) {
        this.souExtra = souExtra;
    }

    public List<Treballador> getLlistaTreballadors() {
        return llistaTreballadors;
    }

    public void setLlistaTreballadors(List<Treballador> llistaTreballadors) {
        this.llistaTreballadors = llistaTreballadors;
    }

    public double getSalari() {
        double salari = super.getSalari();

        return salari + souExtra;
    }

    public int nivellEncarregat() {
        int nivell = 0;
        int newNivell = 0;
        for (Treballador treballador : llistaTreballadors) {
            if (treballador instanceof Encarregat && treballador != null) {
                newNivell = contarNivellsEncarregats((Encarregat) treballador);
                if (newNivell > nivell) {
                    nivell = newNivell;
                }
            }
        }
        return nivell + 1;
    }

    private int contarNivellsEncarregats(Encarregat encarregat) {
        int nivells = 0;
        int newNivells = 0;
        for (Treballador subencarregat : encarregat.getLlistaTreballadors()) {
            if (subencarregat instanceof Encarregat && subencarregat != null) {
                newNivells += contarNivellsEncarregats((Encarregat) subencarregat);
                if (newNivells > nivells) {
                    nivells = newNivells;
                }
            }
        }
        if (!encarregat.getLlistaTreballadors().isEmpty()) {
            return nivells + 1;
        } else {
            return nivells;
        }
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
                .append(getEdat())
                .append(" | ")
                .append(getSalariBase())
                .append("€ ]\n");
        if (llistaTreballadors.size() != 0) {
            result.append(toStringEmpleats());
        } else {
            result.append("\n");
        }

        return result.toString();
    }

    private String toStringEmpleats() {
        StringBuilder result = new StringBuilder();

        result.append("Llista treballadors de [ ")
                .append(getDni())
                .append(" ]: {\n");

        for (int i = 0; i < llistaTreballadors.size(); i++) {
            Treballador treballador = llistaTreballadors.get(i);
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
        result.append("}\n\n");

        return result.toString();
    }
}
