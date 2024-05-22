package daw.m3.uf6.repositories.impl;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import daw.m3.uf6.objects.http.RequestCountry;
import daw.m3.uf6.objects.http.RequestUpdateCountry;
import daw.m3.uf6.objects.http.ResponseCountry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import org.apache.logging.log4j.LogManager;

@Repository
public class CountryRepoJDBC {
    private static final Logger logger = LogManager.getLogger(CountryRepoJDBC.class);

    @Autowired
    private DataSource dataSource;

    public ResponseCountry newCountryJDBC( RequestCountry requestCountry) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();


            String checkSql = "SELECT COUNT(*) FROM country WHERE country = ?";
            pstmt = conn.prepareStatement(checkSql);
            pstmt.setString(1, requestCountry.getNomPais());
            rs = pstmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                logger.error("Country already exists.");
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Country already exists.");
            }
            
            String insertSql = "INSERT INTO country (country, last_update) VALUES (?, ?)";
            pstmt = conn.prepareStatement(insertSql, PreparedStatement.RETURN_GENERATED_KEYS);
            Timestamp currentTime = Timestamp.from(Instant.now());
            pstmt.setString(1, requestCountry.getNomPais());
            pstmt.setTimestamp(2, currentTime);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                logger.info("New Country inserted successfully!");

                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    long generatedId = generatedKeys.getLong(1);

                    ResponseCountry responseCountry = new ResponseCountry();
                    responseCountry.setIdPais(Long.toString(generatedId));
                    responseCountry.setNomPais(requestCountry.getNomPais());
                    responseCountry.setLastUpdate(currentTime.toLocalDateTime());
                    return responseCountry;
                } else {
                    logger.error("No ID obtained for the new Country.");
                    throw new SQLException("No ID obtained for the new Country.");
                }
            } else {
                logger.error("Error inserting the Country.");
                throw new SQLException("Error inserting the Country.");
            }

        } catch (SQLException e) {
            logger.error("Error creating a new Country in the database.", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Database error.");
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ResponseCountry updateCountryJDBC(RequestUpdateCountry requestCountry) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
    
        try {
            conn = dataSource.getConnection();
    
            // Verificar si el país existe por su id
            String checkSql = "SELECT COUNT(*) FROM country WHERE country_id = ?";
            pstmt = conn.prepareStatement(checkSql);
            pstmt.setLong(1, Long.parseLong(requestCountry.getIdPais()));
            rs = pstmt.executeQuery();
            if (rs.next() && rs.getInt(1) == 0) {
                logger.error("Country does not exist.");
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Country does not exist.");
            }
    
            // Actualizar el país
            String updateSql = "UPDATE country SET country = ?, last_update = ? WHERE country_id = ?";
            pstmt = conn.prepareStatement(updateSql);
            Timestamp currentTime = Timestamp.from(Instant.now());
            pstmt.setString(1, requestCountry.getNomPais());
            pstmt.setTimestamp(2, currentTime);
            pstmt.setLong(3, Long.parseLong(requestCountry.getIdPais()));
            int rowsAffected = pstmt.executeUpdate();
    
            if (rowsAffected > 0) {
                logger.info("Country updated successfully!");
    
                ResponseCountry responseCountry = new ResponseCountry();
                responseCountry.setIdPais(requestCountry.getIdPais());
                responseCountry.setNomPais(requestCountry.getNomPais());
                responseCountry.setLastUpdate(currentTime.toLocalDateTime());
                return responseCountry;
            } else {
                logger.error("Error updating the Country.");
                throw new SQLException("Error updating the Country.");
            }
    
        } catch (SQLException e) {
            logger.error("Error updating the Country in the database.", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Database error.");
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
