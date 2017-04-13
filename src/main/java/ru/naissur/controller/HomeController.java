package ru.naissur.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * naissur
 * 13.04.2017
 */

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model) {
        return ("main");
    }
}
