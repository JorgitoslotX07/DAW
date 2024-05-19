package daw.m3.uf6.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.sql.PreparedStatement;

import daw.m3.uf6.objects.*;
import java.util.List;
import java.util.ArrayList;

import daw.m3.uf6.objects.Actor;
import daw.m3.uf6.repositories.ActorRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;


@Service
public class ActorService {

	private static final Logger logger = LogManager.getLogger(ActorService.class);

	private static final String URL = "jdbc:mysql://localhost:3306/m03";
    private static final String USER = "tjorda";
    private static final String PASSWORD = "tjorda";

	@Autowired
    private ActorRepositoryJPA actorRepositoryJPA;

	//@Autowired
	//RepositoriJDBCImpl jdbcRepo;
	
	public List<Actor> getAllActors(){

		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        ArrayList<Actor> actorList = new ArrayList<>();

        try {
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            
            stmt = conn.createStatement();
            
            
            String sql = "SELECT * FROM actor";
            rs = stmt.executeQuery(sql);
            
            
            while (rs.next()) {
                Actor act = new Actor();

                int id = rs.getInt("actor_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String lastUpdateStr = rs.getString("last_update");

                LocalDateTime lastUpdate = LocalDateTime.parse(lastUpdateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                act.setIdActor(id);
                act.setFirstName(firstName);
                act.setSecondName(lastName);
                act.setLastUpdate(lastUpdate);
                
                //System.out.println("ID: " + id + ", First Name: " + firstName + ", Last Name: " + lastName + ", Last Update: " + lastUpdateStr);

                actorList.add(act);
                
            }
        } catch (SQLException e) {
            logger.error("Error al obtener todos los actores desde la base de datos.", e);
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
		logger.info("Mètode getAllActors No implementat");
		//Cridar al jdcbRepo per obtenir usuaris i processar-ne la resposta
		//throw new UnsupportedOperationException("Mètode no implementat");

		//return actorList;S
		return actorRepositoryJPA.findAll();
	}
	
	public Actor createActor(Actor a) {
		logger.info("Mètode createActors No implementat");
		//Cridar al jdcbRepo per crear Actor
		//throw new UnsupportedOperationException("Mètode no implementat");

        Timestamp currentTime = Timestamp.from(Instant.now());
        Connection conn = null;
        PreparedStatement pstmt = null;

		try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
    
            // Declaración SQL actualizada para incluir last_update
            String sql = "INSERT INTO actor (first_name, last_update, last_name) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
    
            // Configuración de los valores en la declaración preparada
            pstmt.setString(1, a.getFirstName());
    
            // Usar la fecha y hora actual para last_update
            pstmt.setTimestamp(2, currentTime);
    
            pstmt.setString(3, a.getSecondName());
    
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                logger.info("¡Nuevo actor insertado correctamente!");
            } else {
                logger.error("Error al insertar el actor.");
            }
        } catch (SQLException e) {
            logger.error("Error al crear un nuevo actor en la base de datos.", e);
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
        LocalDateTime localDateTime = currentTime.toLocalDateTime();
        a.setLastUpdate(localDateTime);
    
        // Persistir usando el repositorio JPA
        return actorRepositoryJPA.save(a);
	}
	
    public Actor updateActorById(Long id, Actor a) {
        Optional<Actor> optionalActor = actorRepositoryJPA.findById(id.intValue());

        if (optionalActor.isPresent()) {
            Actor existingActor = optionalActor.get();
            existingActor.setFirstName(a.getFirstName());
            existingActor.setSecondName(a.getSecondName());
            existingActor.setLastUpdate(LocalDateTime.now()); // Asegúrate de actualizar el campo lastUpdate

            Actor updatedActor = actorRepositoryJPA.save(existingActor);
            System.out.println("¡Actor actualizado correctamente!");
            return updatedActor;
        } else {
            System.out.println("No se encontró ningún actor con el ID proporcionado.");
            return null;
        }
    }

	public Boolean deleteActorById(Long id) {
        if (actorRepositoryJPA.existsById(id.intValue())) {
            actorRepositoryJPA.deleteById(id.intValue());
            logger.info("Actor borrado correctamente.");
            return true;
        } else {
            logger.info("No se encontró ningún actor con el ID proporcionado.");
            return false;
        }
    }
	
	public Actor getActorById(Long id) {
        Optional<Actor> optionalActor = actorRepositoryJPA.findById(id.intValue());
        if (optionalActor.isPresent()) {
            return optionalActor.get();
        } else {
            logger.info("No se encontró ningún actor con el ID proporcionado.");
            return null; // O podrías lanzar una excepción personalizada
        }
    }
}
