package com.example.library.domain.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BorrowRecordRequest {
    private Long bookId;
    private Long borrowerId;
    private LocalDate borrowDate;

    private LocalDate returnDate;
}
