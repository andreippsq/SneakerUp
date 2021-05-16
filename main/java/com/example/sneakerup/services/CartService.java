package com.example.sneakerup.services;

import com.example.sneakerup.other.Product;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    static List<Product> boughtList = new ArrayList<>();

    public void addProduct(Product p){
        boughtList.add(p);
    }

    public List<Product> getBoughtList(){
        return boughtList;
    }

    public float computeTotal(){
        float total = 0;
        for(Product p : boughtList){
            total += p.getPrice() * p.getQuantity();
        }
        return total;
    }
}
