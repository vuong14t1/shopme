package com.shopme.admin.controller;

import com.shopme.admin.service.IUserService;
import com.shopme.shopmecommon.model.Role;
import com.shopme.shopmecommon.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/users/form-add")
    public String formAddUser(Model model){
        User user = new User();
        user.setEnabled(true);
        model.addAttribute("user", user);
        List<Role> roles = userService.getAllRoles();
        model.addAttribute("listRoles", roles);
        return "users_form";
    }

    @PostMapping("/users")
    public String addUser(User user, RedirectAttributes redirectAttributes){
        userService.saveUser(user);
        redirectAttributes.addFlashAttribute("message", "User has been saved successfully.");
        return "redirect:/users";
    }
}
