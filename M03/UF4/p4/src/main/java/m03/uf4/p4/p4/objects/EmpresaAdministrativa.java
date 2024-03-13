package m03.uf4.p4.p4.objects;

import java.util.List;

public class EmpresaAdministrativa extends Negoci {
    public EmpresaAdministrativa(String identificador) {
        super(identificador);
    }

    //@Override
    public void afegirTreballador(Treballador treballador) {
        List<String> dnis = super.obtenerDnis();
        List<Treballador> llistaTreballadors = getLlistaTreballadors();

        if (!dnis.contains(treballador.getDni())) {
            llistaTreballadors.add(treballador);
            treballador.afegirComplement(Complement.BAIX);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Empresa Administrativa [ ")
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
