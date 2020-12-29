package com.practice.ig.service.interfaces;

import com.practice.ig.entity.Users;

import java.util.List;

public interface UserService {
    public List<Users> findAll();
    public Users findUserById(int id);
    public void saveUser(Users users);
    public void deleteUser(int id);

    public List<Users> findUsersWithIdGreaterThan(int id);
}
