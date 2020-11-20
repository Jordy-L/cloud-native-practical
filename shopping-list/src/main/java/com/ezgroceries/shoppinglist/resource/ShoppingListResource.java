package com.ezgroceries.shoppinglist.resource;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Set;
import java.util.UUID;

public class ShoppingListResource {

    private UUID shoppingListId;
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<String> ingredients;

    public ShoppingListResource(){};

    public ShoppingListResource(UUID shoppingListId, String name, Set<String> ingredients) {
        this.shoppingListId = shoppingListId;
        this.name = name;
        this.ingredients = ingredients;
    }

    public ShoppingListResource(ShoppingListResource shoppingListResource){
        this.setShoppingListId(UUID.randomUUID());
        this.setName(shoppingListResource.getName());
        //this.ingredients = new ArrayList<String>();
    }

    public UUID getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(UUID shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<String> ingredients) {
        this.ingredients = ingredients;
    }

}
