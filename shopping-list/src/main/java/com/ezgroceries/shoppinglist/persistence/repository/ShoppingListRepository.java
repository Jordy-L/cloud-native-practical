package com.ezgroceries.shoppinglist.persistence.repository;

import com.ezgroceries.shoppinglist.persistence.entity.ShoppingListEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ShoppingListRepository extends CrudRepository<ShoppingListEntity, UUID> {

}
