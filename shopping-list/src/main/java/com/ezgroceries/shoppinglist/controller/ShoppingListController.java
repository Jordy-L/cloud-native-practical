package com.ezgroceries.shoppinglist.controller;

import com.ezgroceries.shoppinglist.entity.CocktailId;
import com.ezgroceries.shoppinglist.resource.ShoppingListResource;
import com.ezgroceries.shoppinglist.service.ShoppingListService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping(value = "/shopping-lists", produces = "application/json")
public class ShoppingListController {

    public final ShoppingListService shoppingListService;

    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201
    public ShoppingListResource createShoppingList(@RequestBody ShoppingListResource shoppingListResource) {
        return shoppingListService.create(shoppingListResource);
    }

    @PostMapping(value = "/{shoppingListId}/cocktails")
    //@ResponseStatus(HttpStatus.CREATED) // 201
    public Set<CocktailId> addCocktails(@PathVariable UUID shoppingListId, @RequestBody Set<CocktailId> cocktailIds){
        shoppingListService.addCocktailsToShoppingList(shoppingListId, cocktailIds);
        return shoppingListService.getShoppingListCocktailIds(shoppingListId);
    }

    @GetMapping(value = "/{shoppingListId}")
    public ShoppingListResource getShoppingList(@PathVariable UUID shoppingListId){
        return shoppingListService.findShoppingListById(shoppingListId);
    }

    @GetMapping
    public List<ShoppingListResource> getAllShoppingList(){
        return shoppingListService.findAllShoppingList();
    }


    /*private List<ShoppingListResource> getDummyResources() {
        return Arrays.asList(
            new ShoppingListResource(
                UUID.fromString("4ba92a46-1d1b-4e52-8e38-13cd56c7224c"), "Stephanie's birthday",
                Arrays.asList("Tequila", "Triple sec", "Lime juice", "Salt", "Blue Curacao")),
            new ShoppingListResource(
                UUID.fromString("6c7d09c2-8a25-4d54-a979-25ae779d2465"), "My Birthday",
                Arrays.asList("Tequila", "Triple sec", "Lime juice", "Salt", "Blue Curacao")));
    }*/
}