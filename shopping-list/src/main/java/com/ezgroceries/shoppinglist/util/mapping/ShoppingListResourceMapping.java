package com.ezgroceries.shoppinglist.util.mapping;

import com.ezgroceries.cocktail.persistence.entity.CocktailEntity;
import com.ezgroceries.shoppinglist.controller.resource.ShoppingListResource;
import com.ezgroceries.shoppinglist.persistence.entity.ShoppingListEntity;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ShoppingListResourceMapping {

    public static ShoppingListResource fromEntity(ShoppingListEntity shoppingListEntity) {
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

    public static ShoppingListEntity toEntity(ShoppingListResource shoppingListResource) {
        ShoppingListEntity shoppingListEntity = new ShoppingListEntity();
        if (shoppingListResource.getShoppingListId() == null) {
            shoppingListEntity.setShoppingListId(UUID.randomUUID());
        } {
            shoppingListEntity.setShoppingListId(shoppingListResource.getShoppingListId());
        }
        shoppingListEntity.setName(shoppingListResource.getName());
        return shoppingListEntity;
    }
}
