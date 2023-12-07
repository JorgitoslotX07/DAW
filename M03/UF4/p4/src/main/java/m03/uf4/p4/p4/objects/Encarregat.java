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

    //Encara no hem explicat arrayLists per generar-ho així, però bé... 
    private List<String> obtenerDnis() {
        List<String> dnis = new ArrayList<>();
        for (Treballador existent : llistaTreballadors) {
        	//Tingues en compte que si no fessis aquesta validació no et serviria fer el foreach, estàs recorrent sempre les 50 posicions independentment de si hi ha objectes o no. Poc òptim
            if (existent != null) {
                dnis.add(existent.getDni());
            }
        }
        return dnis;
    }

    //Falta validar si està intentant assignar un Encarregat que sigui el seu propi jefe. O a ell mateix (bucle infinit)
    public boolean afegirTreballador(Treballador treballador) {
        List<String> dnis = obtenerDnis();

        if (!dnis.contains(treballador.getDni())) {
        	//Tingues en compte que si no fessis aquesta validació no et serviria fer el foreach, estàs recorrent sempre les 50 posicions independentment de si hi ha objectes o no. Poc òptim
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
        	//Tingues en compte que si no fessis aquesta validació no et serviria fer el foreach, estàs recorrent sempre les 50 posicions independentment de si hi ha objectes o no. Poc òptim
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
    	//Tingues en compte que si no fessis aquesta validació no et serviria fer el foreach, estàs recorrent sempre les 50 posicions independentment de si hi ha objectes o no. Poc òptim
        for (Treballador treballador : llistaTreballadors) {
            if (treballador instanceof Encarregat) {
                nivell += contarNivellsEncarregats((Encarregat) treballador);
            }
        }

        return nivell;
    }

    private int contarNivellsEncarregats(Encarregat encarregat) {
        int nivells = 0;
    	//Tingues en compte que si no fessis aquesta validació no et serviria fer el foreach, estàs recorrent sempre les 50 posicions independentment de si hi ha objectes o no. Poc òptim
        for (Treballador subencarregat : encarregat.getLlistaTreballadors()) {
            if (subencarregat instanceof Encarregat) {   
            	//Estas sobrescrivint a 0 quan tornes a cridar la pròpia funció. Està bé cridar-la cíclicament però t'hauries de guardar la resposta en una altra variable, i en cas de que sigui superior al valor que ja tens, sumar-la.
            	
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

        result.append("Llista treballadors de [ ")
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
