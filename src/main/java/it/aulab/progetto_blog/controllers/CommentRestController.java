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

import it.aulab.progetto_blog.models.Comment;
import it.aulab.progetto_blog.repositories.CommentRepository;

@Controller
@RequestMapping("/api/comments")
public class CommentRestController {
    
    @Autowired
    CommentRepository commentRepository;

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody List<Comment> getAllComment(){
        return commentRepository.findAll();
    }

    @GetMapping("{id}")
    public Comment getComment(@PathVariable("id") Long id){
        return commentRepository.findById(id).get();
    }

    @PostMapping
    public Comment createComment(@RequestBody Comment comment){
        return commentRepository.save(comment);
    }

    @PutMapping("{id}")
    public Comment updateComment(@PathVariable("id") Long id, @RequestBody Comment comment){
        comment.setId(id);
        return commentRepository.save(comment);
    }

    @DeleteMapping("{id}")
    public void deleteComment(@PathVariable("id") Long id){
        commentRepository.deleteById(id);
    }
}
