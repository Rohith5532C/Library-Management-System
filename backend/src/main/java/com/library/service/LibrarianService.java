package com.library.service;

import com.library.entity.Librarian;

import java.util.List;
import java.util.Optional;

public interface LibrarianService {

    List<Librarian> getAll();

    Librarian save(Librarian librarian);

    Optional<Librarian> get(Long id);

    Librarian update(Long id,Librarian librarian);

    void delete(Long id);

}