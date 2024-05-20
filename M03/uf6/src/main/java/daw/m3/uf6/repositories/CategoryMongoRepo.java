package daw.m3.uf6.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import daw.m3.uf6.objects.CategoryMongoDB;

public interface CategoryMongoRepo extends MongoRepository<CategoryMongoDB, Integer> {
    boolean existsByName(String name);
}


