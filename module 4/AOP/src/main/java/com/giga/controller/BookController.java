package com.giga.controller;

import com.giga.entity.Book;
import com.giga.exception.NotAvailableException;
import com.giga.exception.NotBorrowException;
import com.giga.exception.WrongCodeException;
import com.giga.service.IBookService;
import com.giga.service.ICodeService;
import com.giga.service.IStatusService;
import com.giga.validation.ReturnCodeWrapper;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Min;

@Controller
public class BookController {

    @Autowired
    IBookService bookService;

    @Autowired
    ICodeService codeService;

    @Autowired
    IStatusService statusService;

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
    public String createBook(Model model, @Validated @ModelAttribute Book book, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute(book);
            return "create";
        }
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

    @GetMapping("/return")
    public String returnPage(Model model, @RequestParam Integer id, @ModelAttribute ReturnCodeWrapper returnCodeWrapper) throws NotBorrowException {
        Book book = bookService.findById(id);
        if (bookService.checkNoUsedCode(book)) {
            throw new NotBorrowException();
        }
        model.addAttribute("returnCodeWrapper", returnCodeWrapper);
        model.addAttribute("book", book);
        return "return";
    }

    @PostMapping("/return")
    public String returnBook(Model model, @ModelAttribute Book book, @Validated @ModelAttribute ReturnCodeWrapper returnCodeWrapper, BindingResult result)
            throws NotAvailableException, WrongCodeException {
        if (result.hasFieldErrors()) {
            model.addAttribute("returnCodeWrapper", returnCodeWrapper);
            model.addAttribute("book", book);
            return "return";
        }
        bookService.returnBook(book, Integer.parseInt(returnCodeWrapper.getReturnCode()));
        return "redirect:/view";
    }

    @GetMapping("/create_code_status")
    public String createCodeStatus() {
        statusService.createStatus();
        return "index";
    }

    @ExceptionHandler(NotAvailableException.class)
    public String notAvailable() {
        return "error_not_available";
    }

    @ExceptionHandler(WrongCodeException.class)
    public String wrongCode() {
        return "error_wrong_code";
    }

    @ExceptionHandler(NotBorrowException.class)
    public String notBorrow() {
        return "error_not_borrow";
    }

}
