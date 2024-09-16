package org.example.spring6webapp.service;

import org.example.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
