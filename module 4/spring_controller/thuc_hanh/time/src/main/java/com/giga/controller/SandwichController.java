package com.giga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/sandwich")
@Controller
public class SandwichController {

    @GetMapping()
    public String home() {
        return "sandwich";
    }

    @GetMapping("/condiments")
    public String getCondiments(@RequestParam String[] condiments, Model model) {
        String result = "";
        for (int i = 0; i < condiments.length; i++) {
            result += condiments[i] + " ";
        }
        model.addAttribute("result", result);

        return "sandwich";
    }
}
