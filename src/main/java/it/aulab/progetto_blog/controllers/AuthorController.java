package it.aulab.progetto_blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.aulab.progetto_blog.dtos.AuthorDto;
import it.aulab.progetto_blog.models.Author;
import it.aulab.progetto_blog.services.AuthorService;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;
    
    @GetMapping
    public String authorsView(Model viewModel){
        viewModel.addAttribute("title", "Authors view");
        viewModel.addAttribute("authors", authorService.readAll());
        return "authors";
    }

    @GetMapping("create")
    public String createAuthorView(Model viewModel) {
        viewModel.addAttribute("title", "Create Author");
        viewModel.addAttribute("author", new Author());
        return "createAuthor";
    }

    @PostMapping
    public String createAuthor(@ModelAttribute("author") Author author){
        authorService.create(author);
        return "redirect:/authors";
    }

    @GetMapping("edit/{id}")
    public String editAuthor(@PathVariable("id") Long id, Model viewModel) {
        viewModel.addAttribute("title", "Update Author");
        viewModel.addAttribute("author", authorService.read(id));
        return "editAuthor";
    }

    @PostMapping("update")
    public String updateAuthor(@ModelAttribute("author") Author author) {
        authorService.update(author.getId(), author);
        return "redirect:/authors";
    }

    @GetMapping("delete/{id}")
    public String deleteAuthor(@PathVariable("id") Long id) {
       
        AuthorDto author = authorService.read(id);

        // if (author.getNumberOfPosts() != null && !author.getNumberOfPosts().isEmpty()) {
        //     Iterable<Post> posts = author.getNumberOfPosts();
        //     for (Post post: posts) {
        //         post.setAuthor(null);
        //     }
        // }
        authorService.delete(id);
        return "redirect:/authors";
    }

}
