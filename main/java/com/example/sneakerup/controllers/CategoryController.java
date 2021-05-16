package com.example.sneakerup.controllers;

import com.example.sneakerup.other.Product;
import com.example.sneakerup.services.CartService;
import com.example.sneakerup.services.ProductService;
import com.example.sneakerup.services.WishlistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {
    private final ProductService ps = new ProductService();
    private final CartService cs = new CartService();
    private final ProductService ps2 = new ProductService();
    private final WishlistService ws = new WishlistService();

    @GetMapping(value = "/women")
    public String showProductsWomen(Model model) throws SQLException, ClassNotFoundException {
        List<Product> productList = ps.getProducts("women");
        model.addAttribute("productList", productList);

        List<String> productNameList = new ArrayList<>();
        for(Product p : productList){
            productNameList.add(p.getName());
        }
        model.addAttribute("productNameList", productNameList);

        Product productBought = new Product();
        model.addAttribute("productBought", productBought);

        return "women";
    }

    @PostMapping(value = "/women")
    public String submitFormWomen(Model model, @ModelAttribute("productBought") Product productBought) throws SQLException, ClassNotFoundException {
        List<Product> products = cs.getBoughtList();
        List<Product> productList = ps.getProducts("women");
        for(Product p : productList){
            if(productBought.getName().equals(p.getName())) {
                productBought.setPrice(p.getPrice());
                productBought.setSize(p.getSize());
                productBought.setDescription(p.getDescription());
                productBought.setImage(p.getImage());
                break;
            }
        }
        products.add(productBought);
        return "redirect:/shopping_cart";
    }

    @PostMapping(value = "/women2")
    public String submitFormWomen2(Model model, @ModelAttribute("productBought") Product productBought) throws SQLException, ClassNotFoundException {
        List<Product> products = ws.getBoughtList();
        List<Product> productList = ps2.getProducts("women");
        for(Product p : productList){
            if(productBought.getName().equals(p.getName())) {
                productBought = p;
                break;
            }
        }
        productBought.setQuantity(1);
        products.add(productBought);
        return "redirect:/wishlist";
    }

    @GetMapping(value = "/men")
    public String showProductsMen(Model model) throws SQLException, ClassNotFoundException {
        List<Product> productList = ps.getProducts("men");
        model.addAttribute("productList", productList);

        List<String> productNameList = new ArrayList<>();
        for(Product p : productList){
            productNameList.add(p.getName());
        }
        model.addAttribute("productNameList", productNameList);

        Product productBought = new Product();
        model.addAttribute("productBought", productBought);

        return "men";
    }

    @PostMapping(value = "/men")
    public String submitFormMen(Model model, @ModelAttribute("productBought") Product productBought) throws SQLException, ClassNotFoundException {
        List<Product> products = cs.getBoughtList();
        List<Product> productList = ps.getProducts("men");
        for(Product p : productList){
            if(productBought.getName().equals(p.getName())) {
                productBought.setPrice(p.getPrice());
                productBought.setSize(p.getSize());
                productBought.setDescription(p.getDescription());
                productBought.setImage(p.getImage());
                break;
            }
        }
        products.add(productBought);
        return "redirect:/shopping_cart";
    }

    @PostMapping(value = "/men2")
    public String submitFormMen2(Model model, @ModelAttribute("productBought") Product productBought) throws SQLException, ClassNotFoundException {
        List<Product> products = ws.getBoughtList();
        List<Product> productList = ps2.getProducts("men");
        for(Product p : productList){
            if(productBought.getName().equals(p.getName())) {
                productBought = p;
                break;
            }
        }
        productBought.setQuantity(1);
        products.add(productBought);
        return "redirect:/wishlist";
    }

    @GetMapping(value = "/kids")
    public String showProductsKids(Model model) throws SQLException, ClassNotFoundException {
        List<Product> productList = ps.getProducts("kids");
        model.addAttribute("productList", productList);

        List<String> productNameList = new ArrayList<>();
        for(Product p : productList){
            productNameList.add(p.getName());
        }
        model.addAttribute("productNameList", productNameList);

        Product productBought = new Product();
        model.addAttribute("productBought", productBought);

        return "kids";
    }

    @PostMapping(value = "/kids")
    public String submitFormKids(Model model, @ModelAttribute("productBought") Product productBought) throws SQLException, ClassNotFoundException {
        List<Product> products = cs.getBoughtList();
        List<Product> productList = ps.getProducts("kids");
        for(Product p : productList){
            if(productBought.getName().equals(p.getName())) {
                productBought.setPrice(p.getPrice());
                productBought.setSize(p.getSize());
                productBought.setDescription(p.getDescription());
                productBought.setImage(p.getImage());
                break;
            }
        }
        products.add(productBought);
        return "redirect:/shopping_cart";
    }

    @PostMapping(value = "/kids2")
    public String submitFormKids2(Model model, @ModelAttribute("productBought") Product productBought) throws SQLException, ClassNotFoundException {
        List<Product> products = ws.getBoughtList();
        List<Product> productList = ps2.getProducts("kids");
        for(Product p : productList){
            if(productBought.getName().equals(p.getName())) {
                productBought = p;
                break;
            }
        }
        productBought.setQuantity(1);
        products.add(productBought);
        return "redirect:/wishlist";
    }
}
