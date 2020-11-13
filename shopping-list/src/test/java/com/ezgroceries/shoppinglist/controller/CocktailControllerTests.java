package com.ezgroceries.shoppinglist.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

//@SpringBootTest
@AutoConfigureMockMvc
@WebMvcTest(CocktailControllerTests.class)
//@AutoConfigureDataJpa
public class CocktailControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void get(String s){

        // arrange
        /*given(accountManager.getAccount(anyLong()))
            .willReturn(new Account("1234567890", "John Doe"));
         */

        // act and assert
        /*mockMvc.perform(get("/cocktails?search=Russian"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("name").value("Margerita"));*/

        // verify
        //verify(accountManager).getAccount(anyLong());

    }
}
