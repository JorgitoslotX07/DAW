package m03.objects;

import java.util.ArrayList;

public class Gestor implements InterfaceGestor {
    // @Override
    public boolean transferirTreballador(Negoci n1, Negoci n2, String dni) {
        Treballador treballador = null;

        for (Treballador t : n1.getLlistaTreballadors()) {
            if (t != null && t.getDni().equals(dni)) {
                treballador = t;
                break;
            }
        }

        if (treballador == null) {
            System.out.println("Error: No s'ha trobat el treballador amb DNI " + dni + " en el negoci d'origen.");
            return false;
        }

        boolean transferenciaExitosa = n2.afegirTreballadorReturn(treballador);

        if (transferenciaExitosa) {
            if (treballador instanceof EncarregatOld) {
                ((EncarregatOld) treballador).setLlistaTreballadors(new ArrayList<>());
            }

            n1.borrarTreballador(treballador);
            return true;
        } else {
            System.out.println("Error: No s'ha pogut transferir el treballador amb DNI " + dni + ".");
            return false;
        }
    }

    public boolean transferirTreballadorEncarregat(Negoci n1, EncarregatOld n2, String dni) {
        Treballador treballador = null;

        for (Treballador t : n1.getLlistaTreballadors()) {
            if (t != null && t.getDni().equals(dni)) {
                treballador = t;
                break;
            }
        }

        if (treballador == null) {
            System.out.println("Error: No s'ha trobat el treballador amb DNI " + dni + " en el negoci d'origen.");
            return false;
        }

        boolean transferenciaExitosa = n2.afegirTreballador(treballador);

        if (transferenciaExitosa) {
            if (treballador instanceof EncarregatOld) {
                ((EncarregatOld) treballador).setLlistaTreballadors(new ArrayList<>());
            }

            n1.borrarTreballador(treballador);
            return true;
        } else {
            System.out.println("Error: No s'ha pogut transferir el treballador amb DNI " + dni + ".");
            return false;
        }
    }

    public String obtenirTipus(Negoci negoci) {
        if (negoci instanceof Fabrica) {
            return "Fabrica";
        } else if (negoci instanceof EmpresaAdministrativa) {
            return "EmpresaAdministrativa";
        } else {
            return "OID (Objeto Idenficado Desconocido)";
        }
    }
}
