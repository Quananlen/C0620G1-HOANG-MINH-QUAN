package com.giga.controller;

import com.giga.entity.Product;
import com.giga.entity.User;
import com.giga.repository.ProductRepository;
import com.giga.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequestMapping("/shop")
@SessionAttributes("user")
public class ShopController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping()
    public String home(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("productList", productList);
        return "home";
    }

    @GetMapping("/addToCart")
    public String addToCart(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/shop";
    }

    @GetMapping("/viewCart")
    public String viewCart() {
        return "view_cart";
    }

}
