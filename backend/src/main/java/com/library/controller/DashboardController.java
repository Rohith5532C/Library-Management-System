package com.library.controller;

import com.library.dto.DashboardStats;
import com.library.repository.BookRepository;
import com.library.repository.StudentRepository;
import com.library.repository.LibrarianRepository;
import com.library.repository.BorrowRecordRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin("*")
public class DashboardController {

    private final BookRepository bookRepository;
    private final StudentRepository studentRepository;
    private final LibrarianRepository librarianRepository;
    private final BorrowRecordRepository borrowRepository;

    public DashboardController(BookRepository bookRepository,
                               StudentRepository studentRepository,
                               LibrarianRepository librarianRepository,
                               BorrowRecordRepository borrowRepository) {

        this.bookRepository = bookRepository;
        this.studentRepository = studentRepository;
        this.librarianRepository = librarianRepository;
        this.borrowRepository = borrowRepository;
    }

    @GetMapping("/stats")
    public DashboardStats getStats() {

        long totalBooks = bookRepository.count();

        long totalStudents = studentRepository.count();

        long totalLibrarians = librarianRepository.count();

        long borrowedBooks = borrowRepository.findAll()
                .stream()
                .filter(b -> !b.isReturned())
                .count();

        long availableBooks = bookRepository.findAll()
                .stream()
                .filter(book -> book.isAvailable())
                .count();

        return DashboardStats.builder()
                .totalBooks(totalBooks)
                .totalStudents(totalStudents)
                .totalLibrarians(totalLibrarians)
                .borrowedBooks(borrowedBooks)
                .availableBooks(availableBooks)
                .build();
    }

}