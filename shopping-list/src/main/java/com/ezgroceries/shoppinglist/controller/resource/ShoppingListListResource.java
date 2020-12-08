package com.ezgroceries.shoppinglist.controller.resource;

import java.util.UUID;

public class ShoppingListListResource {

    private UUID shoppingListId;
    private String name;

    public ShoppingListListResource(){};

    public ShoppingListListResource(UUID shoppingListId, String name) {
        this.shoppingListId = shoppingListId;
        this.name = name;
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

}
