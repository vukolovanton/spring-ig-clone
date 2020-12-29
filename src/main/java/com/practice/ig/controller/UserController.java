package com.practice.ig.controller;

import com.practice.ig.entity.Users;
import com.practice.ig.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<Users> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users/{userId}")
    public Users findUser(@PathVariable int userId) {
        Users user = userService.findUserById(userId);
        if (user == null) {
            throw new RuntimeException("USER NOT FOUND");
        }
        return user;
    }

    @GetMapping("/top-five/{id}")
    public List<Users> findFiveUsers(@PathVariable int id) {
        return userService.findUsersWithIdGreaterThan(id);
    }

    @PostMapping("/users")
    public Users saveUser(@RequestBody Users user) {
        userService.saveUser(user);
        return user;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId) {
        Users user = userService.findUserById(userId);
        if (user == null) {
            return "User not found";
        }
        userService.deleteUser(userId);
        return "User has been deleted";
    }


}
