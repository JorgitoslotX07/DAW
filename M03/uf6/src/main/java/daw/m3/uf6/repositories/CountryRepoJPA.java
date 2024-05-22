package daw.m3.uf6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import daw.m3.uf6.objects.Country;

@Repository
public interface CountryRepoJPA extends JpaRepository<Country, Integer> {
    boolean existsByNomPais(String nomPais);
}
