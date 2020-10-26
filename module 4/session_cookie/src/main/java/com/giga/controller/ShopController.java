package com.giga.controller;

import com.giga.entity.Cart;
import com.giga.entity.Product;
import com.giga.repository.ProductRepository;
import com.giga.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/shop")
@SessionAttributes({"user", "cartList"})
public class ShopController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping()
    public String home(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("productList", productList);
        model.addAttribute("cart", new Cart(new Product(), 0));
        return "home";
    }

    @GetMapping("/createCart")
    public String createCart(Model model) {
        List<Cart> cartList = new ArrayList<>();
        model.addAttribute("cartList", cartList);
        return "home";
    }

    @GetMapping("/addToCart")
    public String addToCart(@RequestParam Integer id, @ModelAttribute Cart cart, @SessionAttribute("cartList") List<Cart> cartList) {
        cart.setProduct(productRepository.findById(id).orElse(null));
        // check if cart already contain product
        for (int i = 0; i < cartList.size(); i++) {
            Cart productInCart = cartList.get(i);
            if (productInCart.getProduct().getName().equals(cart.getProduct().getName())) {
                productInCart.setQuantity(cart.getQuantity() + productInCart.getQuantity());
                return "redirect:/shop";
            }
        }

        cartList.add(cart);
        return "redirect:/shop";
    }

    @GetMapping("/editCart")
    public String edit(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("productList", productList);
        model.addAttribute("cart", new Cart(new Product(), 0));
        return "edit";
    }

    @PostMapping("/editCart")
    public String editCart(@RequestParam Integer id, @ModelAttribute Cart cart, @SessionAttribute("cartList") List<Cart> cartList) {
        cart.setProduct(productRepository.findById(id).orElse(null));
        for (int i = 0; i < cartList.size(); i++) {
            Cart productInCart = cartList.get(i);
            if (productInCart.getProduct().getName().equals(cart.getProduct().getName())) {
                productInCart.setQuantity(productInCart.getQuantity() - cart.getQuantity());
                if (productInCart.getQuantity() == 0) cartList.remove(productInCart);
                return "redirect:/shop";
            }
        }

        return "redirect:/shop";
    }

    @GetMapping("/viewCart")
    public String viewCart() {
        return "view_cart";
    }
}
