package com.library.service.impl;

import com.library.entity.User;
import com.library.repository.UserRepository;
import com.library.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository){
        this.repository=repository;
    }

    @Override
    public User save(User user){
        return repository.save(user);
    }

    @Override
    public User login(String email,String password){

        User user=repository.findByEmail(email)
                .orElseThrow();

        if(!user.getPassword().equals(password)){

            throw new RuntimeException("Wrong Password");

        }

        return user;
    }

}