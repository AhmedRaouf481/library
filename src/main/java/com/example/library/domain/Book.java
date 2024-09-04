package com.example.library.domain;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Table
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Boolean isbn;

    private LocalDate publishDate;

    @ManyToOne
    @JoinColumn(name = "author_id",nullable = false)
    @JsonBackReference
    private Author author;

    @OneToMany(mappedBy = "book")
    @JsonManagedReference
    private Set<BorrowRecord> borrowRecords;
}
