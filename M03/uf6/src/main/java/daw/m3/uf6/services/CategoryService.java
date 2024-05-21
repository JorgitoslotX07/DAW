package daw.m3.uf6.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

import daw.m3.uf6.objects.*;
import daw.m3.uf6.objects.http.RequestCategory;
import daw.m3.uf6.objects.http.ResponseCategory;
import daw.m3.uf6.repositories.CategoryMongoRepo;
import daw.m3.uf6.repositories.CategoryRespositoryJPA;
import daw.m3.uf6.repositories.impl.CategoryRepositoriJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;



@Service
public class CategoryService {
	private static final Logger logger = LogManager.getLogger(CategoryService.class);

	@Autowired
    private CategoryRespositoryJPA categoryRepositoryJPA;

    @Autowired
    private CategoryRepositoriJDBC categoryRepositoriJDBC;

    @Autowired
    private CategoryMongoRepo categoryMongoRepo;

    public ResponseCategory newCategory(String tipusBD, RequestCategory requestCategory) {
    if (tipusBD.equals("jdbc")) {
        return categoryRepositoriJDBC.newCategoryJDBC(requestCategory);

    } else if (tipusBD.equals("jpa")) {
        if (categoryRepositoryJPA.existsByName(requestCategory.getName())) {
            logger.error("Category already exists.");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category already exists.");
        }

        Category category = new Category();
        LocalDateTime currentTime = LocalDateTime.now();
        category.setName(requestCategory.getName());
        category.setLastUpdate(currentTime);
        category = categoryRepositoryJPA.save(category);

      
        ResponseCategory responseCategory = new ResponseCategory();
        responseCategory.setId(category.getId().toString());
        responseCategory.setName(category.getName());
        responseCategory.setLastUpdate(category.getLastUpdate());
        return responseCategory;

    } else if (tipusBD.equals("mongo")) {
        if (categoryMongoRepo.existsByName(requestCategory.getName())) {
            logger.error("Category already exists.");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category already exists.");
        }

    
        CategoryMongoDB categoryMongoDB = new CategoryMongoDB(requestCategory.getName());
        categoryMongoDB = categoryMongoRepo.save(categoryMongoDB);

 
        ResponseCategory responseCategory = new ResponseCategory();
        responseCategory.setId(categoryMongoDB.getId());
        responseCategory.setName(categoryMongoDB.getName());
        responseCategory.setLastUpdate(categoryMongoDB.getLastUpdate());
        return responseCategory;
    }

    return null;
}
}
