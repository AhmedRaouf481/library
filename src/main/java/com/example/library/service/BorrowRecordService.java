package com.example.library.service;

import java.util.List;

import com.example.library.domain.BorrowRecord;
import com.example.library.domain.request.BorrowRecordRequest;

public interface BorrowRecordService {
    BorrowRecord addBorrowRecord(BorrowRecordRequest borrowRecordRequest);

    List<BorrowRecord> getAllBorrowRecord();

    BorrowRecord getById(Long id);

    List<BorrowRecord> getByBorrowerId(Long borrowerId);

    BorrowRecord updateBorrowRecord(Long id, BorrowRecord borrowRecordDetails);

    void deleteBorrowRecord(Long id);
}
