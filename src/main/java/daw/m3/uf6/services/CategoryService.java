package daw.m3.uf6.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
import daw.m3.uf6.objects.http.RequestCategory;
import daw.m3.uf6.objects.http.ResponseCategory;
import daw.m3.uf6.repositories.CategoryMongoRepo;
import daw.m3.uf6.repositories.CategoryRespositoryJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;



@Service
public class CategoryService {

	private static final Logger logger = LogManager.getLogger(CategoryService.class);

	private static final String URL = "jdbc:mysql://localhost:3306/m03";
    private static final String USER = "tjorda";
    private static final String PASSWORD = "tjorda";

	@Autowired
    private CategoryRespositoryJPA categoryRepositoryJPA;

    @Autowired
    private CategoryMongoRepo categoryMongoRepo;

    public ResponseCategory newCategory(String tipusBD, RequestCategory requestCategory) {
    if (tipusBD.equals("jdbc")) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Check if category already exists
            String checkSql = "SELECT COUNT(*) FROM category WHERE name = ?";
            pstmt = conn.prepareStatement(checkSql);
            pstmt.setString(1, requestCategory.getName());
            rs = pstmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                // Category already exists
                logger.error("Category already exists.");
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category already exists.");
            }

            // Insert new category
            String insertSql = "INSERT INTO category (name, last_update) VALUES (?, ?)";
            pstmt = conn.prepareStatement(insertSql);
            Timestamp currentTime = Timestamp.from(Instant.now());
            pstmt.setString(1, requestCategory.getName());
            pstmt.setTimestamp(2, currentTime);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                logger.info("New Category inserted successfully!");
            } else {
                logger.error("Error inserting the Category.");
            }

            // Create response
            ResponseCategory responseCategory = new ResponseCategory();
            responseCategory.setName(requestCategory.getName());
            responseCategory.setLastUpdate(currentTime.toLocalDateTime());
            return responseCategory;

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

    } else if (tipusBD.equals("jpa")) {
        // Check if category already exists
        if (categoryRepositoryJPA.existsByName(requestCategory.getName())) {
            logger.error("Category already exists.");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category already exists.");
        }

        // Insert new category
        Category category = new Category();
        LocalDateTime currentTime = LocalDateTime.now();
        category.setName(requestCategory.getName());
        category.setLastUpdate(currentTime);
        category = categoryRepositoryJPA.save(category);

        // Create response
        ResponseCategory responseCategory = new ResponseCategory();
        responseCategory.setName(category.getName());
        responseCategory.setLastUpdate(category.getLastUpdate());
        return responseCategory;

    } else if (tipusBD.equals("mongo")) {
        // Check if category already exists
        if (categoryMongoRepo.existsByName(requestCategory.getName())) {
            logger.error("Category already exists.");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category already exists.");
        }

        // Insert new category
        CategoryMongoDB categoryMongoDB = new CategoryMongoDB(requestCategory.getName());
        categoryMongoDB = categoryMongoRepo.save(categoryMongoDB);

        // Create response
        ResponseCategory responseCategory = new ResponseCategory();
        responseCategory.setId(categoryMongoDB.getId());
        responseCategory.setName(categoryMongoDB.getName());
        responseCategory.setLastUpdate(categoryMongoDB.getLastUpdate());
        return responseCategory;
    }

    return null;
}
}
