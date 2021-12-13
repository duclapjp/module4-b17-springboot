package com.example.testspring.service;

import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional findById(Long id) throws ChangeSetPersister.NotFoundException;

    void save(T t);

    void remove(Long id);
}
