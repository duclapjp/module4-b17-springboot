package com.example.testspring.service.blog;


import com.example.testspring.model.blog.Blog;
import com.example.testspring.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional findById(Long id) throws ChangeSetPersister.NotFoundException {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }


    @Override
    public Iterable<Blog> findAllByAuthorContaining(String author, Pageable pageable) throws ChangeSetPersister.NotFoundException {
        return null;
    }
}
