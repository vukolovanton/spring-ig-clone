package com.practice.ig.service.implementation;

import com.practice.ig.entity.Users;
import com.practice.ig.repository.interfaces.UserRepository;
import com.practice.ig.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public Users findUserById(int id) {
        return userRepository.findUserById(id);
    }

    @Override
    @Transactional
    public void saveUser(Users users) {
        userRepository.saveUser(users);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userRepository.deleteUser(id);
    }

    @Override
    @Transactional
    public List<Users> findUsersWithIdGreaterThan(int id) {
        return userRepository.findUsersWithIdGreaterThan(id);
    }
}
