package com.example.sneakerup.controllers;

import com.example.sneakerup.other.User;
import com.example.sneakerup.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;

@Controller
public class RegistrationController {
    private final UserService userService = new UserService();

    @GetMapping(value = "/register")
    public String showForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "register_form";
    }

    @PostMapping(value = "/register")
    public String submitForm(@ModelAttribute("user") User user) throws SQLException, ClassNotFoundException {
        if(userService.userExists(user.getUsername())){
            return "register_form";
        }
        else userService.addUser(user.getName(), user.getUsername(), user.getEmail(), user.getPassword(), user.getAddress(), user.getTelephone());

        return "register_success";
    }
}
