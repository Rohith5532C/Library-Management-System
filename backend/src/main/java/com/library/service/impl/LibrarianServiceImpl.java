package com.library.service.impl;

import com.library.entity.Librarian;
import com.library.repository.LibrarianRepository;
import com.library.service.LibrarianService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibrarianServiceImpl implements LibrarianService {

    private final LibrarianRepository repository;

    public LibrarianServiceImpl(LibrarianRepository repository){
        this.repository=repository;
    }

    @Override
    public List<Librarian> getAll(){
        return repository.findAll();
    }

    @Override
    public Librarian save(Librarian librarian){
        return repository.save(librarian);
    }

    @Override
    public Optional<Librarian> get(Long id){
        return repository.findById(id);
    }

    @Override
    public Librarian update(Long id,Librarian librarian){

        Librarian old=repository.findById(id).orElseThrow();

        old.setName(librarian.getName());
        old.setEmail(librarian.getEmail());
        old.setPhone(librarian.getPhone());
        old.setPassword(librarian.getPassword());

        return repository.save(old);

    }

    @Override
    public void delete(Long id){
        repository.deleteById(id);
    }

}