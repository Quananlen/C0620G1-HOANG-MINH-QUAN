package com.giga.controller;

import com.giga.entity.Permission;
import com.giga.entity.User;
import com.giga.service.IPermissionService;
import com.giga.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;


@Controller
public class UserController {

    @Autowired
    IUserService userService;

    @Autowired
    IPermissionService permissionService;

    @GetMapping()
    public String home() {
        return "index";
    }

    @GetMapping("/view")
    public String view(Model model, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("userList", userService.findAll(pageable));
        return "view";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("permissionList", permissionService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String createUser(Model model, @Validated @ModelAttribute User user, BindingResult bindingResult, @RequestParam Set<Permission> permission) {

        if (bindingResult.hasFieldErrors()) {
            return "create";
        }
        user.setPermissionSet(permission);
        userService.save(user);
        return "redirect:/view";
    }
}
