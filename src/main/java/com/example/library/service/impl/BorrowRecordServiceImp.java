package com.example.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.domain.Book;
import com.example.library.domain.BorrowRecord;
import com.example.library.domain.Borrower;
import com.example.library.domain.request.BorrowRecordRequest;
import com.example.library.exceptions.CustomServiceException;
import com.example.library.repository.BookRepository;
import com.example.library.repository.BorrowRecordRepository;
import com.example.library.repository.BorrowerRepository;
import com.example.library.service.BorrowRecordService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BorrowRecordServiceImp implements BorrowRecordService{

    @Autowired
    private BorrowRecordRepository borrowRecordRepository;
    @Autowired
    private BorrowerRepository borrowerRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public BorrowRecord addBorrowRecord(BorrowRecordRequest borrowRecordRequest) {
        BorrowRecord borrowRecord = new BorrowRecord();

        Book book = bookRepository.findById(borrowRecordRequest.getBookId())
        .orElseThrow(()->new CustomServiceException("Book with id " + borrowRecordRequest.getBookId()+" not found"));
        
        Borrower borrower = borrowerRepository.findById(borrowRecordRequest.getBorrowerId())
        .orElseThrow(()->new CustomServiceException("Borrower with id " + borrowRecordRequest.getBorrowerId()+" not found"));

        borrowRecord.setBook(book);
        borrowRecord.setBorrower(borrower);
        borrowRecord.setReturnDate(borrowRecordRequest.getReturnDate());

        return borrowRecordRepository.save(borrowRecord);
    }

    @Override
    public List<BorrowRecord> getAllBorrowRecord() {
       return borrowRecordRepository.findAll();
    }

    @Override
    public BorrowRecord getById(Long id) {
        return borrowRecordRepository.findById(id)
        .orElseThrow(() -> new CustomServiceException("BorrowRecord with ID " + id + " not found"));
    }

    @Override
    public BorrowRecord updateBorrowRecord(Long id, BorrowRecord borrowRecordDetails) {
        BorrowRecord borrowRecord = borrowRecordRepository.findById(id)
        .orElseThrow(() -> new CustomServiceException("BorrowRecord with ID " + id + " not found"));
        
        borrowRecord.setBorrowDate(borrowRecordDetails.getBorrowDate());
        borrowRecord.setReturnDate(borrowRecordDetails.getReturnDate());

        return borrowRecordRepository.save(borrowRecord);
    }

    @Override
    public void deleteBorrowRecord(Long id) {
        BorrowRecord borrowRecord = borrowRecordRepository.findById(id)
        .orElseThrow(() -> new CustomServiceException("BorrowRecord with ID " + id + " not found"));
        
        borrowRecordRepository.delete(borrowRecord);
    }

    @Override
    public List<BorrowRecord> getByBorrowerId(Long borrowerId) {
       return borrowRecordRepository.findByBorrowerId(borrowerId);
    }

}
