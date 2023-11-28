package m03.uf4.p4.p4.objects;

public class Fabrica extends Negoci {
    public Fabrica(String identificador) {
        super(identificador);
    }

    public void afegirTreballador(Treballador treballador) {
        super.getLlistaTreballadors()[super.getContadorEmpleats()] = treballador;
        treballador.afegirComplement(Complement.MIG);
        treballador.afegirComplement(Complement.ALT);
    }
}
