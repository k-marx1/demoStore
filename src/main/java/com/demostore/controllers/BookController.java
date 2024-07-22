package com.demostore.controllers;


import com.demostore.models.Book;
import com.demostore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "index";
    }

    @GetMapping("/{id}")
    public String showBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "show";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("newBook") Book book) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("newBook") Book book) {
        bookService.saveBook(book);
        return "redirect:/" + book.getId();
    }

    @GetMapping("/edit/{id}")
    public String editbook(@PathVariable Long id, Model model) {
        model.addAttribute("editedBook", bookService.getBookById(id));
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, @ModelAttribute("editedBook") Book book) {
        bookService.editBook(id, book);
        return "redirect:/{id}";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/";
    }







}
