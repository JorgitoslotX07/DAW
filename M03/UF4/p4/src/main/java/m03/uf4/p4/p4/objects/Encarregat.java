package m03.uf4.p4.p4.objects;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Encarregat extends Treballador {
    private double souExtra;
    private List<Treballador> llistaTreballadors;

    public Encarregat() {
        super();
        this.souExtra = 0;
        this.llistaTreballadors = new ArrayList<>();
    }

    public Encarregat(String nom, String cognoms, String dni, 
                      LocalDate dataNaixement, LocalDate dataIniciContracte, 
                      double salariBase, double souExtra) {
        super(nom, cognoms, dni, dataNaixement, dataIniciContracte, salariBase);
        this.souExtra = souExtra;
        this.llistaTreballadors = new ArrayList<>();
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

        if (!dnis.contains(treballador.getDni()) && !treballador.getDni().equals(super.getDni())) {
            if (treballador instanceof Encarregat) {
                if (treballadorContieneDni((Encarregat) treballador, super.getDni())) {
                    return false;
                }
            }
            llistaTreballadors.add(treballador);
            return true;
        }
        return false;
    }

    private boolean treballadorContieneDni(Encarregat encarregat, String dniBuscado) {
        for (Treballador trabaja : encarregat.getLlistaTreballadors()) {
            if (trabaja != null) {
                if (trabaja.getDni().equals(dniBuscado)) {
                    return true;
                } else if (trabaja instanceof Encarregat) {
                    if (treballadorContieneDni((Encarregat) trabaja, dniBuscado)) {
                        return true;
                    }
                }
            }            
        }
        return false;
    }

    public boolean borrarTreballador(Treballador treballador) {
        if (llistaTreballadors.contains(treballador)) {
            llistaTreballadors.remove(treballador);
            return true;
        }
        return false;
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
                    nivells= newNivells;
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
        if (lengthLlistaTreballadors() != 0) {
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
    
    private int lengthLlistaTreballadors() {
        return llistaTreballadors.size();
    }
}
