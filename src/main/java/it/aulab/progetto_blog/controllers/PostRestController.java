package it.aulab.progetto_blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import it.aulab.progetto_blog.models.Post;
import it.aulab.progetto_blog.repositories.PostRepository;

@Controller
@RequestMapping("/api/posts")
public class PostRestController {
    
    @Autowired
    PostRepository postRepository;

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody List<Post> getAllPost(){
        return postRepository.findAll();
    }

    @GetMapping("{id}")
    public Post getPost(@PathVariable("id") Long id) {
        return postRepository.findById(id).get();
    }

    @PostMapping
    public Post createPost(@RequestBody Post post){
        return postRepository.save(post);
    }

    @PutMapping("{id}")
    public Post updatePost(@PathVariable("id") Long id, @RequestBody Post post){
        post.setId(id);
        return postRepository.save(post);
    }

    @DeleteMapping("{id}")
    public void deletePost(@PathVariable("id") Long id){
        postRepository.deleteById(id);
    }
}
