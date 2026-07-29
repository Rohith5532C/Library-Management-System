package com.library.service.impl;

import com.library.entity.Book;
import com.library.entity.BorrowRecord;
import com.library.entity.Student;
import com.library.repository.BookRepository;
import com.library.repository.BorrowRecordRepository;
import com.library.repository.StudentRepository;
import com.library.service.BorrowService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

    private final BorrowRecordRepository borrowRepo;
    private final StudentRepository studentRepo;
    private final BookRepository bookRepo;

    public BorrowServiceImpl(BorrowRecordRepository borrowRepo,
                             StudentRepository studentRepo,
                             BookRepository bookRepo) {

        this.borrowRepo=borrowRepo;
        this.studentRepo=studentRepo;
        this.bookRepo=bookRepo;
    }

    @Override
    public List<BorrowRecord> getAll() {
        return borrowRepo.findAll();
    }

    @Override
    public BorrowRecord borrowBook(Long studentId,
                                   Long bookId,
                                   BorrowRecord record){

        Student student=studentRepo.findById(studentId).orElseThrow();
        Book book=bookRepo.findById(bookId).orElseThrow();

        if(book.getAvailableCopies()==0){

            throw new RuntimeException("Book unavailable");

        }

        book.setAvailableCopies(book.getAvailableCopies()-1);

        if(book.getAvailableCopies()==0){

            book.setAvailable(false);

        }

        bookRepo.save(book);

        record.setBook(book);
        record.setStudent(student);
        record.setReturned(false);

        return borrowRepo.save(record);

    }

    @Override
    public BorrowRecord returnBook(Long id){

        BorrowRecord borrow=borrowRepo.findById(id).orElseThrow();

        borrow.setReturned(true);

        Book book=borrow.getBook();

        book.setAvailableCopies(book.getAvailableCopies()+1);

        book.setAvailable(true);

        bookRepo.save(book);

        return borrowRepo.save(borrow);

    }

}