package com.giga.controller;

import com.giga.entity.Entry;
import com.giga.service.IBlogService;
import com.giga.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    IBlogService blogService;

    @Autowired
    ICategoryService categoryService;

    @GetMapping()
    public String home() {
        return "blog/index";
    }

    @GetMapping("/view")
    public String view(Model model, @PageableDefault(size = 2) Pageable pageable, @RequestParam Optional<String> keyword) {
        if (keyword.isPresent()) {
            model.addAttribute("entryList", blogService.display(pageable, keyword.get()));
            model.addAttribute("keyword", keyword.get());
        } else {
            model.addAttribute("entryList", blogService.display(pageable));
        }
        model.addAttribute("categoryList", categoryService.findAll());
        return "blog/view";
    }

    @GetMapping("/category")
    public String search(Model model, @PageableDefault(size = 2) Pageable pageable, @RequestParam Integer category) {
        Page<Entry> entryList = blogService.display(pageable, category);
        model.addAttribute("categoryId", category);
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("entryList", entryList);
        return "blog/view";
    }

    @GetMapping("/viewEntry")
    public String viewEntry(@RequestParam Integer id, Model model) {
        model.addAttribute("entry", blogService.getEntry(id));
        return "blog/entry";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("entry", new Entry());
        model.addAttribute("categoryList", categoryService.findAll());
        return "/blog/create";
    }

    @PostMapping("/create")
    public String createEntry(@ModelAttribute Entry entry) {
        entry.setDate(String.valueOf(java.time.LocalDate.now()));
        blogService.create(entry);
        return "redirect:/blog/view";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        blogService.delete(id);
        return "redirect:/blog/view";
    }

    @GetMapping("/update")
    public String update(@RequestParam Integer id, Model model) {
        model.addAttribute("entry", blogService.getEntry(id));
        return "blog/update";
    }

    @PostMapping("/update")
    public String updateEntry(@ModelAttribute Entry entry) {
        blogService.update(entry);
        return "redirect:/blog/view";
    }
}
