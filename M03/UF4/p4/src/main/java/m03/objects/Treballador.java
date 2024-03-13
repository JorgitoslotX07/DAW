package m03.objects;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

import m03.utils.converters.Complement;

public class Treballador {

    private String id;
    private String nom;
    private String cognoms;
    private String dni;
    private LocalDate dataNaixement;
    private double salariBase;

    public Treballador() {
        setId(generateNewId());
    }

    public Treballador(String nom, String cognoms, String dni,
            LocalDate dataNaixement, double salariBase) {
        setId(generateNewId());
        setNom(nom);
        setCognoms(cognoms);
        setDni(dni);
        setDataNaixement(dataNaixement);
        setSalariBase(salariBase);
    }

    public void Persona(String dni, LocalDate dataNaixement) {
        setDni(dni);
        setDataNaixement(dataNaixement);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String generateNewId() {
        String newId = UUID.randomUUID().toString();
        return newId;
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

        return Period.between(dn, fecha).getYears();
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
