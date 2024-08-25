package com.example.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.domain.Author;
import com.example.library.domain.Book;
import com.example.library.exceptions.CustomServiceException;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImp implements BookService{

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Book addBook(Long authorId,Book book) {
        Author author = authorRepository.findById(authorId)
        .orElseThrow(() -> new CustomServiceException("Author with ID " + authorId + " not found"));

        book.setAuthor(author);

        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBook() {
       return bookRepository.findAll();
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.findById(id)
        .orElseThrow(() -> new CustomServiceException("Book with ID " + id + " not found"));
    }

    @Override
    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id)
        .orElseThrow(() -> new CustomServiceException("Book with ID " + id + " not found"));
        
        book.setTitle(bookDetails.getTitle());
        book.setIsbn(bookDetails.getIsbn());
        book.setPublishDate(bookDetails.getPublishDate());
        

        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id)
        .orElseThrow(() -> new CustomServiceException("Book with ID " + id + " not found"));
        
        bookRepository.delete(book);
    }


}
