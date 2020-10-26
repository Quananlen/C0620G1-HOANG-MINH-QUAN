package com.giga.controller;

import com.giga.entity.User;
import com.giga.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping()
    public String home(Model model, @CookieValue(value = "usernameC", defaultValue = "") String username,
                       @CookieValue(value = "passwordC", defaultValue = "") String password,
                       @CookieValue(value = "rememberC", defaultValue = "") String remember) {
        model.addAttribute("user", new User(username, password));
        model.addAttribute("remember", remember);
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model, @ModelAttribute User user, @RequestParam Optional<String> remember , HttpServletResponse response) {
        Cookie cookieUsername;
        Cookie cookiePassword;
        Cookie cookieRemember;

        if (remember.isPresent()) {
             cookieUsername = new Cookie("usernameC", user.getUsername());
             cookiePassword = new Cookie("passwordC", user.getPassword());
             cookieRemember = new Cookie("rememberC", remember.get());
        } else {
             cookieUsername = new Cookie("usernameC", "");
             cookiePassword = new Cookie("passwordC", "");
             cookieRemember = new Cookie("rememberC", "");
        }

        cookieUsername.setMaxAge(3600);
        cookiePassword.setMaxAge(3600);
        cookieRemember.setMaxAge(3600);

        response.addCookie(cookieUsername);
        response.addCookie(cookiePassword);
        response.addCookie(cookieRemember);

        List<User> userList = userRepository.findAll();
        for (User userDB : userList) {
            boolean correctLogin = user.getUsername().equals(userDB.getUsername()) && user.getPassword().equals(userDB.getPassword());
            if (correctLogin) {
                return "redirect:/shop";
            }
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
    public String createUser(Model model, @ModelAttribute User user) {
        List<User> userList = userRepository.findAll();
        for (User userDB : userList) {
            if (userDB.getUsername().equals(user.getUsername())) {
                model.addAttribute("loginMessage", "Username is already taken");
                return "login";
            }
        }
        userRepository.save(user);
        return "login";
    }
}
