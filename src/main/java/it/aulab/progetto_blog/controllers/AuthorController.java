package it.aulab.progetto_blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import it.aulab.progetto_blog.models.Author;
import it.aulab.progetto_blog.models.Post;
import it.aulab.progetto_blog.repositories.AuthorRepository;

//@Controller//stiamo comunicando che questo è un bean controller e deve essere trattato come tale
@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    //Handler
    //E' un metodo che restituisce una risposta in un copro di un JSON
    //@RequestMapping(method=RequestMethod.GET)
    @GetMapping
    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    //@RequestMapping(value="/{id}", method=RequestMethod.GET)
    @GetMapping("{id}")
    public Author getAuthor(@PathVariable("id") Long id){
        return authorRepository.findById(id).get();
    }

    @PostMapping
    //Il @RequestBody come parametro definisce che nella richiesta ci sarà un copro da catturare ed utilizzare, nello specifico per questo handler sarà un autore
    public Author createAuthor(@RequestBody Author author){
        return authorRepository.save(author);
    }


    @PutMapping("{id}")
    public Author updateAuthor(@PathVariable("id") Long id, @RequestBody Author author){
        author.setId(id);
        return authorRepository.save(author);
    }

    @DeleteMapping("{id}")
    public void deleteAuthor(@PathVariable("id") Long id){
        // if(authorRepository.existsById(id)){
        //     Author author = authorRepository.findById(id).get();
        //     List<Post> authorPosts = author.getPosts();
        //     for (Post post : authorPosts) {
        //         post.setAuthor(null);
        //     }
        //     authorRepository.deleteById(id);
        // }else{
        //     throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found");
        // }

        authorRepository.deleteById(id);
        
    }

}
