package daw.m3.uf6.repositories;

import org.springframework.stereotype.Repository;

import daw.m3.uf6.objects.http.RequestCountry;
import daw.m3.uf6.objects.http.ResponseCountry;

@Repository
public interface CountryRespository {

	ResponseCountry createActor(String tipusBD, RequestCountry requestCategory);
}
