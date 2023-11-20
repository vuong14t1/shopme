package com.shopme.admin.controller;

import com.shopme.admin.service.IUserService;
import com.shopme.shopmecommon.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    private IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String listAll(Model model){
        List<User> users = userService.listAll();
        model.addAttribute("listUsers", users);
        return "users";
    }
}
