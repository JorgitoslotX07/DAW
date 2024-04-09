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

import daw.m3.uf6.objects.*;

public class RepositoriJDBCImpl {
    // Paràmetres de connexió a la base de dades
    private static final String URL = "jdbc:mysql://localhost:3306/m03";
    private static final String USER = "tjorda";
    private static final String PASSWORD = "tjorda";

    // Mètode per obtenir tots els actors de la taula i imprimir-los
    public void getAllActors() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Connexió a la base de dades
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            // Creació de l'objecte Statement per a executar la consulta SQL
            stmt = conn.createStatement();
            
            // Execució de la consulta SQL
            String sql = "SELECT * FROM actor";
            rs = stmt.executeQuery(sql);
            
            // Recorregut del conjunt de resultats i impressió de la informació d'actors
            
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
                
                System.out.println("ID: " + id + ", First Name: " + firstName + ", Last Name: " + lastName + ", Last Update: " + lastUpdateStr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Tanquem els recursos
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void createActor() {
        Scanner scanner = new Scanner(System.in);
    
        // Solicitar al usuario que introduzca el nombre y apellido del actor
        System.out.println("Introduce el nombre del actor:");
        String firstName = scanner.nextLine();
    
        System.out.println("Introduce el apellido del actor:");
        String lastName = scanner.nextLine();
    
        Connection conn = null;
        PreparedStatement pstmt = null;
    
        try {
            // Conexión a la base de datos
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
    
            // Consulta SQL para insertar un nuevo actor
            String sql = "INSERT INTO actor (first_name, last_name) VALUES (?, ?)";
            pstmt = conn.prepareStatement(sql);
    
            // Establecer los parámetros de la consulta con los valores proporcionados por el usuario
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
    
            // Ejecutar la consulta
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("¡Nuevo actor insertado correctamente!");
            } else {
                System.out.println("Error al insertar el actor.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            scanner.close();
        }
    }

    public void getActorById() {
        Scanner scanner = new Scanner(System.in);
    
        // Solicitar al usuario que introduzca el ID del actor
        System.out.println("Introduce el ID del actor:");
        int actorId = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            // Conexión a la base de datos
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            // Crear objeto PreparedStatement para ejecutar la consulta SQL
            String sql = "SELECT * FROM actor WHERE actor_id = ?";
            pstmt = conn.prepareStatement(sql);
            
            // Establecer el valor del parámetro
            pstmt.setInt(1, actorId);
        
            // Ejecutar la consulta preparada
            rs = pstmt.executeQuery();
            
            // Recorrer los resultados y mostrar la información de los actores
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
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            scanner.close();
        }
    }
   
    public void getActorByName() {
        Scanner scanner = new Scanner(System.in);
    
        // Solicitar al usuario que introduzca el nombre del actor
        System.out.println("Introduce el nombre del actor:");
        String actorName = scanner.nextLine();
    
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            // Conexión a la base de datos
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            // Consulta SQL con un parámetro
            String sql = "SELECT * FROM actor WHERE first_name = ?";
            
            // Preparar la consulta SQL
            pstmt = conn.prepareStatement(sql);
            
            // Establecer el valor del parámetro
            pstmt.setString(1, actorName);
            
            // Ejecutar la consulta
            rs = pstmt.executeQuery();
            
            // Recorrer los resultados y mostrar la información de los actores
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
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            scanner.close();
        }
    }
    
    public void getFilmsByActorId() {
        Scanner scanner = new Scanner(System.in);
    
        // Solicitar al usuario que introduzca el ID del actor
        System.out.println("Introduce el ID del actor:");
        int actorId = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            // Conexión a la base de datos
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            // Crear objeto PreparedStatement para ejecutar la consulta SQL
            String sql = "SELECT f.* FROM actor a " +
                     "JOIN film_actor fa ON a.actor_id = fa.actor_id " +
                     "JOIN film f ON fa.film_id = f.film_id " +
                     "WHERE a.actor_id = ?";
            pstmt = conn.prepareStatement(sql);
            
            // Establecer el valor del parámetro
            pstmt.setInt(1, actorId);
        
            // Ejecutar la consulta preparada
            rs = pstmt.executeQuery();
            
            // Recorrer los resultados y mostrar la información de los actores
            while (rs.next()) {
                int id = rs.getInt("film_id");
                String title = rs.getString("title");
                String description = rs.getString("description");

                System.out.println("ID: " + id + ", Title: " + title + ", Description: " + description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            scanner.close();
        }
    }

    public void updateActorById() {
        Scanner scanner = new Scanner(System.in);
    
        // Solicitar al usuario que introduzca el ID del actor
        System.out.println("Introduce el ID del actor que deseas actualizar:");
        int actorId = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente
    
        Connection conn = null;
        PreparedStatement pstmtSelect = null;
        PreparedStatement pstmtUpdate = null;
        ResultSet rs = null;
    
        try {
            // Conexión a la base de datos
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
    
            // Consulta SQL para recuperar el actor por ID
            String selectSql = "SELECT first_name FROM actor WHERE actor_id = ?";
            pstmtSelect = conn.prepareStatement(selectSql);
            pstmtSelect.setInt(1, actorId);
    
            // Ejecutar la consulta para recuperar el nombre del actor
            rs = pstmtSelect.executeQuery();
    
            if (rs.next()) {
                // Si se encuentra el actor, obtener su nombre y solicitar los nuevos datos
                String currentFirstName = rs.getString("first_name");
                System.out.println("Nombre actual del actor: " + currentFirstName);
    
                System.out.println("Introduce el nuevo nombre del actor:");
                String newFirstName = scanner.nextLine();
    
                System.out.println("Introduce el nuevo apellido del actor:");
                String newLastName = scanner.nextLine();
    
                // Consulta SQL para actualizar el registro del actor
                String updateSql = "UPDATE actor SET first_name = ?, last_name = ? WHERE actor_id = ?";
                pstmtUpdate = conn.prepareStatement(updateSql);
                pstmtUpdate.setString(1, newFirstName);
                pstmtUpdate.setString(2, newLastName);
                pstmtUpdate.setInt(3, actorId);
    
                // Ejecutar la consulta de actualización
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
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (pstmtSelect != null) pstmtSelect.close();
                if (pstmtUpdate != null) pstmtUpdate.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            scanner.close();
        }
    }
    
    public void deleteActorById() {
        Scanner scanner = new Scanner(System.in);
    
        // Solicitar al usuario que introduzca el ID del actor que desea borrar
        System.out.println("Introduce el ID del actor que deseas borrar:");
        int actorId = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente
    
        Connection conn = null;
        PreparedStatement pstmt = null;
    
        try {
            // Conexión a la base de datos
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
    
            // Consulta SQL para borrar el actor por ID
            String sql = "DELETE FROM actor WHERE actor_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, actorId);
    
            // Ejecutar la consulta para borrar el actor
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("¡Actor borrado correctamente!");
            } else {
                System.out.println("No se encontró ningún actor con el ID proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            scanner.close();
        }
    }

    

    public static void main(String[] args) {
        RepositoriJDBCImpl actorManager = new RepositoriJDBCImpl();
        actorManager.getAllActors();

        // actorManager.createActor();

        // actorManager.getActorById();

        // actorManager.getActorByName();

        // actorManager.getFilmsByActorId();

        // actorManager.updateActorById();

        // actorManager.deleteActorById();
        
    }


}
