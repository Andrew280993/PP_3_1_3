package com.example.pp_3_1_3.service;

import com.example.pp_3_1_3.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(long id);
    void saveUser(User user);
    void deleteUserById(long id);
    void updateUser(User user);
}