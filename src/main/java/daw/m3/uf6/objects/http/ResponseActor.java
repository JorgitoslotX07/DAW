package daw.m3.uf6.objects.http;

import java.time.LocalDateTime;

public class ResponseActor {
    private String idActor;
    private String firstName;
    private String secondName;
    private LocalDateTime lastUpdate;

    // Constructor
    public ResponseActor() {
    }

    // Getters y setters
    public String getIdActor() {
        return idActor;
    }

    public void setIdActor(String idActor) {
        this.idActor = idActor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    // Método toString para imprimir la información del objeto
    @Override
    public String toString() {
        return "ResponseActor{" +
                "idActor='" + idActor + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
