package com.example.security;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public User findUserByEmail(String email){
        User user = new User(email, "123456");
        user.setFirstName("Gamboa");
        user.setLastName("Charlie");
        return user;

    }
}
