package com.example.library.domain;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringExclude;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String nationality;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    @ToString.Exclude
    private  List<Book> books;
    
}
