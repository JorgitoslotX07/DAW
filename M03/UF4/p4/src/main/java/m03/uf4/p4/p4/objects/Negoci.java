package m03.uf4.p4.p4.objects;


import java.util.ArrayList;
import java.util.List;

public abstract class Negoci {
    private static int contadorNegocis = 0;
    private String identificador;
    private Treballador[] llistaTreballadors;
    private int contadorEmpleats;

    public Negoci(String identificador) {
        this.identificador = identificador;
        this.llistaTreballadors = new Treballador[50]; 
        this.contadorEmpleats = 0; 
        contadorNegocis++;
    }

    public Negoci(String identificador, Treballador[] llistaTreballadors) {
        this.identificador = identificador;
        this.llistaTreballadors = llistaTreballadors; 
        //Ves en compte, llistaTreballadors.length sempre et retornarà la longitud de l'array independentment de si els objectes que hi ha estan instanciats o no.
        this.contadorEmpleats = lengthLlistaTreballadors(); 
        contadorNegocis++;
    }
 

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Treballador[] getLlistaTreballadors() {
        return llistaTreballadors;
    }

    public void setLlistaTreballadors(Treballador[] llistaTreballadors) {
        this.llistaTreballadors = llistaTreballadors;
        this.contadorEmpleats = lengthLlistaTreballadors(); // + 1
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

        for (int i = 0; i < contadorEmpleats; i++) {
            if (llistaTreballadors[i] != null) {
                sumaSalari += llistaTreballadors[i].getSalari();
            }
        }

        return sumaSalari / contadorEmpleats;
    }

    public abstract void afegirTreballador(Treballador treballador);
    //La idea es que aquest mètode s'ha de sobreescriure en les classes que heretin de Negoci i ho facin ells.
    // public void afegirTreballador(Treballador treballador) {
    //     List<String> dnis = obtenerDnis();
    //     if (!dnis.contains(treballador.getDni())) {
    //         for (int i = 0; i < llistaTreballadors.length; i++) {
    //             if (llistaTreballadors[i] == null) {
    //                 llistaTreballadors[i] = treballador;
    //                 contadorEmpleats++;
    //             }
    //         }
    //     }
    // }

    public boolean afegirTreballadorReturn(Treballador treballador) {
        List<String> dnis = obtenerDnis();

        if (!dnis.contains(treballador.getDni())) {
            for (int i = 0; i < llistaTreballadors.length; i++) {
                if (llistaTreballadors[i] == null) {
                    llistaTreballadors[i] = treballador;
                    contadorEmpleats++;
                    return true;
                }
            }
        }
        return false;
    }

    //El contador d'empleats t'està fallant (quan s'utilitza des de Fabrica i EmpresaAdministrativa (per que no l'actualitzen i per tant queda sempre a 0) i per aquest motiu et fallen algunes funcions
    public void borrarTreballador(Treballador treballador) {
        List<String> dnis = obtenerDnis();

        if (dnis.contains(treballador.getDni())) {
            for (int i = 0; i < llistaTreballadors.length; i++) {
                if (llistaTreballadors[i] == treballador) {
                    if (treballador instanceof Encarregat) {
                        ((Encarregat) treballador).setLlistaTreballadors(null);
                    }
                    
                    if (contadorEmpleats > 0) {
                        contadorEmpleats--;
                    }
                    llistaTreballadors[i] = null;
                }
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

    private int lengthLlistaTreballadors() {
        int can = 0;
        for (int i = 0; i < llistaTreballadors.length; i++) {
            if (llistaTreballadors[i] != null) {
                can++;
            }
        }

        return can;
    }
}
