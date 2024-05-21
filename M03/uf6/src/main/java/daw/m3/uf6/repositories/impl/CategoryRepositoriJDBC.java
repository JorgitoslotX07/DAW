package daw.m3.uf6.repositories.impl;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import daw.m3.uf6.objects.http.RequestCategory;
import daw.m3.uf6.objects.http.ResponseCategory;

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
public class CategoryRepositoriJDBC {
    private static final Logger logger = LogManager.getLogger(CategoryRepositoriJDBC.class);

    //private static final String URL = "jdbc:mysql://localhost:3306/m03";
    //private static final String USER = "tjorda";
    //private static final String PASSWORD = "tjorda";

    @Autowired
    private DataSource dataSource;

    public ResponseCategory newCategoryJDBC( RequestCategory requestCategory) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();


            String checkSql = "SELECT COUNT(*) FROM category WHERE name = ?";
            pstmt = conn.prepareStatement(checkSql);
            pstmt.setString(1, requestCategory.getName());
            rs = pstmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                logger.error("Category already exists.");
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category already exists.");
            }
            
            String insertSql = "INSERT INTO category (name, last_update) VALUES (?, ?)";
            pstmt = conn.prepareStatement(insertSql, PreparedStatement.RETURN_GENERATED_KEYS);
            Timestamp currentTime = Timestamp.from(Instant.now());
            pstmt.setString(1, requestCategory.getName());
            pstmt.setTimestamp(2, currentTime);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                logger.info("New Category inserted successfully!");

                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    long generatedId = generatedKeys.getLong(1);

                    ResponseCategory responseCategory = new ResponseCategory();
                    responseCategory.setId(Long.toString(generatedId));
                    responseCategory.setName(requestCategory.getName());
                    responseCategory.setLastUpdate(currentTime.toLocalDateTime());
                    return responseCategory;
                } else {
                    logger.error("No ID obtained for the new Category.");
                    throw new SQLException("No ID obtained for the new Category.");
                }
            } else {
                logger.error("Error inserting the Category.");
                throw new SQLException("Error inserting the Category.");
            }

        } catch (SQLException e) {
            logger.error("Error creating a new Category in the database.", e);
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
