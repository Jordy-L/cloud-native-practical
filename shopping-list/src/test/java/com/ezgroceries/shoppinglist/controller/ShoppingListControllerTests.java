package com.ezgroceries.shoppinglist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ShoppingListControllerTests.class)
//@AutoConfigureDataJpa
public class ShoppingListControllerTests {

    @Autowired
    private MockMvc mockMvc;
}
