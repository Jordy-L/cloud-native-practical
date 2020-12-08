package com.ezgroceries.shoppinglist.service;

import com.ezgroceries.cocktail.controller.resource.CocktailIdentifierResource;
import com.ezgroceries.cocktail.persistence.entity.CocktailEntity;
import com.ezgroceries.cocktail.persistence.repository.CocktailRepository;
import com.ezgroceries.cocktail.util.mapping.CocktailIdentifierResourceMapping;
import com.ezgroceries.shoppinglist.controller.resource.ShoppingListListResource;
import com.ezgroceries.shoppinglist.controller.resource.ShoppingListResource;
import com.ezgroceries.shoppinglist.persistence.entity.ShoppingListEntity;
import com.ezgroceries.shoppinglist.persistence.repository.ShoppingListRepository;
import com.ezgroceries.shoppinglist.util.mapping.ShoppingListListResourceMapping;
import com.ezgroceries.shoppinglist.util.mapping.ShoppingListResourceMapping;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;
    private final CocktailRepository cocktailRepository;

    public ShoppingListService(ShoppingListRepository shoppingListRepository, CocktailRepository cocktailRepository) {
        this.shoppingListRepository = shoppingListRepository;
        this.cocktailRepository = cocktailRepository;
    }

    public ShoppingListListResource create(ShoppingListListResource shoppingListListResource) {
        ShoppingListEntity shoppingListEntity = ShoppingListListResourceMapping.toEntity(shoppingListListResource);
        shoppingListEntity = shoppingListRepository.save(shoppingListEntity);
        return  ShoppingListListResourceMapping.fromEntity(shoppingListEntity);
    }

    public ShoppingListResource findShoppingListById(UUID id) {
        ShoppingListEntity shoppingListEntity = shoppingListRepository.findById(id).get();
        return ShoppingListResourceMapping.fromEntity(shoppingListEntity);
    }

    public List<ShoppingListResource> findAllShoppingList() {
        List<ShoppingListResource> shoppingListResourceList = new ArrayList<>();
        Iterator<ShoppingListEntity> it = shoppingListRepository.findAll().iterator();
        while(it.hasNext())
            shoppingListResourceList.add(ShoppingListResourceMapping.fromEntity(it.next()));
        return shoppingListResourceList;
    }

    public void addCocktailsToShoppingList(UUID shoppingListId, Set<CocktailIdentifierResource> cocktailIds) {
        ShoppingListEntity shoppingListEntity = shoppingListRepository.findById(shoppingListId).get();
        for(CocktailIdentifierResource cocktailId : cocktailIds) {
            shoppingListEntity.getCocktailEntitySet().add(cocktailRepository.findById(cocktailId.getCocktailId()).get());
        }
        shoppingListRepository.save(shoppingListEntity);
    }

    public Set<CocktailIdentifierResource> getShoppingListCocktailIds(UUID shoppingListId) {
        Set<CocktailIdentifierResource> cocktailIdentifierResourceSet = new HashSet<>();
        for (CocktailEntity cocktailEntity : shoppingListRepository.findById(shoppingListId).get().getCocktailEntitySet()){
            cocktailIdentifierResourceSet.add(CocktailIdentifierResourceMapping.fromEntity(cocktailEntity));
        }
        return cocktailIdentifierResourceSet;
    }
}