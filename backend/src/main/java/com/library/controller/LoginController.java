package com.library.controller;

import com.library.entity.User;
import com.library.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@CrossOrigin("*")
public class LoginController {

    private final UserService service;

    public LoginController(UserService service){
        this.service=service;
    }

    @PostMapping
    public User login(@RequestBody User user){

        return service.login(user.getEmail(),
                user.getPassword());

    }

    @PostMapping("/register")
    public User register(@RequestBody User user){

        return service.save(user);

    }

}