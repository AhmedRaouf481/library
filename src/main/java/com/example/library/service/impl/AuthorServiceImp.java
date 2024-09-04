package com.example.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.domain.Author;
import com.example.library.exceptions.ApiRequestException;
import com.example.library.repository.AuthorRepository;
import com.example.library.service.AuthorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorServiceImp implements AuthorService{

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAllAuthor() {
       return authorRepository.findAll();
    }

    @Override
    public Author getById(Long id) {
        return authorRepository.findById(id)
        .orElseThrow(() -> new ApiRequestException("Author with ID " + id + " not found"));
    }

    @Override
    public Author updateAuthor(Long id, Author authorDetails) {
        Author author = authorRepository.findById(id)
        .orElseThrow(() -> new ApiRequestException("Author with ID " + id + " not found"));
        
        author.setName(authorDetails.getName());
        author.setNationality(authorDetails.getNationality());
        author.setBirthDate(authorDetails.getBirthDate());

        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        Author author = authorRepository.findById(id)
        .orElseThrow(() -> new ApiRequestException("Author with ID " + id + " not found"));
        
        authorRepository.delete(author);
    }

}
