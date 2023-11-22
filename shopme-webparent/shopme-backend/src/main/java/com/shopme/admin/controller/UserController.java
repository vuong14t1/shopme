package com.shopme.admin.controller;

import com.shopme.admin.exception.NotFoundUserException;
import com.shopme.admin.service.IUserService;
import com.shopme.shopmecommon.model.Role;
import com.shopme.shopmecommon.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
    public String viewCreateUser(Model model){
        User user = new User();
        user.setEnabled(true);
        model.addAttribute("user", user);
        model.addAttribute("pageTitle", "Add User");
        List<Role> roles = userService.getAllRoles();
        model.addAttribute("listRoles", roles);
        return "users_form";
    }

    @PostMapping("/users")
    public String addUser(User user, RedirectAttributes redirectAttributes){
        String msg = "User has been saved successfully.";
        if(userService.isUniqueEmail(user.getId(), user.getEmail())){
            userService.saveUser(user);
        }else{
            msg = "This email is duplicated.";
        }
        redirectAttributes.addFlashAttribute("message", msg);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String viewEditUser(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes){
        Optional<User> user = userService.getUserById(id);
        if(user.isEmpty()){
            redirectAttributes.addFlashAttribute("message", "User: " + id + " not found.");
            return "redirect:/users";
        }

        model.addAttribute("user", user.get());
        List<Role> roles = userService.getAllRoles();
        model.addAttribute("listRoles", roles);
        model.addAttribute("pageTitle", "Edit User(ID:" + id + ")");
        return "users_form";
    }

}
