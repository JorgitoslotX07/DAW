package daw.m3.uf6.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import daw.m3.uf6.objects.Country;
import daw.m3.uf6.objects.CountryMongoDB;

public interface CountryRepoMongo extends MongoRepository<CountryMongoDB, Integer> {
    boolean existsByNomPais(String nomPais);
    CountryMongoDB findByIdPais(String idPais);
}


