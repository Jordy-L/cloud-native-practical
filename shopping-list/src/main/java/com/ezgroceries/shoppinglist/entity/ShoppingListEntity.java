package com.ezgroceries.shoppinglist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "shopping_list")
public class ShoppingListEntity {

    private UUID shoppingListId;
    private String name;
    private Set<CocktailEntity> cocktailEntitySet;

    public ShoppingListEntity(){};

    public ShoppingListEntity(UUID shoppingListId, String name, List<String> ingredients) {
        this.shoppingListId = shoppingListId;
        this.name = name;
    }

    public ShoppingListEntity(ShoppingListEntity shoppingListResource){
        this.setShoppingListId(UUID.randomUUID());
        this.setName(shoppingListResource.getName());
        //this.ingredients = new ArrayList<String>();
    }

    @Id
    @Column(name = "id", nullable = false)
    public UUID getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(UUID shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany
    @JoinTable(
        name = "cocktail_shopping_list",
        joinColumns = { @JoinColumn(name = "shopping_list_id") },
        inverseJoinColumns = { @JoinColumn(name = "cocktail_id") }
    )
    public Set<CocktailEntity> getCocktailEntitySet() {
        return cocktailEntitySet;
    }

    public void setCocktailEntitySet(Set<CocktailEntity> cocktailEntitySet) {
        this.cocktailEntitySet = cocktailEntitySet;
    }

    @Transient
    public Set<CocktailId> getCocktailIds(){
        Set<CocktailId> cocktailIds = new HashSet<>();
        for(CocktailEntity ce: cocktailEntitySet)
            cocktailIds.add(new CocktailId(ce.getId()));
        return cocktailIds;
    }
}
