package com.example.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.domain.Borrower;
import com.example.library.exceptions.ApiRequestException;
import com.example.library.repository.BorrowerRepository;
import com.example.library.service.BorrowerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BorrowerServiceImp implements BorrowerService{

    @Autowired
    private BorrowerRepository borrowerRepository;

    @Override
    public Borrower addBorrower(Borrower borrower) {
        return borrowerRepository.save(borrower);
    }

    @Override
    public List<Borrower> getAllBorrower() {
       return borrowerRepository.findAll();
    }

    @Override
    public Borrower getById(Long id) {
        return borrowerRepository.findById(id)
        .orElseThrow(() -> new ApiRequestException("Borrower with ID " + id + " not found"));
    }

    @Override
    public Borrower updateBorrower(Long id, Borrower borrowerDetails) {
        Borrower borrower = borrowerRepository.findById(id)
        .orElseThrow(() -> new ApiRequestException("Borrower with ID " + id + " not found"));
        
        borrower.setName(borrowerDetails.getName());
        borrower.setEmail(borrowerDetails.getEmail());
        borrower.setMembershipDate(borrowerDetails.getMembershipDate());
        

        return borrowerRepository.save(borrower);
    }

    @Override
    public void deleteBorrower(Long id) {
        Borrower borrower = borrowerRepository.findById(id)
        .orElseThrow(() -> new ApiRequestException("Borrower with ID " + id + " not found"));
        
        borrowerRepository.delete(borrower);
    }


}
