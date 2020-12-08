package com.ezgroceries.shoppinglist.util.mapping;

import com.ezgroceries.shoppinglist.controller.resource.ShoppingListListResource;
import com.ezgroceries.shoppinglist.persistence.entity.ShoppingListEntity;

import java.util.UUID;

public class ShoppingListListResourceMapping {

    public static ShoppingListListResource fromEntity(ShoppingListEntity shoppingListEntity) {
        return new ShoppingListListResource(shoppingListEntity.getShoppingListId(), shoppingListEntity.getName());
    }

    public static ShoppingListEntity toEntity(ShoppingListListResource shoppingListResource) {
        ShoppingListEntity shoppingListEntity = new ShoppingListEntity();
        if (shoppingListResource.getShoppingListId() == null) {
            shoppingListEntity.setShoppingListId(UUID.randomUUID());
        } else {
            shoppingListEntity.setShoppingListId(shoppingListResource.getShoppingListId());
        }
        shoppingListEntity.setName(shoppingListResource.getName());
        return shoppingListEntity;
    }
}
