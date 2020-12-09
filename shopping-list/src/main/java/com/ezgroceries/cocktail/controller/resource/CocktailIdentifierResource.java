package com.ezgroceries.cocktail.controller.resource;

import java.util.UUID;

public class CocktailIdentifierResource {

    private UUID cocktailId;

    public CocktailIdentifierResource(){};


    public CocktailIdentifierResource(UUID cocktailId) {
        this.cocktailId = cocktailId;
    }

    public UUID getCocktailId() {
        return cocktailId;
    }

    public void setCocktailId(UUID cocktailId) {
        this.cocktailId = cocktailId;
    }

}
