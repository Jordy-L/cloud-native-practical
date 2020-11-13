package com.ezgroceries.shoppinglist.persistence;

import com.ezgroceries.shoppinglist.entity.CocktailDBResponse;
import com.ezgroceries.shoppinglist.entity.CocktailResource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CocktailResourceService {

    private final CocktailDBClient cocktailDBClient;

    public CocktailResourceService(CocktailDBClient cocktailDBClient) {
        this.cocktailDBClient = cocktailDBClient;
    }

    public List<CocktailResource> searchCocktails(String name){
        CocktailDBResponse cocktailDBResponse = cocktailDBClient.searchCocktails(name);
        List<CocktailResource> cocktailResources = new ArrayList<>();
        for(CocktailDBResponse.DrinkResource dr : cocktailDBResponse.getDrinks()) {
            cocktailResources.add(new CocktailResource(UUID.randomUUID(), dr.getStrDrink(), dr.getStrGlass(), dr.getStrInstructions(), dr.getStrDrinkThumb(), dr.getStrIngredients()));
        }
        return cocktailResources;
    }


}
