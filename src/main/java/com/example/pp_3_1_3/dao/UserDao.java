package com.example.pp_3_1_3.dao;

import com.example.pp_3_1_3.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User getUserById(long id);
    void saveUser(User user);
    void deleteUserById(long id);
    void updateUser(User user);
    User findByUsername(String email);
}
