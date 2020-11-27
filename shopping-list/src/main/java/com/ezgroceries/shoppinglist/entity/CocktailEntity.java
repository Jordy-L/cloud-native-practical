package com.ezgroceries.shoppinglist.entity;

import com.ezgroceries.shoppinglist.util.StringSetConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "cocktail")
public class CocktailEntity {

    private UUID id;
    private String idDrink;
    private String name;
    private Set<String> ingredients;

    public CocktailEntity(){};

    public CocktailEntity(UUID id, String idDrink, String name, String glass, String instructions, String image, Set<String> ingredients) {
        this.id = id;
        this.idDrink = idDrink;
        this.name = name;
        this.ingredients = ingredients;
    }

    @Id
    @Column(name = "id", nullable = false)
    public UUID getId() {
        return id;
    }

    public void setId(UUID cocktailId) {
        this.id = cocktailId;
    }

    @Column(name = "id_drink")
    public String getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(String drinkId) {
        this.idDrink = drinkId;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "ingredients")
    @Convert(converter = StringSetConverter.class)
    public Set<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<String> ingredients) {
        this.ingredients = ingredients;
    }
}
