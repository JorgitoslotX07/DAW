package m03.uf4.p4.objects;

import java.time.LocalDate;

public class Treballador {

    private String nom;
    private String cognoms;
    private String dni;
    private LocalDate dataNaixement;
    private LocalDate dataIniciContracte;
    private double salariBase;

    public Treballador() {
        this(
            null, 
            null, 
            null, 
            null, 
            null, 
            0
        );

        // this.nom = null;
        // this.cognoms = null;
        // this.dni = null;
        // this.dataNaixement = null;
        // this.dataIniciContracte = null;
        // this.salariBase = 0;
    }

    public Treballador(String nom, String cognoms, String dni, 
        LocalDate dataNaixement, LocalDate dataIniciContracte, double salariBase) {

        setNom(nom);
        setCognoms(cognoms);
        setDni(dni);
        setDataNaixement(dataNaixement);
        setDataIniciContracte(dataIniciContracte);
        setSalariBase(salariBase);
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getDataNaixement() {
        return dataNaixement;
    }

    public void setDataNaixement(LocalDate dataNaixement) {
        this.dataNaixement = dataNaixement;
    }

    public LocalDate getDataIniciContracte() {
        return dataIniciContracte;
    }

    public void setDataIniciContracte(LocalDate dataIniciContracte) {
        this.dataIniciContracte = dataIniciContracte;
    }

    public double getSalariBase() {
        return salariBase;
    }

    public void setSalariBase(double salariBase) {

        if (salariBase < 1000) {
            this.salariBase = 1000;
        } else {
            this.salariBase = salariBase;
        }
    }

    public int getEdat() {
        LocalDate dn = this.dataNaixement;
        LocalDate fecha = LocalDate.now();

        int edat = fecha.getYear() - dn.getYear();

        if (fecha.getMonthValue() < dn.getMonthValue()  || 
            (fecha.getMonthValue() == dn.getMonthValue() &&
            fecha.getDayOfMonth() < dn.getDayOfMonth())) {
            
                edat --;
        } 

        return edat;
    }
    public double getSalari() {
        int edad = getEdat();

        if (edad > 16 && edad < 40) {
            return getSalariBase();
        } else if (edad >= 40 && edad < 55) {
            return getSalariBase() + 1000;
        } else if (edad >= 55) {
            return getSalariBase() + 2000;
        }
        
        return 0; 
    }

    @Override
    public String toString() {
       return "Nom: " + this.getNom() + 
        "\nCognoms: " + this.getCognoms() +
        "\nDNI: " + this.getDni() +
        "\nData de Naixement" + this.getDataNaixement() +
        "\nData de Inici de Contracte: " + this.getDataIniciContracte() +
        "\nSalari Base: " + this.getSalariBase();
    }

    public void afegirComplement(Complement complement) {
        switch (complement) {
            case BAIX:
                this.salariBase += 100;
                break;
            case MIG:
                this.salariBase += 500;
                break;
            case ALT:
                this.salariBase += 1000;
                break;
            default:
                break;
        }
    }
    
}
