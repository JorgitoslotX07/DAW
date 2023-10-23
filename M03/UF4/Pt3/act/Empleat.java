package UF4.Pt3.act;

public class Empleat {
    private String nom;
    private int edad;
    private double sueldo;

    private static int nEmpleado = 0;

    public Empleat(String nom, int edad, double sueldo) {
        this.nom = nom;
        this.edad = edad;
        this.sueldo = sueldo;
        nEmpleado++;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdat() {
        return edad;
    }

    public void setEdat(int edad) {
        this.edad = edad;
    }

    public double getSou() {
        return sueldo;
    }

    public void setSou(double sueldo) {
        this.sueldo = sueldo;
    }

    public static int getNEmpleados() {
        return nEmpleado;
    }

    public void mostrarInformacio() {
        System.out.println("Nom: " + nom);
        System.out.println("edad: " + edad);
        System.out.println("sueldo: " + sueldo);
    } 
}
