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
import org.springframework.web.bind.annotation.*;

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
    public String createUser(Model model, @Validated @ModelAttribute User user, BindingResult bindingResult) {

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("permissionList", permissionService.findAll());
            return "create";
        }
        userService.save(user);
        return "redirect:/view";
    }

    @GetMapping("/update")
    public String update(Model model, @RequestParam Integer id) throws Exception {
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("permissionList", permissionService.findAll());
        return "update";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/view";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        userService.deleteById(id);
        return "redirect:/view";
    }

    @ExceptionHandler(Exception.class)
    public String error() {
        return "error";
    }
}

