package com.giga.controller;

import com.giga.service.IProductService;
import com.giga.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping()
    public String home() {
        return "product/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.create(product);
        redirectAttributes.addFlashAttribute("success", "Create Product successfully");
        return "redirect:/product/view";
    }

    @GetMapping("/view")
    public String view(Model model) {
        List<Product> productList = productService.display();
        model.addAttribute("productList", productList);
        return "product/view";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam String id) {
        productService.delete(id);
        return "redirect:/product/view";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable String id, Model model) {
        Product product = productService.getProduct(id);
        model.addAttribute("product", product);
        return "product/update";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product) {
        productService.update(product);
        return "redirect:/product/view";
    }
}
