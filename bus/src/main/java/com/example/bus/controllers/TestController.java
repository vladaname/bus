package com.example.bus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

    @GetMapping("/hello")
    public String testHello(Model model, @RequestParam(value = "name", required = false, defaultValue = "Hello World")String name){
        model.addAttribute("name", name);
        return "hello";
    }
}
