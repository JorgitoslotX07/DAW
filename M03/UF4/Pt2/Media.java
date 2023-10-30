package UF4.Pt2;

public class Media {
    private String nom;
    private String autor;
    private Integer duradaSegons;

    public Media(String n, String a, Integer d) {
        this.setNom(n);
        this.setAutor(a);
        this.setDurada(d);
    }

    public static final void main(String[] args) {

        Media m = new Media("Pendejada 4000", "Toni Jorda Leon", 120);

       
        System.out.println("\n" + m.getNom() + " " + m.getAutor() + " " + m.getDurada());

        System.out.println("\n-----------------------------------\n");
        
        System.out.println(m.toString());

    }

    public String getNom() {
        return this.nom;
    }

    public String getAutor() {
        return this.autor;
    }

    public Integer getDurada() {
        return this.duradaSegons;
    }


    public void setNom(String n) {
        this.nom = n;
    }

    public void setAutor(String a) {
        this.autor = a;
    }

    public void setDurada(Integer d) {
        this.duradaSegons = d;
    }

    @Override
    public String toString() {
        return "Nom: " + this.getNom() + 
            "\nAutor: " + this.getAutor() + 
            "\nDurada: " + this.getDurada()
        ;
    }

}
