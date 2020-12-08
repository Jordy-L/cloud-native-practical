package com.ezgroceries.cocktail.persistence.repository;

import com.ezgroceries.cocktail.persistence.entity.CocktailEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface CocktailRepository extends CrudRepository<CocktailEntity, UUID> {

    public  List<CocktailEntity> findByIdDrinkIn(List<String> ids);

    public List<CocktailEntity> findByNameContainingIgnoreCase(String search);
}
