package com.library.controller;

import com.library.entity.Librarian;
import com.library.service.LibrarianService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/librarians")
@CrossOrigin("*")
public class LibrarianController {

    private final LibrarianService service;

    public LibrarianController(LibrarianService service){
        this.service=service;
    }

    @GetMapping
    public List<Librarian> all(){
        return service.getAll();
    }

    @PostMapping
    public Librarian add(@RequestBody Librarian librarian){
        return service.save(librarian);
    }

    @PutMapping("/{id}")
    public Librarian update(@PathVariable Long id,
                            @RequestBody Librarian librarian){
        return service.update(id,librarian);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}