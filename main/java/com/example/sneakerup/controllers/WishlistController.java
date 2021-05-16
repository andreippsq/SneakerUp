package com.example.sneakerup.controllers;

import com.example.sneakerup.other.Product;
import com.example.sneakerup.services.CartService;
import com.example.sneakerup.services.WishlistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
public class WishlistController {
    private final WishlistService wishlistService = new WishlistService();

    @GetMapping(value = "/wishlist")
    public String showCart(Model model) throws SQLException, ClassNotFoundException {
        List<Product> boughtList = wishlistService.getBoughtList();
        model.addAttribute("boughtList", boughtList);

        return "wishlist";
    }
}
