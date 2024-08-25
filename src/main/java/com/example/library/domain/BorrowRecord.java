package com.example.library.domain;

import java.time.LocalDate;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data
public class BorrowRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "borrower_id")
    private Borrower borrower;

    private LocalDate borrowDate;

    private LocalDate returnDate;

    @Override
    public boolean equals(Object o) {
        return true;

    }

    @Override
    public int hashCode() {
        return 1;
    }
}
