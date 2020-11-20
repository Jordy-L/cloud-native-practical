package com.ezgroceries.shoppinglist.service;

import com.ezgroceries.shoppinglist.entity.ShoppingListEntity;
import com.ezgroceries.shoppinglist.repository.ShoppingListRepository;
import com.ezgroceries.shoppinglist.resource.ShoppingListResource;
import com.ezgroceries.shoppinglist.util.ShoppingListConvertor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;

    public ShoppingListService(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

    public ShoppingListResource create(ShoppingListResource shoppingListResource) {
        ShoppingListEntity shoppingListEntity = ShoppingListConvertor.convertToEntity(shoppingListResource);
        shoppingListEntity = shoppingListRepository.save(shoppingListEntity);
        return  ShoppingListConvertor.convertToResource(shoppingListEntity);
    }

    public ShoppingListResource findShoppingListById(UUID id) {
        ShoppingListEntity shoppingListEntity = shoppingListRepository.findById(id).get();
        return ShoppingListConvertor.convertToResource(shoppingListEntity);
    }

    public List<ShoppingListResource> findAllShoppingList() {
        List<ShoppingListResource> shoppingListResourceList = new ArrayList<>();
        shoppingListRepository.findAll().forEach(shoppingListResourceList::new);
        return shoppingListResourceList;
    }
}