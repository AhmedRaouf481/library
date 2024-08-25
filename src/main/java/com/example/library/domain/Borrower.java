package com.example.library.domain;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Table
@Data
public class Borrower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String email;

    private LocalDate membershipDate;

    @OneToMany(mappedBy = "borrower")
    private Set<BorrowRecord> borrowRecords;
 
}
