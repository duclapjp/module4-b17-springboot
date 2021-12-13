package com.example.testspring.service.blog;

import com.example.testspring.model.blog.Blog;
import com.example.testspring.service.IGeneralService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGeneralService<Blog> {
    Iterable<Blog> findAllByAuthorContaining(String author, Pageable pageable) throws ChangeSetPersister.NotFoundException;
}
