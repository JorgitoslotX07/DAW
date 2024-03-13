package m03.objects;

import java.util.ArrayList;
import java.util.List;

public abstract class Negoci {
    private static int contadorNegocis = 0;
    private String identificador;
    private List<Treballador> llistaTreballadors;
    private int contadorEmpleats;

    public Negoci(String identificador) {
        this.identificador = identificador;
        this.llistaTreballadors = new ArrayList<>();
        this.contadorEmpleats = 0;
        contadorNegocis++;
    }

    public Negoci(String identificador, List<Treballador> llistaTreballadors) {
        this.identificador = identificador;
        this.llistaTreballadors = llistaTreballadors;
        this.contadorEmpleats = llistaTreballadors.size();
        contadorNegocis++;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public List<Treballador> getLlistaTreballadors() {
        return llistaTreballadors;
    }

    public void setLlistaTreballadors(List<Treballador> llistaTreballadors) {
        this.llistaTreballadors = llistaTreballadors;
        this.contadorEmpleats = llistaTreballadors.size();
    }

    public int getContadorEmpleats() {
        return contadorEmpleats;
    }

    public static int getContadorNegocis() {
        return contadorNegocis;
    }

    public double calcularSalariMitja() {
        if (contadorEmpleats == 0) {
            return 0.0;
        }

        double sumaSalari = 0.0;

        for (Treballador treballador : llistaTreballadors) {
            if (treballador != null) {
                sumaSalari += treballador.getSalari();
            }
        }

        return sumaSalari / contadorEmpleats;
    }

    public abstract void afegirTreballador(Treballador treballador);

    public boolean afegirTreballadorReturn(Treballador treballador) {
        List<String> dnis = obtenerDnis();

        if (!dnis.contains(treballador.getDni())) {
            llistaTreballadors.add(treballador);
            contadorEmpleats++;
            return true;
        }
        return false;
    }

    public void borrarTreballador(Treballador treballador) {
        if (llistaTreballadors.contains(treballador)) {
            llistaTreballadors.remove(treballador);
            if (contadorEmpleats > 0) {
                contadorEmpleats--;
            }
        }
    }

    public List<String> obtenerDnis() {
        List<String> dnis = new ArrayList<>();
        for (Treballador existent : llistaTreballadors) {
            if (existent != null) {
                dnis.add(existent.getDni());
            }
        }
        return dnis;
    }
}
