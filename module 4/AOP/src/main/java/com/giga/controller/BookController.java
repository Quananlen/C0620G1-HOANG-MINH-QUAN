package com.giga.controller;

import com.giga.entity.Book;
import com.giga.exception.NotAvailableException;
import com.giga.service.IBookService;
import com.giga.service.ICodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    IBookService bookService;

    @Autowired
    ICodeService codeService;

    @GetMapping()
    public String home() {
        return "index";
    }

    @GetMapping("/view")
    public String view(Model model) {
        model.addAttribute("bookList", bookService.findAll());
        return "view";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("book", new Book());
        return "create";
    }

    @PostMapping("/create")
    public String createBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/view";
    }

    @GetMapping("/borrow")
    public String borrow(Model model, @RequestParam Integer id) throws NotAvailableException {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        model.addAttribute("availableCode", bookService.getNextAvailableCode(book));
        return "borrow";
    }

    @PostMapping("/borrow")
    public String borrowBook(@ModelAttribute Book book, @RequestParam Integer usedCode) {
        bookService.borrow(book, usedCode);
        return "redirect:/view";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        bookService.delete(id);
        return "redirect:/view";
    }

    @ExceptionHandler(NotAvailableException.class)
    public String notAvailable() {
        return "error";
    }
}
