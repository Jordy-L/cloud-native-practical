package com.ezgroceries.cocktail.service.external;

import com.ezgroceries.cocktail.persistence.entity.CocktailEntity;
import com.ezgroceries.cocktail.persistence.repository.CocktailRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
class CocktailDBClientFallback implements CocktailDBClient {

    private final CocktailRepository cocktailRepository;

    public CocktailDBClientFallback(CocktailRepository cocktailRepository) {
        this.cocktailRepository = cocktailRepository;
    }

    @Override
    public CocktailDBResponse searchCocktails(String search) {
        List<CocktailEntity> cocktailEntities = cocktailRepository.findByNameContainingIgnoreCase(search);

        CocktailDBResponse cocktailDBResponse = new CocktailDBResponse();
        cocktailDBResponse.setDrinks(cocktailEntities.stream().map(cocktailEntity -> {
            CocktailDBResponse.DrinkResource drinkResource = new CocktailDBResponse.DrinkResource();
            drinkResource.setIdDrink(cocktailEntity.getIdDrink());
            drinkResource.setStrDrink(cocktailEntity.getName());
            drinkResource.setStrDrinkThumb(cocktailEntity.getImageLink());
            drinkResource.setStrGlass(cocktailEntity.getGlass());
            drinkResource.setStrInstructions(cocktailEntity.getInstructions());
            drinkResource.setStrIngredients(cocktailEntity.getIngredients());
            return drinkResource;
        }).collect(Collectors.toList()));

        return cocktailDBResponse;
    }
}
