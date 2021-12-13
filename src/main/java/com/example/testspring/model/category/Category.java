package com.example.testspring.model.category;

import com.example.testspring.model.blog.Blog;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(targetEntity = Blog.class)
    @JsonManagedReference
    private List<Blog> blogList;

    public Category() {
    }

    public Category(String name, List<Blog> blogList) {
        this.name = name;
        this.blogList = blogList;
    }

    public Category(Long id, String name, List<Blog> blogList) {
        this.id = id;
        this.name = name;
        this.blogList = blogList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}
