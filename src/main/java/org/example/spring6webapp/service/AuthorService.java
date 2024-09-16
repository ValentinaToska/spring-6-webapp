package org.example.spring6webapp.service;

import org.example.spring6webapp.domain.Author;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {
    Iterable<Author> findAll();
}
