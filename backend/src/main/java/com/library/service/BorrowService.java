package com.library.service;

import com.library.entity.BorrowRecord;

import java.util.List;

public interface BorrowService {

    List<BorrowRecord> getAll();

    BorrowRecord borrowBook(Long studentId,
                            Long bookId,
                            BorrowRecord borrowRecord);

    BorrowRecord returnBook(Long id);

}