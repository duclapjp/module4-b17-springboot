package com.example.testspring.controller;

import com.example.testspring.model.blog.Blog;
import com.example.testspring.model.category.Category;
import com.example.testspring.service.blog.IBlogService;
import com.example.testspring.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @RequestMapping("/view")
    public ModelAndView showHome(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("blogs",blogService.findAll());
        return modelAndView;
    }
    @GetMapping("/blog")
    public ResponseEntity<Iterable<Blog>> showBlogList(){
        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/category")
    public ResponseEntity<Iterable<Category>> showCategoryList(){
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }
}
