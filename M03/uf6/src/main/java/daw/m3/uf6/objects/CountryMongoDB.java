package daw.m3.uf6.objects;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "country")
public class CountryMongoDB {

    @Id
    private String idPais;
    private String nomPais;
    private LocalDateTime lastUpdate;

    public CountryMongoDB(String nomPais) {
        this.idPais = UUID.randomUUID().toString();
        this.nomPais = nomPais;
        this.lastUpdate = LocalDateTime.now();
    }

    public String getIdPais() {
        return idPais;
    }

    public void setIdPais(String idPais) {
        this.idPais = idPais;
    }

    public String getNomPais() {
        return nomPais;
    }

    public void setNomPais(String nomPais) {
        this.nomPais = nomPais;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
