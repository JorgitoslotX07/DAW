package daw.m3.uf6.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import daw.m3.uf6.objects.Category;

@Repository
public interface CategoryRespositoryJPA extends JpaRepository<Category, Integer> {
    boolean existsByName(String name);
}