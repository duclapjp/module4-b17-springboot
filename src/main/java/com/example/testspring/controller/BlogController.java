package com.example.testspring.controller;

import com.example.testspring.model.blog.Blog;
import com.example.testspring.service.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/all")
    public ResponseEntity<Iterable<Blog>> showBlogList(){
        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Blog> createNewBlog(@RequestBody Blog blog){
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Blog> editBlog(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
       Optional blog= blogService.findById(id);
       blogService.save((Blog) blog.get());
       return new ResponseEntity<>(HttpStatus.OK);
    }
}
