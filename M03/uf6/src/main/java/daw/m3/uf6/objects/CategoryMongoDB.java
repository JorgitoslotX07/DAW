package daw.m3.uf6.objects;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(collection = "category")
public class CategoryMongoDB {

    @Id
    private String id;
    private String name;
    private LocalDateTime lastUpdate;

    // Constructor
    public CategoryMongoDB(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.lastUpdate = LocalDateTime.now();
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}