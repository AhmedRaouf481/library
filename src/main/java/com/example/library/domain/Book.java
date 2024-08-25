package com.example.library.domain;

import java.time.LocalDate;
import java.util.Set;

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
    private Author author;

    @OneToMany(mappedBy = "book")
    private Set<BorrowRecord> borrowRecords;
}
