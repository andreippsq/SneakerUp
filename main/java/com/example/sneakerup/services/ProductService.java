package com.example.sneakerup.services;

import com.example.sneakerup.other.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public List<Product> getProducts(String category) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/wadproject";
        Connection con = DriverManager.getConnection(url, "root",  "root");
        Statement instr = con.createStatement();
        String sql = "SELECT * FROM product WHERE category = '"  + category + "'";
        ResultSet rs = instr.executeQuery(sql);
        List<Product> products = new ArrayList<>();

        while (rs.next()) {
            Product p = new Product();
            p.setName(rs.getString("name"));
            p.setDescription(rs.getString("description"));
            p.setSize(rs.getInt("size"));
            p.setPrice(rs.getFloat("price"));
            p.setCategory(rs.getString("category"));
            p.setQuantity(rs.getInt("quantity"));
            p.setImage(rs.getString("image"));
            products.add(p);
        }

        instr.close();
        con.close();

        return products;
    }
}
