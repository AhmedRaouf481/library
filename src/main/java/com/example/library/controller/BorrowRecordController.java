package com.example.library.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.domain.BorrowRecord;
import com.example.library.domain.request.BorrowRecordRequest;
import com.example.library.exceptions.CustomServiceException;
import com.example.library.service.BorrowRecordService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/borrowRecord")
@RequiredArgsConstructor
public class BorrowRecordController {
    private final BorrowRecordService borrowRecordService;

    @PostMapping
    public ResponseEntity<?> addborrowRecord(@RequestBody BorrowRecordRequest borrowRecordRequest) {
        return ResponseEntity.ok(borrowRecordService.addBorrowRecord(borrowRecordRequest));
    }

    @GetMapping
    public ResponseEntity<?> getAllBorrowRecords() {
        return ResponseEntity.ok(borrowRecordService.getAllBorrowRecord());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBorrowRecordbyId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(borrowRecordService.getById(id));
        } catch (CustomServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("borrower/{borrowerId}")
    public ResponseEntity<?> getBorrowRecordbyBorrowerId(@PathVariable Long borrowerId) {
        return ResponseEntity.ok(borrowRecordService.getByBorrowerId(borrowerId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> getMethodName(@PathVariable Long id, @RequestBody BorrowRecord borrowRecord) {
        try {
            return ResponseEntity.ok(borrowRecordService.updateBorrowRecord(id, borrowRecord));
        } catch (CustomServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBorrowRecord(@PathVariable Long id) {
        try {
            borrowRecordService.deleteBorrowRecord(id);
            return ResponseEntity.ok("BorrowRecord Deleted Succefully");
        } catch (CustomServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
