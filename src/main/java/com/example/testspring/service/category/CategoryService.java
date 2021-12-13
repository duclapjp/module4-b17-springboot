package com.example.testspring.service.category;


import com.example.testspring.model.category.Category;
import com.example.testspring.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional findById(Long id) throws ChangeSetPersister.NotFoundException {
        return categoryRepository.findById(id);
    }

    @Override
    public void save(Category category) {
      categoryRepository.save(category);
    }

    @Override
    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }
}
