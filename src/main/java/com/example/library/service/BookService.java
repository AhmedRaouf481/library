package com.example.library.service;

import java.util.List;

import com.example.library.domain.Book;

public interface BookService {
    Book addBook(Long authorId,Book Book);

    List<Book> getAllBook();

    Book getById(Long id);

    Book updateBook(Long id, Book bookDetails);

    void deleteBook(Long id);
}
