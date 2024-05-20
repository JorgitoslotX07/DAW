package daw.m3.uf6.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import daw.m3.uf6.objects.ActorMongoDB;

public interface ActorMongoRepo extends MongoRepository<ActorMongoDB, Integer> {

}
