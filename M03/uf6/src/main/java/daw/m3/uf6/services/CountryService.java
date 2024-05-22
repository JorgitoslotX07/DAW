package daw.m3.uf6.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Optional;

import daw.m3.uf6.objects.*;
import daw.m3.uf6.objects.http.RequestCountry;
import daw.m3.uf6.objects.http.RequestUpdateCountry;
import daw.m3.uf6.objects.http.ResponseCountry;
import daw.m3.uf6.repositories.CountryRepoMongo;
import daw.m3.uf6.repositories.CountryRepoJPA;
import daw.m3.uf6.repositories.impl.CountryRepoJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



@Service
public class CountryService {
	private static final Logger logger = LogManager.getLogger(CategoryService.class);

	@Autowired
    private CountryRepoJPA countryRepoJPA;

    @Autowired
    private CountryRepoJDBC countryRepoJDBC;

    @Autowired
    private CountryRepoMongo countryRepoMongo;

    public ResponseCountry newCountry(String tipusBD, RequestCountry requestCountry) {
        if (tipusBD.equals("jdbc")) {
            return countryRepoJDBC.newCountryJDBC(requestCountry);

        } else if (tipusBD.equals("jpa")) {
            if (countryRepoJPA.existsByNomPais(requestCountry.getNomPais())) {
                logger.error("Country already exists.");
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Country already exists.");
            }

            Country country = new Country();
            LocalDateTime currentTime = LocalDateTime.now();
            country.setNomPais(requestCountry.getNomPais());
            country.setLastUpdate(currentTime);
            country = countryRepoJPA.save(country);

        
            ResponseCountry responseCountry = new ResponseCountry();
            responseCountry.setIdPais(country.getIdPais().toString());
            responseCountry.setNomPais(country.getNomPais());
            responseCountry.setLastUpdate(country.getLastUpdate());
            return responseCountry;

        } else if (tipusBD.equals("mongo")) {
            if (countryRepoMongo.existsByNomPais(requestCountry.getNomPais())) {
                logger.error("Country already exists.");
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Country already exists.");
            }

        
            CountryMongoDB countryMongoDB = new CountryMongoDB(requestCountry.getNomPais());
            countryMongoDB = countryRepoMongo.save(countryMongoDB);

    
            ResponseCountry responseCountry = new ResponseCountry();
            responseCountry.setIdPais(countryMongoDB.getIdPais());
            responseCountry.setNomPais(countryMongoDB.getNomPais());
            responseCountry.setLastUpdate(countryMongoDB.getLastUpdate());
            return responseCountry;
        }

        return null;
    }
    public ResponseCountry updateCountry(String tipusBD, RequestUpdateCountry requestCountry) {
        if (tipusBD.equals("jdbc")) {
            return countryRepoJDBC.updateCountryJDBC(requestCountry);

        } else if (tipusBD.equals("jpa")) {
            Optional<Country> optionalCountry = countryRepoJPA.findById(Integer.parseInt(requestCountry.getIdPais()));

            if (optionalCountry.isPresent()) {
                Country existingActor = optionalCountry.get();
                existingActor.setNomPais(requestCountry.getNomPais());
                existingActor.setLastUpdate(LocalDateTime.now()); 

                Country updatedActor = countryRepoJPA.save(existingActor);
                logger.info("Country actualizado correctamente!");


                ResponseCountry responseCountry = new ResponseCountry();
                responseCountry.setIdPais(updatedActor.getIdPais().toString());
                responseCountry.setNomPais(updatedActor.getNomPais());
                responseCountry.setLastUpdate(updatedActor.getLastUpdate());
                return responseCountry;
            } else {
                logger.info("No se encontró ningún actor con el ID proporcionado.");
                return null;
            }

        } else if (tipusBD.equals("mongo")) {
            if (countryRepoMongo.existsByNomPais(requestCountry.getNomPais())) {
            
                CountryMongoDB existingCountry = countryRepoMongo.findByIdPais(requestCountry.getIdPais());
                if (existingCountry == null) {
                    logger.error("Country not found");
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Country not found");
                }

                // Actualizar los campos del país
                existingCountry.setNomPais(requestCountry.getNomPais());
                existingCountry.setLastUpdate(LocalDateTime.now());

                // Guardar los cambios
                countryRepoMongo.save(existingCountry);

                // Preparar la respuesta
                ResponseCountry responseCountry = new ResponseCountry();
                responseCountry.setIdPais(existingCountry.getIdPais());
                responseCountry.setNomPais(existingCountry.getNomPais());
                responseCountry.setLastUpdate(existingCountry.getLastUpdate());
                return responseCountry;
            }

            return null;
        }
        return null;
    }
}
