package com.example.bookmaker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

public class MainController {
    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "index";
    }
}
