package m03.objects;

import java.util.List;

import m03.utils.converters.Complement;

public class Fabrica extends Negoci {
    public Fabrica(String identificador) {
        super(identificador);
    }

    @Override
    public void afegirTreballador(Treballador treballador) {
        List<String> dnis = obtenerDnis();

        if (!dnis.contains(treballador.getDni())) {
            List<Treballador> llistaTreballadors = getLlistaTreballadors();

            boolean uno = true;
            for (int i = 0; i < llistaTreballadors.size(); i++) {
                if (llistaTreballadors.get(i) == null && uno) {
                    llistaTreballadors.set(i, treballador);
                    uno = false;
                }
            }

            treballador.afegirComplement(Complement.MIG);
            treballador.afegirComplement(Complement.ALT);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Fabrica [ ")
                .append("Identificador: ").append(getIdentificador()).append(" | ")
                .append("Contador de Empleados: ").append(getContadorEmpleats()).append(" | ")
                .append("Salario Promedio: ").append(calcularSalariMitja()).append("€ ]\n");
        if (!getLlistaTreballadors().isEmpty()) {
            result.append(toStringTreballadors());
        }

        return result.toString();
    }

    private String toStringTreballadors() {
        StringBuilder result = new StringBuilder();

        result.append("Lista de Trabajadores:\n");

        List<Treballador> llistaTreballadors = getLlistaTreballadors();
        for (int i = 0; i < llistaTreballadors.size(); i++) {
            Treballador treballador = llistaTreballadors.get(i);
            if (treballador != null) {
                result.append("\t")
                        .append(i)
                        .append(" - ");

                if (treballador instanceof EncarregatOld) {
                    result.append(((EncarregatOld) treballador).toString());

                } else {
                    result.append(treballador.toString())
                            .append("\n");
                }
            }
        }

        return result.toString();
    }
}
