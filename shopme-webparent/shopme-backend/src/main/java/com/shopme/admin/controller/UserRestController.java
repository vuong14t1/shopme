package com.shopme.admin.controller;

import com.shopme.admin.service.IUserService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
    private final IUserService userService;

    public UserRestController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users/check-email")
    public String checkUniqueEmail(@Param("email") String email){
        return userService.isUniqueEmail(email) ? "OK": "Duplicated";
    }
}
