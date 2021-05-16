package com.example.sneakerup.services;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class UserService {
    public static String getHash(String password) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        digest.reset();

        try {
            digest.update(password.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        return new BigInteger(1, digest.digest()).toString(16);
    }

    public boolean userExists(final String username) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/wadproject";
        Connection con = DriverManager.getConnection(url, "root",  "root");
        Statement instr = con.createStatement();
        String sql = "SELECT * FROM users";
        ResultSet rs = instr.executeQuery(sql);

        boolean res = false;
        while (rs.next()) {
            if(username.equals(rs.getString("username"))){
                res = true;
                break;
            }
        }

        instr.close();
        con.close();

        return res;
    }

    public void addUser(String name, String uname, String email, String password, String address, String telephone) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/wadproject";
        Connection con = DriverManager.getConnection(url, "root",  "root");
        Statement instr = con.createStatement();

        String pass = getHash(password);
        String sql = "insert into users(name, username, email, passw, address, telephone) VALUES (" +
                "'" + name + "','" + uname + "','" + email + "','" + pass + "','" + address + "','" + telephone + "')";
        instr.executeUpdate(sql);

        instr.close();
        con.close();
    }

    public boolean checkPassword(final String username, final String pass) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/wadproject";
        Connection con = DriverManager.getConnection(url, "root",  "root");
        Statement instr = con.createStatement();
        String sql = "SELECT * FROM users";
        ResultSet rs = instr.executeQuery(sql);

        boolean res = false;
        while (rs.next()) {
            if(username.equals(rs.getString("username"))){
                if(getHash(pass).equals(rs.getString("passw"))){
                    res = true;
                    break;
                }
            }
        }

        instr.close();
        con.close();

        return res;
    }
}
