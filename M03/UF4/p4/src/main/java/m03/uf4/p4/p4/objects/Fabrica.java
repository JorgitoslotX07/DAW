package m03.uf4.p4.p4.objects;

import java.util.List;

public class Fabrica extends Negoci {
    public Fabrica(String identificador) {
        super(identificador);
    }

    //Aquesst mètode realment està sobreescrivint el de Negoci però no ho fa correctament per què no actualitza el numTreballadors i per tant, no sap quants n'hi ha realment.
    //@Override
    public void afegirTreballador(Treballador treballador) {
        List<String> dnis = super.obtenerDnis();
        Treballador[] llistaTreballadors = getLlistaTreballadors();

        if (!dnis.contains(treballador.getDni())) {
            boolean uno = true;
            for (int i = 0; i < llistaTreballadors.length; i++) {
                if (llistaTreballadors[i] == null && uno) {
                    llistaTreballadors[i] = treballador;
                    uno = false;
                }
            }
        }
        setLlistaTreballadors(llistaTreballadors);

        treballador.afegirComplement(Complement.MIG);
        treballador.afegirComplement(Complement.ALT);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Fabrica [ ")
                .append("Identificador: ").append(getIdentificador()).append(" | ")
                .append("Contador de Empleados: ").append(getContadorEmpleats()).append(" | ")
                .append("Salario Promedio: ").append(calcularSalariMitja()).append("€ ]\n");
        if (getLlistaTreballadors().length > 0) {
            result.append(toStringTreballadors());
        }
        
        return result.toString();
    }

    private String toStringTreballadors() {
        StringBuilder result = new StringBuilder();

        result.append("Lista de Trabajadores:\n");

        for (int i = 0; i < getLlistaTreballadors().length; i++) {
            Treballador treballador = getLlistaTreballadors()[i];
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
