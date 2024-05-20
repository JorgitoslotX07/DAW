package daw.m3.uf6.repositories;

import org.springframework.stereotype.Repository;

import daw.m3.uf6.objects.Category;
import daw.m3.uf6.objects.http.RequestCategory;
import daw.m3.uf6.objects.http.ResponseCategory;

@Repository
public interface CategoryRespository {

	ResponseCategory createActor(String tipusBD, RequestCategory requestCategory);
}
