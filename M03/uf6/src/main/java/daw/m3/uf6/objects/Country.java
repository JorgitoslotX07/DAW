package daw.m3.uf6.objects;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "country")
@Entity
public class Country {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Integer idPais;
    
    @Column(name = "country")
    private String nomPais;
    
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
	
	
	public Integer getIdPais() {
		return idPais;
	}
	public void setId(Integer idPais) {
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
