package com.ezgroceries.shoppinglist.controller;

import com.ezgroceries.shoppinglist.entity.CocktailResource;
import com.ezgroceries.shoppinglist.persistence.CocktailResourceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@SpringBootTest
@AutoConfigureMockMvc
@WebMvcTest(CocktailController.class)
//@AutoConfigureDataJpa
public class CocktailControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CocktailResourceService cocktailResourceService;

    @Test
    public void get() throws Exception {

        // arrange
        given(cocktailResourceService.searchCocktails("Russian"))
            .willReturn(Arrays.asList(
                new CocktailResource(
                    UUID.fromString("23b3d85a-3928-41c0-a533-6538a71e17c4"), "Margerita",
                    "Cocktail glass",
                    "Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten..",
                    "https://www.thecocktaildb.com/images/media/drink/wpxpvu1439905379.jpg",
                    Arrays.asList("Tequila", "Triple sec", "Lime juice", "Salt")),
                new CocktailResource(
                    UUID.fromString("d615ec78-fe93-467b-8d26-5d26d8eab073"), "Blue Margerita",
                    "Cocktail glass",
                    "Rub rim of cocktail glass with lime juice. Dip rim in coarse salt..",
                    "https://www.thecocktaildb.com/images/media/drink/qtvvyq1439905913.jpg",
                    Arrays.asList("Tequila", "Blue Curacao", "Lime juice", "Salt"))));


        // act and assert
        mockMvc.perform(MockMvcRequestBuilders.get("/cocktails?search=Russian"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
            //.andExpect(jsonPath(".name").value(containsInAnyOrder("Margerita", "")));

        // verify
        //verify(accountManager).getAccount(anyLong());

    }
}
