package com.example.pp_3_1_3.service;

import com.example.pp_3_1_3.dao.UserDao;
import com.example.pp_3_1_3.dao.UserDaoImpl;
import com.example.pp_3_1_3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    BCryptPasswordEncoder passwordEncoder;
    private UserDao userDao = new UserDaoImpl();

    @Autowired
    public UserServiceImpl(BCryptPasswordEncoder passwordEncoder, UserDao userDao) {
        this.passwordEncoder = passwordEncoder;
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.saveUser(user);
    }

    @Override
    public void deleteUserById(long id) {
        userDao.deleteUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}

