package com.shopme.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class MainController {
    @GetMapping("/index")
    public String viewHomePage(){
        return "index";
    }
}
