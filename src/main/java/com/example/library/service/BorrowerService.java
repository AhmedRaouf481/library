package com.example.library.service;

import java.util.List;

import com.example.library.domain.Borrower;

public interface BorrowerService {
    Borrower addBorrower(Borrower Borrower);

    List<Borrower> getAllBorrower();

    Borrower getById(Long id);

    Borrower updateBorrower(Long id, Borrower borrowerDetails);

    void deleteBorrower(Long id);
}
