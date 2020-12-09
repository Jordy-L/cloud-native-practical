package com.ezgroceries.cocktail.util.mapping;

import com.ezgroceries.cocktail.controller.resource.CocktailResource;
import com.ezgroceries.cocktail.persistence.entity.CocktailEntity;

public class CocktailResourceMapping {

    public final CocktailResource fromEntity(CocktailEntity cocktailEntity) {
        return new CocktailResource(
            cocktailEntity.getId(),
            cocktailEntity.getName(),
            cocktailEntity.getGlass(),
            cocktailEntity.getInstructions(),
            cocktailEntity.getImageLink(),
            cocktailEntity.getIngredients()
        );
    }

    public final CocktailEntity toEntity(CocktailResource cocktailResource) {
        CocktailEntity cocktailEntity = new CocktailEntity();
        cocktailEntity.setId(cocktailResource.getCocktailId());
        cocktailEntity.setName(cocktailResource.getName());
        cocktailEntity.setGlass(cocktailResource.getGlass());
        cocktailEntity.setInstructions(cocktailResource.getInstructions());
        cocktailEntity.setImageLink(cocktailResource.getImage());
        cocktailEntity.setIngredients(cocktailResource.getIngredients());
        return cocktailEntity;
    }
}
