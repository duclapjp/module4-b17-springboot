package com.example.testspring.repository;


import com.example.testspring.model.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Long> {
}
