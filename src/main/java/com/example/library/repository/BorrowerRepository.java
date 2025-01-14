package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library.domain.Borrower;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower,Long> {

}
