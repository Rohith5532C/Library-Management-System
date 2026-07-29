package com.library.service;

import com.library.entity.User;

public interface UserService {

    User login(String email,String password);

    User save(User user);

}