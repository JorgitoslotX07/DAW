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

	@Autowired
    private ActorRepositoryJPA actorRepositoryJPA;

	//@Autowired
	//RepositoriJDBCImpl jdbcRepo;
	
	public List<Actor> getAllActors(){
		return actorRepositoryJPA.findAll();
	}
	
	public Actor createActor(Actor a) {
		logger.info("Mètode createActors No implementat");
		
        Timestamp currentTime = Timestamp.from(Instant.now());
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
            existingActor.setLastUpdate(LocalDateTime.now()); 

            Actor updatedActor = actorRepositoryJPA.save(existingActor);
            logger.info("¡Actor actualizado correctamente!");
            return updatedActor;
        } else {
            logger.info("No se encontró ningún actor con el ID proporcionado.");
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
            return null;
        }
    }
}
