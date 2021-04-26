package com.example.tutorial.controllers;

import com.example.tutorial.other.LoginUser;
import com.example.tutorial.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class LoginController {
    private final UserService userService = new UserService();

    @GetMapping(value = "/login")
    public String showForm(Model model){
        LoginUser lUser = new LoginUser();
        model.addAttribute("loginuser", lUser);
        return "login_form";
    }

    @PostMapping(value = "/login")
    public String submitForm(@ModelAttribute("loginuser") LoginUser lUser) throws SQLException, ClassNotFoundException {
        if(userService.userExists(lUser.getUsername())){
            if (userService.checkPassword(lUser.getUsername(), lUser.getPassword()))
                System.out.println("good");
            else System.out.println("wrong pass");
        }
        else System.out.println("no user");
        return "login_success";
    }
}
