package com.giga.controller;

import com.giga.entity.User;
import com.giga.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping()
    public String home(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model, @ModelAttribute User user) {
        List<User> userList = userRepository.findAll();
        for (User userDB : userList) {
            boolean correctLogin = user.getUsername().equals(userDB.getUsername()) && user.getPassword().equals(userDB.getPassword());
            if (correctLogin) return "redirect:/shop";
        }
        model.addAttribute("loginMessage", "Invalid username or password");
        return "login";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "login";
    }
}
