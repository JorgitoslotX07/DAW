package m03.uf4.p4.p4.objects;

import java.time.LocalDate;
import java.time.Period;

public class Treballador {

    private String nom;
    private String cognoms;
    private String dni;
    private LocalDate dataNaixement;
    private LocalDate dataIniciContracte;
    private double salariBase;

    //El constructors sense paràmetres no cal que defineixis res, per defecte fa el que has posat
    public Treballador() {
        // this(
        //     null, 
        //     null, 
        //     null, 
        //     null, 
        //     null, 
        //     0
        // );
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

        return  Period.between(dn, fecha).getYears();
        //Per calcular l'edat era més fàcil utilitzar Period.between(Data 1, Data2).getYears(). Pero
        // int edat = fecha.getYear() - dn.getYear();

        // if (fecha.getMonthValue() < dn.getMonthValue()  || 
        //     (fecha.getMonthValue() == dn.getMonthValue() &&
        //     fecha.getDayOfMonth() < dn.getDayOfMonth())) {
            
        //         edat --;
        // } 

        // return edat;
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
        StringBuilder result = new StringBuilder();
        result.append("Treballador [ ")
            .append(getCognoms())
            .append(", ")
            .append(getNom())
            .append(" | ")
            .append(getDni())
            .append(" | ")
            .append(getDataNaixement())
            .append(" | ")
            .append(getEdat())
            .append(" | ")
            .append(getSalariBase())
            .append("€ ]\n");
            
        return result.toString();
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
