package com.ezgroceries.shoppinglist.service;

import com.ezgroceries.shoppinglist.entity.CocktailId;
import com.ezgroceries.shoppinglist.entity.ShoppingListEntity;
import com.ezgroceries.shoppinglist.repository.CocktailRepository;
import com.ezgroceries.shoppinglist.repository.ShoppingListRepository;
import com.ezgroceries.shoppinglist.resource.ShoppingListResource;
import com.ezgroceries.shoppinglist.util.ShoppingListConvertor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public ShoppingListResource create(ShoppingListResource shoppingListResource) {
        ShoppingListEntity shoppingListEntity = ShoppingListConvertor.convertToEntity(shoppingListResource);
        shoppingListEntity.setShoppingListId(UUID.randomUUID());
        shoppingListEntity = shoppingListRepository.save(shoppingListEntity);
        return  ShoppingListConvertor.convertToResource(shoppingListEntity);
    }

    public ShoppingListResource findShoppingListById(UUID id) {
        ShoppingListEntity shoppingListEntity = shoppingListRepository.findById(id).get();
        return ShoppingListConvertor.convertToResource(shoppingListEntity);
    }

    public List<ShoppingListResource> findAllShoppingList() {
        List<ShoppingListResource> shoppingListResourceList = new ArrayList<>();
        Iterator<ShoppingListEntity> it = shoppingListRepository.findAll().iterator();
        while(it.hasNext())
            shoppingListResourceList.add(ShoppingListConvertor.convertToResource(it.next()));
        return shoppingListResourceList;
    }

    public void addCocktailsToShoppingList(UUID shoppingListId, Set<CocktailId> cocktailIds) {
        ShoppingListEntity shoppingListEntity = shoppingListRepository.findById(shoppingListId).get();
        for(CocktailId cocktailId : cocktailIds) {
            shoppingListEntity.getCocktailEntitySet().add(cocktailRepository.findById(cocktailId.getCocktailId()).get());
        }
        shoppingListRepository.save(shoppingListEntity);
    }

    public Set<CocktailId> getShoppingListCocktailIds(UUID shoppingListId) {
        return shoppingListRepository.findById(shoppingListId).get().getCocktailIds();
    }
}