package com.ezgroceries.cocktail.controller.resource;

import java.util.UUID;

public class CocktailListResource {

    private UUID cocktailId;
    private String name;

    public CocktailListResource(){};

    public CocktailListResource(UUID cocktailId, String name) {
        this.cocktailId = cocktailId;
        this.name = name;
    }

    public UUID getCocktailId() {
        return cocktailId;
    }

    public void setCocktailId(UUID cocktailId) {
        this.cocktailId = cocktailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
