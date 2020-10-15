package com.giga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/calculator")
@Controller
public class CalculatorController {
    @GetMapping()
    public String home() {
        return "calculator";
    }

    @GetMapping("/addition")
    public String addition(@RequestParam int num1, @RequestParam int num2, Model model) {
        model.addAttribute("result", num1 + num2);
        return "calculator";
    }

    @GetMapping("/subtraction")
    public String subtraction(@RequestParam int num1, @RequestParam int num2, Model model) {
        model.addAttribute("result", num1 - num2);
        return "calculator";
    }

    @GetMapping("/multiplication")
    public String multiplication(@RequestParam int num1, @RequestParam int num2, Model model) {
        model.addAttribute("result", num1 * num2);
        return "calculator";
    }

    @GetMapping("/division")
    public String division(@RequestParam int num1, @RequestParam int num2, Model model) {
        model.addAttribute("result", num1 / num2);
        return "calculator";
    }
}
