package com.giga.controller;

import com.giga.service.Email;
import com.giga.service.IEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/email")
@Controller
public class EmailController {

    @Autowired
    IEmail iEmail;

    @GetMapping()
    public String homepage() {
        return "email";
    }

    @GetMapping("/validate")
    public String validateEmail(@RequestParam String email, Model model) {
        model.addAttribute("result", iEmail.validate(email));
        model.addAttribute("email", email);
        return "email";
    }


}
