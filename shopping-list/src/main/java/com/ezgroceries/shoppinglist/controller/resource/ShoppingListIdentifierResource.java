package com.ezgroceries.shoppinglist.controller.resource;

import java.util.UUID;

public class ShoppingListIdentifierResource {

    private UUID shoppingListId;

    public ShoppingListIdentifierResource(){};

    public ShoppingListIdentifierResource(UUID shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public UUID getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(UUID shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

}
