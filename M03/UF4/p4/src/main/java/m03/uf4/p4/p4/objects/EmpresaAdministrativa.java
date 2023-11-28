package m03.uf4.p4.p4.objects;

public class EmpresaAdministrativa extends Negoci {
    public EmpresaAdministrativa(String identificador) {
        super(identificador);
    }

    public void afegirTreballador(Treballador treballador) {
        super.getLlistaTreballadors()[super.getContadorEmpleats()] = treballador;
        treballador.afegirComplement(Complement.BAIX);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Empresa Administrativa [ ")
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
