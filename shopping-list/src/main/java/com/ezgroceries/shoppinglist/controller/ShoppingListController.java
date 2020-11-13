package com.ezgroceries.shoppinglist.controller;

import com.ezgroceries.shoppinglist.entity.CocktailId;
import com.ezgroceries.shoppinglist.entity.ShoppingList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/shopping-lists", produces = "application/json")
public class ShoppingListController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201
    public ShoppingList createShoppingList(@RequestBody ShoppingList shoppingList) {
        return new ShoppingList(shoppingList);
    }

    @PostMapping(value = "/{shoppingListId}/cocktails")
    //@ResponseStatus(HttpStatus.CREATED) // 201
    public List<CocktailId> addCocktails(@PathVariable UUID shoppingListId, @RequestBody List<CocktailId> CocktailIds){
        return CocktailIds;
    }

    @GetMapping(value = "/{shoppingListId}")
    public ShoppingList getShoppingList(@PathVariable UUID shoppingListId){
        return getDummyResources().get(0);
    }

    @GetMapping
    public List<ShoppingList> getAllShoppingList(){
        return getDummyResources();
    }


    private List<ShoppingList> getDummyResources() {
        return Arrays.asList(
            new ShoppingList(
                UUID.fromString("4ba92a46-1d1b-4e52-8e38-13cd56c7224c"), "Stephanie's birthday",
                Arrays.asList("Tequila", "Triple sec", "Lime juice", "Salt", "Blue Curacao")),
            new ShoppingList(
                UUID.fromString("6c7d09c2-8a25-4d54-a979-25ae779d2465"), "My Birthday",
                Arrays.asList("Tequila", "Triple sec", "Lime juice", "Salt", "Blue Curacao")));
    }
}