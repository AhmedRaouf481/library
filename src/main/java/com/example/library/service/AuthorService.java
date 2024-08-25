package com.example.library.service;

import com.example.library.domain.Author;
import java.util.List;

public interface AuthorService {
    Author addAuthor(Author author);

    List<Author> getAllAuthor();

    Author getById(Long id);

    Author updateAuthor(Long id, Author authorDetails);

    void deleteAuthor(Long id);
}
