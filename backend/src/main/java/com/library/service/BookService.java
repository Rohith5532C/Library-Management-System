package com.library.service;

import com.library.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getAllBooks();

    Book saveBook(Book book);

    Optional<Book> getBook(Long id);

    Book updateBook(Long id, Book book);

    void deleteBook(Long id);

    Book getBookById(java.lang.Long id);
}