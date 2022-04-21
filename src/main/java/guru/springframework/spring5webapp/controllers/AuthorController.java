package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepo;


    @GetMapping
    public String getAuthors(Model model) {
        model.addAttribute("authors", authorRepo.findAll());

        return "authors/list";
    }

    @GetMapping("/{id}")
    ResponseEntity<Author> findAuthorById(@PathVariable(value="id") long id) {
        Author tom = new Author("Tom", "Evan");
        return ResponseEntity.ok().body(tom);
    }
}
