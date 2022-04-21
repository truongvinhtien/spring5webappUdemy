package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepo;
//
//    public BookController(BookRepository bookRepo) {
//        this.bookRepo = bookRepo;
//    }

    @GetMapping()
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepo.findAll());

        return "books/list";
    }
}
