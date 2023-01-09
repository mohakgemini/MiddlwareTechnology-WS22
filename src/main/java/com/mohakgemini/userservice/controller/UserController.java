package com.mohakgemini.userservice.controller;

import com.mohakgemini.userservice.model.User;
import com.mohakgemini.userservice.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/getUsers")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @PostMapping("/saveUser")
    public User createUser(@RequestBody User user){
        return userService.save(user);
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long id, @RequestBody User userDetails) {
        User user = userService.findFirstById(id);
        if(null == user) {
            return ResponseEntity.notFound().build();
        }
        User updatedUser = userService.save(userDetails);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Long id) {
        User user = userService.findFirstById(id);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        userService.delete(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/testMessage")
    public String getTestMessage(){
        return "Hello World... I'm ready docker anggik";
    }
}
