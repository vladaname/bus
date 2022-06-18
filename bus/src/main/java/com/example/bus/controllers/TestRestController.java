package com.example.bus.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    public class TestRestController {

        @RequestMapping({"/hello"})
        public String firstPage() {
            return "Hello World";
        }

    }
