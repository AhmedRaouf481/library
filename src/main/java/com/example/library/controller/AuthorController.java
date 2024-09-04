package com.example.library.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.domain.Author;
import com.example.library.service.AuthorService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<?> addauthor(@RequestBody Author author) {
        return ResponseEntity.ok(authorService.addAuthor(author));
    }

    @GetMapping
    public ResponseEntity<?> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthor());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthorbyId(@PathVariable Long id) {
            return ResponseEntity.ok(authorService.getById(id));
     
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> getMethodName(@PathVariable Long id, @RequestBody Author author) {
            return ResponseEntity.ok(authorService.updateAuthor(id, author));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Long id) {
            authorService.deleteAuthor(id);
            return ResponseEntity.ok("Author Deleted Succefully");
    }

}
