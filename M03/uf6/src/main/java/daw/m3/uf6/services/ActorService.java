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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.sql.PreparedStatement;

import daw.m3.uf6.objects.*;
import java.util.List;
import java.util.ArrayList;

import daw.m3.uf6.objects.Actor;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ActorService {

	private static final Logger logger = LogManager.getLogger(ActorService.class);

	private static final String URL = "jdbc:mysql://localhost:3306/m03";
    private static final String USER = "tjorda";
    private static final String PASSWORD = "tjorda";

	//@Autowired
    //private ActorRepositoryJPA actorRepositoryJPA;

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

		return actorList;
		//return actorRepositoryJPA.findAll();
	}
	
	public Actor createActor(Actor a) {
		logger.info("Mètode createActors No implementat");
		//Cridar al jdcbRepo per crear Actor
		//throw new UnsupportedOperationException("Mètode no implementat");

		Connection conn = null;
        PreparedStatement pstmt = null;
    
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
    
            String sql = "INSERT INTO actor (first_name, last_name) VALUES (?, ?)";
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, a.getFirstName());
            pstmt.setString(2, a.getSecondName());
    
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("¡Nuevo actor insertado correctamente!");
            } else {
                System.out.println("Error al insertar el actor.");
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
            //scanner.close();
        }

		return a;
		//return actorRepositoryJPA.save(a);
	}
	
	public Actor updateActorById(Long id, Actor a) {
        //Scanner scanner = new Scanner(System.in);
    
        
        System.out.println("Introduce el ID del actor que deseas actualizar:");
    
        Connection conn = null;
        PreparedStatement pstmtSelect = null;
        PreparedStatement pstmtUpdate = null;
        ResultSet rs = null;

        try {
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String selectSql = "SELECT first_name FROM actor WHERE actor_id = ?";
            pstmtSelect = conn.prepareStatement(selectSql);
            pstmtSelect.setLong(1, id);
    
            
            rs = pstmtSelect.executeQuery();
    
            if (rs.next()) {
    
                String updateSql = "UPDATE actor SET first_name = ?, last_name = ? WHERE actor_id = ?";
                pstmtUpdate = conn.prepareStatement(updateSql);
                pstmtUpdate.setString(1, a.getFirstName());
                pstmtUpdate.setString(2, a.getSecondName());
                pstmtUpdate.setLong(3, id);
    
                int rowsAffected = pstmtUpdate.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("¡Actor actualizado correctamente!");
                } else {
                    System.out.println("No se pudo actualizar el actor.");
                }
            } else {
                System.out.println("No se encontró ningún actor con el ID proporcionado.");
            }
        } catch (SQLException e) {
            logger.error("Error al actualizar un actor por ID en la base de datos.", e);
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmtSelect != null) pstmtSelect.close();
                if (pstmtUpdate != null) pstmtUpdate.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

		return a;
    }

	public Boolean deleteActorById(Long id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Boolean deleted = false;
	
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			String sql = "DELETE FROM actor WHERE actor_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
	
			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected > 0) {
				logger.info("Actor borrado correctamente.");
				deleted = true;
			} else {
				logger.info("No se encontró ningún actor con el ID proporcionado.");
			}
		} catch (SQLException e) {
			logger.error("Error al borrar un actor por ID en la base de datos.", e);
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				logger.error("Error al cerrar la conexión.", e);
			}
		}
		return deleted;
	}
	
	public Actor getActorById(Long id) {
        //Scanner scanner = new Scanner(System.in);
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

		Actor actor = new Actor();
        
        try {
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
           
            String sql = "SELECT * FROM actor WHERE actor_id = ?";
            pstmt = conn.prepareStatement(sql);
            
            
            pstmt.setLong(1, id);
        
            
            rs = pstmt.executeQuery();
            
            
            while (rs.next()) {
                
    
                int ids = rs.getInt("actor_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String lastUpdateStr = rs.getString("last_update");
    
                LocalDateTime lastUpdate = LocalDateTime.parse(lastUpdateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    
                actor.setIdActor(ids);
                actor.setFirstName(firstName);
                actor.setSecondName(lastName);
                actor.setLastUpdate(lastUpdate);
                
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Error al obtener un actor por ID desde la base de datos.", e);        } finally {
            
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //scanner.close();
        }

		return actor;
        
    }
}
