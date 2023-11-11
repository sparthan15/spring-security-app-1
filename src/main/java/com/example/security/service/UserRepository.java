package com.example.security.service;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public User findUserByEmail(String email){
        //whatever the email is ok, but the password must be 123456..
        User user = new User(email, "123456");
        user.setFirstName("Carlos");
        user.setLastName("Gamboa");
        return user;
    }
}
