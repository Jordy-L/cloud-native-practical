package com.ezgroceries.cocktail.persistence.entity;

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
    private String glass;
    private String instructions;
    private String imageLink;

    public CocktailEntity(){};

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

    @Column(name = "glass")
    public String getGlass() {
        return glass;
    }

    public void setGlass(String glass) {
        this.glass = glass;
    }

    @Column(name = "instructions")
    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Column(name = "image_link")
    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String image) {
        this.imageLink = image;
    }
}
