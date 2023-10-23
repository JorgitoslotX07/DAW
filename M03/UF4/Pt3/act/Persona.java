package UF4.Pt3.act;

public class Persona {
    private String nom;
    private Data dataNaci;
    private NIF nif;

    public Persona(String nom, Data dataNaci, NIF nif) {
        this.nom = nom;
        this.dataNaci = dataNaci;
        this.nif = nif;
    }
    
    public void mostrarInfo() {
        System.out.println("Nom: " + nom);
        System.out.println("Data nacimiento: " + dataNaci.toString());
        System.out.println("NIF: " + nif.getNIF());
    }
}
