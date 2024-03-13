package m03.objects.daos;

import java.time.LocalDate;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "treballador")
@XmlAccessorType(XmlAccessType.FIELD)
public class TreballadorDAO {
    @XmlAttribute(name = "idTreballador")
    private String idTreballador;

    @XmlAttribute(name = "indEncarregat")
    private boolean indEncarregat;

    @XmlElement(name = "nom")
    private String nom;

    @XmlElement(name = "cognoms")
    private String cognoms;

    @XmlElement(name = "dni")
    private String dni;

    @XmlElement(name = "dataNaixement")
    private String dataNaixement;

    @XmlElement(name = "salari")
    private double salariBase;

    @XmlElement(name = "souExtra")
    private double souExtra;

    @XmlElement(name = "llistaTreballadors")
    private List<TreballadorDAO> llistaTreballadors;

    public List<TreballadorDAO> getLlistaTreballadors() {
        return llistaTreballadors;
    }

    public void setLlistaTreballadors(List<TreballadorDAO> llistaTreballadors) {
        this.llistaTreballadors = llistaTreballadors;
    }

    public double getSouExtra() {
        return souExtra;
    }

    public void setSouExtra(double souExtra) {
        this.souExtra = souExtra;
    }

    public String getIdTreballador() {
        return idTreballador;
    }

    public void setIdTreballador(String idTreballador) {
        this.idTreballador = idTreballador;
    }

    public boolean getIndEncarregat() {
        return indEncarregat;
    }

    public void setIndEncarregat(boolean indEncarregat) {
        this.indEncarregat = indEncarregat;
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

    public String getDataNaixement() {
        return dataNaixement;
    }

    public void setDataNaixement(String dataNaixement) {
        this.dataNaixement = dataNaixement;
    }

    public double getSalariBase() {
        return salariBase;
    }

    public void setSalariBase(double salariBase) {
        this.salariBase = salariBase;
    }
}
