package daw.m3.uf6.repositories.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.sql.PreparedStatement;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import daw.m3.uf6.objects.*;
import java.util.List;
import java.util.ArrayList;

public class RepositoriJDBCImpl {
    private static final Logger logger = LogManager.getLogger(RepositoriJDBCImpl.class);

    private static final String URL = "jdbc:mysql://localhost:3306/m03";
    private static final String USER = "tjorda";
    private static final String PASSWORD = "tjorda";

    Scanner scanner = new Scanner(System.in);

    
    public List<Actor> getAllActors() {
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
        return actorList;
    }
    
    public void createActor() {
        //Scanner scanner = new Scanner(System.in);
    
        
        System.out.println("Introduce el nombre del actor:");
        String firstName = scanner.nextLine();
    
        System.out.println("Introduce el apellido del actor:");
        String lastName = scanner.nextLine();
    
        Connection conn = null;
        PreparedStatement pstmt = null;
    
        try {
           
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
    
            String sql = "INSERT INTO actor (first_name, last_name) VALUES (?, ?)";
            pstmt = conn.prepareStatement(sql);
    
            
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
    
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
    }

    public void getActorById() {
        //Scanner scanner = new Scanner(System.in);
    
        
        System.out.println("Introduce el ID del actor:");
        int actorId = scanner.nextInt();
        scanner.nextLine(); 
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
           
            String sql = "SELECT * FROM actor WHERE actor_id = ?";
            pstmt = conn.prepareStatement(sql);
            
            
            pstmt.setInt(1, actorId);
        
            
            rs = pstmt.executeQuery();
            
            
            while (rs.next()) {
                Actor actor = new Actor();
    
                int id = rs.getInt("actor_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String lastUpdateStr = rs.getString("last_update");
    
                LocalDateTime lastUpdate = LocalDateTime.parse(lastUpdateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    
                actor.setIdActor(id);
                actor.setFirstName(firstName);
                actor.setSecondName(lastName);
                actor.setLastUpdate(lastUpdate);
                
                System.out.println("ID: " + id + ", First Name: " + firstName + ", Last Name: " + lastName + ", Last Update: " + lastUpdateStr);
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
        
    }
   
    public void getActorByName() {
        //Scanner scanner = new Scanner(System.in);
    
        
        System.out.println("Introduce el nombre del actor:");
        String actorName = scanner.nextLine();
    
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
           
            String sql = "SELECT * FROM actor WHERE first_name = ?";
            
            
            pstmt = conn.prepareStatement(sql);
            
           
            pstmt.setString(1, actorName);
            
            
            rs = pstmt.executeQuery();
            
            
            while (rs.next()) {
                Actor actor = new Actor();
    
                int id = rs.getInt("actor_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String lastUpdateStr = rs.getString("last_update");
    
                LocalDateTime lastUpdate = LocalDateTime.parse(lastUpdateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    
                actor.setIdActor(id);
                actor.setFirstName(firstName);
                actor.setSecondName(lastName);
                actor.setLastUpdate(lastUpdate);
                
                System.out.println("ID: " + id + ", First Name: " + firstName + ", Last Name: " + lastName + ", Last Update: " + lastUpdateStr);
            }
        } catch (SQLException e) {
            logger.error("Error al obtener un actor por nombre desde la base de datos.", e);
            e.printStackTrace();
        } finally {
            
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //scanner.close();
        }
    }
    
    public void getFilmsByActorId() {
        //Scanner scanner = new Scanner(System.in);
    
        
        System.out.println("Introduce el ID del actor:");
        int actorId = scanner.nextInt();
        scanner.nextLine();
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
           
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
           
            String sql = "SELECT f.* FROM actor a " +
                     "JOIN film_actor fa ON a.actor_id = fa.actor_id " +
                     "JOIN film f ON fa.film_id = f.film_id " +
                     "WHERE a.actor_id = ?";
            pstmt = conn.prepareStatement(sql);
            
            
            pstmt.setInt(1, actorId);
        
            
            rs = pstmt.executeQuery();
            
           
            while (rs.next()) {
                int id = rs.getInt("film_id");
                String title = rs.getString("title");
                String description = rs.getString("description");

                System.out.println("ID: " + id + ", Title: " + title + ", Description: " + description);
            }
        } catch (SQLException e) {
            logger.error("Error al obtener películas por ID de actor desde la base de datos.", e);
            e.printStackTrace();
        } finally {
            
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //scanner.close();
        }
    }

    public void updateActorById() {
        //Scanner scanner = new Scanner(System.in);
    
        
        System.out.println("Introduce el ID del actor que deseas actualizar:");
        int actorId = scanner.nextInt();
        scanner.nextLine(); 
    
        Connection conn = null;
        PreparedStatement pstmtSelect = null;
        PreparedStatement pstmtUpdate = null;
        ResultSet rs = null;
    
        try {
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String selectSql = "SELECT first_name FROM actor WHERE actor_id = ?";
            pstmtSelect = conn.prepareStatement(selectSql);
            pstmtSelect.setInt(1, actorId);
    
            
            rs = pstmtSelect.executeQuery();
    
            if (rs.next()) {
                
                String currentFirstName = rs.getString("first_name");
                System.out.println("Nombre actual del actor: " + currentFirstName);
    
                System.out.println("Introduce el nuevo nombre del actor:");
                String newFirstName = scanner.nextLine();
    
                System.out.println("Introduce el nuevo apellido del actor:");
                String newLastName = scanner.nextLine();
    
                
                String updateSql = "UPDATE actor SET first_name = ?, last_name = ? WHERE actor_id = ?";
                pstmtUpdate = conn.prepareStatement(updateSql);
                pstmtUpdate.setString(1, newFirstName);
                pstmtUpdate.setString(2, newLastName);
                pstmtUpdate.setInt(3, actorId);
    
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
            //scanner.close();
        }
    }
    
    public void deleteActorById() {
        // Scanner scanner = new Scanner(System.in);
    
        
        System.out.println("Introduce el ID del actor que deseas borrar:");
        int actorId = scanner.nextInt();
        scanner.nextLine(); 
    
        Connection conn = null;
        PreparedStatement pstmt = null;
    
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
    
            
            String sql = "DELETE FROM actor WHERE actor_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, actorId);
    
            
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("¡Actor borrado correctamente!");
            } else {
                System.out.println("No se encontró ningún actor con el ID proporcionado.");
            }
        } catch (SQLException e) {
            logger.error("Error al borrar un actor por ID en la base de datos.", e);
            e.printStackTrace();
        } finally {
            
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // scanner.close();
        }
    }

    

    public static void main(String[] args) {
        RepositoriJDBCImpl actorManager = new RepositoriJDBCImpl();

        actorManager.getAllActors();

        actorManager.createActor();

        actorManager.getActorById();

        actorManager.getActorByName();

        actorManager.getFilmsByActorId();

        actorManager.updateActorById();

        actorManager.deleteActorById();

        actorManager.scanner.close();
    }
}
