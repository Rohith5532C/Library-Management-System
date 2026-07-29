package com.library.service.impl;

import com.library.entity.Book;
import com.library.repository.BookRepository;
import com.library.service.BookService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Override
    public Book saveBook(Book book) {

        return repository.save(book);

    }

    @Override
    public Optional<Book> getBook(Long id) {

        return repository.findById(id);

    }

    @Override
    public Book updateBook(Long id, Book book) {

        Book existing = repository.findById(id).orElseThrow();

        existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());
        existing.setPublisher(book.getPublisher());
        existing.setCategory(book.getCategory());
        existing.setQuantity(book.getQuantity());
        existing.setAvailableCopies(book.getAvailableCopies());
        existing.setIsbn(book.getIsbn());
        existing.setAvailable(book.isAvailable());

        return repository.save(existing);
    }

    @Override
    public void deleteBook(Long id) {

        repository.deleteById(id);

    }

    @Override
    public Book getBookById(Long id) {
        return repository.findById(id).orElseThrow();
    }

}