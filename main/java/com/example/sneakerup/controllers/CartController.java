package com.example.sneakerup.controllers;


import com.example.sneakerup.other.Product;
import com.example.sneakerup.services.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
public class CartController {
    private final CartService cartService = new CartService();

    @GetMapping(value = "/shopping_cart")
    public String showCart(Model model) throws SQLException, ClassNotFoundException {
        List<Product> boughtList = cartService.getBoughtList();
        model.addAttribute("boughtList", boughtList);

        float total = (float) cartService.computeTotal();
        model.addAttribute("total", total);

        return "shopping_cart";
    }
}
