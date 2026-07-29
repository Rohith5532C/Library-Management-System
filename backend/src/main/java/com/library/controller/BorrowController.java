package com.library.controller;

import com.library.entity.BorrowRecord;
import com.library.service.BorrowService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrow")
@CrossOrigin("*")
public class BorrowController {

    private final BorrowService service;

    public BorrowController(BorrowService service){

        this.service=service;

    }

    @GetMapping
    public List<BorrowRecord> all(){

        return service.getAll();

    }

    @PostMapping("/{studentId}/{bookId}")
    public BorrowRecord borrow(@PathVariable Long studentId,
                               @PathVariable Long bookId,
                               @RequestBody BorrowRecord record){

        return service.borrowBook(studentId,bookId,record);

    }

    @PutMapping("/return/{id}")
    public BorrowRecord returnBook(@PathVariable Long id){

        return service.returnBook(id);

    }

}