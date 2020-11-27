package com.ezgroceries.shoppinglist.controller;

import com.ezgroceries.shoppinglist.resource.CocktailResource;
import com.ezgroceries.shoppinglist.service.CocktailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cocktails", produces = "application/json")
public class CocktailController {

    public final CocktailService cocktailService;

    public CocktailController(CocktailService cocktailService) {
        this.cocktailService = cocktailService;
    }

    @GetMapping
    public List<CocktailResource> get(@RequestParam String search) {
        return cocktailService.searchCocktails(search);
    }

}