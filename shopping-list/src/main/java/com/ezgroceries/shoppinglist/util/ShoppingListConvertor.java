package com.ezgroceries.shoppinglist.util;

import com.ezgroceries.shoppinglist.entity.CocktailEntity;
import com.ezgroceries.shoppinglist.entity.ShoppingListEntity;
import com.ezgroceries.shoppinglist.resource.ShoppingListResource;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ShoppingListConvertor {

    public static ShoppingListEntity convertToEntity(ShoppingListResource shoppingListResource) {
        ShoppingListEntity shoppingListEntity = new ShoppingListEntity();
        if (shoppingListResource.getShoppingListId() == null) {
            shoppingListEntity.setShoppingListId(UUID.randomUUID());
        } {
            shoppingListEntity.setShoppingListId(shoppingListResource.getShoppingListId());
        }
        shoppingListEntity.setName(shoppingListResource.getName());
        CocktailEntity cocktailEntity = new CocktailEntity();
        return shoppingListEntity;
    }

    public static ShoppingListResource convertToResource(ShoppingListEntity shoppingListEntity) {
        ShoppingListResource shoppingListResource = new ShoppingListResource();
        shoppingListResource.setShoppingListId(shoppingListEntity.getShoppingListId());
        shoppingListResource.setName(shoppingListEntity.getName());
        if (!CollectionUtils.isEmpty(shoppingListEntity.getCocktailEntitySet())){
            Set<String> ingredients = new HashSet<>();
            for(CocktailEntity ce: shoppingListEntity.getCocktailEntitySet())
                ingredients.addAll(ce.getIngredients());
            shoppingListResource.setIngredients(ingredients);
        }
        return shoppingListResource;
    }
}
