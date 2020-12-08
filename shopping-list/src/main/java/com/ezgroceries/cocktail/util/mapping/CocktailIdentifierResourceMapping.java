package com.ezgroceries.cocktail.util.mapping;

import com.ezgroceries.cocktail.controller.resource.CocktailIdentifierResource;
import com.ezgroceries.cocktail.persistence.entity.CocktailEntity;

public class CocktailIdentifierResourceMapping {

    public static CocktailIdentifierResource fromEntity(CocktailEntity cocktailEntity) {
        return new CocktailIdentifierResource(cocktailEntity.getId());
    }

    public static CocktailEntity toEntity(CocktailIdentifierResource cocktailIdentifierResource) {
        CocktailEntity cocktailEntity = new CocktailEntity();
        cocktailEntity.setId(cocktailIdentifierResource.getCocktailId());
        return cocktailEntity;
    }
}
