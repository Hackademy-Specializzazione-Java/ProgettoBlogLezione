package it.aulab.progetto_blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.aulab.progetto_blog.dtos.AuthorDto;
import it.aulab.progetto_blog.models.Author;
import it.aulab.progetto_blog.services.AuthorService;

//@Controller//stiamo comunicando che questo è un bean controller e deve essere trattato come tale
@RestController
@RequestMapping("/api/authors")
public class AuthorRestController {

    // @Autowired
    // AuthorRepository authorRepository;

    @Autowired
    AuthorService authorService;

    //Handler
    //E' un metodo che restituisce una risposta in un copro di un JSON
    //@RequestMapping(method=RequestMethod.GET)
    @GetMapping
    public List<AuthorDto> getAllAuthors(){
        //return authorRepository.findAll();
        return authorService.readAll();
    }

    //@RequestMapping(value="/{id}", method=RequestMethod.GET)
    @GetMapping("{id}")
    public AuthorDto getAuthor(@PathVariable("id") Long id){
        //return authorRepository.findById(id).get();
        return authorService.read(id);
    }

    @PostMapping
    //Il @RequestBody come parametro definisce che nella richiesta ci sarà un copro da catturare ed utilizzare, nello specifico per questo handler sarà un autore
    public AuthorDto createAuthor(@RequestBody Author author){
        //return authorRepository.save(author);
        return authorService.create(author);
    }


    @PutMapping("{id}")
    public AuthorDto updateAuthor(@PathVariable("id") Long id, @RequestBody Author author){
        // author.setId(id);
        // return authorRepository.save(author);
        return authorService.update(id, author);
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

        //authorRepository.deleteById(id);
        authorService.delete(id);
        
    }

}
