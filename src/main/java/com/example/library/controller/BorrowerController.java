package com.example.library.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.domain.Borrower;
import com.example.library.service.BorrowerService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/borrower")
@RequiredArgsConstructor
public class BorrowerController {
    private final BorrowerService borrowerService;

    @PostMapping
    public ResponseEntity<?> addborrower(@RequestBody Borrower borrower) {
        return ResponseEntity.ok(borrowerService.addBorrower(borrower));
    }

    @GetMapping
    public ResponseEntity<?> getAllBorrowers() {
        return ResponseEntity.ok(borrowerService.getAllBorrower());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBorrowerbyId(@PathVariable Long id) {
            return ResponseEntity.ok(borrowerService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> getMethodName(@PathVariable Long id, @RequestBody Borrower borrower) {
        
            return ResponseEntity.ok(borrowerService.updateBorrower(id, borrower));
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBorrower(@PathVariable Long id) {
            borrowerService.deleteBorrower(id);
            return ResponseEntity.ok("Borrower Deleted Succefully");
    }

}
