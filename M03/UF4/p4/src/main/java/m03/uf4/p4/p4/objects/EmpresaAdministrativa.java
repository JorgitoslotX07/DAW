package m03.uf4.p4.p4.objects;

public class EmpresaAdministrativa extends Negoci {
    public EmpresaAdministrativa(String identificador) {
        super(identificador);
    }

    public void afegirTreballador(Treballador treballador) {
        super.getLlistaTreballadors()[super.getContadorEmpleats()] = treballador;
        treballador.afegirComplement(Complement.BAIX);
    }
}
