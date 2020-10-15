package com.giga.controller;

import model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/setting")
@Controller
public class SettingController {

    @GetMapping()
    public String home(Model model) {
        model.addAttribute("setting", new Setting());
        return "setting";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Setting setting, Model model) {
        model.addAttribute("setting", setting);
        return "current_setting";
    }
}
